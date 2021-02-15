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

    private Date datum_odrzano;

    private int nauceno;

    private char pred_aud;

    public Predavanje() {
    }

    public Predavanje(Predmet predmet, Date datum_odrzano, int nauceno, char pred_aud) {
        this.predmet = predmet;
        this.datum_odrzano = datum_odrzano;
        this.nauceno = nauceno;
        this.pred_aud = pred_aud;
    }
}
