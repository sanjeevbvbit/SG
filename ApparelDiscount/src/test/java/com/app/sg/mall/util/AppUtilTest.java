package com.app.sg.mall.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.sg.mall.dto.Items;

public class AppUtilTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertStringToItems() {
		Items item = new Items();
		String line = "1,Arrow,Shirts,800";
		item=AppUtil.convertStringToItems(item, line);
		assertEquals(item.getId(),1);
		assertEquals(item.getBrand(),"Arrow");
		assertEquals(item.getCategory(),"Shirts");
		assertEquals(item.getPrice(),800,1.0);
	}
	
	@Test
	public void testConvertStringToItemsNeg() {
		Items item = new Items();
		String line = "1,,Shirts,800";
		item=AppUtil.convertStringToItems(item, line);
		assertEquals(item.getId(),0);
		assertEquals(item.getBrand(),null);
		assertEquals(item.getCategory(),null);
		assertEquals(item.getPrice(),0,1.0);
	}
	
	@Test
	public void testIsNotNull(){
		assertTrue(AppUtil.isNotNull("Sample"));
	}

	@Test
	public void testIsNotNullval(){
		assertTrue(!AppUtil.isNotNull(""));
	}
}
