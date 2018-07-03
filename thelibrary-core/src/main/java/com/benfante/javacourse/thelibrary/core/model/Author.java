package com.benfante.javacourse.thelibrary.core.model;

public class Author {
	
	
	public String firstName;
	public String lastName;
	
//---------------------------------------COSTRUTTORE----------------------------------------------------------
	
	public Author(String firstName , String lastName) {
		setAuthor(firstName,lastName);
	}
	
//-----------------------------------------GET--------------------------------------------------------
	
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}

//-----------------------------------------SET--------------------------------------------------------

	private void setFirstName(String firstName) {
		if((firstName != null) && (!firstName.equals(""))) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException();
		}
	}
	private void setLastName(String lastName) {
		if((lastName != null) && (!lastName.equals(""))) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void setAuthor(String firstName,String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
//----------------------------------------TOSTRING---------------------------------------------------------
	public String toString() {
		String str = "";
		str = ("\nFirstName : "+this.firstName+" \t LastName: "+this.lastName);
		return str;
	}


	public boolean equals(Author author) {
		if(author.getFirstName().equals(this.firstName)) {
			if(author.getLastName().equals(this.lastName)) {
				return true;
			}
		}
		return false;
	}
}
