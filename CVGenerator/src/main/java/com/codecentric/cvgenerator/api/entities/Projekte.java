package com.codecentric.cvgenerator.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projekte {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long projekte_id;
	 
	    private String projekte_begin;
	    private String projekte_kunde;
	    private String projekte_end;
	    private String projekte_thematik;
	    private String projekte_rolle;
	    private String projekte_technologie;
	
	    @ManyToOne
	    @JoinColumn(name = "user_id", 
	         insertable=false, updatable=false, 
	         nullable=true
	        // referencedColumnName="user_id")
	         )
	    
	    @JsonIgnore
	    private User user;
	    
	    public Projekte(){}


		public Projekte(String projekte_begin, String projekte_kunde, String projekte_end, String projekte_thematik,
				String projekte_rolle, String projekte_technologie) {
			
			this.projekte_begin = projekte_begin;
			this.projekte_kunde = projekte_kunde;
			this.projekte_end = projekte_end;
			this.projekte_thematik = projekte_thematik;
			this.projekte_rolle = projekte_rolle;
			this.projekte_technologie = projekte_technologie;
		}


        public User getUser() {
			return user;
		}
            

		public void setUser(User user) {
			this.user = user;
		}


		public long getProjekte_id() {
			return projekte_id;
		}


		public void setProjekte_id(long projekte_id) {
			this.projekte_id = projekte_id;
		}


		public String getProjekte_begin() {
			return projekte_begin;
		}


		public void setProjekte_begin(String projekte_begin) {
			this.projekte_begin = projekte_begin;
		}


		public String getProjekte_kunde() {
			return projekte_kunde;
		}


		public void setProjekte_kunde(String projekte_kunde) {
			this.projekte_kunde = projekte_kunde;
		}


		public String getProjekte_end() {
			return projekte_end;
		}


		public void setProjekte_end(String projekte_end) {
			this.projekte_end = projekte_end;
		}


		public String getProjekte_thematik() {
			return projekte_thematik;
		}


		public void setProjekte_thematik(String projekte_thematik) {
			this.projekte_thematik = projekte_thematik;
		}


		public String getProjekte_rolle() {
			return projekte_rolle;
		}


		public void setProjekte_rolle(String projekte_rolle) {
			this.projekte_rolle = projekte_rolle;
		}


		public String getProjekte_technologie() {
			return projekte_technologie;
		}


		public void setProjekte_technologie(String projekte_technologie) {
			this.projekte_technologie = projekte_technologie;
		}


	
}
