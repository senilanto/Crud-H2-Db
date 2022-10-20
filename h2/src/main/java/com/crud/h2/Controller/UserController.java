package com.crud.h2.Controller;


import com.crud.h2.Service.UserService;
import com.crud.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

@PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user){
        User oneUser= userService.createUser(user);
        return  new ResponseEntity<>(oneUser, HttpStatus.CREATED);
    }

    @PostMapping("/users")
public  ResponseEntity<List<User>> addUsers(@RequestBody List<User> users){
    List<User> manyUsers= userService.createUsers(users);
    return  new ResponseEntity<>(manyUsers,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getByID(@PathVariable int id){
    User user=userService.getUserById(id);
    return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public  ResponseEntity<List<User>> getAllUsers(){
    List<User> users= userService.getAllUsers();
    return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
    User updatedUser=userService.updateUser(user);
    return  new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("deleted user",HttpStatus.OK);
    }


}
