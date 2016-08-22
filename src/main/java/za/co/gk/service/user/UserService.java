package za.co.gk.service.user;

import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
public interface UserService {
    void addUser(UserDto userDto);
    List<UserDto> getUsers();
}
