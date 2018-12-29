package pku.p10xx.p100x;

import java.util.Scanner;

/**
 * Biorhythms
 * 
 * Description
 * Some people believe that there are three cycles in a person's life that start the day he or she is born. 
 * These three cycles are the physical, emotional, and intellectual cycles, and they have periods of lengths 23, 28, and 33 days, 
 * respectively. There is one peak in each period of a cycle. At the peak of a cycle, 
 * a person performs at his or her best in the corresponding field (physical, emotional or mental). F
 * or example, if it is the mental curve, thought processes will be sharper and concentration will be easier. 
 * Since the three cycles have different periods, the peaks of the three cycles generally occur at different times. 
 * We would like to determine when a triple peak occurs (the peaks of all three cycles occur in the same day) for any person. 
 * For each cycle, you will be given the number of days from the beginning of the current year at which one of its peaks (not necessarily the first) occurs. 
 * You will also be given a date expressed as the number of days from the beginning of the current year. 
 * You task is to determine the number of days from the given date to the next triple peak. The given date is not counted. 
 * For example, if the given date is 10 and the next triple peak occurs on day 12, the answer is 2, not 3. 
 * If a triple peak occurs on the given date, you should give the number of days to the next occurrence of a triple peak. 
 * 
 * Input
 * You will be given a number of cases. The input for each case consists of one line of four integers p, e, i, and d. 
 * The values p, e, and i are the number of days from the beginning of the current year at which the physical, emotional, 
 * and intellectual cycles peak, respectively. The value d is the given date and may be smaller than any of p, e, or i. 
 * All values are non-negative and at most 365, and you may assume that a triple peak will occur within 21252 days of the given date. 
 * The end of input is indicated by a line in which p = e = i = d = -1.
 * 
 * Output
 * For each test case, print the case number followed by a message indicating the number of days to the next triple peak, in the form: 
 * Case 1: the next triple peak occurs in 1234 days. 
 * Use the plural form ``days'' even if the answer is 1.
 */
public class Main1006 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int count = 1, lp = 1, le = 1, li = 1, finalNum = 0;
		int pPeriod = 23, ePeriod = 28, iPeriod = 33;
		
		while (true) {
			int p = cin.nextInt();
			int e = cin.nextInt();
			int i = cin.nextInt();
			int d = cin.nextInt();

			if (p == -1 && e == -1 && i == -1 && d == -1) {
				break;
			}

			p %= pPeriod;
			e %= ePeriod;
			i %= iPeriod;

			while ((ePeriod * iPeriod * lp) % pPeriod != 1) {
				lp++;
			}
			while ((iPeriod * pPeriod * le) % ePeriod != 1) {
				le++;
			}
			while ((pPeriod * ePeriod * li) % iPeriod != 1) {
				li++;
			}
			
			finalNum = (ePeriod * iPeriod * lp * p + iPeriod * pPeriod * le * e + pPeriod * ePeriod * li * i) % 21252;
			
			if (finalNum == d) {
				finalNum = 21252;
			} else if (finalNum < d) {
				finalNum = 21252 - (d - finalNum);
			} else if (finalNum > d) {
				finalNum = finalNum - d;
			}

			System.out.println("Case " + (count++) + ": the next triple peak occurs in " + finalNum + " days.");
		}
	}
}

/*
输入示例
0 0 0 0
0 0 0 100
5 20 34 325
4 5 6 7
283 102 23 320
203 301 203 40
-1 -1 -1 -1

示例输出
Case 1: the next triple peak occurs in 21252 days.
Case 2: the next triple peak occurs in 21152 days.
Case 3: the next triple peak occurs in 19575 days.
Case 4: the next triple peak occurs in 16994 days.
Case 5: the next triple peak occurs in 8910 days.
Case 6: the next triple peak occurs in 10789 days.

// Time Limit Exceeded
public static void main(String args[]) throws Exception {
	Scanner cin = new Scanner(System.in);
	int count = 1;
	
	while (true) {
		int p = cin.nextInt();
		int e = cin.nextInt();
		int i = cin.nextInt();
		int d = cin.nextInt();

		if (p == -1 && e == -1 && i == -1 && d == -1) {
			break;
		}

		p %= 23;
		e %= 28;
		i %= 33;

		int j = d + 1;

		for (; j <= 21252 + d; j++) {
			if (j % 23 == p && j % 28 == e && j % 33 == i) {
				break;
			}
		}

		System.out.println("Case " + (count++) + ": the next triple peak occurs in " + (j - d) + " days.");
	}
}
*/
