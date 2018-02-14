package dto;


import java.util.Date;

// Klasa do reprezentacji obiektów z bazy danych tabeli autorzy

public class AuthorDto {

    private Integer id;
    private String mail;
    private String www;
    private String city;
    private String country;
    private Integer continent;
    private String firstName;
    private String secondName;
    private Integer group;
    private Character leader;
    private String history;
    private String tested;
    private Date add_date;
    private Integer confirmation;

    public AuthorDto() {
    }

    public AuthorDto(Integer id, String mail, String www, String city, String country, Integer continent, String firstName, String secondName, Integer group, Character leader, String history, String tested, Date add_date, Integer confirmation) {
        this.id = id;
        this.mail = mail;
        this.www = www;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.firstName = firstName;
        this.secondName = secondName;
        this.group = group;
        this.leader = leader;
        this.history = history;
        this.tested = tested;
        this.add_date = add_date;
        this.confirmation = confirmation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Character getLeader() {
        return leader;
    }

    public void setLeader(Character leader) {
        this.leader = leader;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTested() {
        return tested;
    }

    public void setTested(String tested) {
        this.tested = tested;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public Integer getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Integer confirmation) {
        this.confirmation = confirmation;
    }
}
