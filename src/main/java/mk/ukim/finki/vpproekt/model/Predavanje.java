package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Predavanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Predmet predmet;

    private Date datumOdrzano;

    private int nauceno;

    private char predAud;

    public Predavanje() {
    }

    public Predavanje(Predmet predmet, Date datumOdrzano, int nauceno, char predAud) {
        this.predmet = predmet;
        this.datumOdrzano = datumOdrzano;
        this.nauceno = nauceno;
        this.predAud = predAud;
    }
}
