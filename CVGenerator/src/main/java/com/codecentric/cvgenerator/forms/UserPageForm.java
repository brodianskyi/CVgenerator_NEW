package com.codecentric.cvgenerator.forms;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserPageForm {
	
	@NotEmpty(message = "Schreiben Sie bitte Ihr Name.")
	@Size(max = 15,message = "Maximale Namenslänge ist 15 Zeichen")
	private String name;
	@NotEmpty(message = "Schreiben Sie bitte schreiben Sie Ihr Vorname.")
	@Size(max = 15,message = "Maximale Vornamenslänge ist 15 Zeichen")
	private String vorname;
	@NotEmpty(message = "Falsch Format für Geburtsdatum")
	@DateTimeFormat(pattern="DD-MM-YYYY")
	private String geburtsdatum;
	@NotEmpty(message = "Schreiben Sie bitte Ihren Wohnort.")
	@Size(max = 15,message = "Maximale Wohnortslänge ist 15 Zeichen")
	private String wohnort;
	@NotEmpty(message = "Schreiben Sie bitte Ihre Nationalität.")
	@Size(max = 15,message = "Die maximale Größe ist 25 Zeichen")
	private String nationalitaet;
	@NotEmpty(message = "Schreiben Sie bitte Ihre Sprachen.")
	@Size(max = 15,message = "Die maximale Größe ist 30 Zeichen")
	private String sprachen;
	@Pattern(regexp= "[0-9]+",message = "Falsche Format für Telefonnummer.")
	private String telefon;
	@NotEmpty(message = "Schreiben Sie bitte Ihre Email.")
	@Email(message = "Falsches E-Mail-Format.")
	private String email;

	private String message;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
	
	

}
