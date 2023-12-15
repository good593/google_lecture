package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.model.dto.UserDto;
import com.example.basic.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    /*
     * 누구나 접근 가능
     */
    @GetMapping("/index")
    public String index(Authentication authentication) {
        if(authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        }

        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(
        @RequestParam(value = "error", required = false)String error,
        @RequestParam(value = "exception", required = false)String exception, Model model) {
        
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login/loginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/loginPage";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "login/joinPage";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto dto) {

        userService.joinUserDto(dto);
        return "redirect:/loginPage";
    }
    
    /*
     * 로그인한 경우만 
     */
    @GetMapping("/user/index")
    public String user(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "staff/user";
    }

    @GetMapping("/manager/index")
    public String manager(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "staff/manager1";
    }

    @GetMapping("/admin/index")
    public String admin(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "staff/admin1";
    }

    @Secured("ADMIN")
    @GetMapping("/secured")
    public String secured(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "staff/secured";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @GetMapping("/secured-roles")
    public String securedRoles(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "staff/securedRoles";
    }

}
