package com.benfante.javacourse.thelibrary.core.model;
import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable , Comparable<Book>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookCompare bec;
	private int id ;
	private String ISBN = "";
	private String title;
	private BigDecimal price;
	private List <Author> authors = new LinkedList<>();
	private Publisher publisher;
	private SortedSet <BookCategory> categories = new TreeSet<>();
	public Book(int id , String title , List <Author> author ){
		setTitle(title);
		addAuthors(author);
		price = new BigDecimal(-1);
		publisher = null;
		setId(id);
	}
	
	public Book(int id , String title , List <Author> author  , BigDecimal price){
		this(id ,title , author);
		setPrice(price);
		publisher = null;
	}
	
	public Book(int id,String title , List <Author> author  , BigDecimal price , Publisher publisher ){
		this( id ,title , author , price);
		setPublisher(publisher);
	}
	
	public SortedSet<BookCategory> getCategories() {
		return categories;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getTitle() { return this.title; }
	
	public BigDecimal getPrice() { return this.price; }
	
	public  List <Author> getAuthor() {
		return this.authors;
		
		/*Author[] result = new Author[this.authors.length];
		for(int i =0; i<this.authors.length;i++) { 
			if(authors[i] != null) {result[i] = this.authors[i];}
			else { break; }
		}
		return result;*/
	}

	public Publisher getPublisher() {return this.publisher;}
	
	public int getId() { return this.id;}
	
	public void setISBN(String ISBN) {
		if(ISBN != null) {
			this.ISBN = ISBN;
		}
	}

	public void setTitle(String title) {
		if(title!= "" || title == null) { this.title= title; } 
		else {throw new IllegalArgumentException(); }
	}
	
	public void setPrice(BigDecimal price) {
		if(price.compareTo(BigDecimal.valueOf(0))> 0) { this.price = price; } 
		else {throw new IllegalArgumentException(); }
	}
	
	public void addAuthor(Author author) {
		if (author != null) authors.add(author);
		else System.out.println("Autore inserito non valido!");
		
		/*
		Author[] aut;
		if(author != null) { this.authors[ctAut] = author; ctAut++; }
		else { throw new IllegalArgumentException(); }
		if(author != null) {
			aut = new Author[authors.length+1];
			for(int i = 0 ; i< authors.length; i++) {
				aut[i] = authors[i];
			}
			aut[aut.length-1] = author;
			authors = new Author[aut.length];
			for(int i = 0 ; i< authors.length; i++) {
				authors[i] = aut[i];
			}
			
		}
		*/
	}
	
	public void addAuthors(List <Author>authors) {
		this.authors.addAll(authors);
	}
	
	public void addPublisher(Publisher publisher) {
		if(this.publisher == null && publisher != null) {
			this.publisher=publisher;
		}
	}
	
	public void setPublisher(Publisher publisher) {
		if(publisher != null) { this.publisher = publisher; }
		else { throw new IllegalArgumentException(); }
	}
	
	public void setId(int id) {
		if(id >= 0) { this.id = id; }
		else { throw new IllegalArgumentException(); }
	}
	
	public void setCategories(SortedSet<BookCategory> categories) {
		this.categories.clear();
		this.categories.addAll(categories);
	}
	
	public boolean hasAuthor(Author author) {
		boolean result = false;
		for (Author currAut : authors) {
			if(currAut.hashCode() == author.hashCode() && currAut.equals(author))
				result = true;
		}
		return result;
	}
	
	public boolean equals(Book book) {
		bec = new BookCompare(book);
		if(bec.compareID(this.id) && 
				bec.compareTitle(this.title) && 
				bec.compareAuthors(this.authors) &&
				bec.comparePrice(this.price) &&
				bec.comparePublisher(this.publisher)) {
			return true;
		}
		return false;
	}
	
	public void addCategory(BookCategory category) {
		this.categories.add(category);
	}

	@Override
	public String toString() {
		String ret="";
		ret += ( "Book Id: " + id + "\nTitle: " + title + "\nPrice: " + price +"\nAuthors:"); 
		for(Author author : authors) {
			ret += author.toString();
		}
		ret += "\nCategories: \n" ;
		for(BookCategory cat : categories) {
			ret += cat.toString()+"\n"; 
		}
		ret +=  "\n"+publisher.toString() ;
		return ret;
	}

	@Override
	public int compareTo(Book o) {
		if(this.id == (o.getId()))
		return 0;
		
		if(this.id > (o.getId()))
		return 1;
		
		return-1;
	}
}
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

