package com.benfante.javacourse.thelibrary.core.model;
public class Library {
private static Book[] books;

//----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		 Author aut1,aut2;
		 Publisher pub = new Publisher("pubtest");
		 aut1 = new Author("ALBERTO","LECCHINI");
		 Book books = new Book(5,"test",aut1,52);
		 aut2 = new Author("ENRICO","LECCHINI");
		 books.setPublisher(pub);
		 books.addAuthor(aut2);
		 System.out.println(books.toString());
	}
	
	
//----------------------------------------------------------------------------------------------
	public void addBook(Book book) {
		Book[] copy;
		if(books[books.length-1]!=null) {
			copy = new Book[(books.length)*2];
			for(int i =0;i<books.length;i++) {
				copy[i] = books[i];
			}
			books = new Book[copy.length];
			for(int i =0;i<books.length;i++) {
				if(copy[i] != null) { books[i] = copy[i]; } else { break; }
			}
		}
		if(book != null) {
			for(int i=0 ;i<books.length;i++) {
				if(books[i] == null) {
					books[i] = book;
				}
			}
		}
	}
//-------------------------------------------------------------------------------------------------
	public void removeBook(Book book) {
		for(int i = 0 ; i<books.length ; i++) {
			if(book == books[i]) {
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
	
	
	
	
	
//----------------------------------------------------------------------------------------------
}
