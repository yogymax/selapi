package com.clc.sel.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumReadData {

	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yogesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table/");

		WebElement table = driver.findElement(By.className("tsc_table_s13"));
		List<WebElement> columnNames = table.findElement(By.tagName("thead")).findElement(By.tagName("tr")).findElements(By.tagName("th"));
		List<WebElement> rowsInfo = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		
		/*
		 * for (WebElement webElement : columnNames) {
		 * System.out.print(webElement.getText() +" \t "); }
		 */		
		//System.out.println("---------------------------------------------------------------------------");
		//System.out.println("---------------------------------------------------------------------------");
		
		List<DataStructure> listOfObjs = new ArrayList<DataStructure>();
		DataStructure ds = null;
		for (WebElement webElement : rowsInfo) {
			ds = new DataStructure();
			ds.setStructure(webElement.findElement(By.tagName("th")).getText());
			List<WebElement> listOfTds = webElement.findElements(By.tagName("td"));
			ds.setCountry(listOfTds.get(0).getText());
			ds.setCity(listOfTds.get(1).getText());
			ds.setHeight(listOfTds.get(2).getText());
			ds.setBuilt(listOfTds.get(3).getText());
			ds.setRank(listOfTds.get(4).getText());
			listOfObjs.add(ds);

			/*
			System.out.print(webElement.findElement(By.tagName("th")).getText() +" \t \t\t ");
			List<WebElement> listOfTds = webElement.findElements(By.tagName("td"));
			for (WebElement td : listOfTds) {
				System.out.print(td.getText() +" \t \t\t");
			}
			System.out.println("\n---------------------------------------------------------------------------");
			*/
		
		}
		
		
		
		
		System.out.println(listOfObjs);
		
		writeDataIntoExcelsheet(listOfObjs);
		
	}

	private static void writeDataIntoExcelsheet(List<DataStructure> listOfObjs) throws IOException {
		File file =new File("C:\\Users\\Yogesh\\Desktop\\demo\\info.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("info");
		int rowCount = 1;
		
		for (DataStructure singleOb : listOfObjs) {
			XSSFRow row = sheet.createRow(rowCount);
			row.createCell(0).setCellValue(singleOb.getStructure());
			row.createCell(1).setCellValue(singleOb.getCity());
			row.createCell(2).setCellValue(singleOb.getCountry());
			row.createCell(3).setCellValue(singleOb.getHeight());
			row.createCell(4).setCellValue(singleOb.getRank());
			row.createCell(5).setCellValue(singleOb.getBuilt());
			rowCount++;
		}
	
		FileOutputStream fio = new FileOutputStream(file);
		workbook.write(fio);
		
	}
	
}


class DataStructure{
		private String structure;
		private String country;
		private String city;
		private String height;
		private String built;
		private String rank;
		public String getStructure() {
			return structure;
		}
		public void setStructure(String structure) {
			this.structure = structure;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getBuilt() {
			return built;
		}
		public void setBuilt(String built) {
			this.built = built;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		@Override
		public String toString() {
			return "\n  [structure=" + structure + ", country=" + country + ", city=" + city + ", height="
					+ height + ", built=" + built + ", rank=" + rank + "]";
		}
		public DataStructure(String structure, String country, String city, String height, String built, String rank) {
			super();
			this.structure = structure;
			this.country = country;
			this.city = city;
			this.height = height;
			this.built = built;
			this.rank = rank;
		}
		public DataStructure() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
}