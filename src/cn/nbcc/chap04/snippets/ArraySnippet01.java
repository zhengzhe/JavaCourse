package cn.nbcc.chap04.snippets;

public class ArraySnippet01 {

	public static void main(String[] args) {
		
		int i=5,j=6;
		int c[] = new int[20];
		c[i+j] = 10;
		
		int d[]=null;
		d = new int[]{1,2,3};
		
		System.out.println(c[11]);
	}
}
