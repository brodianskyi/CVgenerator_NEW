package com.codecentric.cvgenerator.api.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
    @NotNull
	private String name;
    @NotNull
    private String vorname;
    @NotNull
    private String geburtsdatum; 
    @NotNull
    private String wohnort;
    @NotNull
    private String nationalitaet;
    @NotNull
    private String sprachen;
    @NotNull
    private String telefon;
    @NotNull
    private String email;
   
    @OneToMany(mappedBy = "user") 
    private List<Ausbildung> ausbildung;
    
    public User(){};
    
    public User(long user_id) {
    	this.user_id = user_id;
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
		if(this.ausbildung == null) {
			this.ausbildung = new ArrayList<Ausbildung>();
		} else {
			this.ausbildung.add(ausbildung);			
		}
		
	}
    
   
    
    
    
}
