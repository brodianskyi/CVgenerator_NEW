package com.codecentric.cvgenerator.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;



//@Component
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihr Name.")
	@Size(max = 15,message = "Maximale Namenslänge ist 15 Zeichen")
	private String name;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte schreiben Sie Ihr Vorname.")
	@Size(max = 15,message = "Maximale Vornamenslänge ist 15 Zeichen")
	private String vorname;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihr Password.")
	private String password;
	@NotNull
	@NotEmpty(message = "Falsch Format für Geburtsdatum")
	@DateTimeFormat(pattern="DD-MM-YYYY")
	private String geburtsdatum;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihren Wohnort.")
	@Size(max = 15,message = "Maximale Wohnortslänge ist 15 Zeichen")
	private String wohnort;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihre Nationalität.")
	@Size(max = 15,message = "Die maximale Größe ist 25 Zeichen")
	private String nationalitaet;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihre Sprachen.")
	@Size(max = 15,message = "Die maximale Größe ist 30 Zeichen")
	private String sprachen;
	@NotNull
	@Pattern(regexp= "[0-9]+",message = "Falsche Format für Telefonnummer.")
	private String telefon;
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihre Email.")
	@Email(message = "Falsches E-Mail-Format.")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private List<Ausbildung> ausbildung = new ArrayList<Ausbildung>();

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private List<Beruf> beruf = new ArrayList<Beruf>();

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private List<Fach> fach = new ArrayList<Fach>();

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private List<Projekte> projekte = new ArrayList<Projekte>();

	public User() {}
	public User(String name, String vorname, String password,
			String geburtsdatum, String wohnort, String nationalitaet, String sprachen, String telefon, String email) {
		
		
		this.name = name;
		this.vorname = vorname;
		this.password = password;
		this.geburtsdatum = geburtsdatum;
		this.wohnort = wohnort;
		this.nationalitaet = nationalitaet;
		this.sprachen = sprachen;
		this.telefon = telefon;
		this.email = email;
	}


   public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public String getNationalitaet() {
		return nationalitaet;
	}

	public void setNationalitaet(String nationalitaet) {
		this.nationalitaet = nationalitaet;
	}

	public String getSprachen() {
		return sprachen;
	}

	public void setSprachen(String sprachen) {
		this.sprachen = sprachen;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Ausbildung> getAusbildung() {
		return ausbildung;
	}

	public void setAusbildung(List<Ausbildung> ausbildung) {
		this.ausbildung = ausbildung;
	}

	public void addAusbildung(Ausbildung ausbildung) {
		this.ausbildung.add(ausbildung);
	}

	public List<Beruf> getBeruf() {
		return beruf;
	}

	public void setBeruf(List<Beruf> beruf) {
		this.beruf = beruf;
	}

	public void addBeruf(Beruf beruf) {
		this.beruf.add(beruf);

	}

	public List<Fach> getFach() {
		return fach;
	}

	public void setFach(List<Fach> fach) {
		this.fach = fach;
	}

	public void addFach(Fach fach) {
		this.fach.add(fach);
	}

	public List<Projekte> getProjekte() {
		return projekte;
	}

	public void setProjekte(List<Projekte> projekte) {
		this.projekte = projekte;
	}

	public void addProjekte(Projekte projekte) {
		this.projekte.add(projekte);
	}
	

}
