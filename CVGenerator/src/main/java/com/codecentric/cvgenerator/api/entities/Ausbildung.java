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
@Table (name = "ausbildung")
public class Ausbildung {
	
	   
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long ausbildung_id;
	    private String ausbildung_begin ;
        private String ausbildung_end ;
        private String ausbildung_ort;
        private String ausbildung_stelle; 
	    
        @ManyToOne
	    @JoinColumn(name = "user_id", 
                insertable=false, updatable=false, 
                nullable=true
               // referencedColumnName="user_id")
                )
	    @JsonIgnore
	    private User user;
	    
	    public Ausbildung(){};
	   
	    
	    
		public Ausbildung(String ausbildung_begin, String ausbildung_end, String ausbildung_ort,
				String ausbildung_stelle) {
			
			this.ausbildung_begin = ausbildung_begin;
			this.ausbildung_end = ausbildung_end;
			this.ausbildung_ort = ausbildung_ort;
			this.ausbildung_stelle = ausbildung_stelle;
		}



		public long getAusbildung_id() {
			return ausbildung_id;
		}
		
		public void setAusbildung_id(long ausbildung_id) {
			this.ausbildung_id = ausbildung_id;
		}
		
		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
		public String getAusbildung_begin() {
			return ausbildung_begin;
		}
		
		public void setAusbildung_begin(String ausbildung_begin) {
			this.ausbildung_begin = ausbildung_begin;
		}
		
		public String getAusbildung_end() {
			return ausbildung_end;
		}
		
		public void setAusbildung_end(String ausbildung_end) {
			this.ausbildung_end = ausbildung_end;
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

 }
