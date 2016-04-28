package com.codecentric.cvgenerator.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long ausbildung_id;
	    @ElementCollection
	    @Column(name="AUSBILDUNG_DATE")
	    @CollectionTable(name ="AUSBILDUNG_DATE", joinColumns={@JoinColumn(name="ausbildung_id")})
	    private List<String> ausbildung_datum_1 = new ArrayList<String>();
	 /*   @ElementCollection
	    @Column(name="AUSBILDUNG_DATE_2")
	    @CollectionTable(name ="AUSBILDUNG_DATE_2", joinColumns={@JoinColumn(name="ausbildung_id")})
	    private ArrayList<String> ausbildung_datum_2 = new ArrayList<String>(); 
	  */
	    private String ausbildung_ort;
	    private String ausbildung_stelle;
	   
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    public Ausbildung(){};
	    public Ausbildung(long ausbildung_id){
	    	this.ausbildung_id = ausbildung_id;
	    }

		
        public long getAusbildung_id() {
			return ausbildung_id;
		}
		public void setAusbildung_id(long ausbildung_id) {
			this.ausbildung_id = ausbildung_id;
		}
		public List<String> getAusbildung_datum_1() {
			return ausbildung_datum_1;
		}

		public void setAusbildung_datum_1(List<String> ausbildung_datum_1) {
			this.ausbildung_datum_1 = ausbildung_datum_1;
		}

		
	/* public ArrayList<String> getAusbildung_datum_2() {
			return ausbildung_datum_2;
		}
		public void setAusbildung_datum_2(ArrayList<String> ausbildung_datum_2) {
			this.ausbildung_datum_2 = ausbildung_datum_2;
		}
	*/
			

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
