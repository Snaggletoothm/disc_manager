package ru.maxsut.model;

import ru.maxsut.domain.User;

import java.util.List;

public interface UserDal {
    List<User> findAllUsers();
    List<User> findAllUsersWithDetails();
    User findUserByName(String name);
    User findUserById(int id);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
