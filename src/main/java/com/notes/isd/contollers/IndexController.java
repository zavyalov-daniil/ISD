package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    private UserAccountService userAccountService;

    public IndexController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<UserAccount> usersList = userAccountService.getAll();
        model.addAttribute("usersList", usersList);
        return "index";
    }
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userAccountService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute UserAccount user) {
        userAccountService.save(user);
        return "redirect:/";
    }
}
