package com.benfante.javacourse.thelibrary.core.model;

public class Publisher {
	public String name;
	
//-----------------------------------------COSTRUTTORE---------------------------------------------------------
	public Publisher(String name) {
		setName(name);
	}
//---------------------------------------------GET-----------------------------------------------------
	public String getName() {return name;	}

//---------------------------------------------SET----------------------------------------------------

	public void setName(String name) {
		if(name != "") {
			this.name = name;
		}
	}
	@Override
	public String toString() {
		return "Publisher name: " + name + "";
	}
	
//-----------------------------------------------TOSTRING--------------------------------------------------


}
