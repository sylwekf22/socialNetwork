package dto;


import java.util.Date;

public class TitleDto{

    private Integer id;

    private String title;

    private String publication_place;

    private String publication_year;

    private Integer publisher_id;

    private String publication_month;

    private String book_chapter;

    private String pages;

    private String book_volume;

    private String note;

    private String book_series;

    private String subtitle;

    private String school;

    private Integer user_id;

    private String url;

    private String isbn;

    private String preface;

    private String issn;

    private String classifier;

    private Date return_date;

    private String public_key;

    private String ee_dblp;

    private String url_dblp;

    private String cdrom_dblp;

    private String crossref_dblp;

    private String howpublished;

    private String type;

    private String institution;

    private Integer confirmation;

    public TitleDto() {
    }

    public TitleDto(Integer id, String title, String publication_place, String publication_year, Integer publisher_id, String publication_month, String book_chapter, String pages, String book_volume, String note, String book_series, String subtitle, String school, Integer user_id, String url, String isbn, String preface, String issn, String classifier, Date return_date, String public_key, String ee_dblp, String url_dblp, String cdrom_dblp, String crossref_dblp, String howpublished, String type, String institution, Integer confirmation) {
        this.id = id;
        this.title = title;
        this.publication_place = publication_place;
        this.publication_year = publication_year;
        this.publisher_id = publisher_id;
        this.publication_month = publication_month;
        this.book_chapter = book_chapter;
        this.pages = pages;
        this.book_volume = book_volume;
        this.note = note;
        this.book_series = book_series;
        this.subtitle = subtitle;
        this.school = school;
        this.user_id = user_id;
        this.url = url;
        this.isbn = isbn;
        this.preface = preface;
        this.issn = issn;
        this.classifier = classifier;
        this.return_date = return_date;
        this.public_key = public_key;
        this.ee_dblp = ee_dblp;
        this.url_dblp = url_dblp;
        this.cdrom_dblp = cdrom_dblp;
        this.crossref_dblp = crossref_dblp;
        this.howpublished = howpublished;
        this.type = type;
        this.institution = institution;
        this.confirmation = confirmation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublication_place() {
        return publication_place;
    }

    public void setPublication_place(String publication_place) {
        this.publication_place = publication_place;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublication_month() {
        return publication_month;
    }

    public void setPublication_month(String publication_month) {
        this.publication_month = publication_month;
    }

    public String getBook_chapter() {
        return book_chapter;
    }

    public void setBook_chapter(String book_chapter) {
        this.book_chapter = book_chapter;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getBook_volume() {
        return book_volume;
    }

    public void setBook_volume(String book_volume) {
        this.book_volume = book_volume;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBook_series() {
        return book_series;
    }

    public void setBook_series(String book_series) {
        this.book_series = book_series;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getEe_dblp() {
        return ee_dblp;
    }

    public void setEe_dblp(String ee_dblp) {
        this.ee_dblp = ee_dblp;
    }

    public String getUrl_dblp() {
        return url_dblp;
    }

    public void setUrl_dblp(String url_dblp) {
        this.url_dblp = url_dblp;
    }

    public String getCdrom_dblp() {
        return cdrom_dblp;
    }

    public void setCdrom_dblp(String cdrom_dblp) {
        this.cdrom_dblp = cdrom_dblp;
    }

    public String getCrossref_dblp() {
        return crossref_dblp;
    }

    public void setCrossref_dblp(String crossref_dblp) {
        this.crossref_dblp = crossref_dblp;
    }

    public String getHowpublished() {
        return howpublished;
    }

    public void setHowpublished(String howpublished) {
        this.howpublished = howpublished;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Integer confirmation) {
        this.confirmation = confirmation;
    }
}