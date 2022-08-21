package com.example.reactjava.users.controllers;

import com.example.reactjava.users.model.User;
import com.example.reactjava.users.repositories.IUserRepository;
import com.example.reactjava.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@Tag(name = "default")
@CrossOrigin("*")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserRepository userRepository;

    @Operation(summary = "Creates a new user")
@PostMapping
    public R<User> addUser(@RequestBody User user)
    {
        try {
            userRepository.save(user);
        }catch (Exception e){
            logger.error("Create a new user fails:" +e.getMessage());
        }


        return new R<User>().success();
    }

    @GetMapping("")
    @ResponseBody
    public R<List<User>> findUsers()
    {
        List<User> userList=null;
        try {
            userList=userRepository.findAll();
        }catch (Exception e){
            logger.error("Find the user list fails:" +e.getMessage());
        }
        return new R<List<User>>().success().data(userList);
    }
    @Operation(summary = "Update an existing  user")
    @PutMapping
    public R<User> updateUser(@RequestBody User user)
    {
        try {
            userRepository.save(user);
        }catch (Exception e){
            logger.error("Update a  user fails:" +e.getMessage());
        }


        return new R<User>().success();
    }
    @GetMapping("/{email}")
    public R<User> findUserByEmail(@PathVariable String email)
    {
        User user =null;

        try {
            user = userRepository.findById(email).orElse(new User());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<User>().success().data(user);
    }
    @DeleteMapping(value = "/{email}")

    public R<User> deleteUser(@PathVariable final String email)
    {
        try {
           userRepository.deleteById(email);
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<User>().success();
    }

}
