package com.example.srpingbootjpa.controller;

import com.example.srpingbootjpa.entity.User;
import com.example.srpingbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody  List<User> users)
    {
        return userService.createUsers( users);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser( user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        if( userService.deleteUserById(id) )
        {
            return "User is successfully deleted";
        }
        else
        {
            return "User ID cannot be found, delete is unsuccessful";
        }
    }
}
