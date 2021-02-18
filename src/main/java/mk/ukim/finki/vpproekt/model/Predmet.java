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
    private Predmet_Finki predmetFinki;

    @ManyToOne
    private Student student;

    private char tekovnoZapisan;

    private int kojPat;

    @Column(length = 50)
    private String semestarZapisan;

    private char polozen;

    private int ocenka;

    public Predmet() {
    }

    public Predmet(Predmet_Finki predmetFinki, Student student, char tekovnoZapisan, int kojPat, String semestarZapisan, char polozen, int ocenka) {
        this.predmetFinki = predmetFinki;
        this.student = student;
        this.tekovnoZapisan = tekovnoZapisan;
        this.kojPat = kojPat;
        this.semestarZapisan = semestarZapisan;
        this.polozen = polozen;
        this.ocenka = ocenka;
    }
}
