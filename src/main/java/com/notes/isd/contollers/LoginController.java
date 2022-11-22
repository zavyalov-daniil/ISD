package com.notes.isd.contollers;

import com.notes.isd.services.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserAccountService userAccountService;

    public LoginController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping()
    public String getLoginPage() {
        return "index";
    }

    @PostMapping()
    public String signIn(@ModelAttribute("login") String login, @ModelAttribute("password") String password) {
        return "redirect:index";
    }
}
