package pku.p10xx.p100x;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 487-3279
 * 
 * Description
 * Businesses like to have memorable telephone numbers. 
 * One way to make a telephone number memorable is to have it spell a memorable word or phrase. For example, 
 * you can call the University of Waterloo by dialing the memorable TUT-GLOP. Sometimes only part of the number is used to spell a word. 
 * When you get back to your hotel tonight you can order a pizza from Gino's by dialing 310-GINO. 
 * Another way to make a telephone number memorable is to group the digits in a memorable way. 
 * You could order your pizza from Pizza Hut by calling their ``three tens'' number 3-10-10-10. 
 * 
 * The standard form of a telephone number is seven decimal digits with a hyphen between the third and fourth digits (e.g. 888-1200). 
 * The keypad of a phone supplies the mapping of letters to numbers, as follows: 
 * 
 * A, B, and C map to 2 
 * D, E, and F map to 3 
 * G, H, and I map to 4 
 * J, K, and L map to 5 
 * M, N, and O map to 6 
 * P, R, and S map to 7 
 * T, U, and V map to 8 
 * W, X, and Y map to 9 
 * 
 * There is no mapping for Q or Z. Hyphens are not dialed, and can be added and removed as necessary. 
 * The standard form of TUT-GLOP is 888-4567, the standard form of 310-GINO is 310-4466, 
 * and the standard form of 3-10-10-10 is 310-1010. 
 * 
 * Two telephone numbers are equivalent if they have the same standard form. (They dial the same number.) 
 * 
 * Your company is compiling a directory of telephone numbers from local businesses. 
 * As part of the quality control process you want to check that no two (or more) businesses in the directory have the same telephone number. 
 * 
 * Input
 * The input will consist of one case. 
 * The first line of the input specifies the number of telephone numbers in the directory (up to 100,000) as a positive integer alone on the line. 
 * The remaining lines list the telephone numbers in the directory, with each number alone on a line. 
 * Each telephone number consists of a string composed of decimal digits, uppercase letters (excluding Q and Z) and hyphens. 
 * Exactly seven of the characters in the string will be digits or letters. 
 * 
 * Output
 * Generate a line of output for each telephone number that appears more than once in any form. 
 * The line should give the telephone number in standard form, followed by a space, 
 * followed by the number of times the telephone number appears in the directory. 
 * Arrange the output lines by telephone number in ascending lexicographical order. 
 * If there are no duplicates in the input print the line: 
 * 
 * No duplicates.
 */
public class Main1002 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		Map<String, Integer> ret = new TreeMap<String, Integer>();
		char[] codes = {'2','2','2','3','3','3','4','4','4','5','5','5'
				,'6','6','6','7','7','7','7','8','8','8','9','9','9'};
		
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		
		for (int i = 0; i < count; i++) {
			char[] inputLine = cin.next().toCharArray();
			
			String phone = "";
			for (char c : inputLine) {
				if (c >= 48 && c <= 57) { // 1-9
					phone += c;
				} else if (c >= 65 && c <= 90){ // A-Z
					phone += codes[c - 65];
				}
			}
			
			ret.put(phone, ret.containsKey(phone) ? ret.get(phone) + 1 : 1);
		}
		
		int n = 0;
		for (Entry<String, Integer> entry : ret.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey().substring(0, 3) + "-" + entry.getKey().substring(3) + " " + entry.getValue());
				n++;
			}
		}
		
		if (n == 0) {
			System.out.println("No duplicates.");
		}
	}
}

/*
输入示例
12
4873279
ITS-EASY
888-4567
3-10-10-10
888-GLOP
TUT-GLOP
967-11-11
310-GINO
F101010
888-1200
-4-8-7-3-2-7-9-
487-3279

示例输出
310-1010 2
487-3279 4
888-4567 3
*/
