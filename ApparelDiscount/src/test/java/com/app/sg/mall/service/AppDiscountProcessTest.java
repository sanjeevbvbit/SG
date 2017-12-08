package com.app.sg.mall.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.sg.mall.dto.Items;
import com.app.sg.mall.util.AppUtil;

public class AppDiscountProcessTest {

	AppDiscountProcess app = new AppDiscountProcess();
	
	@Before
	public void setUp() throws Exception {
		app.getDiscountInitalize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDiscountProcessed() {
		app.getDiscountProcessed();
		List<Items> itemLst = new ArrayList<>();
		itemLst.add(AppUtil.convertStringToItems("1,Arrow,Shirts,800"));
		app.setItems(itemLst);
		app.getDiscountProcessed();
		assertEquals(app.getDiscount().get(1).intValue(),640);
	}
	
	@Test
	public void testGetDiscountProcessedVal() {
		app.getDiscountProcessed();
		List<Items> itemLst = new ArrayList<>();
		itemLst.add(AppUtil.convertStringToItems("2,Vero Moda,Dresses,1400"));
		app.setItems(itemLst);
		app.getDiscountProcessed();
		assertEquals(app.getDiscount().get(2).intValue(),560);
	}

	@Test
	public void testGetDiscountProcessedVal1() {
		app.getDiscountProcessed();
		List<Items> itemLst = new ArrayList<>();
		itemLst.add(AppUtil.convertStringToItems("3,Provogue,Footwear,1800"));
		app.setItems(itemLst);
		app.getDiscountProcessed();
		assertEquals(app.getDiscount().get(3).intValue(),900);
	}
	
	@Test
	public void testGetMaxDiscount(){
		assertEquals(app.getMaxDiscount("Arrow", "Shirts"),20);
	}
	
	@Test
	public void testGetMaxDiscount2(){
		assertEquals(app.getMaxDiscount("Vero Moda", "Dresses"),60);
	}
}
