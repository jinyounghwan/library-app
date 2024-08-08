package com.group.libraryapp.dto.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {

    Optional<User> findByName(String name);

    //boolean existByName(String name);
}
