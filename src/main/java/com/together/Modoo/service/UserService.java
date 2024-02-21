package com.together.Modoo.service;

import com.together.Modoo.config.filter.JwtTokenProvider;
import com.together.Modoo.dto.request.user.RequestJoinUser;
import com.together.Modoo.dto.request.user.RequestLoginUser;
import com.together.Modoo.dto.request.user.RequestUser;
import com.together.Modoo.dto.response.user.ResponseUser;
import com.together.Modoo.exception.NotExistUser;
import com.together.Modoo.exception.WrongUserPassword;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void save(RequestUser requestUser) {
        User user = new User(requestUser);
        userRepository.save(user);
    }

    public void join(RequestJoinUser joinUser) {
        String rawPassword = joinUser.password();
        String encPassword = passwordEncoder.encode(rawPassword);

        User user = new User(joinUser);
        user.setPassword(encPassword);//비밀번호 교체

        userRepository.save(user);
    }

    public void login(RequestLoginUser loginUser, HttpServletRequest request, HttpServletResponse response) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUser.username());
        if (optionalUser.isEmpty())
            throw new NotExistUser();

        User user = optionalUser.get();

        if (!passwordEncoder.matches(loginUser.password(), user.getPassword()))
            throw new WrongUserPassword();

        String token = jwtTokenProvider.createToken(user.getUsername());

        response.setHeader("X-AUTH-TOKEN", token);
    }

    public ResponseUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new).toDto();
    }

    public void update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isEmpty())
            throw new RuntimeException();

        User user1 = optionalUser.get();
        user1.update(user);
    }

    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty())
            throw new NotExistUser();

        User user = optionalUser.get();
        user.setDeleteTime(ZonedDateTime.now());//현재 시간으로 제거되었음을 알린다.
    }
}
