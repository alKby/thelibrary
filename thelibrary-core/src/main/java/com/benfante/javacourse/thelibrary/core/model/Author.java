package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;

public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String firstName;
	public String lastName;
	
	
	public Author(int id ,String firstName , String lastName) { setAuthor(id, firstName,lastName); }
	
	
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public int getId() { return this.id; }

	private void setFirstName(String firstName) {
		if((firstName != null) && (!firstName.equals(""))) { this.firstName = firstName; } 
		else { throw new IllegalArgumentException(); }
	}
	
	private void setLastName(String lastName) {
		if((lastName != null) && (!lastName.equals(""))) { this.lastName = lastName; } 
		else { throw new IllegalArgumentException(); }
	}
	
	public void setAuthor(int id ,String firstName,String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		this.id=id;
	}
	 

	public String toString() {
		 return ("\nFirstName: "+this.firstName+"\nLastName: "+this.lastName+"\n");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		*/
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
