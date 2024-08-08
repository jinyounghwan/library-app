package com.group.libraryapp.dto.domain.user;

import com.group.libraryapp.dto.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false , length = 20, name="name") // name varchar(20) 변수명이랑 같으면 name 생략가능
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {

    }

    public Long getId() {
        return id;
    }

    public User(String name, Integer age) {
      if(name ==null || name.isBlank()){
        throw new IllegalArgumentException(String.format("잘못된 name(%s)가 들어왔습니다."));
      }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void updateName(String name){
        this.name=name;
    }

    public void loanBook(String bookName){
        this.userLoanHistories.add(new UserLoanHistory(this , bookName));
    }

    public void returnBook(String bookName){
        UserLoanHistory tagetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        tagetHistory.doReturn();
    }
}
