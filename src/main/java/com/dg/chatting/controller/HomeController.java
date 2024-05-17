package com.dg.chatting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.service.FriendService;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private FriendService friendService;

	@GetMapping(value = "/")
    public String home(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        List<FriendDto> friendList = friendService.getFriendsByUserId(userId);
        System.out.println(friendList.size());
        model.addAttribute("friendList", friendList);

        return "home";
    }
}