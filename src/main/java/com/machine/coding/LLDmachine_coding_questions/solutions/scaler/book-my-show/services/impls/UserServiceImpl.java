package com.machine.coding.LLDmachine_coding_questions.services.impls;

import com.machine.coding.LLDmachine_coding_questions.models.User;
import com.machine.coding.LLDmachine_coding_questions.repositories.UserRepository;
import com.machine.coding.LLDmachine_coding_questions.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User creatUser(String username, String password) {
        User user= new User(username,password);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userName) {
        return null;
    }
}
