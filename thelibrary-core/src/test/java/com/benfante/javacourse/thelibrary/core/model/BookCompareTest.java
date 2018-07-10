package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BookCompareTest {
	String title = "t";
	List <Author> aut = new LinkedList<>();
	Publisher publisher = new Publisher (1, "pn");
	Author autin = new Author(1,"name","lastName"); 
	{
		aut.add(autin);
	}
	BigDecimal price = new BigDecimal("12");
	Book book = new Book(1, title, aut, price , publisher);
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
		Author author1 = new Author(3,"c","d");
		Author author3 = new Author(2,"e","f");
		book.addAuthor(author3);
		List <Author> comptr= new LinkedList<>();
		comptr.add(autin);
		comptr.add(author3);
		List <Author> comptr2= new LinkedList<>();
		comptr2.add(author1);
		assertEquals(bc.compareAuthors(comptr) , true);
		assertEquals(bc.compareAuthors(comptr2) , false);
	}
	
	@Test
	public void testComparePrice() {
		assertEquals(price , this.book.getPrice());	
	}
	
	@Test
	public void testComparePublisher() {
		assertTrue(bc.comparePublisher((new Publisher(1,"pn"))));
		assertFalse(bc.comparePublisher((new Publisher(2,"pnx"))));
	}
}

