package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "autorzy")
public class Authors {
    @Id
    @Column(name = "id_autora")
    private Integer id;

    @Column(name = "mail")
    private String mail;

    @Column(name = "www")
    private String www;

    @Column(name = "miasto")
    private String city;

    @Column(name = "kraj")
    private String country;

    @Column(name = "kontynent")
    private Integer continent;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String secondName;

    @Column(name = "grupa")
    private Integer group;

    @Column(name = "lider")
    private Character leader;

    @Column(name = "historia")
    private String history;

    @Column(name = "sprawdzony")
    private String tested;

    @Column(name = "data_dodania")
    private Date add_date;

    @Column(name = "potwierdzenie")
    private Integer confirmation;

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getWww() {
        return www;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getContinent() {
        return continent;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Integer getGroup() {
        return group;
    }

    public Character getLeader() {
        return leader;
    }

    public String getHistory() {
        return history;
    }

    public String getTested() {
        return tested;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public Integer getConfirmation() {
        return confirmation;
    }
}