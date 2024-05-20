package com.dg.chatting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
    @PostMapping("/searchFriendResult")
    public String searchFriend(@RequestParam("searchId") String searchId, Model model) {
        List<FriendDto> searchResults = friendService.searchFriend(searchId);
        model.addAttribute("searchResults", searchResults);
        return "searchFriendPopup";  // 다시 팝업 페이지로 돌아갑니다.
    }

    @PostMapping("/addFriend")
    public String addFriend(@RequestParam("friendId") String friendId) {
        // 친구 추가 로직
        friendService.addFriend(friendId);
        return "redirect:/home";  // 메인 페이지로 리다이렉트
    }
	
	
}