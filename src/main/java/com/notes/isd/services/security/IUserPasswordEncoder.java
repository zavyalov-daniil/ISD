package com.notes.isd.services.security;

public interface IUserPasswordEncoder {

    //Зашифровать пароль
    public String encryptPassword(String pass);

}
