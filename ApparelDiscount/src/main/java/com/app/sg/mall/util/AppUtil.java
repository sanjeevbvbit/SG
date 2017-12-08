package com.app.sg.mall.util;

import com.app.sg.mall.dto.Items;

public class AppUtil {

	private static final String COMMA = ",";

	public static Items convertStringToItems(Items item, String line) {
		String[] p = line.split(COMMA);

		if (isNotNull(p[0]) && isNotNull(p[1]) && isNotNull(p[2]) && isNotNull(p[3])) {
			item.setId(Integer.parseInt(p[0]));
			item.setBrand(p[1]);
			item.setCategory(p[2]);
			item.setPrice(Float.parseFloat(p[3]));
		}
		return item;
	}

	public static Items convertStringToItems(String line) {
		Items item = new Items();
		return convertStringToItems(item, line);
	}

	public static boolean isNotNull(String value) {
		if (value != null && value.trim().length() > 0) {
			return true;
		}
		return false;
	}

	
}
