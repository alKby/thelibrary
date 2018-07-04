package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;
import java.math.*;
import java.lang.reflect.Array;
import java.util.Arrays;

//import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Author[] aut,newAut;

	@Test
	public void testBookGets() {
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Book book = new Book(id, title, author, price);
		aut = book.getAuthor();	
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertArrayEquals(aut, book.getAuthor());
		assertEquals(price, book.getPrice(), 0.1);
	}

	@Test
	public void testBookSetters() {
		String title = "A title";
		int id = 1,id2 = 2;
		Publisher publisher = new Publisher (1, "nome");
		Author author = new Author(id,"nome","cognome");
		float price = 1.23f;
		Book book = new Book(1, title, author, price,publisher);
		String newTitle = "A title";
		Author newAuthor = new Author(id,"nome","cognome");
		float newPrice = 1.23f;
		book.setId(id2);
		book.setTitle(newTitle);
		book.addAuthor(newAuthor);
		book.setPrice(newPrice);
		Publisher pub2 = new Publisher(2,"nome2");
		book.setPublisher(pub2);
		newAut = book.getAuthor();
		assertEquals(id2, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertArrayEquals(newAut, book.getAuthor());
		assertEquals(newPrice, book.getPrice(), 0.1);
		assertEquals(pub2, book.getPublisher());
	}
	
	@Test
	public void testAsAuthor() {;
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(2 ,"test");
		Book book = new Book(id, title, author, price , publisher);
		Author a2 = new Author(2,"name","lastname");
		book.addAuthor(a2);
		assertTrue(book.hasAuthor(a2));
		assertFalse(book.hasAuthor(new Author(3,"name3","lastName3")));
	}
	
	@Test
	public void testAddAuthor() {;
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(2 ,"test");
		Book book = new Book(id, title, author, price , publisher);
		Author a2 = new Author(2,"name","lastname");
		book.addAuthor(a2);
		assertTrue(book.hasAuthor(a2));
		
	}
	
	@Test
	public void testEquals() {
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(2 ,"test");
		Book book = new Book(id, title, author, price , publisher);
		Book book2 = new Book(id, title, author, price , publisher);
		assertTrue(book.equals(book2));
	}

	@Test
	public void testSetCategories(){
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(1, "name");
		Book book = new Book(id, title, author, price , publisher);
		BookCategory[] bc = new BookCategory[2];
		bc[0] = BookCategory.ARTS_AND_POTHOGRAPY;
		bc[1] = BookCategory.COMPUTERS_AND_TECNOLOGY;
		BookCategory[] bc2 = bc;
		book.setCategories(bc);
		assertTrue(Arrays.equals(book.getCategories() , bc2));
	}
	
	@Test
	public void testAddCategory(){
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(1, "name");
		Book book = new Book(id, title, author, price , publisher);
		BookCategory bc;
		bc = BookCategory.ARTS_AND_POTHOGRAPY;
		book.addCategory(bc);
		BookCategory  gc= book.getCategories()[0];
		assertTrue(bc.equals(gc));
		bc = BookCategory.COMPUTERS_AND_TECNOLOGY;
		assertFalse(bc.equals(gc));
	}
	
	@Test
	public void testGetCategories(){
		int id = 0;
		String title = "A title";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(1, "name");
		Book book = new Book(id, title, author, price , publisher);
		BookCategory bc[] = new BookCategory[2];
		bc[0] = BookCategory.ARTS_AND_POTHOGRAPY;
		bc[1] = BookCategory.COMPUTERS_AND_TECNOLOGY;
		BookCategory[] bc2 = bc;
		book.setCategories(bc);
		BookCategory[] bc3 = book.getCategories();
		bc2[1] = BookCategory.HYSTORY;
		assertEquals(Arrays.equals(bc3 , book.getCategories()) , true);
		assertEquals(Arrays.equals(book.getCategories() , bc2) , false);
	}
	
	@Test
	public void testToString() {
		int id = 0;
		String title = "A title", test = "";
		Author author = new Author(1,"nome","cognome");
		float price = 1.23f;
		Publisher publisher = new Publisher(1, "name");
		Book book = new Book(id, title, author, price , publisher);
		test += ( "Book Id: " + book.getId() + "\nTitle: " + book.getTitle() + "\nPrice: " + book.getPrice() +"\nAuthors:"); 
		for(int i =0;i<book.getAuthor().length;i++) {
			if(book.getAuthor()[i] != null) { test += (book.getAuthor()[i].toString()); }
			else { break; }
		}
		test +=  "\n"+book.getPublisher().toString() ;
		assertEquals(test , book.toString());
	}
	
	
}
