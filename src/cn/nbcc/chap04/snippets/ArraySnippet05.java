package cn.nbcc.chap04.snippets;

import java.util.Arrays;

public class ArraySnippet05 {
	
	public static void some(int i) {
		System.out.println("int");
	}
	public static void some(Integer in) {
		System.out.println("Integer");
	}
	
	public static int sum(int... numbers) {
		int sum = 0 ;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}
	

	public static void main(String[] args) {
		ArraySnippet05.some(1);
		String[][] strs = {
				{"Java","Java","Java"},
				{"Java","Java","Java","Java"}
		};
		for (String[] row : strs) {
			for (String str : row) {
				System.out.println(str);
			}
		}
	}
}
