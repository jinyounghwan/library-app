package com.group.libraryapp.dto.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory , Long> {

    // selet * from user_loan_history where bbook_name = ? and is is_reutn  = ?
    boolean existsByBookNameAndIsReturn(String name , boolean isReturn);


    //Optional<UserLoanHistory> findByUserIdAndBookName(long userId , String bookName);
}
