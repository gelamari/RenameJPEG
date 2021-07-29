package com.demo.JPEGProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RenameJPEG {

	public static Calendar calendar = Calendar.getInstance();
	public static String monthday = new SimpleDateFormat("MMMMdd-hhmm").format(calendar.getTime());
	
	
	//CHANGE BELOW
	//This is where the new file tracking sheet will go, suggest keeping it in the same folder as the client sheet, must end with \\
	public static String folder = "C:\\Users\\angel\\Downloads\\Shania_JPEG\\ScriptTestingFiles\\";
	//This is the path to the image folder, must end with just the name of the folder
	public static String imageFolder = "C:\\Users\\angel\\Downloads\\Shania_JPEG\\ScriptTestingFiles\\justImages";
	//This is the path to the client sheet, must end with the file name
	public static String clientSheet = "C:\\Users\\angel\\Downloads\\Shania_JPEG\\ScriptTestingFiles\\ClientSheet.xlsx";

	public static void main(String[] args) throws IOException {
		FileInputStream excel = new FileInputStream(clientSheet);

		XSSFWorkbook workbook = new XSSFWorkbook(excel);
		Sheet spreadsheet = workbook.getSheetAt(0);

		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<String> oldNames = new ArrayList<String>();
		ArrayList<String> newNames = new ArrayList<String>();

		for (Row row : spreadsheet) {
			Person temp = new Person();
		
			temp.filename = row.getCell(0).toString();

			temp.lastname = row.getCell(1).toString();

			temp.firstname = row.getCell(2).toString();

			people.add(temp);
		}

		workbook.close();
		excel.close();

		File dir = new File(imageFolder);
		if (dir.isDirectory()) {
			// for each file in the directory
			imageFolder += "\\";
			int i = 1;
			for (final File f : dir.listFiles()) {
				try {

					oldNames.add(f.getName());
					String newFileName = people.get(i).getFullName() + ".jpg";
					String fullPath = imageFolder + newFileName;
					System.out.println("OLD " + f.getName() + " | " +  " NEW: " + newFileName);

					File newFile = new File(fullPath);
					newNames.add(newFileName);
					if (f.renameTo(newFile)) {
						System.out.println("Rename succesful");

					} else {
						System.out.println("Renamed failed");
					}
					i++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		trackFileChange(oldNames, newNames);
	}

	// Creates a file for the changes in file names
	public static void trackFileChange(ArrayList<String> oldNames, ArrayList<String> newNames) {
		String newFileName = "FilenameChanges_" + monthday + ".xlsx";
		String filePath = folder + newFileName;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("File Names");

		// Column Names
		Row row = sheet.createRow(0);
		Cell cell0 = row.createCell(0);
		cell0.setCellValue("Old Name");
		Cell cell1 = row.createCell(1);
		cell1.setCellValue("New name");
		int j = 1;

		for (int i = 0; i < oldNames.size(); i++) {
			Row rowi = sheet.createRow(j);
			cell0 = rowi.createCell(0);
			cell1 = rowi.createCell(1);
			cell0.setCellValue(oldNames.get(i));
			cell1.setCellValue(newNames.get(i));
			j++;

		}
		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("Successful: " + newFileName + " created");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to create File Name Tracking sheet");
		}

	}

}
