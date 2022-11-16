package com.notes.isd.service.security;

public interface ISimpleAuthenticationService extends IUserAuthenticationService {
    public void setSalt(byte[] salt);

    public byte[] getSalt() throws NullPointerException;
}
