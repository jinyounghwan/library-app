package com.group.libraryapp.dto.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    protected Book(){

    };

    public Book(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name이 들어았음"));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
