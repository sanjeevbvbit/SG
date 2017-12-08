package com.app.sg.mall.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.app.sg.mall.dto.Items;
import com.app.sg.mall.util.AppUtil;

public class InputReader {

	public List<Items> processInputFile(String inputFilePath) {

		List<Items> inputList = new ArrayList<Items>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputList;
	}

	private Function<String, Items> mapToItem = (line) -> {
		Items item = new Items();
		AppUtil.convertStringToItems(item, line);
		return item;
	};

	public List<Items> processConsoleInput(Scanner scan) {
		List<Items> result = new ArrayList<Items>();
		int count = scan.nextInt();
		String line = scan.nextLine();
		for (int i = 0; i < count; i++) {
			line = scan.nextLine();
			result.add(AppUtil.convertStringToItems(line));
		}
		return result;
	}

	public List<String> processOrder(Scanner scan) {
		List<String> result = new ArrayList<>();
		int count = scan.nextInt();
		String line = scan.nextLine();
		for (int i = 0; i < count; i++) {
			line = scan.nextLine();
			if (null != line && line.trim().length() > 0)
				result.add(line);
		}
		return result;

	}
}
