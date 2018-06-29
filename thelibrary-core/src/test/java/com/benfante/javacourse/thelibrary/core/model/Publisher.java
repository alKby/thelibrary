package com.benfante.javacourse.thelibrary.core.model;

public class Publisher {
	public String name;
	
//--------------------------------------------------------------------------------------------------
	public Publisher(String name) {
		setName(name);
	}
//--------------------------------------------------------------------------------------------------
	public String getName() {return name;	}
	
	public void setName(String name) {
		if(name != "") {
			this.name = name;
		}
	}
}
