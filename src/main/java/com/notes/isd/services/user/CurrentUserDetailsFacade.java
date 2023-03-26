package com.notes.isd.services.user;

import com.notes.isd.services.user.AppUserDetails;
import com.notes.isd.services.user.ICurrentUserDetailsFacade;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserDetailsFacade implements ICurrentUserDetailsFacade {

    @Override
    public AppUserDetails getUserDetails() {
        return (AppUserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
