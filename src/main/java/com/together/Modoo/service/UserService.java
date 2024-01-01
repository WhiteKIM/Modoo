package com.together.Modoo.service;

import com.together.Modoo.model.User;
import com.together.Modoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isEmpty())
            throw new RuntimeException();

        User user1 = optionalUser.get();
        user1.update(user);
    }

    public void delete(Long id) {
        return;
    }
}
