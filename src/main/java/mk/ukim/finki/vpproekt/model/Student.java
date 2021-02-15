package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 13)
    private String embg;

    @Column(length = 6)
    private String broj_indeks;

    @Column(length = 50)
    private String ime;

    @Column(length = 50)
    private String prezime;

    @Column(length = 50)
    private String grad;

    private Date datum_zapisuvanje;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String telefon;

    private char redoven_vonreden;

    @Column(length = 100)
    private String smer;


    public Student() {

    }

    public Student(String embg, String broj_indeks, String ime, String prezime, String grad, Date datum_zapisuvanje, String email, String telefon, char redoven_vonreden, String smer) {
        this.embg = embg;
        this.broj_indeks = broj_indeks;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
        this.datum_zapisuvanje = datum_zapisuvanje;
        this.email = email;
        this.telefon = telefon;
        this.redoven_vonreden = redoven_vonreden;
        this.smer = smer;
    }
}
