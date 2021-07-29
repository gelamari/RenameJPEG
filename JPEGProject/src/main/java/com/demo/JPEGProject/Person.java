package com.demo.JPEGProject;

public class Person {
	
	String firstname; 
	String lastname; 
	String filename; 
	
	public Person() {
		
	}
	public Person(String firstname, String lastname, String filename){
		this.firstname = firstname; 
		this.lastname = lastname; 
		this.filename = filename;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFullName() {
		
		return lastname + "_" + firstname; 
	}
	
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", filename=" + filename + "]";
	}
	
	
	
}
