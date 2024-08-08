package com.group.libraryapp.service.book;


import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.dto.domain.book.Book;
import com.group.libraryapp.dto.domain.book.BookRepository;
import com.group.libraryapp.dto.domain.user.User;
import com.group.libraryapp.dto.domain.user.UserRepository;
import com.group.libraryapp.dto.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.dto.domain.user.loanhistory.UserLoanHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository ,
                       UserLoanHistoryRepository userLoanHistoryRepository ,
                       UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    public void loanBook(BookLoanRequest request){
        // 1. 책 정보를 가져옴
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 대출기록 정보 확인 대출중인지 확인
        // 3. 만약 확인했는데 ㄷ대출중이면 예외 발생
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName() , false)){
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다.");
        }
        // 4. 유저 정보 가져오기.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장
       //userLoanHistoryRepository.save(new UserLoanHistory(user , book.getName()));
        user.loanBook(book.getName());
    }

    @Transactional
    public void returnBook(BookReturnRequest request){
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        /*
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId() , request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        history.doReturn();
        */
        System.out.println("hello");
        user.returnBook(request.getBookName());
    }
}
