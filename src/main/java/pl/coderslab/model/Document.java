package pl.coderslab.model;

import javax.persistence.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> person =  new ArrayList<>();
    private Date createDate;
    private String path;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<File> files = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
