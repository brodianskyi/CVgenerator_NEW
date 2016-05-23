package com.codecentric.cvgenerator.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fach")
public class Fach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fach_id;

	private String fach_gebiet;
	private String fach_kenntnisse;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = true
	// referencedColumnName="user_id")
	)
	@JsonIgnore
	private User user;

	public Fach() {
	};

	public Fach(String fach_gebiet, String fach_kenntnisse) {

		this.fach_gebiet = fach_gebiet;
		this.fach_kenntnisse = fach_kenntnisse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getFach_id() {
		return fach_id;
	}

	public void setFach_id(long fach_id) {
		this.fach_id = fach_id;
	}

	public String getFach_gebiet() {
		return fach_gebiet;
	}

	public void setFach_gebiet(String fach_gebiet) {
		this.fach_gebiet = fach_gebiet;
	}

	public String getFach_kenntnisse() {
		return fach_kenntnisse;
	}

	public void setFach_kenntnisse(String fach_kenntnisse) {
		this.fach_kenntnisse = fach_kenntnisse;
	}

}
