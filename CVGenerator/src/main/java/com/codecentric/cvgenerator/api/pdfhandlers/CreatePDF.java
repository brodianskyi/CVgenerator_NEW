package com.codecentric.cvgenerator.api.pdfhandlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.api.entities.helpers.AusbildungHelper;
import com.codecentric.cvgenerator.api.entities.helpers.BerufHelper;
import com.codecentric.cvgenerator.api.entities.helpers.FachHelper;
import com.codecentric.cvgenerator.api.entities.helpers.ProjekteHelper;
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


	private static final Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 23, Font.BOLD);
	private static final Font TIME_ROMAN_MAIN = new Font(Font.FontFamily.TIMES_ROMAN, 23, Font.BOLD);
	private static final Font TIME_ROMAN_BIG = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
	
	public static String current_url;
	private StringTokenizer stringTokenizer = new StringTokenizer();
	private User user;
	private AusbildungHelper ausbildungHelper;
	private BerufHelper berufHelper;
	private FachHelper fachHelper;
	private ProjekteHelper projekteHelper;
	private int pagenumber;

	/**
	 * @param args
	 */

	public CreatePDF(User user, AusbildungHelper ausbildungHelper, BerufHelper berufHelper, FachHelper fachHelper,
			ProjekteHelper projekteHelper) {
		this.user = user;
		this.ausbildungHelper = ausbildungHelper;
		this.berufHelper = berufHelper;
		this.fachHelper = fachHelper;
		this.projekteHelper = projekteHelper;
		Path currentRelativePath = Paths.get("");
		current_url = currentRelativePath.toAbsolutePath().toString();
		current_url += "/src/main/webapp/resources/images/";
	}

	public void onStartPage(PdfWriter writer, Document document) {

		try {
			pagenumber++;
			Image image = Image.getInstance(current_url + "codecentric-ag.gif");
			image.setAbsolutePosition(330, 720);
			image.scaleToFit(200, 200);
			if (pagenumber > 1) {
				document.add(image);
				Paragraph preface = new Paragraph();
				creteEmptyLine(preface, 5);
				document.add(preface);

			} else {
				Image image_small_title = Image.getInstance(current_url + "for_pdf0.png");
				image_small_title.setAbsolutePosition(360, 720);
				image_small_title.scaleToFit(200, 200);
				document.add(image_small_title);
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

			document = new Document(PageSize.A4);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			writer.setPageEvent(this);
			document.open();

			addMetaData(document);

			addTitleCV(document, writer);

			addPerson(document);

			addAusbildung(document);

			addBeruf(document);

			addFachkenntnisse(document);

			addProjekte(document);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private void addTitleCV(Document document, PdfWriter writer)
			throws MalformedURLException, IOException, DocumentException {

		PdfContentByte canvas = writer.getDirectContentUnder();
		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(400f);
		table.setSpacingAfter(500f);
		TIME_ROMAN_BIG.setColor(BaseColor.WHITE);
		TIME_ROMAN_MAIN.setColor(BaseColor.WHITE);
		table.addCell(new Paragraph(" " + user.getVorname() + " " + user.getName(), TIME_ROMAN_BIG));
		table.addCell("");
		table.addCell("");
		createEmptyCell(table, 3);
		table.addCell(new Paragraph(" " + berufHelper.getBeruf_position().get(0), TIME_ROMAN_MAIN));
		table.addCell("");
		table.addCell("");

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();

		createEmptyCell(table, 9);
		table.addCell(new Paragraph(" codecentric AG | " + dateFormat.format(date), TIME_ROMAN_MAIN));
		table.addCell("");
		table.addCell("");
		float[] columnWidths = new float[] { 80f, 10f, 10f };
		table.setWidths(columnWidths);
		document.add(new Paragraph(" ", TIME_ROMAN));

		Image image = Image.getInstance(current_url + "for_pdf3.png");
		image.setAbsolutePosition(0, 0);
		image.scaleToFit(1610, 870);
		try {
			canvas.addImage(image);
			document.add(table);
		} catch (DocumentException e) {

			e.printStackTrace();
		}
	}

	private void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");

	}

	private void addPerson(Document document) throws DocumentException, MalformedURLException, IOException {

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
		table.addCell(stringTokenizer.getRightdate(user.getGeburtsdatum(), "-"));
		createEmptyCell(table, 2);

		table.addCell("Wohnort ");
		table.addCell(user.getWohnort());
		createEmptyCell(table, 2);

		table.addCell("Nationalität");
		table.addCell(user.getNationalitaet());
		createEmptyCell(table, 2);

		table.addCell("Sprachen");
		table.addCell(user.getSprachen());
		createEmptyCell(table, 2);

		table.addCell("Telefon");
		table.addCell(user.getTelefon());
		createEmptyCell(table, 2);

		table.addCell("Email");
		table.addCell(user.getEmail());
		createEmptyCell(table, 2);

		float[] columnWidths = new float[] { 30f, 50f };
		table.setWidths(columnWidths);

		document.add(preface);
		document.add(table);

	}

	private void addAusbildung(Document document) throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Ausbildung/Universität", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(90);

		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		for (int i = 0; i < ausbildungHelper.getAusbildung_begin().size(); i++) {
			table.addCell(stringTokenizer.getRightdate(ausbildungHelper.getAusbildung_begin().get(i), "-") + " / "
					+ stringTokenizer.getRightdate(ausbildungHelper.getAusbildung_end().get(i), "-"));
			table.addCell(ausbildungHelper.getAusbildung_stelle().get(i));
			createEmptyCell(table, 1);
			table.addCell(ausbildungHelper.getAusbildung_ort().get(i));
			createEmptyCell(table, 2);
		}
		float[] columnWidths = new float[] { 30f, 50f };
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);

	}

	private void addBeruf(Document document) throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Berufserfahrung", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(90);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		for (int i = 0; i < berufHelper.getBeruf_begin().size(); i++) {
			table.addCell(stringTokenizer.getRightdate(berufHelper.getBeruf_begin().get(i), "-") + " / "
					+ stringTokenizer.getRightdate(berufHelper.getBeruf_end().get(i), "-"));
			table.addCell(berufHelper.getBeruf_position().get(i));
			createEmptyCell(table, 1);
			table.addCell(berufHelper.getBeruf_stelle().get(i));
			createEmptyCell(table, 2);
		}
		float[] columnWidths = new float[] { 30f, 50f };
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);
	}

	private void addFachkenntnisse(Document document) throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Fachkenntnisse", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(90);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		for (int i = 0; i < fachHelper.getFach_kenntnisse().size(); i++) {
			table.addCell(fachHelper.getFach_gebiet().get(i));
			table.addCell(fachHelper.getFach_kenntnisse().get(i));
			createEmptyCell(table, 2);
		}
		float[] columnWidths = new float[] { 30f, 50f };
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);

	}

	private void addProjekte(Document document) throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("     Projekte(Auszug)", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(90);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		for (int i = 0; i < projekteHelper.getProjekte_begin().size(); i++) {
			table.addCell(stringTokenizer.getRightdate(projekteHelper.getProjekte_begin().get(i), "-") + " /   ");
			table.addCell("Kunde");
			table.addCell(projekteHelper.getProjekte_kunde().get(i));

			table.addCell(stringTokenizer.getRightdate(projekteHelper.getProjekte_end().get(i), "-"));
			table.addCell("Thematik");
			table.addCell(projekteHelper.getProjekte_thematik().get(i));

			createEmptyCell(table, 1);
			table.addCell("Rolle");
			table.addCell(projekteHelper.getProjekte_rolle().get(i));

			createEmptyCell(table, 1);
			table.addCell("Technologie");
			table.addCell(projekteHelper.getProjekte_technologie().get(i));
			createEmptyCell(table, 3);

		}

		float[] columnWidths = new float[] { 23f, 20f, 70f };
		table.setWidths(columnWidths);
		document.add(preface);
		document.add(table);
	}

	private void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private void createEmptyCell(PdfPTable table, int number) {
		for (int i = 0; i < number; i++)
			table.addCell(" ");
	}

}
