package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Author[] aut,newAut;

	@Test
	public void testBookConstruction() {
		long id = 0;
		String title = "A title";
		Author author = new Author("nome","cognome");
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
		long id = 0;
		String title = "A title";
		Author author = new Author("nome","cognome");
		float price = 1.23f;
		Book book = new Book(id, title, author, price);
		long newId = 0;
		String newTitle = "A title";
		Author newAuthor = new Author("nome","cognome");
		float newPrice = 1.23f;
		book.setId(newId);
		book.setTitle(newTitle);
		book.setAuthor(newAuthor);
		book.setPrice(newPrice);
		newAut = book.getAuthor();
		assertEquals(newId, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertArrayEquals(newAut, book.getAuthor());
		assertEquals(newPrice, book.getPrice(), 0.1);
	}
	
}
