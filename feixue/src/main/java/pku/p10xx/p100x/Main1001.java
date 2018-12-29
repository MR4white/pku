package pku.p10xx.p100x;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Exponentiation
 * 
 * Description
 * Problems involving the computation of exact values of very large magnitude and precision are common. 
 * For example, the computation of the national debt is a taxing experience for many computer systems. 
 * This problem requires that you write a program to compute the exact value of Rn 
 * where R is a real number ( 0.0 < R < 99.999 ) and n is an integer such that 0 < n <= 25.
 * 
 * Input
 * The input will consist of a set of pairs of values for R and n. The R value will occupy columns 1 through 6, 
 * and the n value will be in columns 8 and 9.
 * 
 * Output
 * The output will consist of one line for each line of input giving the exact value of R^n. 
 * Leading zeros should be suppressed in the output. Insignificant trailing zeros must not be printed. 
 * Don't print the decimal point if the result is an integer.
 */
public class Main1001 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			// 底数
			BigDecimal num = cin.nextBigDecimal();
			// 幂数
			int power = cin.nextInt();
			
			String retStr = num.pow(power).toPlainString();
			if (retStr.startsWith("0.")) {
				retStr = retStr.substring(1);
			}
			while (retStr.endsWith("0")) {
				retStr = retStr.substring(0, retStr.length() - 1);
			}
			if (retStr.endsWith(".")) {
				retStr = retStr.substring(0, retStr.length() - 1);
			}
			System.out.println(retStr);
		}
	}
}

/*
输入示例
95.123 12
0.4321 20
5.1234 15
6.7592  9
98.999 10
1.0100 12

示例输出
548815620517731830194541.899025343415715973535967221869852721
.00000005148554641076956121994511276767154838481760200726351203835429763013462401
43992025569.928573701266488041146654993318703707511666295476720493953024
29448126.764121021618164430206909037173276672
90429072743629540498.107596019456651774561044010001
1.126825030131969720661201
*/
