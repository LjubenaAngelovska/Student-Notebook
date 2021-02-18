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

    private Date datumPolaganje;

    private char online;

    private char polozen;

    private double osvoeniPoeni;

    private char teorijaPrakticno;

    public Polaganje() {
    }

    public Polaganje(Predmet predmet, Sesija sesija, Date datumPolaganje, char online, char polozen, double osvoeniPoeni, char teorijaPrakticno) {
        this.predmet = predmet;
        this.sesija = sesija;
        this.datumPolaganje = datumPolaganje;
        this.online = online;
        this.polozen = polozen;
        this.osvoeniPoeni = osvoeniPoeni;
        this.teorijaPrakticno = teorijaPrakticno;
    }
}
