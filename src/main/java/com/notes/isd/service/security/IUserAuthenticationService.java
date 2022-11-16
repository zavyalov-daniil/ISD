package com.notes.isd.service.security;

public interface IUserAuthenticationService {
    public boolean matchPasswords(String incomingPassword, String savedPassword) throws Exception;
}
