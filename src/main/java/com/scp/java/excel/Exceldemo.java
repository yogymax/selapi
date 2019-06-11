package com.scp.java.excel;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Exceldemo {

	public static final String FILE_PATH = "C:\\Users\\Yogesh\\Desktop\\demo\\New folder\\emp_info.xlsx";

	private static void writeDataIntoExcel(XSSFWorkbook workbook,Employee ...employees) throws IOException {
		XSSFSheet sheet = workbook.getSheet("empdata");
		generateHeaders(sheet);
		for (int row=1;row<=employees.length;row++) {
			XSSFRow rowC = sheet.createRow(row);
			Employee emp = employees[row-1];
			rowC.createCell(0).setCellValue(emp.getEmpId());
			rowC.createCell(1).setCellValue(emp.getEmpName());
			rowC.createCell(2).setCellValue(emp.getEmpAge());
			rowC.createCell(3).setCellValue(emp.getEmpAddress());
			rowC.createCell(4).setCellValue(emp.getEmpSalary());
		}
		
		System.out.println("Data written into excelsheet..!");

		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		workbook.write(fos);
				
		if(true)
			return;
		
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("A1");
		
		XSSFRow row1 = sheet.createRow(1);
		XSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("B1");
		
		XSSFCell cell0 = row1.createCell(2);
		cell0.setCellValue("A2");
		//FileOutputStream fos = new FileOutputStream(file);
		//workbook.write(fos);
	}

	
	public static void generateHeaders(XSSFSheet sheet) {
		XSSFRow row  = sheet.createRow(0);
		row.createCell(0).setCellValue("employeeid");
		row.createCell(1).setCellValue("emploename");
		row.createCell(2).setCellValue("employeage");
		row.createCell(3).setCellValue("empaddress");
		row.createCell(4).setCellValue("employesal");
	}
	
	public static void main(String[] args) throws IOException {
		Employee emps [] = new Employee[10];
		for(int i=0;i<10;i++) {
			emps[i]=new Employee(1012+i,"YYYYY"+i,20+i,"Pune"+i,29932.3+i);
		}
		

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("empdata");
		
		writeDataIntoExcel(workbook,emps);
		readDataFromExcel(workbook);
	}


	private static void readDataFromExcel(XSSFWorkbook workbook) {
		XSSFSheet  sheet = workbook.getSheet("empdata");
		
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()) {
			//System.out.println("\n---------------------------------------------------------------------------");
			System.out.println();
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			int count = 0;
			while(cells.hasNext()) {
				Cell cell = cells.next();
				boolean isHeaderRow = false;
				if(cell.getCellType()==CellType.STRING && cell.getStringCellValue().contains("emp")) {
						isHeaderRow=true;
				}else {
					isHeaderRow=false;
				}
				if(cell.getCellType()==CellType.NUMERIC) {
					if(count==0 || count==2)
						//System.out.print((int)cell.getNumericCellValue()+"\t");
						printDataOnConsole((int)cell.getNumericCellValue());
					else
						//System.out.print(cell.getNumericCellValue()+"\t");
						printDataOnConsole(cell.getNumericCellValue());
				}else if(cell.getCellType()==CellType.STRING) {
					//System.out.print(cell.getStringCellValue() +"\t");
					printDataOnConsole(cell.getStringCellValue(),isHeaderRow);
				}
				
				count++;
			}
		}
	}

	static int space = 19;
	static int hspace = 15;
	private static void printDataOnConsole(int numericCellValue) {
		String numric = numericCellValue+""; //1111
		if(numric.length()<space) {
			int no = space-numric.length();
			for(int i=0;i<no;i++) {
				numric+=" ";
			}
		}
		System.out.print(numric);
	}
	

	private static void printDataOnConsole(double numericCellValue) {
		String numric = numericCellValue+""; //1111
		if(numric.length()<space) {
			int no = space-numric.length();
			for(int i=0;i<no;i++) {
				numric+=" ";
			}
		}
		System.out.print(numric);

	
	}
	
	

	private static void printDataOnConsole(String numric,boolean isHeader) {
		if(isHeader) {
			if(numric.length()<hspace) {
				int no = hspace-numric.length();
				for(int i=0;i<no;i++) {
					numric+=" ";
				}
			}

		}else	 if(numric.length()<space) {
			int no = space-numric.length();
			for(int i=0;i<no;i++) {
				numric+=" ";
			}
		}
		System.out.print(numric);

	}
}


class Employee{
	private int empId;
	private String empName;
	private int empAge;
	private String empAddress;
	private double empSalary;
	public Employee(int empId, String empName, int empAge, String empAddress, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empAddress=" + empAddress
				+ ", empSalary=" + empSalary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}