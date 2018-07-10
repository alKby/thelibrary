package com.benfante.javacourse.thelibrary.core.model;
//import java.lang.reflect.Array;
import java.util.*;
import static org.junit.Assert.*;
import java.math.*;

//import org.junit.Before;
import org.junit.Test;

public class BookTest {

	@Test
	public void testBookGets() {
		int id = 0;
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(id, title, author, price , publisher);
		List <Author> aut = new LinkedList<>();
		aut = book.getAuthor();
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertEquals(aut, book.getAuthor());
		assertEquals(price, book.getPrice());
	}

	@Test
	public void testBookSetters() {
		String title = "A title";
		int id = 1,id2 = 2;
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		String newTitle = "A title";
		Author newAuthor = new Author(id,"nome","cognome");
		List <Author> authorx = new LinkedList<>();
		authorx.add(newAuthor);
		BigDecimal newPrice = new BigDecimal("17.2");
		book.setId(id2);
		book.setTitle(newTitle);
		book.addAuthor(newAuthor);
		book.setPrice(newPrice);
		Publisher pub2 = new Publisher(2,"nome2");
		book.setPublisher(pub2);
		authorx = book.getAuthor();
		assertEquals(id2, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertEquals(authorx, book.getAuthor());
		assertEquals(newPrice, book.getPrice());
		assertEquals(pub2, book.getPublisher());
	}
	
	@Test
	public void testAsAuthor() {;
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		Author a2 = new Author(2,"name","lastname");
		book.addAuthor(a2);
		assertTrue(book.hasAuthor(a2));
		assertFalse(book.hasAuthor(new Author(3,"name3","lastName3")));
	}
	
	@Test
	public void testAddAuthor() {;
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		Author a2 = new Author(2,"name","lastname");
		book.addAuthor(a2);
		assertTrue(book.hasAuthor(a2));
		
	}
	
	@Test
	public void testEquals() {
		int id = 0;
		String title = "A title";
		List <Author> author = new LinkedList<>();
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Publisher publisher = new Publisher(2 ,"test");		
		Book book = new Book(id, title, author, price,publisher);
		Book book2 = new Book(id, title, author, price , publisher);
		assertTrue(book.equals(book2));
	}

	@Test
	public void testSetCategories(){
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		SortedSet<BookCategory> bc = new TreeSet<>();
		bc.add( BookCategory.ARTS_AND_POTHOGRAPY);
		bc.add(BookCategory.COMPUTERS_AND_TECNOLOGY);
		SortedSet<BookCategory> bc2 = bc;
		book.setCategories(bc);
		assertEquals(book.getCategories() , bc2);
	}
	
	@Test
	public void testAddCategory(){
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		BookCategory bc;
		bc = BookCategory.ARTS_AND_POTHOGRAPY;
		book.addCategory(bc);
		BookCategory  gc= book.getCategories().first();
		assertTrue(bc.equals(gc));
		bc = BookCategory.COMPUTERS_AND_TECNOLOGY;
		assertFalse(bc.equals(gc));
	}
	
	@Test
	public void testGetCategories(){
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		SortedSet<BookCategory> bc = new TreeSet<>();
		bc.add( BookCategory.ARTS_AND_POTHOGRAPY);
		bc.add(BookCategory.COMPUTERS_AND_TECNOLOGY);
		SortedSet<BookCategory> bc2 = bc;
		book.setCategories(bc);
		SortedSet<BookCategory> bc3 = new TreeSet<>();
		bc2.add(BookCategory.HYSTORY);
		bc3.add(BookCategory.ARTS_AND_POTHOGRAPY );
		bc3.add(BookCategory.COMPUTERS_AND_TECNOLOGY);
		assertEquals(bc3 , book.getCategories());
		assertNotEquals(book.getCategories() , bc2);
	}
	
	@Test
	public void testToString() {
		String title = "A title";
		List <Author> author = new LinkedList<>();
		Publisher publisher = new Publisher (1, "nome");
		author.add(new Author(1,"name","lastName"));
		BigDecimal price = new BigDecimal("12");
		Book book = new Book(1, title, author, price,publisher);
		String ret="";
		ret += ( "Book Id: " + book.getId() + "\nTitle: " + book.getTitle() + "\nPrice: " + book.getPrice() +"\nAuthors:"); 
		for(Author authorx : book.getAuthor()) {
			ret += authorx.toString();
		}
		ret += "\nCategories: \n" ;
		for(BookCategory cat : book.getCategories()) {
			ret += cat.toString()+"\n"; 
		}
		ret +=  "\n"+publisher.toString() ;
		assertEquals(ret , book.toString());
	}
	
	
}
