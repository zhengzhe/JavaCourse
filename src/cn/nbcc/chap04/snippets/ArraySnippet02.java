package cn.nbcc.chap04.snippets;

import java.util.Arrays;

public class ArraySnippet02 {
	
	public static void main(String[] args) {
		
		//数组复制
		int s1[] ={1,2,3,4,5};
		//方法1
		int s2[] = new int[s1.length];
		for (int i = 0; i < s1.length; i++) {
			s1[i]=s2[i];
		}
		//方法2
		int s3[] =new int[s1.length];
		System.arraycopy(s1, 0, s3, 0, s1.length);
		//方法3
		int s4[];
		s4 = Arrays.copyOf(s1, s1.length);
	}

}
