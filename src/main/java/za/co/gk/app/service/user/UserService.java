package za.co.gk.app.service.user;

import za.co.gk.app.model.User;

import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
public interface UserService {
    void addUser(User user);
    User getUser(Long id);
    void updateUser (User user);
    void deleteUser (User user);
    void generateLoginToken(User user);
    List<User> getUsers();
}
