package com.codecentric.cvgenerator.api.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UploadFile {
	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private long id;
	@Column(name = "FILE_NAME")
	private String fileName;
//	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "LONGBLOB") 
//	@Column(name = "FILE_DATA",  length = 100000 )
	private byte[] data;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
