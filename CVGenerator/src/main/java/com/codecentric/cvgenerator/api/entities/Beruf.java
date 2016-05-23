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
@Table(name = "beruf")
public class Beruf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long beruf_id;

	private String beruf_begin;
	private String beruf_end;
	private String beruf_position;
	private String beruf_stelle;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = true
	// referencedColumnName="user_id")
	)
	@JsonIgnore
	private User user;

	public Beruf() {
	};

	public Beruf(String beruf_begin, String beruf_end, String beruf_stelle, String beruf_position) {

		this.beruf_begin = beruf_begin;
		this.beruf_end = beruf_end;
		this.beruf_stelle = beruf_stelle;
		this.beruf_position = beruf_position;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getBeruf_id() {
		return beruf_id;
	}

	public void setBeruf_id(long beruf_id) {
		this.beruf_id = beruf_id;
	}

	public String getBeruf_begin() {
		return beruf_begin;
	}

	public void setBeruf_begin(String beruf_begin) {
		this.beruf_begin = beruf_begin;
	}

	public String getBeruf_end() {
		return beruf_end;
	}

	public void setBeruf_end(String beruf_end) {
		this.beruf_end = beruf_end;
	}

	public String getBeruf_position() {
		return beruf_position;
	}

	public void setBeruf_position(String beruf_position) {
		this.beruf_position = beruf_position;
	}

	public String getBeruf_stelle() {
		return beruf_stelle;
	}

	public void setBeruf_stelle(String beruf_stelle) {
		this.beruf_stelle = beruf_stelle;
	}

}
