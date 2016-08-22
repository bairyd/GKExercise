package za.co.gk.resource;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import za.co.gk.service.user.UserDto;
import za.co.gk.service.user.UserService;
import za.co.gk.service.util.Credential;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
@Path("/api")
public class LoginResource {

    @Inject
    UserService userService;

    @PUT
    @Path("/user/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(UserDto userDto){
        userService.addUser(userDto);
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUserts(){
        return userService.getUsers();
    }
}
