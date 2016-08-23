package za.co.gk.app.api;

import org.springframework.web.bind.annotation.*;
import za.co.gk.app.model.User;
import za.co.gk.app.service.user.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
@RestController
@RequestMapping(value = "/api")
public class UserResource {

    @Inject
    UserService userService;

    @RequestMapping(value = "/user/add",method = RequestMethod.PUT)
    public void addUser(@ModelAttribute User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public void addUserPost(@ModelAttribute User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public void getLoginToken(User user){
        userService.generateLoginToken(user);
    }

    @RequestMapping(value = "/user/logout/{id}",method = RequestMethod.POST)
    public void destroyLoginToken(@PathVariable("id") Long id,@RequestBody(required = true)String token){
//        userService.detroyLoginToken();
    }
}
