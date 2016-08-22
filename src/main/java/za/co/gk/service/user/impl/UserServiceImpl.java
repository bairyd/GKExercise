package za.co.gk.service.user.impl;


import za.co.gk.service.user.UserDao;
import za.co.gk.service.user.UserDto;
import za.co.gk.service.user.UserService;

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

    public void addUser(UserDto userDto) {
        userDao.addUser(userDto);
    }

    public List<UserDto> getUsers() {
        return userDao.getUsers();
    }
}
