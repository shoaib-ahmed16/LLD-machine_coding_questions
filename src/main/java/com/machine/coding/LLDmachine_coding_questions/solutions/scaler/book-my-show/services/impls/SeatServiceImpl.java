package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateSeatsOfHallDTO;
import com.machine.coding.LLDmachine_coding_questions.models.Hall;
import com.machine.coding.LLDmachine_coding_questions.models.Seat;
import com.machine.coding.LLDmachine_coding_questions.models.enums.SeatType;
import com.machine.coding.LLDmachine_coding_questions.repositories.SeatRepository;
import com.machine.coding.LLDmachine_coding_questions.services.HallService;
import com.machine.coding.LLDmachine_coding_questions.services.SeatService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final HallService hallService;
    private final int firstAsciiLetterStarts=65;
    @Transactional
    @Override
    public List<Seat> createSeatsByHall(CreateSeatsOfHallDTO request) {
        List<Seat> seatList = new ArrayList<>();
        Hall hall = hallService.getHallInternal(request.getHallId())
                .orElseThrow(() -> new NoSuchElementException("Hall does not exist for Id: " + request.getHallId()));

        int[] rowCounter = {0};
        int totalColumns = request.getTotalColumn();
        Map<SeatType, Integer> seatTypeRows = request.getSeatTypeRows();

        seatTypeRows.forEach((seatType, rowCount) -> {
            List<Seat> seats = IntStream.range(rowCounter[0], rowCounter[0] + rowCount)
                    .boxed()
                    .flatMap(row ->
                            IntStream.rangeClosed(1, totalColumns)
                                    .mapToObj(colNum -> Seat.builder()
                                            .seatType(seatType)
                                            .rowNo((char) (firstAsciiLetterStarts + row))
                                            .columnNo(colNum)
                                            .hall(hall)
                                            .build()
                                    )
                    ).toList();
            seatList.addAll(seats);
            rowCounter[0] += rowCount;
        });
        return seatRepository.saveAll(seatList);
    }
    @Override
    public List<Seat> getAllSeatsByHallId(Long id) {
        return seatRepository.findAllByHall_Id(id);
    }


}
