package com.mf.spring.springmvsboot.controller;

import com.mf.spring.springmvsboot.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", user);
        return "user";
    }
}
