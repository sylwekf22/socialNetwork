package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tab_lacz1")
public class TableConnectOne implements Serializable{

    private static final long serialVersionUID = 1L;

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