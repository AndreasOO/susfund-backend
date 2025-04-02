package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String username;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_password_id")
    private UserPassword userPassword;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="case_manager_id")
    private CaseManager caseManager;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_credentials_user_roles",
            joinColumns = @JoinColumn(name = "user_credentials_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id")
    )
    private List<UserRole> userRoles;


    public UserCredentials() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public CaseManager getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(CaseManager caseManager) {
        this.caseManager = caseManager;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserPassword getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPassword userPassword) {
        this.userPassword = userPassword;
    }
}
