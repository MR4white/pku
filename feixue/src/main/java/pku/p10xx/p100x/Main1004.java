package pku.p10xx.p100x;

import java.util.Scanner;

/**
 * Financial Management
 * 
 * Description
 * Larry graduated this year and finally has a job. He's making a lot of money, but somehow never seems to have enough. 
 * Larry has decided that he needs to grab hold of his financial portfolio and solve his financing problems. 
 * The first step is to figure out what's been going on with his money. Larry has his bank account statements 
 * and wants to see how much money he has. Help Larry by writing a program to take his closing balance from each of the past twelve months 
 * and calculate his average account balance.
 * 
 * Input
 * The input will be twelve lines. Each line will contain the closing balance of his bank account for a particular month. 
 * Each number will be positive and displayed to the penny. No dollar sign will be included.
 * 
 * Output
 * The output will be a single number, the average (mean) of the closing balances for the twelve months. 
 * It will be rounded to the nearest penny, preceded immediately by a dollar sign, and followed by the end-of-line. 
 * There will be no other spaces or characters in the output.
 */
public class Main1004 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		double inputCount = 12; // 12个月
		double sum = 0;

		Scanner cin = new Scanner(System.in);
		for (int i = 0; i < inputCount; i++) {
			double income = cin.nextDouble();
			sum += income;
		}
		System.out.println("$" + String.format("%.2f", sum / inputCount));
	}
}

/*
输入示例
100.00
489.12
12454.12
1234.10
823.05
109.20
5.27
1542.25
839.18
83.99
1295.01
1.75

示例输出
$1581.42
*/
