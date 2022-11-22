package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.services.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class RegistrationController {
    private UserAccountService userAccountService;

    public RegistrationController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping()
    public String getRegistrationPage() {
        return "index";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute("user") @Valid UserAccount userAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/login";
        userAccountService.save(userAccount);
        return "notes";
    }
}
