package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.services.AppUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    AppUserDetailsService appUserDetailsService;

    public IndexController(AppUserDetailsService appUserDetailsService) {
        this.appUserDetailsService = appUserDetailsService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserAccount());

        return "registration";
    }

    @PostMapping("/process_register")
    public String processRegister(UserAccount user) {
        appUserDetailsService.registerNewUser(user);
        return "successful_registration";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserAccount> listUsers = appUserDetailsService.findAllUsers();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}
