package com.clc.rest.api.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestEmployeeAPI {

	public static void main(String[] args) throws JSONException {
		
		deleteEmp(102);
		
		//Employee e = new Employee(103,"TTTTTTTTTT", 29383.3,22,"ABC","XYA");
		//updateEmp(e);
		/*
		 * for (int i=0;i<10;i++) { Employee e = new Employee(103,"TRT"+i, 29383.3,
		 * 33,"ABC"+i,"XYZ"+i); insertEmp(e); }
		 */		
		if(true)
			return;
		
		/*
		 * HashMap<String,String> empValues = new HashMap<String, String>();
		 * empValues.put("name",e.getEmpName());
		 * empValues.put("salary",e.getEmpSalary()+"");
		 * empValues.put("desig",e.getDesignation());
		 * empValues.put("address",e.getAddress()); empValues.put("age",e.getAge()+"");
		 */
		
		
		
		/**
		 * {
	"name":"Amit",
	"salary":22992.2,
	"desig":"Tester",
	"address":"PP",
	"age":33
}

		 * 
		 */
		//RestAssured.post("http://localhost:5000/emp/",empValues);
		
		
		Employee emp = getSingleEmp(833);
		System.out.println(emp);
		
		//System.out.println(fetchAllEmps());
	}
	


	

	private static void deleteEmp(int eid) throws JSONException {
    	RestAssured.baseURI  = "http://localhost:5000/emp/"+eid;	
    	Response r = RestAssured.given()
    	.contentType("application/json").
    	body("").
        when().
       delete("");

    	String body = r.getBody().asString();
    	System.out.println(body);
		
		System.out.println(r.getStatusCode());

	}

	

	private static void updateEmp(Employee e) throws JSONException {
		String myJson = "{\"name\":\""+e.getEmpName()+"\",\"age\":"+e.getAge()+",\"salary\":"+e.getEmpSalary()+",\"address\":\""+e.getAddress()+"\",\"desig\":\"" +e.getDesignation()+"\"}";
    	RestAssured.baseURI  = "http://localhost:5000/emp/"+e.getEmpId();	
    	Response r = RestAssured.given()
    	.contentType("application/json").
    	body(myJson).
        when().
        put("");

    	String body = r.getBody().asString();
    	System.out.println(body);
		
		System.out.println(r.getStatusCode());

	}
	
	
	private static void insertEmp(Employee e) throws JSONException {
		String myJson = "{\"name\":\""+e.getEmpName()+"\",\"age\":"+e.getAge()+",\"salary\":"+e.getEmpSalary()+",\"address\":\""+e.getAddress()+"\",\"desig\":\"" +e.getDesignation()+"\"}";
    	RestAssured.baseURI  = "http://localhost:5000/emp/";	
    	Response r = RestAssured.given()
    	.contentType("application/json").
    	body(myJson).
        when().
        post("");

    	String body = r.getBody().asString();
    	System.out.println(body);
		
		System.out.println(r.getStatusCode());
		
		/*
		 * RestAssured.baseURI ="http://localhost:5000/"; RequestSpecification request =
		 * RestAssured.given();
		 * 
		 * JSONObject requestParams = new JSONObject(); requestParams.put("name",
		 * "Virender"); // Cast requestParams.put("age", "Singh");
		 * requestParams.put("salary", 20393.3); requestParams.put("desig", "Software");
		 * requestParams.put("address", "sample2ee26d9@gmail.com");
		 * request.body(requestParams.toString()); Response response =
		 * request.post("emp/");
		 */
		
		
		//RestAssured.baseURI = "https://localhost:5000";
		/*
		 * Response response = RestAssured.given().urlEncodingEnabled(true)
		 * .param("name", "user@site.com") .param("address", "Pas54321") .param("age",
		 * "Pas54321") .param("desig", "Pas54321") .param("salary",209392.2)
		 * .header("Accept", ContentType.JSON.getAcceptHeader())
		 * .post("http://localhost:5000/emp/");
		 */
		//System.out.println(response.getStatusCode());
		
		/*
		 * HashMap<String,String> empValues = new HashMap<String, String>();
		 * empValues.put("name",e.getEmpName());
		 * empValues.put("salary",e.getEmpSalary()+"");
		 * empValues.put("desig",e.getDesignation());
		 * empValues.put("address",e.getAddress()); empValues.put("age",e.getAge()+"");
		 * 
		 * Response response =
		 * RestAssured.given().post("http://localhost:5000/emp/",empValues);
		 * System.out.println(response.getStatusCode());
		 * System.out.println(response.asString());
		 */
		 	
	}




	public static Employee getSingleEmp(int eid) throws JSONException {
		Response response = RestAssured.get("http://127.0.0.1:5000/emp/"+eid);
		JSONObject singEmp = new JSONObject(response.asString());
		//JSONObject singEmp = jsonOb.getJSONObject(Integer.toString(eid));
		Employee emp = new Employee(singEmp.getInt("empId"), singEmp.getString("empName"), singEmp.getDouble("empSalary"), singEmp.getInt("empAge"),singEmp.getString("empAddress"),singEmp.getString("empDesignation"));
		return emp;
	}
	
	public static List<Employee> fetchAllEmps() throws JSONException{
		Response response = RestAssured.get("http://127.0.0.1:5000/emp/");
		JSONObject jsonOb = new JSONObject(response.asString());
		List<Employee> listOfEmps = new ArrayList<Employee>();
		Employee emp = null;
		for(int no=101;no<111;no++) {
			JSONObject singEmp = jsonOb.getJSONObject(Integer.toString(no));
			emp = new Employee(singEmp.getInt("empId"), singEmp.getString("empName"), singEmp.getDouble("empSalary"), singEmp.getInt("empAge"),singEmp.getString("empAddress"),singEmp.getString("empDesignation"));
			listOfEmps.add(emp);
		}
		return listOfEmps;
	}
}


class Employee{
	private int empId;
	private String empName;
	private double empSalary;
	private int age;
	private String address;
	private String designation;
	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", age=" + age
				+ ", address=" + address + ", designation=" + designation + "]";
	}
	public Employee(int empId, String empName, double empSalary, int age, String address, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.age = age;
		this.address = address;
		this.designation = designation;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
}