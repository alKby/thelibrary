package com.benfante.javacourse.thelibrary.core.model;
public class BookCompare  {
	private Book book;
	public BookCompare(Book book) {
		this.book = book;
	}
	
	
	public boolean compareID(int id) {
		if(this.book.getId() == id) { return true; }
		return false;
	}
	
	public  boolean compareTitle(String title) {
		if(this.book.getTitle().equals(title)) { return true; }
		return false;
	}
	
	public boolean compareAuthors(Author[] authors) {
		boolean x = false;
		if(authors.length != this.book.getAuthor().length) { return false; }
		for(int i = 0 ; i < this.book.getAuthor().length ; i++) {
			if(authors[i].equals(this.book.getAuthor()[i])) { x = true; }
			else {x = false; break; }
		}
		return x;
	}
	
	public boolean comparePrice(float price) {
		if(this.book.getPrice() == price) { return true; }
		return false;
	}
	
	public boolean comparePublisher(Publisher publisher) {
			if(this.book.getPublisher().equals(publisher)){ return true; }
			return false;
	}
}
	
	

