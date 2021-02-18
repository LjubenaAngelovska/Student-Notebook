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
    private String brojIndeks;

    @Column(length = 50)
    private String ime;

    @Column(length = 50)
    private String prezime;

    @Column(length = 50)
    private String grad;

    private Date datumZapisuvanje;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String telefon;

    private char redovenVonreden;

    @Column(length = 100)
    private String smer;


    public Student() {

    }

    public Student(String embg, String brojIndeks, String ime, String prezime, String grad, Date datumZapisuvanje, String email, String telefon, char redovenVonreden, String smer) {
        this.embg = embg;
        this.brojIndeks = brojIndeks;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
        this.datumZapisuvanje = datumZapisuvanje;
        this.email = email;
        this.telefon = telefon;
        this.redovenVonreden = redovenVonreden;
        this.smer = smer;
    }
}
