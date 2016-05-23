package com.codecentric.cvgenerator.api.entities.helpers;

import java.util.ArrayList;

public class FachHelper {

	private ArrayList<String> fach_gebiet;
	private ArrayList<String> fach_kenntnisse;

	public ArrayList<String> getFach_gebiet() {
		return fach_gebiet;
	}

	public void setFach_gebiet(ArrayList<String> fach_gebiet) {
		this.fach_gebiet = fach_gebiet;
	}

	public ArrayList<String> getFach_kenntnisse() {
		return fach_kenntnisse;
	}

	public void setFach_kenntnisse(ArrayList<String> fach_kenntnisse) {
		this.fach_kenntnisse = fach_kenntnisse;
	}

}
