package com.benfante.javacourse.thelibrary.core.model;
import java.util.*;
import org.slf4j.*;


public class Library {	
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	private  Book[] books = new Book[0];
	static BookCompare bec;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
	
		in.close();
	}	

	public  void addBook(Book book) {
		log.debug("\nAdding book with:\ntitle = {}\nid = {}",book.getTitle() , book.getId() );
		Book[] copy;
		if(books.length <= 0) {
			books = new Book [1];
			books[0] = book;
		}else{
			if(books[books.length-1] != null ) {
				copy = new Book[books.length+1];
				for(int i =0 ; i<books.length;i++) {
					copy[i] = books[i];
				}
				copy[copy.length-1] = book;
				books = new Book [copy.length];
				for(int i =0 ; i<books.length;i++) {
					books[i] = copy[i];
				}
				
			}
		}
		
	}

	public  void removeBook(Book book) {
		boolean removed = false;
		Book[] copy = null;
		for(int i = 0 ; i < books.length; i++) {
			if(book.equals(books[i])) {
				books[i] = null;
				System.out.println("Libro rimosso con successo!");
				removed = true;
				
				if(books.length-1 > i ) {
					if(books[i+1]!= null) {
						for(int c = i ; c<books.length-1;c++) {
							books[c] = books[c+1];
						}
					}
				}
				copy = new Book[(books.length-1)];
				for(int j =0; j< copy.length;j++) {
					copy[j] = books[j];
				}
				books = new Book[copy.length];
				for(int j =0; j< copy.length;j++) {
					books[j] = copy[j];
				}
				break;
			}
		}
		if(!removed) {
			System.out.println("Not Found!");
		}
	}

	
	public   Book[] searchBooksById(int id) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new BookCompare(books[i]);
			if(bec.compareID(id)) {
				book[ct] = books[i];
				ct++;
			}
		}
		System.out.println("Libri con lo stesso id trovati : " +ct +"\n");
		for(Book i : book) {
			System.out.println(i);
		}
		System.out.println();
		return book;
	}
	
	
	public   Book[] searchBooksByTitle(String title) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new BookCompare(books[i]);
			if(bec.compareTitle(title)) {
				book[ct] = books[i];
				ct++;
			}
		}
		System.out.println("Libri con lo stesso titolo trovati : " +ct +"\n");
		for(Book i : book) {
			System.out.println(i);
		}
		return book;
	}
	
	
	public   Book[] searchBooksByAuthor(Author[] author) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new BookCompare(books[i]);
			if(bec.compareAuthors(author)) {
				book[ct] = books[i];
				ct++;
			}
		}
		System.out.println("Libri con lo stesso autore trovati : " +ct +"\n");
		for(Book i : book) {
			System.out.println(i);
		}
		return book;
	}
	
		
	public   Book[] searchBooksByPrice(float price) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new BookCompare(books[i]);
			if(bec.comparePrice(price)) {
				book[ct] = books[i];
				ct++;
			}
		}
		System.out.println("Libri con lo stesso prezzo trovati : " +ct +"\n");
		for(Book i : book) {
			System.out.println(i);
		}
		return book;
	}
	
	
	
	public   Book[] searchBooksByPublisher(Publisher publisher) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new BookCompare(books[i]);
			if(bec.comparePublisher(publisher)) {
				book[ct] = books[i];
				ct++;
			}
		}
		System.out.println("Libri con lo stesso publisher trovati : " +ct +"\n");
		for(Book i : book) {
			System.out.println(i);
		}
		return book;
	}
	

	
	
}
