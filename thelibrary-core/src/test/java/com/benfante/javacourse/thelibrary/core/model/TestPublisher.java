package com.benfante.javacourse.thelibrary.core.model;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestPublisher{
	
	@Test
	public void testGets() {
		Publisher publisher;
		String name = "test";
		long id = 2;
		publisher = new Publisher(id , name);
		assertEquals(publisher.getName() , name);
		assertEquals(publisher.getId() , id); 
		
	}
}