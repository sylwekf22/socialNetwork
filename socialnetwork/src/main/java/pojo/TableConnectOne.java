package pojo;

import javax.persistence.*;

@Entity
@Table(name = "tab_lacz1")
public class TableConnectOne {

    @Id
    private Integer id;

    @Column(name = "id_tytulu")
    private Integer title_id;

    @Column(name = "kolejnosc")
    private Integer order;

    @Column(name = "id_autora")
    private Integer author_id;

    @Column(name = "potwierdzenie")
    private Integer confirmation;

    public Integer getTitle_id() {
        return title_id;
    }

    public Integer getOrder() {
        return order;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public Integer getConfirmation() {
        return confirmation;
    }
}