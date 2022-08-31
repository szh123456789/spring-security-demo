package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsService userDetailsService;

    @RequestMapping("/")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
    @RequestMapping("/fail")
    public String fail(){
        return "fail";
    }
}
