package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateBookingDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.CustomerNotFoundException;
import com.machine.coding.LLDmachine_coding_questions.exceptions.SeatNotAvailableException;
import com.machine.coding.LLDmachine_coding_questions.exceptions.ShowNotFoundException;
import com.machine.coding.LLDmachine_coding_questions.models.Booking;
import com.machine.coding.LLDmachine_coding_questions.models.Customer;
import com.machine.coding.LLDmachine_coding_questions.models.Show;
import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;
import com.machine.coding.LLDmachine_coding_questions.models.enums.BookingStatus;
import com.machine.coding.LLDmachine_coding_questions.models.enums.SeatStatus;
import com.machine.coding.LLDmachine_coding_questions.repositories.BookingRepository;
import com.machine.coding.LLDmachine_coding_questions.services.BookingService;
import com.machine.coding.LLDmachine_coding_questions.services.CustomerService;
import com.machine.coding.LLDmachine_coding_questions.services.ShowSeatService;
import com.machine.coding.LLDmachine_coding_questions.services.ShowService;
import com.machine.coding.LLDmachine_coding_questions.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final ShowService showService;
    private final ShowSeatService showSeatService;
    private final PricingStrategy pricingStrategy;
    @Transactional //(isolation = Isolation.SERIALIZABLE)
    @Override
    public Booking createBooking(CreateBookingDTO request) {

        Customer customer = customerService.getCustomerInternal(request.getCustomerId())
                            .orElseThrow(() -> new CustomerNotFoundException("No Customer details found for the Id: "+request.getCustomerId())
                                );
        Show show =showService.getShowInternallyById(request.getShowId())
                .orElseThrow(()->new ShowNotFoundException("No Show Record found for the Id: "+request.getShowId()));
        List<ShowSeat> showSeats =lockSeats(request);

        Booking booking = Booking.builder()
                                .show(show)
                                .customer(customer)
                                .bookedAt(new Date())
                                .status(BookingStatus.PENDING)
                                .seats(showSeats)
                                .build();
        Double amount= pricingStrategy.calculatePrice(booking,showSeats);
        Booking withAmount =booking.toBuilder().amount(amount).build();
        return bookingRepository.save(withAmount);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> lockSeats(CreateBookingDTO bookingRequest){
        List<ShowSeat> showSeats=showSeatService.getShowSeatInternally(bookingRequest.getShowSeatIDs());

        List<Long> nonAvailableSeatIds = showSeats.stream()
                .filter(showSeat -> showSeat.getStatus() != SeatStatus.AVAILABLE)
                .map(ShowSeat::getId)
                .collect(Collectors.toList());

        if (!nonAvailableSeatIds.isEmpty()) {
            throw new SeatNotAvailableException(
                    "Seats already booked for IDs: " + nonAvailableSeatIds.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
            );
        }
        List<ShowSeat> lockedSeats=showSeats.stream().map(showSeat -> showSeat.toBuilder().status(SeatStatus.LOCKED).build()).toList();
        showSeatService.saveAllLockedSeats(lockedSeats);
        return lockedSeats;
    }
}
