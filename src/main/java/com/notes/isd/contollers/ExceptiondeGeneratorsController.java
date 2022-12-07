package com.notes.isd.contollers;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptiondeGeneratorsController {
    @GetMapping("/gimme_error")
    public String generateRuntimeException() {
        throw new RuntimeException("Here we are!");
    }

    @GetMapping("/gimme_bad_credentials")
    public String generateBadCredentials() {
        throw new BadCredentialsException("Here we are!");
    }
}
