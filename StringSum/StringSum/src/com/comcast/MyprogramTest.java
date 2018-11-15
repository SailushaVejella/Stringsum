package com.comcast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyprogramTest {

	@Test
	public void testHexDecimal() {
		int sum =Myprogram.processInput("abc123 -x");
		assertEquals(39, sum);
		
	}
	
	@Test
	public void testFileInput(){
		int sum =Myprogram.processInput("-f test.txt");
		assertEquals(6, sum);
	}
	
	@Test
	public void testDecimal() {
		int sum =Myprogram.processInput("abc123");
		assertEquals(6, sum);
		
	}

}
