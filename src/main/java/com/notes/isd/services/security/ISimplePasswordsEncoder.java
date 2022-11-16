package com.notes.isd.services.security;

import java.security.NoSuchAlgorithmException;

//PBKDF2
public interface ISimplePasswordsEncoder extends IUserPasswordEncoder {
    public byte[] generateSalt() throws NoSuchAlgorithmException;
}
