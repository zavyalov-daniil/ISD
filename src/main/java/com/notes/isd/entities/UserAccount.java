package com.notes.isd.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.EnumSet;
import java.util.Set;
import com.notes.isd.entities.Role;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Login should not be empty")
    @Size(min = 5, max = 30, message = "Login should be between 5 and 30 characters")
    private String login;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
