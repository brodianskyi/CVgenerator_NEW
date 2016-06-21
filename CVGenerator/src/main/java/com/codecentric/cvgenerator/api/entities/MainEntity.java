package com.codecentric.cvgenerator.api.entities;


public class MainEntity {
	
	private User user;
	private Beruf beruf;
	private Fach fach;
	private Projekte projecte;
	private Ausbildung ausbildung;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Beruf getBeruf() {
		return beruf;
	}
	public void setBeruf(Beruf beruf) {
		this.beruf = beruf;
	}
	public Fach getFach() {
		return fach;
	}
	public void setFach(Fach fach) {
		this.fach = fach;
	}
	public Projekte getProjecte() {
		return projecte;
	}
	public void setProjecte(Projekte projecte) {
		this.projecte = projecte;
	}
	public Ausbildung getAusbildung() {
		return ausbildung;
	}
	public void setAusbildung(Ausbildung ausbildung) {
		this.ausbildung = ausbildung;
	}
	
	

}
