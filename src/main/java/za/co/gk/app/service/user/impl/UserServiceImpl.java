package za.co.gk.app.service.user.impl;


import za.co.gk.app.domain.UserDao;
import za.co.gk.app.model.User;
import za.co.gk.app.service.user.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
@Named
public class UserServiceImpl implements UserService {

    @Inject
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        // TODO: 23/08/2016 save password as MD5
        userDao.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public void updateUser(User user) {
        // TODO: 23/08/2016 save password as MD5
        userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void generateLoginToken(User user) {
        // TODO: 23/08/2016 confirm details are correct. Maybe use MD5?
        // TODO: 23/08/2016 generate token
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }
}
