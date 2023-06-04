package ru.lisin.labwork1lmm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lisin.labwork1lmm.entities.User;
import ru.lisin.labwork1lmm.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String login) {
        return userRepository.findByUserLogin(login);
    }
}
