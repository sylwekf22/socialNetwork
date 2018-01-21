package pojo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "tytul")
public class Title implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tytulu")
    private Integer id;

    @Column(name = "tytul")
    private String title;

    @Column(name = "miejsce_wydania")
    private String publication_place;

    @Column(name = "rok_wydania")
    private String publication_year;

    @Column(name = "id_wydawnictwa")
    private Integer publisher_id;

    @Column(name = "miesiac_wydania")
    private String publication_month;

    @Column(name = "rozdzial_ksiazki")
    private String book_chapter;

    @Column(name = "strony")
    private String pages;

    @Column(name = "tom_ksiazki")
    private String book_volume;

    @Column(name = "notka")
    private String note;

    @Column(name = "seria_ksiazki")
    private String book_series;

    @Column(name = "podtytul")
    private String subtitle;

    @Column(name = "szkola")
    private String school;

    @Column(name = "id_uzytkownika")
    private Integer user_id;

    @Column(name = "url")
    private String url;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "abstract")
    @Type(type = "text")
    private String preface;

    @Column(name = "issn")
    private String issn;

    @Column(name = "klasyfikator")
    private String classifier;

    @Column(name = "data_dodania")
    private Date return_date;

    @Column(name = "key_publ")
    private String public_key;

    @Column(name = "ee_dblp")
    private String ee_dblp;

    @Column(name = "url_dblp")
    private String url_dblp;

    @Column(name = "cdrom_dblp")
    private String cdrom_dblp;

    @Column(name = "crossref_dblp")
    private String crossref_dblp;

    @Column(name = "howpublished")
    private String howpublished;

    @Column(name = "type")
    private String type;

    @Column(name = "institution")
    private String institution;

    @Column(name = "potwierdzenie")
    private Integer confirmation;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublication_place() {
        return publication_place;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public String getPublication_month() {
        return publication_month;
    }

    public String getBook_chapter() {
        return book_chapter;
    }

    public String getPages() {
        return pages;
    }

    public String getBook_volume() {
        return book_volume;
    }

    public String getNote() {
        return note;
    }

    public String getBook_series() {
        return book_series;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSchool() {
        return school;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUrl() {
        return url;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPreface() {
        return preface;
    }

    public String getIssn() {
        return issn;
    }

    public String getClassifier() {
        return classifier;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public String getPublic_key() {
        return public_key;
    }

    public String getEe_dblp() {
        return ee_dblp;
    }

    public String getUrl_dblp() {
        return url_dblp;
    }

    public String getCdrom_dblp() {
        return cdrom_dblp;
    }

    public String getCrossref_dblp() {
        return crossref_dblp;
    }

    public String getHowpublished() {
        return howpublished;
    }

    public String getType() {
        return type;
    }

    public String getInstitution() {
        return institution;
    }

    public Integer getConfirmation() {
        return confirmation;
    }
}