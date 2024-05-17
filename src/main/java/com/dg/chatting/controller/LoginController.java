package com.dg.chatting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dg.chatting.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String login() {
        return "login"; 
    }

    @PostMapping("/")
    public String validateLogin(@RequestParam("userId") String userId,
                                @RequestParam("userPass") String userPass,
                                HttpServletRequest request) {
        if (loginService.validateUser(userId, userPass)) {
        	loginService.storeSessionById(userId, request);
            return "redirect:/home/"; 
        } else {
            request.setAttribute("error", "Invalid username or password");
            return "login"; 
        }
    }
}