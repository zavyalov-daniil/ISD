package com.notes.isd.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.EnumSet;
import java.util.Set;
import com.notes.isd.entities.Role;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true, length = 45)
    private String login;
    @Column(nullable = false, length = 64)
    private String encryptedPassword;

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
