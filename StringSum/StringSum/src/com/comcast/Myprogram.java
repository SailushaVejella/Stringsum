package com.comcast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Myprogram {
	public static void main(String[] args) {
		System.out.println("Enter input: ");
		Scanner scanObj = new Scanner(System.in);
		if (scanObj.hasNext()) {
			System.out.println(processInput(scanObj.nextLine().trim()));
		}
		scanObj.close();
		

	}

	public static int processInput(String str) {
		int sum = 0;
			if (str.contains("-x")) {
				String st = str.replace("-x", "").trim();
				sum = calculateHex2DecSum(st);
			} else if (str.contains("-f")) {
				String st = str.replace("-f", "").trim();
				sum = calculateSumFromFile(st);
			} else {
				sum = calculateSum(str);
			}
		
		return sum;
	}
	private static int calculateSumFromFile (String input){
		int sum = 0;
		File file = new File("./" + input);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String sr;
			while ((sr = br.readLine()) != null) {
				sum = calculateSum(sr);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}

	private static int calculateSum(String s) {
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				sum = sum + Character.getNumericValue(s.charAt(i));
			}
		}
		return sum;
	}

	private static int calculateHex2DecSum(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = val + d;
		}
		return val;
	}
}
