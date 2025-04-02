package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="case_manager_id")
    private CaseManager caseManager;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles_mapping",
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
