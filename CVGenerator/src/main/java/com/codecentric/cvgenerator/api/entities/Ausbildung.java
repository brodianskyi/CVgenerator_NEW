package com.codecentric.cvgenerator.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "ausbildung")
public class Ausbildung {
	   
	    @Id
	    @Column(name = "ausbildung_id")
	    private int id;
	    
	    private String ausbildung_datum_1;
	    private String ausbildung_datum_2;
	    private String ausbildung_ort;
	    private String ausbildung_stelle;
	   
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    public Ausbildung(){
	    	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAusbildung_datum_1() {
			return ausbildung_datum_1;
		}

		public void setAusbildung_datum_1(String ausbildung_datum_1) {
			this.ausbildung_datum_1 = ausbildung_datum_1;
		}

		public String getAusbildung_datum_2() {
			return ausbildung_datum_2;
		}

		public void setAusbildung_datum_2(String ausbildung_datum_2) {
			this.ausbildung_datum_2 = ausbildung_datum_2;
		}

		public String getAusbildung_ort() {
			return ausbildung_ort;
		}

		public void setAusbildung_ort(String ausbildung_ort) {
			this.ausbildung_ort = ausbildung_ort;
		}

		public String getAusbildung_stelle() {
			return ausbildung_stelle;
		}

		public void setAusbildung_stelle(String ausbildung_stelle) {
			this.ausbildung_stelle = ausbildung_stelle;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    
	    
	  
	
		
	   
		
}
