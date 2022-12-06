package com.notes.isd.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserDetailsFacade implements ICurrentUserDetailsFacade {

    @Override
    public AppUserDetails getUserDetails() {
        return (AppUserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
