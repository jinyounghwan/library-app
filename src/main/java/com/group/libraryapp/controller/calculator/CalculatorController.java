package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request)
    {
        return request.getNum1() + request.getNum2();
    }

    @PostMapping("/multiply")
    public int mutiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNum1() * request.getNum2();
    }

}
