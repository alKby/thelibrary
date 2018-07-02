package com.benfante.javacourse.thelibrary.core.model;
import java.util.*;
public class Library {

	private static Book[] books = new Book[1];

//----------------------------------------MAIN-------------------------------------------------
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Author author;
		Book b;
		String title,authorN,authorC;
		float price;
		Publisher publisher;
		int sw = 0,id;
		do {
			System.out.println("\n\nINSERISCI UN NUMERO PER CONTINUARE:\n(1)Inserisci un libro\n(2)Rimuovi un libro\n(3)Stampa tutti i libri\n(0)ESCI");
			sw = in.nextInt();
			in.nextLine();
			switch(sw) {
				case 1:
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
					   String publisherN = in.nextLine();
					   publisher = new Publisher(publisherN);
					   b = new Book (id,title,author,price,publisher);
					   addBook(b);
					   break;
					   
				case 2:System.out.println("Inserisci Id: ");
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
				       publisher = new Publisher(publisherN);
				       b = new Book (id,title,author,price,publisher);
				       removeBook(b);
				       break;
				       
				case 3:for(int i = 0;i<books.length-1;i++) {
					   		System.out.println(books[i].toString()+"\n");
				       }
					   break;
				case 0:
					   System.out.println("CIAO!");
					   break;
				default:
					   System.out.println("Inserimento non valido!");
					   break;
			}
		}while(sw!=0);
		 
	
	
	
		in.close();
	}
	

	
	
	
	
	

//----------------------------------------ADD BOOK------------------------------------------------------
	public static void addBook(Book book) {
		Book[] copy;
		if(books[books.length-1]==null) {
			copy = new Book[(books.length)+1];
			for(int i =0;i<books.length;i++) {
				copy[i] = books[i];
			}
			books = new Book[copy.length];
			for(int i =0;i<books.length;i++) {
				if(copy[i] != null) { books[i] = copy[i]; } else { break; }
			}
		}
		if(book != null) {
			for(int i=0 ;i<books.length-1;i++) {
				if(books[i] == null) {
					books[i] = book;
				}
			}
		}
	}
//-----------------------------------------REMOVE BOOK--------------------------------------------------------
	public static void removeBook(Book book) {
		for(int i = 0 ; i<books.length-1; i++) {
			if(book.equals(books[i])) {
				System.out.println("ahdsjgvdfausdhfjdsfjdsvjaoisv");
				books[i] = null;
				if(books[i+1]!= null) {
					for(int c = i ; c<books.length-1;c++) {
						books[c] = books[c+1];
					}
				}
				break;
			}
		}
		System.out.println("Not Found!");
	}
//-------------------------------------------------------------------------------------------------
	
	
}
