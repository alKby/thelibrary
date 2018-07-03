package com.benfante.javacourse.thelibrary.core.model;

public class Author {
	
	public String firstName;
	public String lastName;
	
	
	public Author(String firstName , String lastName) { setAuthor(firstName,lastName); }
	
	
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }

	private void setFirstName(String firstName) {
		if((firstName != null) && (!firstName.equals(""))) { this.firstName = firstName; } 
		else { throw new IllegalArgumentException(); }
	}
	
	private void setLastName(String lastName) {
		if((lastName != null) && (!lastName.equals(""))) { this.lastName = lastName; } 
		else { throw new IllegalArgumentException(); }
	}
	
	public void setAuthor(String firstName,String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String toString() {
		 return ("\nFirstName: "+this.firstName+"\tLastName: "+this.lastName);
	}

	public boolean equals(Author author) {
		if(author.getFirstName().equals(this.firstName)) {
			if(author.getLastName().equals(this.lastName)) { return true; }
		}
		return false;
	}
}
