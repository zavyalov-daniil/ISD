package com.notes.isd.service.security;

import java.security.NoSuchAlgorithmException;

//PBKDF2
public interface ISimpleUserRegistrationService extends IUserRegistrationService {
    public byte[] generateSalt() throws NoSuchAlgorithmException;
}
