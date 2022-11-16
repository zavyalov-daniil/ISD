package com.notes.isd.services.security;

public interface ISimplePasswordsMatcher extends IUserPasswordMatcher {
    public void setSalt(byte[] salt);

    public byte[] getSalt() throws NullPointerException;
}
