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
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
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
    @Transactional
    @Override
    public Booking createBooking(CreateBookingDTO request) {

        // Validate customer exist or not using customer id
        Customer customer = customerService.getCustomerInternal(request.getCustomerId())
                            .orElseThrow(() -> new CustomerNotFoundException("No Customer details found for the Id: "+request.getCustomerId())
                                );
        // validate show id
        Show show =showService.getShowInternallyById(request.getShowId())
                .orElseThrow(()->new ShowNotFoundException("No Show Record found for the Id: "+request.getShowId()));

        // validate showSeats
        List<ShowSeat> showSeats=showSeatService.getShowSeatInternally(request.getShowSeatIDs());
        // - check if they are available

            // Find all non-available seats
            List<Long> nonAvailableSeatIds = showSeats.stream()
                    .filter(showSeat -> showSeat.getStatus() != SeatStatus.AVAILABLE)
                    .map(ShowSeat::getId)
                    .collect(Collectors.toList());

            // If there are any non-available seats, throw an exception
            if (!nonAvailableSeatIds.isEmpty()) {
                throw new SeatNotAvailableException(
                        "Seats already booked for IDs: " + nonAvailableSeatIds.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", "))
                );
            }
        // Lock the available seats if all are available
        List<ShowSeat> lockedSeats=showSeats.stream().map(showSeat -> showSeat.toBuilder().status(SeatStatus.LOCKED).build()).toList();
        // Save the seats
        showSeatService.saveAllLockedSeats(lockedSeats);
        // Save the Booking
        Booking booking = Booking.builder()
                                .show(show)
                                .customer(customer)
                                .bookedAt(new Date())
                                .status(BookingStatus.PENDING)
                                .seats(lockedSeats)
                                .build();
        Double amount= pricingStrategy.calculatePrice(booking,lockedSeats);
        Booking withAmount =booking.toBuilder().amount(amount).build();

        return bookingRepository.save(withAmount);
    }
}
