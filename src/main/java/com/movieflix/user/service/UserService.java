package com.movieflix.user.service;

import com.movieflix.user.model.User;
import com.movieflix.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User save (User user){
        return repository.save(user);
    }

}
