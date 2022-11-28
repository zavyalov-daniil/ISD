package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.repositories.UserAccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    UserAccountRepository repos;

    public IndexController(UserAccountRepository repos) {
        this.repos = repos;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getEncryptedPassword());
        user.setEncryptedPassword(encodedPassword);

        repos.save(user);

        return "successful_registration";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserAccount> listUsers = repos.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}
