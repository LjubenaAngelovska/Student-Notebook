package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Zabeleski {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Predmet predmet;

    private Timestamp timestamp;

    @Column(length = 255)
    private String tekst_zabeleska;

    public Zabeleski() {
    }

    public Zabeleski(Predmet predmet, String tekst_zabeleska) {
        this.predmet = predmet;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.tekst_zabeleska = tekst_zabeleska;
    }
}
