package entity.appuser;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name="user_password")
public class UserPassword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String password;


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

}
