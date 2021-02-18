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
    private String sesKol;

    private Date datumOd;

    private Date datumDo;

    public Sesija() {
    }

    public Sesija(String opis, String sesKol, Date datumOd, Date datumDo) {
        this.opis = opis;
        this.sesKol = sesKol;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }
}
