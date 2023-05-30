package ru.lisin.labwork1lmm.services;

import ru.lisin.labwork1lmm.entities.User;

public interface UserService {
    User getUser(String login);
}
