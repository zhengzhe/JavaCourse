package cn.nbcc.chap04.snippets;

public class ArraySnippet03 {
	
	public static void main(String[] args) {
		int a[][]=new int[2][];
		a[0]=new int[]{1,2,3,4,5};
		a[1]=new int[]{1,2,3,4};
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%d ", a[i][j]);
			}
			System.out.println();
		}
	}

}
