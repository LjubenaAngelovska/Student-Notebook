package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Sesija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String opis;

    @Column(length = 50)
    private String ses_kol;

    private Date datum_od;

    private Date datum_do;

    public Sesija() {
    }

    public Sesija(String opis, String ses_kol, Date datum_od, Date datum_do) {
        this.opis = opis;
        this.ses_kol = ses_kol;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }
}
