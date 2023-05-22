package com.balmes.cursos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long estudiantId;

    @Column(nullable = false)
    private String estudiantNom;

    @Column(nullable = false)
    private String estudiantCognom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "estudiant_curs",
            joinColumns = @JoinColumn(name = "estudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "curs_id")
    )
    private List<Curs> cursos;

    public Estudiant() {
    }
    public Estudiant(long id) {
        this.estudiantId = id;
    }

    public Estudiant(int estudiantId, String estudiantNom, String estudiantCognom, Curs curs) {
        this.estudiantId = estudiantId;
        this.estudiantNom = estudiantNom;
        this.estudiantCognom = estudiantCognom;
    }

    public long getEstudiantId() {
        return estudiantId;
    }

    public void setEstudiantId(long estudiantId) {
        this.estudiantId = estudiantId;
    }

    public String getEstudiantNom() {
        return estudiantNom;
    }

    public void setEstudiantNom(String estudiantNom) {
        this.estudiantNom = estudiantNom;
    }

    public String getEstudiantCognom() {
        return estudiantCognom;
    }

    public void setEstudiantCognom(String estudiantCognom) {
        this.estudiantCognom = estudiantCognom;
    }

    public List<Curs> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curs> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudiant estudiant = (Estudiant) o;

        return estudiantId == estudiant.estudiantId;
    }

    @Override
    public int hashCode() {
        return (int) (estudiantId ^ (estudiantId >>> 32));
    }
}
