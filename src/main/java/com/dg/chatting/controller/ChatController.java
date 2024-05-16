//package com.dg.chatting.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.dg.chatting.Dto.UserDto;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Controller
//@Slf4j
//@RequestMapping(value="/chat")
//public class ChatController {
//
//    @GetMapping("")
//    public String chat(Model model, HttpSession session) {
//    	UserDto user = (UserDto) session.getAttribute("username");
//
//        log.info("@ChatController, chat GET()");
//
//        model.addAttribute("userName", user.getUserName());
//
//        return "chat/chat";
//    }
//}
//
