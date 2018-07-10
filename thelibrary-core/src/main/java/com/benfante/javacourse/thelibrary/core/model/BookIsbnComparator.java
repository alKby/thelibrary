package com.benfante.javacourse.thelibrary.core.model;

import java.util.Comparator;

public class BookIsbnComparator implements Comparator<Book> {

	@Override
	public int compare(Book o , Book o2) {
		if(o2.getISBN().equals(o.getISBN()))
		return 0;
		if((o2.getISBN().compareTo(o.getISBN())) > 0) {
			return 1;
		}
		return -1;
	}

}
