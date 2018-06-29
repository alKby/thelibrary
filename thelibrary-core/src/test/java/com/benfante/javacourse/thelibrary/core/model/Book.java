package com.benfante.javacourse.thelibrary.core.model;

//import java.util.Arrays;

public class Book {
	private int ctAut=0;
	private long id;
	private String title;
	private float price;
	private Author[] author = new Author [10];
	private Publisher publisher;
//---------------------------------------COSTRUTTORI-------------------------------------------
	public Book(long id , String title , Author author ){
		setTitle(title);
		setAuthor(author);
		setId(id);
		price = -1;
		publisher = null;
	}
	public Book(long id , String title , Author author , float price){
		this(id ,title , author);
		setPrice(price);
		publisher = null;
	}
	public Book(String title , Author author , float price , Publisher publisher ,long id){
		this( id ,title , author , price);
		setPublisher(publisher);
	}
//------------------------------------------GET-----------------------------------------------------------
	public String getTitle() { return this.title;}
	public float getPrice() {return this.price;}
	public  Author[] getAuthor() {
		Author[] result = new Author[this.author.length];
		for(int i =0; i<this.author.length;i++) {
			if(author[i] != null) {
				result[i] = this.author[i];
			}else {
				break;
			}
		}
		return result;
	}
	public Publisher getpublisher() {return this.publisher;}
	public long getId() { return this.id;}
//------------------------------------------SET------------------------------------------------------------
	public void setTitle(String title) {
		if(title!= "" || title == null) {
			this.title= title;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void setPrice(float price) {
		if(price>= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void setAuthor(Author author) {
		if(author != null) {
			this.author[ctAut] = author;
			ctAut++;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void addAuthor(Author autor) {
		setAuthor(autor);
	}
	public void setPublisher(Publisher publisher) {
		if(publisher != null) {
			this.publisher = publisher;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void setId(long id) {
		if(id >= 0) {
			this.id = id;
		}else {
			throw new IllegalArgumentException();
		}
	}
	@Override
	public String toString() {
		String ret="";
		ret += ( "Book Id: " + id + "\nTitle: " + title + "\nPrice: " + price +"\nAuthors:"); 
		for(int i =0;i<author.length;i++) {
			if(author[i] != null) { 
				ret += (author[i].toString());
			}
		}
		ret += "\nPublishers= "+ publisher.getName() + "";
		return ret;
	}
	

	
}
//--------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

