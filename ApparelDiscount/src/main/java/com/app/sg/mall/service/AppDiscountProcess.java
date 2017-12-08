package com.app.sg.mall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.sg.mall.dto.Items;

public class AppDiscountProcess {

	private Map<String, Integer> discountCategory = new HashMap<>();
	private Map<String, Integer> discountBrand = new HashMap<>();
	private List<Items> item = new ArrayList<>();
	private Map<Integer, Float> discount = new HashMap<>();

	public void getDiscountProcessed() {
		this.getDiscountInitalize();
		float discnt = 0;
		for (Items itm : item) {
			if (itm != null) {
				discnt = itm.getPrice()- (itm.getPrice() * getMaxDiscount(itm.getBrand(),itm.getCategory())/100);
				discount.put(itm.getId(), discnt);
			}
		}
	}
	
	int getMaxDiscount(String brand, String category){
		brand = brand.trim();
		category=category.trim();
		int  brnd=(this.getDiscountBrand().get(brand)==null)?0:this.getDiscountBrand().get(brand);
		int cat = this.getDiscountCategory().get(category)==null?0:this.getDiscountCategory().get(category);
		return Math.max(brnd, cat);
	}

	public void getProcessOrder(List<String> order) {
		int sum;
		System.out.println("Output : ");
		for (String odr : order) {
			sum = 0;
			int[] arr = Arrays.stream(odr.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < arr.length; i++) {
				sum += discount.get(arr[i]);
			}
			System.out.println(sum);
		}

	}

	public Map<String, Integer> getDiscountCategory() {
		return discountCategory;
	}

	public void setDiscountCategory(Map<String, Integer> discountCategory) {
		this.discountCategory = discountCategory;
	}

	public Map<String, Integer> getDiscountBrand() {
		return discountBrand;
	}

	public void setDiscountBrand(Map<String, Integer> discountBrand) {
		this.discountBrand = discountBrand;
	}

	public List<Items> getItems() {
		return item;
	}

	public void setItems(List<Items> item) {
		this.item = item;
	}

	public Map<Integer, Float> getDiscount() {
		return discount;
	}

	public void setDiscount(Map<Integer, Float> discount) {
		this.discount = discount;
	}

	/**
	 * Initalize Category and Brand
	 */
	
	public void getDiscountInitalize(){
		Map <String,Integer> discountcat = new HashMap<>();
		discountcat.put("Casuals", 30);
		discountcat.put("Jeans", 20);
		discountcat.put("Dresses", 50);
		discountcat.put("Footwear", 50);
		setDiscountCategory(discountcat);
		
		Map <String,Integer> discountbd = new HashMap<>();
		discountbd.put("Wrangler", 10);
		discountbd.put("Arrow", 20);
		discountbd.put("Vero Moda", 60);
		discountbd.put("Adidas", 5);
		discountbd.put("Provogue", 20);
		setDiscountBrand(discountbd);
	}
}
