package za.co.gk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.gk.service.user.UserDao;
import za.co.gk.service.user.UserService;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.Mockito.when;

/**
 * Created by DevMachine on 2016/08/22.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    UserDao userDao;

    @Inject
    @InjectMocks
    UserService userServiceImpl;

    @Test
    public void testAddUser(){
//        when(userServiceImpl.getUsers()).thenReturn(anyIterable());
    }

}