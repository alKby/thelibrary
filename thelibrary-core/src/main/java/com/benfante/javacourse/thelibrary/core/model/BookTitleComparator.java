package com.benfante.javacourse.thelibrary.core.model;
import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

	
	@Override
	public int compare(Book o , Book o2) {
		if(o2.getTitle().equals(o.getTitle()))
		return 0;
		if((o2.getTitle().compareTo(o.getTitle())) > 0) {
			return 1;
		}
		return -1;
	}
	
}
