package pl.coderslab.model;

import org.hibernate.validator.constraints.Email;
import sun.security.util.Password;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int typeUser = 0;//0 - user, 1 - admin
    @NotNull(message = "Podaj imię")
    private String userFirstName;
    @NotNull(message = "Podaj nazwisko")
    private String userLastName;
    @Email
    @NotNull(message = "Podaj email")
    private String email;
    @NotNull(message = "Podaj haslo")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
