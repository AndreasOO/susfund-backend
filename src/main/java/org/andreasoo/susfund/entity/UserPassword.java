package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

@Entity
@Table (name="user_password")
public class UserPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;

    @OneToOne
    @JoinColumn(name="user_credentials_id")
    private UserCredentials userCredentials;

    public UserPassword() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }
}
