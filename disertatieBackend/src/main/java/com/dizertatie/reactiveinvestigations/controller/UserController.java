package com.dizertatie.reactiveinvestigations.controller;

import com.dizertatie.reactiveinvestigations.persistance.model.UserModel;
import com.dizertatie.reactiveinvestigations.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/addUser")
    public void addUser(@RequestBody UserModel userModel){
        userRepo.save(userModel);
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String username, String password){
        List<UserModel> userModelList = userRepo.findAll();
        Optional<UserModel> optionalUserModel= userModelList.stream().filter(userModel -> userModel.getUsername().equals(username) && userModel.getPassword().equals(password)).findAny();
        return optionalUserModel.isPresent();
    }
}
