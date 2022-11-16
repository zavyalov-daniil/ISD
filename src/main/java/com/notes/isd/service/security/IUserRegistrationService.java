package com.notes.isd.service.security;

public interface IUserRegistrationService {

    //Зашифровать пароль
    public String encryptPassword(String pass);

}
