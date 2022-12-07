package com.notes.isd.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptiondeGeneratorsController {
    @GetMapping("/gimme_error")
    public String processRegister() {
        throw new RuntimeException("Here we are!");
    }
}
