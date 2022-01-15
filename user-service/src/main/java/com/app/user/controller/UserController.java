package com.app.user.controller;

import com.app.user.VO.ResponseVO;
import com.app.user.entity.User;
import com.app.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/users")
public class UserController {

    private static final String USER_SERVICE="userService";

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUserByDepartmentId/{userId}")
    @CircuitBreaker(name="USER_SERVICE",fallbackMethod = "departmentFallBack")
    public ResponseVO getUserByDepartmentId(@PathVariable Long userId){
        return userService.getUserByDepartmentId(userId);
    }

    public ResponseVO departmentFallBack(Throwable e){
        System.out.println("Service is down, please try again later");
        return null;
    }
}
