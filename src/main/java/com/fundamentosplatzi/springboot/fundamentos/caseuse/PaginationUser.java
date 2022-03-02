package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaginationUser {
    private UserService userService;

    public PaginationUser(UserService userService) {
        this.userService = userService;
    }

    public List<User> pageable(int page, int size){
        return userService.pageable(page, size);
    }
}
