package com.libraryManagementSystem.User.Controller;

import com.libraryManagementSystem.User.Model.AppUser;
import com.libraryManagementSystem.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/User")
@XmlRootElement
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/createUser" , method = RequestMethod.POST)
    public AppUser createUser(@RequestBody AppUser user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/editUserDetails",method = RequestMethod.PUT)
    public AppUser editUser(@RequestBody AppUser user){return userService.editUserDetails(user);}

    @RequestMapping(value = "/deleteUser/{username}",method = RequestMethod.DELETE)
    public AppUser deleteUser(@PathVariable("username") String username){return userService.deleteUser(username);}

    @RequestMapping(value="/findByUsername/{username}",method = RequestMethod.GET)
    public AppUser findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }

    @RequestMapping(value="/fetchAllUsers",method = RequestMethod.GET)
    public List<AppUser> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @RequestMapping("/admin/home")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
