package pku.p10xx.p100x;

import java.util.Scanner;

/**
 * I Think I Need a Houseboat
 * 
 * Description
 * Fred Mapper is considering purchasing some land in Louisiana to build his house on. In the process of investigating the land, 
 * he learned that the state of Louisiana is actually shrinking by 50 square miles each year, 
 * due to erosion caused by the Mississippi River. Since Fred is hoping to live in this house the rest of his life, 
 * he needs to know if his land is going to be lost to erosion. 
 * 
 * After doing more research, Fred has learned that the land that is being lost forms a semicircle. 
 * This semicircle is part of a circle centered at (0,0), with the line that bisects the circle being the X axis. 
 * Locations below the X axis are in the water. The semicircle has an area of 0 at the beginning of year 1. 
 * (Semicircle illustrated in the Figure.) 
 * 
 * Input
 * The first line of input will be a positive integer indicating how many data sets will be included (N). 
 * Each of the next N lines will contain the X and Y Cartesian coordinates of the land Fred is considering. 
 * These will be floating point numbers measured in miles. The Y coordinate will be non-negative. (0,0) will not be given.
 * 
 * Output
 * For each data set, a single line of output should appear. 
 * This line should take the form of: “Property N: This property will begin eroding in year Z.” Where N is the data set (counting from 1), 
 * and Z is the first year (start from 1) this property will be within the semicircle AT THE END OF YEAR Z. 
 * Z must be an integer. After the last data set, this should print out “END OF OUTPUT.”
 */
public class Main1005 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int inputCount = cin.nextInt();

		for (int i = 1; i <= inputCount; i++) {
			double x = cin.nextDouble();
			double y = cin.nextDouble();

			double area = Math.PI * (x * x + y * y) / 2;
			int year = (int) (area / 50) + 1;
			System.out.println("Property " + i + ": This property will begin eroding in year " + year + ".");
		}
		System.out.println("END OF OUTPUT.");
	}
}

/*
输入示例
2
1.0 1.0
25.0 0.0

示例输出
Property 1: This property will begin eroding in year 1.
Property 2: This property will begin eroding in year 20.
END OF OUTPUT.
*/
