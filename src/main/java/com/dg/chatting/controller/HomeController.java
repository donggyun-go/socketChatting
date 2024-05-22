package com.dg.chatting.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.dto.UserDto;
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
	
	
    @GetMapping(value = "/searchFriendResult")
    public String searchFriend(@RequestParam("userId") String userId, Model model) {
        List<UserDto> searchResults = friendService.searchFriend(userId);
        model.addAttribute("searchResults", searchResults);
        return "searchFriendPopup"; 
    }
    
    @ResponseBody
    @PostMapping("/addFriend")
    public Map<String, Object> addFriend(@RequestParam("friendId") String friendId, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            throw new IllegalStateException("User is not logged in");
        }

        FriendDto friendDto = new FriendDto();
        friendDto.setFriendId(friendId);
        friendDto.setUserId(userId);
        friendDto.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        Map<String, Object> response = new HashMap<>();
        try {
            friendService.addFriend(friendDto);
            response.put("friendAddSuccess", true);
        } catch (Exception e) {
            response.put("friendAddSuccess", false);
        }

        return response;
    }
	
}