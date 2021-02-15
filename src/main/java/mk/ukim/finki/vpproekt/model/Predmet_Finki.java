package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Predmet_Finki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String ime;

    private String opis;

    @Column(length = 50)
    private String semestar;

    private char zadolzitelen;

    public Predmet_Finki() {
    }

    public Predmet_Finki(String ime, String opis, String semestar, char zadolzitelen) {
        this.ime = ime;
        this.opis = opis;
        this.semestar = semestar;
        this.zadolzitelen = zadolzitelen;
    }
}
