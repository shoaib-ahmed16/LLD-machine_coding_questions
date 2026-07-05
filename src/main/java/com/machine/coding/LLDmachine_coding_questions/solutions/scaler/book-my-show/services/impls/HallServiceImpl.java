package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.dtos.CreateHallDTO;
import com.machine.coding.LLDmachine_coding_questions.exceptions.HallDoesNotExistException;
import com.machine.coding.LLDmachine_coding_questions.models.Hall;
import com.machine.coding.LLDmachine_coding_questions.repositories.HallRepository;
import com.machine.coding.LLDmachine_coding_questions.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;
    @Override
    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElseThrow(()-> new HallDoesNotExistException("No Hall Exist for the Hall Id: "+id)
                );
    }

    @Override
    public Optional<Hall> getHallInternal(Long id) {
        return hallRepository.findById(id);
    }
}
