package com.codecentric.cvgenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 23,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
	private static int  STRING_END = 57;
    private User user;
	/**
	 * @param args
	 */
	
	public CreatePDF(User user){
		 this.user = user;
	}
	
	public Document createPDF(String file) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document);

			addPerson(document);

			addAusbildung(document);
			
			addBeruf(document);
			
			addFachkenntnisse(document);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
		
		
	}

	private void addPerson(Document document)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Zur Person", TIME_ROMAN));

		creteEmptyLine(preface, 1);

		preface.add(new Paragraph("Geburtsdatum "
				+ "         " + user.getGeburtsdatum(),TIME_ROMAN_SMALL ));
		
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Nationalität"
				+ "         " + user.getNationalitaet(), TIME_ROMAN_SMALL));
		
		preface.add(new Paragraph("Telefon"
				+ "         " + user.getTelefon(), TIME_ROMAN_SMALL));
		
		preface.add(new Paragraph("Email"
				+ "         " + user.getTelefon(), TIME_ROMAN_SMALL));
	 
		document.add(preface);
		

	}
	
	private void addAusbildung(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Ausbildung und Berufserfahrung", TIME_ROMAN));
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph(user.getAusbildung_datum_1()+ " - "+ user.getAusbildung_datum_2() +
				"          " + user.getAusbildung_ort(),TIME_ROMAN_SMALL));
		preface.add(new Paragraph(
	    "                  " + user.getAusbildung_stelle(), TIME_ROMAN_SMALL));
		document.add(preface);
		
	}
	
	private void addBeruf(Document document)
	        throws DocumentException{
		
		Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
		
        preface.add(new Paragraph(user.getBeruf_datum_1()+ " - "+ user.getBeruf_datum_2() +
				"          " + user.getBeruf_ort(),TIME_ROMAN_SMALL));
		preface.add(new Paragraph(
	    "                  " + user.getBeruf_stelle(), TIME_ROMAN_SMALL));
		document.add(preface);
	    
	 }
	
	
	private void addFachkenntnisse(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		
		preface.add(new Paragraph("Fachkenntnisse", TIME_ROMAN));
		
		creteEmptyLine(preface, 1);
		
		preface.add(new Paragraph(user.getFach_gebiet()
				+ "         " + user.getFach_kenntnisse() , TIME_ROMAN_SMALL));
		
		
		document.add(preface);
	}
	
	private void addProjecte(Document document)
	       throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		
		preface.add(new Paragraph(user.getFach_gebiet()
				+ "         " + user.getFach_kenntnisse() , TIME_ROMAN_SMALL));
		
		
	}

	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	

}
