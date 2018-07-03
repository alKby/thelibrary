package com.benfante.javacourse.thelibrary.core.model;
import org.junit.Test;
import static org.junit.Assert.*;
public class PublisherTest{
	
	@Test
	public void testGets() {
		Publisher publisher;
		String name = "test";
		long id = 2;
		publisher = new Publisher(id , name);
		assertEquals(publisher.getName() , name);
		assertEquals(publisher.getId() , id); 
	}
	
	@Test
	public void testSets() {
		Publisher publisher;
		String name = "test";
		long id = 2;
		publisher = new Publisher(10,"hey");
		publisher.setId(id);
		publisher.setName(name);
		assertEquals(publisher.getId() , id);
		assertEquals(publisher.getName() , name);
	}
	
	@Test
	public void testToString() {
		Publisher publisher;
		String name = "test";
		long id = 2;
		publisher = new Publisher(id , name);
		String str = publisher.toString();
		String compar = "Id: " +id+ "\nName: "+name;
		assertEquals(str , compar);
	}
	
	@Test
	public void testEquals() {
		Publisher publisher;
		String name = "test";
		long id = 2;
		publisher = new Publisher(id , name);
		boolean tr = publisher.equals(new Publisher(id , name));
		boolean fls = publisher.equals(new Publisher(5 , "notname"));
		assertEquals( tr , true );
		assertEquals( fls , false );
	}
}