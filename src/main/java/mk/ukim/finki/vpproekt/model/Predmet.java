package mk.ukim.finki.vpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Predmet_Finki predmet_finki;

    @ManyToOne
    private Student student;

    private char tekovno_zapisan;

    private int koj_pat;

    @Column(length = 50)
    private String semestar_zapisan;

    private char polozen;

    private int ocenka;

    public Predmet() {
    }

    public Predmet(Predmet_Finki predmet_finki, Student student, char tekovno_zapisan, int koj_pat, String semestar_zapisan, char polozen, int ocenka) {
        this.predmet_finki = predmet_finki;
        this.student = student;
        this.tekovno_zapisan = tekovno_zapisan;
        this.koj_pat = koj_pat;
        this.semestar_zapisan = semestar_zapisan;
        this.polozen = polozen;
        this.ocenka = ocenka;
    }
}
