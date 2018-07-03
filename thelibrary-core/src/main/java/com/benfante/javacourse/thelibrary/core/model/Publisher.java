package com.benfante.javacourse.thelibrary.core.model;

public class Publisher {
	protected long id;
	protected String name;
	
	Publisher(long id , String name){
		setId(id);
		setName(name);
	}
	
	
	public long getId() { return this.id ; }
	public String getName() { return this.name; }
	
	public void setId(long id) {
		if (id > 0  ) { this.id = id; }
	    else { throw new IllegalArgumentException(); }
	}
	
	public void setName(String name) {
		if(name != null) { this.name = name; }
		else { throw new IllegalArgumentException(); }
	}
	
	public boolean equals( Publisher publisher) {
		if(publisher.getName().equals(this.name) && publisher.getId() == this.id) { return true; }
		else { return false; }
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + "\nName: "+ this.name;
	}
	
}
	
