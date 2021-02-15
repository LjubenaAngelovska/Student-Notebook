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

    private Date due_date;

    private int zavrseno;

    public Domasno() {
    }

    public Domasno(Predmet predmet, Date due_date, int zavrseno) {
        this.predmet = predmet;
        this.due_date = due_date;
        this.zavrseno = zavrseno;
    }
}
