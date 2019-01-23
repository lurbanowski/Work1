package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private boolean active = true;//not active false
    @NotNull
    private boolean alive = false; //żyjące = true
    @NotNull
    private boolean family = true; // nie rodzina =  false
    @NotNull
    private String gender;
    @Column(length = 150)
    private String firstName;
    @Column(length = 150)
    private String lastName;
    @Column(length = 150)
    private String maiden;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Document> document = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
    }
}
