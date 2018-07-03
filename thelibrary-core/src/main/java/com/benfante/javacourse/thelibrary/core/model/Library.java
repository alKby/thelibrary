package com.benfante.javacourse.thelibrary.core.model;
import java.util.*;
import org.slf4j.*;

import com.benfante.javacourse.thelibrary.core.model.bookElementsComparator;
public class Library {
	
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	private  Book[] books = new Book[0];
	static bookElementsComparator bec;
	static Scanner in = new Scanner(System.in);

//----------------------------------------MAIN-------------------------------------------------
	public static void main(String[] args) {
		Library library = new Library();
		int sw = 0,sw2 = 0;;
		
		do {
			System.out.println("\n\nINSERISCI UN NUMERO PER CONTINUARE:\n(1)Inserisci un libro\n(2)Rimuovi un libro\n(3)Stampa tutti i libri\n(4)Ricerca per singolo campo\n(0)ESCI");
			sw = in.nextInt();
			in.nextLine();
			switch(sw) {
				case 1:library.addBook(insertBook());
					   break;
					   
				case 2:library.removeBook(insertBook());
				       break;
				       
				case 3:if(library.books.length > 0) {
							for(int i = 0;i<library.books.length;i++) {
								if(library.books[i] != null) {
								System.out.println(library.books[i].toString()+"\n");
								}else {
									break;
								}
							 }
							break; 
					   }
					   System.out.println("Nessun libro da stampare.");
					   break;
					   
				case 4:System.out.println("Ricerca tramite:");
					   System.out.println("(1)ID\n(2)Titolo\n(3)Autore/i\n(4)Prezzo\n(5)Publisher\n");
					   sw2 = in.nextInt();
					   in.nextLine();
					   switch(sw2) {
					   		case 1:	System.out.println("Inserisci l'Id da cercare:\n");
					   				int id = 0;
					   				id = in.nextInt();
					   				in.nextLine();					   		
					   				library.searchBooksById(id);
					   				break;
					   		case 2:System.out.println("Inserisci il titolo da cercare:\n");
			   					   String title = "";
			   					   title = in.nextLine();			   		
			   					   library.searchBooksByTitle(title);
			   					   break;
					   		case 3:System.out.println("Inserisci l'autore da cercare:\n");
					   			   System.out.print("nome:");
					   			   String name = in.nextLine();
					   			   System.out.print("cognome:");
					   			   String lastName = in.nextLine();
					   			   System.out.println();
		   					   	   Author[] author = new Author[1];
		   					   	   author[0]= new Author(name,lastName);
		   					       library.searchBooksByAuthor(author);
		   					       		 
					   		case 4:System.out.println("Inserisci il prezzo da cercare:\n");
		   					       float price;
		   					       price = in.nextFloat();	
		   					       in.nextLine();
		   					       library.searchBooksByPrice(price);
		   					       break;
					   		case 5:System.out.println("Inserisci il publisher da cercare:\n");
					   		       Publisher publisher;
					   			   System.out.println("Inserisci publisher");
					   			   publisher = new Publisher(1, in.nextLine());
	   					           library.searchBooksByPublisher(publisher);
	   					           break;
					   }
					   break;
				
					
					
					
					
					
				case 0:
					   System.out.println("CIAO!");
					   break;
				default:
					   System.out.println("Inserimento non valido!");
					   break;
			}
		   }while(sw != 0); 
		 
	
	
		in.close();
	}	

//----------------------------------------ADD BOOK------------------------------------------------------
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
//-----------------------------------------REMOVE BOOK--------------------------------------------------------
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
//---------------------------------------INSERIMENTO TASTIERA LIBRO----------------------------------------------------------------------------
	public  static Book insertBook() {
		   int id;
		   Author author;
		   Book b;
		   String publisherN;
		   String title,authorN,authorC;
		   float price;
		   Publisher publisher;
		   System.out.println("Inserisci Id: ");
	       id = in .nextInt();
		   System.out.println("Inserisci un titolo:");
	       title = in.nextLine();
	       title = in.nextLine();
	       System.out.println("Inserisci nome autore");
	       authorN = in.nextLine();
	       System.out.println("Inserisci cognome autore");
	       authorC = in.nextLine();
	       author = new Author(authorN, authorC);
	       System.out.println("Inserisci prezzo:");
	       price = in.nextFloat();
	       in.nextLine();
	       System.out.println("Inserici publisher:");
	       publisherN = in.nextLine();
	       publisher = new Publisher(1,publisherN);
	       b = new Book (id,title,author,price,publisher);
	       return b;
	       
	}
	
//------------------------------------------RICERCHE-----------------------------------------------------
	public   Book[] searchBooksById(int id) {
		Book[] book = new Book[books.length];
		int ct = 0;
		for(int i = 0 ; i < books.length ; i++) {
			bec = new bookElementsComparator(books[i]);
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
			bec = new bookElementsComparator(books[i]);
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
			bec = new bookElementsComparator(books[i]);
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
			bec = new bookElementsComparator(books[i]);
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
			bec = new bookElementsComparator(books[i]);
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
	
//-------------------------------------------------------------------------------------------------
	
	
}
