package pku.p10xx.p100x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * DNA Sorting
 * 
 * Description
 * One measure of ``unsortedness'' in a sequence is the number of pairs of entries that are out of order with respect to each other. 
 * For instance, in the letter sequence ``DAABEC'', this measure is 5, since D is greater than four letters to its right 
 * and E is greater than one letter to its right. This measure is called the number of inversions in the sequence. 
 * The sequence ``AACEDGG'' has only one inversion (E and D)---it is nearly sorted---
 * while the sequence ``ZWQM'' has 6 inversions (it is as unsorted as can be---exactly the reverse of sorted). 
 * 
 * You are responsible for cataloguing a sequence of DNA strings (sequences containing only the four letters A, C, G, and T). 
 * However, you want to catalog them, not in alphabetical order, but rather in order of ``sortedness'', 
 * from ``most sorted'' to ``least sorted''. All the strings are of the same length. 
 * 
 * Input
 * The first line contains two integers: a positive integer n (0 < n <= 50) giving the length of the strings; 
 * and a positive integer m (0 < m <= 100) giving the number of strings. 
 * These are followed by m lines, each containing a string of length n.
 * 
 * Output
 * Output the list of input strings, arranged from ``most sorted'' to ``least sorted''. 
 * Since two strings can be equally sorted, then output them according to the orginal order.
 */
public class Main1007 {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int inputLength = cin.nextInt();
		int inputCount = cin.nextInt();
		
		List<String> rets = new ArrayList<String>(inputCount);
		List<Integer> vals = new ArrayList<Integer>(inputCount);
		
		for (int i = 0; i < inputCount; i++) {
			int val = 0;
			String _line = cin.next();
			char[] line = _line.toCharArray();

			for (int j = 0; j < inputLength - 1; j++) {
				for (int k = j + 1; k < inputLength; k++) {
					if (line[j] > line[k])
						val++;
				}
			}

			if (rets.isEmpty()) {
				rets.add(_line);
				vals.add(val);
			} else {
				for (int j = rets.size() - 1; j >= 0; j--) {
					if (vals.get(j) <= val) {
						rets.add(j + 1, _line);
						vals.add(j + 1, val);
						break;
					}
					if (j == 0) {
						rets.add(j, _line);
						vals.add(j, val);
					}
				}
			}

		}
		
		for (String ret : rets) {
			System.out.println(ret);
		}
	}
}

/*
输入示例
10 6
AACATGAAGG
TTTTGGCCAA
TTTGGCCAAA
GATCAGATTT
CCCGGGGGGA
ATCGATGCAT

示例输出
CCCGGGGGGA
AACATGAAGG
GATCAGATTT
ATCGATGCAT
TTTTGGCCAA
TTTGGCCAAA

// Wrong Answer	可能原因是排序不稳定
public static void main(String args[]) throws Exception {
		Map<String, Integer> ret = new TreeMap<String, Integer>();
		Scanner cin = new Scanner(System.in);
		int inputLength = cin.nextInt();
		int inputCount = cin.nextInt();
		
		for (int i = 1; i <= inputCount; i++) {
			int val = 0;
			String _line = cin.next();
			char[] line = _line.toCharArray();
			
			for (int j = 0; j < inputLength - 1; j++) {
				for (int k = j + 1; k < inputLength; k++) {
					if (line[j] > line[k])
						val++;
				}
			}
			ret.put(_line, val * 1000 + i);// 使val相同时先进的排在前面
		}
		
		// 升序比较器
		Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		};
		// map转换成list进行排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ret.entrySet());
		// 排序
		Collections.sort(list, valueComparator);
		
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey());
		}
	}
*/
