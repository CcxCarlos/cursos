package com.balmes.cursos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cursId;
	@Column(nullable = false)
	private String titolCurs;

	@Column(nullable = false)
	private String descCurs;

	@Column(nullable = false)
	private String urlCurs;

	@ManyToMany(mappedBy = "cursos")
	private List<Estudiant> estudiants;
	
	public Curs() {}
	
	public Curs(int cursId, String titolCurs, String descCurs, String urlCurs) {
		this.cursId = cursId;
		this.titolCurs = titolCurs;
		this.descCurs = descCurs;
		this.urlCurs = urlCurs;
		this.estudiants = new ArrayList<>();
	}

	public Curs(int cursId, String titolCurs, String descCurs, String urlCurs, List<Estudiant> estudiants) {
		this.cursId = cursId;
		this.titolCurs = titolCurs;
		this.descCurs = descCurs;
		this.urlCurs = urlCurs;
		this.estudiants = estudiants;
	}

	public void addEstudiant(Estudiant estudiant){
		estudiants.add(estudiant);
	}
	public Estudiant getEstudiantByPos(int num){
		return estudiants.get(num);
	}
	public List<Estudiant> getEstudiants() {
		return estudiants;
	}

	public void setEstudiants(List<Estudiant> estudiants) {
		this.estudiants = estudiants;
	}

	public long getCursId() {
		return cursId;
	}

	public void setCursId(long cursId) {
		this.cursId = cursId;
	}

	public String getTitolCurs() {
		return titolCurs;
	}

	public void setTitolCurs(String titolCurs) {
		this.titolCurs = titolCurs;
	}

	public String getDescCurs() {
		return descCurs;
	}

	public void setDescCurs(String descCurs) {
		this.descCurs = descCurs;
	}

	public String getUrlCurs() {
		return urlCurs;
	}

	public void setUrlCurs(String urlCurs) {
		this.urlCurs = urlCurs;
	}
}
