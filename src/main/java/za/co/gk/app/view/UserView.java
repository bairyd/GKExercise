package za.co.gk.app.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.gk.app.model.User;
import za.co.gk.app.service.user.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by DevMachine on 2016/08/23.
 */
@Controller
public class UserView {

    @Inject
    UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("users",new User("","",""));
        return "index";
    }

    @RequestMapping("/index")
    public String indexPages(Model model){
        model.addAttribute("users",new User("","",""));
        return "pages";
    }

    @RequestMapping("/viewUsers")
    public String viewUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        return "viewUsers";
    }

    @RequestMapping(value = "/addUser",method=RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("user",new User("","",""));
        return "addUser";
    }

    @RequestMapping(value = "/login")
    public String userLogin(Model model){
        model.addAttribute("user",new User("","",""));
        return "login";
    }


}
