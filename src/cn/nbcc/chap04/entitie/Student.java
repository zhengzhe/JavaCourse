package cn.nbcc.chap04.entitie;

public class Student {
	String id;
	String name;
	public Student(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public Student(String name) {
		this("Unknown",name);
	}
	public Student() {
		this("Unknown","Unknown");
	}
	
}
