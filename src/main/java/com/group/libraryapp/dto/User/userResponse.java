package com.group.libraryapp.dto.User;

import com.group.libraryapp.dto.domain.user.User;

public class userResponse {
    private long id;
    private String name;
    private Integer age;


    public userResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public userResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public userResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }
}
