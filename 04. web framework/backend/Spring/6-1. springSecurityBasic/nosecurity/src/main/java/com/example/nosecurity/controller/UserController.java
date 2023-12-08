package com.example.nosecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.nosecurity.model.dto.UserDto;
import com.example.nosecurity.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        log.info("[UserController][index] Start");
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        log.info("[UserController][logout] Start");

        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userRole");

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        log.info("[UserController][loginPage] Start");
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto dto, HttpServletRequest request) {
        log.info("[UserController][login] Start");

        UserDto isOk = userService.loginUser(dto);
        if(isOk == null ) {
            return "redirect:/join";
        } else if(isOk.getUserEmail() == null) {
            return "redirect:/login";
        }

        log.info("login 성공!!");
        HttpSession session = request.getSession();
        // userId: 로그인 유무(인증) 
        session.setAttribute("userId", isOk.getUserId());
        // userRole: 사용자의 권한 확인(인가) 
        session.setAttribute("userRole", isOk.getUserRole());

        return "redirect:/user";
    }

    @GetMapping("/join")
    public String joinPage() {
        log.info("[UserController][joinPage] Start");
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto dto) {

        userService.joinUser(dto);
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String user(HttpServletRequest request, Model model) {
        log.info("[UserController][user] Start");

        HttpSession session = request.getSession();

        // 인증 확인!! -> 로그인 유무 확인 
        if(session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("userRole", session.getAttribute("userRole"));
        return "user";
    }

    @GetMapping("/admin")
    public String admin(HttpServletRequest request, Model model) {
        log.info("[UserController][admin] Start");

        HttpSession session = request.getSession();

        // 인증 확인!! -> 로그인 유무 확인 
        if(session.getAttribute("userId") == null) {
            return "redirect:/login";
        } 
        // 인가 확인!! -> 관리자 유무 확인 
        else if(!session.getAttribute("userRole").equals("admin")) {
            return "redirect:/user";
        }

        model.addAttribute("userId", session.getAttribute("userId"));
        model.addAttribute("userRole", session.getAttribute("userRole"));
        return "admin";
    }
}
