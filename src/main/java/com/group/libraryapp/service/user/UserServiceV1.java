package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.User.UserCreatRequest;
import com.group.libraryapp.dto.User.UserupdateRequest;
import com.group.libraryapp.dto.User.userResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userRepository;

    public UserServiceV1(UserJdbcRepository userRepository){
       this.userRepository = userRepository;
    }

    public void updateUser(UserupdateRequest request){
        boolean isUserNotExist = userRepository.isUserNotExist(request.getId());
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getName() , request.getId());
    }


    public void deleteUser(String name){

        if(userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }

    public void saveUser(UserCreatRequest request){
        userRepository.savaUser(request.getName() , request.getAge());
    }

    public List<userResponse> getUsers(){
        return userRepository.getUsers();
    }
}
