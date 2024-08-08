package com.group.libraryapp.controller.User;

import com.group.libraryapp.dto.User.UserCreatRequest;
import com.group.libraryapp.dto.User.UserupdateRequest;
import com.group.libraryapp.dto.User.userResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userService;


    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreatRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<userResponse> getUsers(){
        return userService.getUsers();
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserupdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }

    @GetMapping("/user/error-test")
    public void errorTest(){
        throw new IllegalArgumentException();
    }
}
