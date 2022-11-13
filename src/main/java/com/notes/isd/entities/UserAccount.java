package com.notes.isd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String login;

    public UserAccount() {
    }

    public UserAccount(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
