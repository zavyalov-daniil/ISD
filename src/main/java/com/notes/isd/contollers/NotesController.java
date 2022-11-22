package com.notes.isd.contollers;

import com.notes.isd.services.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Notes")
public class NotesController {
    private UserAccountService userAccountService;

    public NotesController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping()
    public String getAllNotes() {
        return "notes";
    }
}
