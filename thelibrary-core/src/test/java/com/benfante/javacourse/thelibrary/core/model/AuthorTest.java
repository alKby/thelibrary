package com.benfante.javacourse.thelibrary.core.model;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorTest {
	
	@Test
	public void testGets() {
		Author author;
		String firstName = "testName";
		String lastName = "testLastName";
		author = new Author(1,firstName, lastName);
		assertEquals(author.getFirstName() , firstName);
		assertEquals(author.getLastName() , lastName);
		assertEquals(author.getId() , 1);	
	}
	
	@Test
	public void testSets() {
		Author author;
		String firstName = "testName";
		String lastName = "testLastName";
		String firstName2 = "testName2";
		String lastName2 = "testLastName2";
		author = new Author(1,firstName, lastName);
		author.setAuthor(1,firstName2,lastName2);
		assertEquals(author.getFirstName() , firstName2);
		assertEquals(author.getLastName() , lastName2);	
	}
	
	@Test
	public void testToString() {
		Author author;
		String firstName = "testName";
		String lastName = "testLastName";
		author = new Author(1,firstName, lastName);
		assertEquals(author.toString() , "\nFirstName: "+firstName+ "\tLastName: "+lastName);
	}
	
	@Test
	public void testEquals() {
		Author author;
		String firstName = "testName";
		String lastName = "testLastName";
		author = new Author(1,firstName, lastName);
		assertEquals(author.equals(new Author(1,"testName","testLastName")) , true);
		assertFalse(author.equals(new Author(2,"testName2","testLastName2")));
	}

}
