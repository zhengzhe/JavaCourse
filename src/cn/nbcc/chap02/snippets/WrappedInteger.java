package cn.nbcc.chap02.snippets;

public class WrappedInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 300;
		int y = 300;
		
		Integer i1 = x;
		Integer i2 = y;
		
		System.out.println(i1.equals(x));
		System.out.println(i2.equals(y));
//		if (i1==i2) {
//			System.out.println("i1==i2");
//		}else {
//			System.out.println("i1!=i2");
//		}
	}

}
