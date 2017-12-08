package com.app.sg.mall.service;

import java.util.List;
import java.util.Scanner;

import com.app.sg.mall.io.InputReader;

public class AppDiscountService {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AppDiscountProcess process = new AppDiscountProcess();
		InputReader input = new InputReader();
		System.out.println("Welcome to Discount Price Application");
		System.out.println("Please specify the input file mode\n 1. CSV \n2. Manual ");
		int choice = scan.nextInt();
		scan.nextLine();
		if(choice == 1 ){
			System.out.println("Please specify the input file path");
			String path = scan.nextLine();
			if(null != path){
				process.setItems(input.processInputFile(path));
			}
		} else if (choice == 2 ){
			System.out.println("Please specify the input on console: ");
			process.setItems(input.processConsoleInput(scan));
		}else{
			System.out.println("Invalid input, Please Retry");
			System.exit(0);
		}
		process.getDiscountProcessed();
		System.out.println("Please enter Order");
		List<String> order = input.processOrder(scan);
		process.getProcessOrder(order);
		scan.close();
	}
	
}
