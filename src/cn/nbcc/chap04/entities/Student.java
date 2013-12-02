package cn.nbcc.chap04.entities;

public class Student {
	public static int count;
	public static int finalizedCount;
	String id;
	String name;
	String klsName;
	int credits;
	public Student(String id,String name) {
		count++;
	}
	@Override
	protected void finalize() throws Throwable {
		finalizedCount++;
	}
}
