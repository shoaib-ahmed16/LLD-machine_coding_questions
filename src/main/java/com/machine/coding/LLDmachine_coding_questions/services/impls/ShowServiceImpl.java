package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateShowDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.ShowNotFoundException;
import com.machine.coding.LLDmachine_coding_questions.models.*;
import com.machine.coding.LLDmachine_coding_questions.models.enums.SeatStatus;
import com.machine.coding.LLDmachine_coding_questions.repositories.ShowRepository;
import com.machine.coding.LLDmachine_coding_questions.services.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final HallService hallService;
    private final SeatService seatService;
    private final MovieService movieService;

    private final ShowSeatService showSeatService;

    @Transactional
    @Override
    public Show createShow(CreateShowDTO request) {

        Hall hall = hallService.getHallInternal(request.getHallId())
                .orElseThrow(()->new NoSuchElementException("Hall does not exist forId: "+request.getHallId()));
        Movie movie =movieService.getMovieInternalById(request.getMovieId())
                .orElseThrow(()->new NoSuchElementException("Movie does not exist for Id: "+request.getMovieId()));
        Show show = Show.builder()
                .movie(movie)
                .duration(movie.getDuration())
                .startTime(request.getStartTime())
                .language(request.getLanguage())
                .hall(hall)
                .build();
        List<Seat> seatList =seatService.getAllSeatsByHallId(request.getHallId());
        List<ShowSeat> showSeats = seatList.stream()
                .map(seat ->ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .status(SeatStatus.AVAILABLE)
                        .build()
                ).toList();
        showSeatService.create(showSeats);
        return show;
    }

    @Override
    public Optional<Show> getShowInternallyById(Long id) {
        return showRepository.findById(id);
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(()->new ShowNotFoundException("No Show Record found for the Id: "+id));
    }
}
