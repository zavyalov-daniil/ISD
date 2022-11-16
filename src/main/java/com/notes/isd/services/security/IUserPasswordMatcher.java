package com.notes.isd.services.security;

public interface IUserPasswordMatcher {
    public boolean matchPasswords(String incomingPassword, String savedPassword) throws Exception;
}
