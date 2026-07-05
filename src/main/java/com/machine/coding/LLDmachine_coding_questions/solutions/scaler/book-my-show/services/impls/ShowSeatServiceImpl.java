package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.models.ShowSeat;
import com.machine.coding.LLDmachine_coding_questions.repositories.ShowSeatRepository;
import com.machine.coding.LLDmachine_coding_questions.services.ShowSeatService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatServiceImpl implements ShowSeatService {
    private final ShowSeatRepository showSeatRepository;
    @Transactional
    @Override
    public void create(List<ShowSeat> showSeats) {
        showSeatRepository.saveAll(showSeats);
    }

    @Override
    public List<ShowSeat> getShowSeatInternally(List<Long> ids) {
        return showSeatRepository.findAllById(ids);
    }

    @Override
    public void saveAllLockedSeats(List<ShowSeat> showSeats) {
        showSeatRepository.saveAll(showSeats);
    }
}
