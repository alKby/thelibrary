package com.benfante.javacourse.thelibrary.core.model;

public class Book {
	
	private BookCompare bec;
	private int id ;
	private String title;
	private float price;
	private Author[] authors = new Author [0];
	private Publisher publisher;
	private BookCategory[] categories = new BookCategory[0];

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
	
	
	public BookCategory[] getCategories() {
		return categories;
	}
	
	public String getTitle() { return this.title; }
	
	public float getPrice() { return this.price; }
	
	public  Author[] getAuthor() {
		Author[] result = new Author[this.authors.length];
		for(int i =0; i<this.authors.length;i++) { 
			if(authors[i] != null) {result[i] = this.authors[i];}
			else { break; }
		}
		return result;
	}

	public Publisher getPublisher() {return this.publisher;}
	
	public int getId() { return this.id;}

	public void setTitle(String title) {
		if(title!= "" || title == null) { this.title= title; } 
		else {throw new IllegalArgumentException(); }
	}
	
	public void setPrice(float price) {
		if(price>= 0) { this.price = price; } 
		else {throw new IllegalArgumentException(); }
	}
	
	//addAuthor == setAuthor!!!
	public void addAuthor(Author author) {
		Author[] aut;
		/*if(author != null) { this.authors[ctAut] = author; ctAut++; }
		else { throw new IllegalArgumentException(); }*/
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
	}
	
	
	public void setPublisher(Publisher publisher) {
		if(publisher != null) { this.publisher = publisher; }
		else { throw new IllegalArgumentException(); }
	}
	
	public void setId(int id) {
		if(id >= 0) { this.id = id; }
		else { throw new IllegalArgumentException(); }
	}
	
	public void setCategories(BookCategory[] categories) {
		this.categories = new BookCategory[0];
		for(int i = 0 ; i < categories.length ; i++) {
			this.addCategory(categories[i]);
		}
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
		BookCategory[] bc = new BookCategory[this.categories.length+1];
		if(category.equals(null)) {
			throw new IllegalArgumentException();
		}else {
			for(int i = 0 ; i<this.categories.length; i++) {
				if(this.categories[i] == category)
					return;
				bc[i] = this.categories[i];
			}
			bc[bc.length-1] = category;
			this.categories = new BookCategory[bc.length];
			for(int i = 0 ; i<bc.length; i++) {
				this.categories[i] = bc[i];
			}
		}
	}

	
	@Override
	public String toString() {
		String ret="";
		ret += ( "Book Id: " + id + "\nTitle: " + title + "\nPrice: " + price +"\nAuthors:"); 
		for(int i =0;i<authors.length;i++) {
			if(authors[i] != null) { ret += (authors[i].toString()); }
			else { break; }
		}
		ret +=  "\n"+publisher.toString() ;
		return ret;
	}
}
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

