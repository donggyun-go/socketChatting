package com.dg.chatting.controller;

import com.dg.chatting.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            return "redirect:/home"; 
        } else {
            request.setAttribute("error", "Invalid username or password");
            return "login"; 
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home"; 
    }
}