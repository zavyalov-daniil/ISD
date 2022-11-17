package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.services.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private UserAccountService userAccountService;

    public MainController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/main")
    public String getAll() {
        return "main";
    }
}
