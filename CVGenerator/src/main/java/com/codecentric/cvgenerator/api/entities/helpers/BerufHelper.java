package com.codecentric.cvgenerator.api.entities.helpers;

import java.util.ArrayList;

public class BerufHelper {

	private ArrayList<String> beruf_begin;
	private ArrayList<String> beruf_end;
	private ArrayList<String> beruf_stelle;
	private ArrayList<String> beruf_position;

	public ArrayList<String> getBeruf_begin() {
		return beruf_begin;
	}

	public void setBeruf_begin(ArrayList<String> beruf_begin) {
		this.beruf_begin = beruf_begin;
	}

	public ArrayList<String> getBeruf_end() {
		return beruf_end;
	}

	public void setBeruf_end(ArrayList<String> beruf_end) {
		this.beruf_end = beruf_end;
	}

	public ArrayList<String> getBeruf_stelle() {
		return beruf_stelle;
	}

	public void setBeruf_stelle(ArrayList<String> beruf_stelle) {
		this.beruf_stelle = beruf_stelle;
	}

	public ArrayList<String> getBeruf_position() {
		return beruf_position;
	}

	public void setBeruf_position(ArrayList<String> beruf_position) {
		this.beruf_position = beruf_position;
	}

}
