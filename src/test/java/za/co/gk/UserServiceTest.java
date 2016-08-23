package za.co.gk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.gk.app.domain.UserDao;
import za.co.gk.app.model.User;
import za.co.gk.app.service.user.impl.UserServiceImpl;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DevMachine on 2016/08/22.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserDao userDao;

    @Inject
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    public void testGetUser(){
        when(userServiceImpl.getUser(1L)).thenReturn(new User("bair","12345","pass"));
        User user = userServiceImpl.getUser(1L);
        verify(userDao).findOne(1L);
        assertEquals("username matches","bair",user.getUsername());
        assertEquals("phone matches","12345",user.getPhone());
        assertEquals("password matches","pass",user.getPassword());
    }

    @Test
    public void testFindAll(){
        List<User> users = new ArrayList<>();
        users.add(new User("bair","12345","pass"));
        users.add(new User("meg","67890","word"));

        when(userServiceImpl.getUsers()).thenReturn(users);
        List<User> users1 = userServiceImpl.getUsers();
        verify(userDao).findAll();
        assertNotNull(users1);
        assertTrue(users1.size() > 1);
        assertEquals("username matches","meg",users1.get(1).getUsername());
        assertEquals("phone matches","67890",users1.get(1).getPhone());
        assertEquals("password matches","word",users1.get(1).getPassword());
    }

    @Test
    public void testAddUser(){
        User user = new User("bair","12345","pass");
        userServiceImpl.addUser(user);
        verify(userDao).save(user);
    }

    @Test
    public void testDeleteUser(){
        User user = new User("bair","12345","pass");
        userServiceImpl.addUser(user);
        verify(userDao).save(user);
        user.setUsername("newBair");
        user.setPhone("newPhone");
        user.setPassword("newPass");
        userServiceImpl.updateUser(user);
        when(userServiceImpl.getUser(1L)).thenReturn(user);
        assertEquals("username matches","newBair",user.getUsername());
        assertEquals("phone matches","newPhone",user.getPhone());
        assertEquals("password matches","newPass",user.getPassword());
        userServiceImpl.deleteUser(user);
        verify(userDao).delete(user);
        List<User> users = userServiceImpl.getUsers();
        assertTrue(users.size() == 0);
    }

}
