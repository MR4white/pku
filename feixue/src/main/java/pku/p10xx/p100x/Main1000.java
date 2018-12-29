package pku.p10xx.p100x;

import java.util.Scanner;

/**
 * A+B Problem
 * 
 * Description
 * Calculate a+b
 * 
 * Input
 * Two integer a,b (0<=a,b<=10)
 * 
 * Output
 * Output a+b
 */
public class Main1000 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt(), b = cin.nextInt();
		System.out.println(a + b);
	}
}

/*
输入示例
1 2

示例输出
3
*/