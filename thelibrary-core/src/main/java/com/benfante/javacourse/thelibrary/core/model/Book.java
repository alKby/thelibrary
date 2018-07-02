package com.benfante.javacourse.thelibrary.core.model;

//import java.util.Arrays;

public class Book {
	private bookElementsComparator bec;
	private int ctAut= 0;
	private int id ;
	private String title;
	private float price;
	private Author[] authors = new Author [2];
	private Publisher publisher;
//---------------------------------------COSTRUTTORI-------------------------------------------
	public Book(int id , String title , Author author ){
		setTitle(title);
		addAuthor(author);
		price = -1;
		publisher = null;
	}
	public Book(int id , String title , Author author , float price){
		this(id ,title , author);
		setPrice(price);
		publisher = null;
	}
	public Book(int id,String title , Author author , float price , Publisher publisher ){
		this( id ,title , author , price);
		setPublisher(publisher);
		setId(id);
	}
//------------------------------------------GET-----------------------------------------------------------
	
	public String getTitle() { return this.title;}
	public float getPrice() {return this.price;}
	public  Author[] getAuthor() {
		Author[] result = new Author[this.authors.length];
		for(int i =0; i<this.authors.length;i++) {
			if(authors[i] != null) {result[i] = this.authors[i];}else {break;}}
		return result;
	}
	public Publisher getPublisher() {return this.publisher;}
	public int getId() { return this.id;}

//------------------------------------------SET------------------------------------------------------------

	public void setTitle(String title) {
		if(title!= "" || title == null) {this.title= title;} else {throw new IllegalArgumentException();}
	}
	
	public void setPrice(float price) {
		if(price>= 0) {this.price = price;} else {throw new IllegalArgumentException();}
	}
	
	public void addAuthor(Author author) {
		if(author != null) { this.authors[ctAut] = author; ctAut++; } else { throw new IllegalArgumentException();}
	}
	
	
	public void setPublisher(Publisher publisher) {
		if(publisher != null) { this.publisher = publisher; } else { throw new IllegalArgumentException(); }
	}
	public void setId(int id) {
			if(id >= 0) {
				this.id = id;
			}else {
				throw new IllegalArgumentException();
			}
	}	
	
	
//------------------------------------------EQUALS------------------------------------------------------------
	
	
	public boolean equals(Book book) {
		bec = new bookElementsComparator(book);
		if(bec.compareID(this.id) && bec.compareTitle(this.title) && bec.compareAuthors(this.authors) && bec.comparePrice(this.price) && bec.comparePublisher(this.publisher)) {
			return true;
		}
		return false;
		/*if(book.id == this.id && book.title.equals(this.title)) {
			for(int i = 0 ; i < this.authors.length ; i++) {
				if(book.authors[i].equals(this.authors[i])) {
					if(this.price == book.getPrice()) {
						if(this.publisher.equals(book.getPublisher())){
							return true;
						}
					}
				}
					
			}
		}*/ 
		
	}
//------------------------------------------toSTRING------------------------------------------------------------
		
	@Override
	public String toString() {
		String ret="";
		ret += ( "Book Id: " + id + "\nTitle: " + title + "\nPrice: " + price +"\nAuthors:"); 
		for(int i =0;i<authors.length;i++) {
			if(authors[i] != null) { 
				ret += (authors[i].toString());
			}
		}
		ret +=  "\n"+publisher.toString() ;
		return ret;
	}
}
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

