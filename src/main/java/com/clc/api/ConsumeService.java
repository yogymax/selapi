package com.clc.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsumeService {

public static void main(String[] args) throws JSONException {
	Emp e = new Emp(23,"newEmpName",2222.2, 22, "ABCD");
	String myJson = "{\"name\":\""+e.getEmpName()+"\",\"age\":\""+e.getEmpAge()+"\",\"salary\":\""+e.getEmpSalary()+"\",\"id\":\""+e.getEmpId()+"\"}";
	RestAssured.baseURI  = "http://dummy.restapiexample.com/api/v1/create";	
	Response r = RestAssured.given()
	.contentType("application/json").
	body(myJson).
    when().
    post("");

	String body = r.getBody().asString();
	System.out.println(body);
	System.out.println(r.getStatusCode());

	
	
	
	if(true)
		return;
	Response response =RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
	
	
	//System.out.println(response.asString());
	Emp emp = null;
	List<Emp> emps = new ArrayList<Emp>();
	JSONArray jArray = new JSONArray(response.asString());
	for(int i=0;i<jArray.length();i++) {
		JSONObject jsonOb = (JSONObject) jArray.get(i);
		emp =new Emp(
				Integer.parseInt(jsonOb.getString("id")),
				jsonOb.getString("employee_name"),
				Double.parseDouble(jsonOb.getString("employee_salary")),
				Integer.parseInt(jsonOb.getString("employee_age")),
				jsonOb.getString("profile_image"));
		emps.add(emp);
	}
	
	
	
	Collections.sort(emps);
	
	System.out.println(emps);
}
	
	
}

class Emp implements Comparable<Emp>{
	private int empId;
	private String empName;
	private double empSalary;
	private int empAge;
	private String dp;
	
	public int compareTo(Emp o) {
		return this.empAge - o.empAge;
	}
	
	public Emp(int empId, String empName, double empSalary, int empAge, String dp) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.dp = dp;
	}
	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", dp=" + dp + "]";
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
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
