package cn.nbcc.chap04.snippets;

public class ArraySnippet04 {

	public static void main(String[] args) {
		
		int [] arr1= {1,2,3};
		int [] arr2 = new int[arr1.length];
		arr2 = arr1;
		for (int value : arr2) {
			System.out.printf("%d", value);
		}
	}
}
