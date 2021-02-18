package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Domasno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Predmet predmet;

    private Date dueDate;

    private int zavrseno;

    public Domasno() {
    }

    public Domasno(Predmet predmet, Date dueDate, int zavrseno) {
        this.predmet = predmet;
        this.dueDate = dueDate;
        this.zavrseno = zavrseno;
    }
}
