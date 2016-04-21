package com.codecentric.cvgenerator.api.pdfhandlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.utils.stringutils.StringTokenizer;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF extends PdfPageEventHelper {
	//BaseColor.CYAN 
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String IMAGE_CODECENTRIC = "/home/pavel/git/CVgenerator_NEW/CVGenerator/src/main/webapp/resources/images/codecentric-ag.gif";
	public static final String IMAGE_MAIN = "/home/pavel/git/CVgenerator_NEW/CVGenerator/src/main/webapp/resources/images/for_pdf2.png";
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 23,Font.BOLD);
	private static Font TIME_ROMAN_MAIN = new Font(Font.FontFamily.TIMES_ROMAN, 23,Font.BOLD);
	private static Font TIME_ROMAN_BIG = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
	private StringTokenizer stringTokenizer = new StringTokenizer();
    private User user;
    private int pagenumber;
	/**
	 * @param args
	 */
	
	public CreatePDF(User user){
		 this.user = user;
	}
	
	
	public void onEndPage(PdfWriter writer,Document document){
	
      try {
    	    pagenumber++;
    	    Image image = Image.getInstance(IMAGE_CODECENTRIC);
			image.setAbsolutePosition(330, 720);
			image.scaleToFit(200, 200);
		if (pagenumber > 1){
			document.add(image);
		}	
		} catch (BadElementException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document createPDF(String file) throws MalformedURLException, IOException {

		Document document = null;

		try {
			document = new Document(PageSize.A4, 20, 20, 130, 50);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			writer.setPageEvent(this);
			document.open();
			
			addMetaData(document);

			addTitleCV(document,writer);
			
			addPerson(document);

			addAusbildung(document);
			
			addBeruf(document);
			
			addFachkenntnisse(document);
			
			addProjecte(document);
		
		
			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

    private void addTitleCV(Document document,PdfWriter writer) throws MalformedURLException, IOException, DocumentException {
    	PdfContentByte canvas = writer.getDirectContentUnder();
    	PdfPTable table = new PdfPTable(3);
	    table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	    table.setWidthPercentage(100f);
	    table.setSpacingBefore(400f);
	    table.setSpacingAfter(500f);
	    TIME_ROMAN_BIG.setColor(BaseColor.WHITE);
	    TIME_ROMAN_MAIN.setColor(BaseColor.WHITE);
	    table.addCell(new Paragraph(" Pavel Brodyanskiy", TIME_ROMAN_BIG));
	    table.addCell("");
	    table.addCell("");
	    createEmptyCell(table,1);
	    table.addCell(new Paragraph(" Senior IT Consultant", TIME_ROMAN_MAIN));
	    table.addCell("");
	    table.addCell("");

	    createEmptyCell(table,3);
	    table.addCell(new Paragraph(" codecentric AG | 10.02.2016", TIME_ROMAN_MAIN));
	    table.addCell("");
	    table.addCell("");
	    float[] columnWidths = new float[]{80f,10f,10f};
	    table.setWidths(columnWidths); 
	    document.add(new Paragraph(" ", TIME_ROMAN));
	  //  document.add(table);
    	 Image image = Image.getInstance(IMAGE_MAIN);
         image.setAbsolutePosition(0, 0);
    	 try {
    		 canvas.addImage(image);
    		 document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
		
		
	}

	
	private void addPerson(Document document)
			throws DocumentException, MalformedURLException, IOException {
		
		document.newPage();
        Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
        TIME_ROMAN.setColor(BaseColor.CYAN);
		preface.add(new Paragraph("     Zur Person", TIME_ROMAN));
        creteEmptyLine(preface, 1);
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        
        table.addCell("Geburtsdatum ");
        table.addCell(user.getGeburtsdatum());
			
        table.addCell("Nationalität");
		table.addCell(user.getNationalitaet());
		
		table.addCell("Telefon");
		table.addCell(user.getTelefon());
		
		table.addCell("Email");
		table.addCell(user.getTelefon());
		
		float[] columnWidths = new float[] {30f, 50f};
		table.setWidths(columnWidths);
	 
		document.add(preface);
		document.add(table);

		
		

	}
	
	private void addAusbildung(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
	    creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Ausbildung und Berufserfahrung", TIME_ROMAN));
		creteEmptyLine(preface, 1);
		
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        
        Map<Integer, String> map_for_datum1 = stringTokenizer.getCommaValues(user.getAusbildung_datum_1());
		Map<Integer, String> map_for_datum2 = stringTokenizer.getCommaValues(user.getAusbildung_datum_2());
		Map<Integer, String> map_for_ort = stringTokenizer.getCommaValues(user.getAusbildung_ort());
		Map<Integer, String> map_for_stelle = stringTokenizer.getCommaValues(user.getAusbildung_stelle());
	
		for(int i = 1 ; i < map_for_datum1.size() + 1; i++)
		{
			table.addCell(map_for_datum1.get(i) + " / " + map_for_datum2.get(i));
			table.addCell(map_for_ort.get(i));
			table.addCell("");
			table.addCell(map_for_stelle.get(i));
		 }
		float[] columnWidths = new float[] {30f, 50f};
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);
		
	}
	
	private void addBeruf(Document document)
	        throws DocumentException{
		
		Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        
    	Map<Integer, String> map_for_beruf_datum1 = stringTokenizer.getCommaValues(user.getBeruf_datum_1());
		Map<Integer, String> map_for_beruf_datum2 = stringTokenizer.getCommaValues(user.getBeruf_datum_2());
		Map<Integer, String> map_for_ort = stringTokenizer.getCommaValues(user.getBeruf_ort());
		Map<Integer, String> map_for_stelle = stringTokenizer.getCommaValues(user.getBeruf_stelle());
        
		for(int i = 1 ; i < map_for_beruf_datum1.size()+1 ; i++)
		{
			table.addCell(map_for_beruf_datum1.get(i) + " / " + map_for_beruf_datum2.get(i));
			table.addCell(map_for_ort.get(i));
			table.addCell("");
			table.addCell(map_for_stelle.get(i));
		}
		
		float[] columnWidths = new float[] {30f, 50f};
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);
	 } 
	 
	
	private void addFachkenntnisse(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Fachkenntnisse", TIME_ROMAN));
		creteEmptyLine(preface, 1);
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(90);
	    table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		
		Map<Integer, String> map_for_fach_gebiet = stringTokenizer.getCommaValues(user.getFach_gebiet());
		Map<Integer, String> map_for_fach_kenntnisse = stringTokenizer.getCommaValues(user.getFach_kenntnisse());

		for(int i=1;i < map_for_fach_gebiet.size()+1;i++)
		{
			table.addCell(map_for_fach_gebiet.get(i));
			table.addCell(map_for_fach_kenntnisse.get(i));
		}
		
		float[] columnWidths = new float[] {30f, 50f};
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);
		
		
	}
	
	private void addProjecte(Document document)
	       throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Projekte(Auszug)", TIME_ROMAN));
		creteEmptyLine(preface, 1);
		
		PdfPTable table = new PdfPTable(3);
	    table.setWidthPercentage(90);
	    table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	
		Map<Integer, String> map_for_projekt_datum1 = stringTokenizer.getCommaValues(user.getProjekte_datum1());
		Map<Integer, String> map_for_projekt_datum2 = stringTokenizer.getCommaValues(user.getProjekte_datum2());
        Map<Integer, String> map_for_kunde = stringTokenizer.getCommaValues(user.getProjekte_kunde());
     	Map<Integer, String> map_for_thematik = stringTokenizer.getCommaValues(user.getProjekte_thematik());
     	Map<Integer, String> map_for_rolle = stringTokenizer.getCommaValues(user.getProjekte_rolle());
     	Map<Integer, String> map_for_technologie = stringTokenizer.getCommaValues(user.getProjekte_technologie());
     
     	for(int i=1;i < map_for_projekt_datum1.size()+1;i++)
     	{
     		table.addCell(map_for_projekt_datum1.get(i) + " /   ");
     		table.addCell("Kunde");
     		table.addCell(map_for_kunde.get(i));
     		
     		table.addCell(map_for_projekt_datum2.get(i));
     		table.addCell("Thematik");
     		table.addCell(map_for_thematik.get(i));
     		
     		table.addCell("");
     		table.addCell("Rolle");
     		table.addCell(map_for_rolle.get(i));
     		
     		table.addCell("");
     		table.addCell("Technologie");
     		table.addCell(map_for_technologie.get(i));
     		
    	} 
     	  float[] columnWidths = new float[] {23f,20f,70f};
		  table.setWidths(columnWidths);
		  document.add(preface);
		  document.add(table);
     }

	private void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}	
	private void createEmptyCell(PdfPTable table, int number){
			for(int i = 0 ; i < number * 3 ; i++)
			table.addCell(" ");
		}
  }
	
	

