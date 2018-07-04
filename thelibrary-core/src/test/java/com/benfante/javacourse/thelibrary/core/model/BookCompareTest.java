package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookCompareTest {
	Author author = new Author(1,"a","b");
	float d = 3;
	Publisher publisher = new Publisher(1,"pn");
	Book book = new Book(1,"t",author,d,publisher);
	BookCompare bc = new BookCompare(book);

	@Test
	public void testCompareID(){
		assertEquals(bc.compareID(1) , true);
		assertEquals(bc.compareID(2) , false);
	}
	
	@Test
	public void testCompareTitle() {
		assertTrue(bc.compareTitle("t"));
		assertFalse(bc.compareTitle("z"));
	}
	
	@Test
	public void testCompareAuthors() {
		Author[] author1 = new Author[2];
		author1[0] = new Author(1,"a","b");
		author1[1] = new Author(2,"e","f");
		Author author3 = new Author(2,"e","f");
		book.addAuthor(author3);
		Author[] author2 = new Author[1];
		author2[0] = new Author(3,"c","d");
		assertEquals(bc.compareAuthors(author1) , true);
		assertEquals(bc.compareAuthors(author2) , false);
	}
	
	@Test
	public void testComparePrice() {
		assertEquals(d , this.book.getPrice(), 1);	
	}
	
	@Test
	public void testComparePublisher() {
		assertTrue(bc.comparePublisher((new Publisher(1,"pn"))));
		assertFalse(bc.comparePublisher((new Publisher(2,"pnx"))));
	}
}

