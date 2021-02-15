package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Polaganje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Predmet predmet;

    @ManyToOne
    Sesija sesija;

    private Date datum_polaganje;

    private char online;

    private char polozen;

    private double osvoeni_poeni;

    private char teorija_prakticno;

    public Polaganje() {
    }

    public Polaganje(Predmet predmet, Sesija sesija, Date datum_polaganje, char online, char polozen, double osvoeni_poeni, char teorija_prakticno) {
        this.predmet = predmet;
        this.sesija = sesija;
        this.datum_polaganje = datum_polaganje;
        this.online = online;
        this.polozen = polozen;
        this.osvoeni_poeni = osvoeni_poeni;
        this.teorija_prakticno = teorija_prakticno;
    }
}
