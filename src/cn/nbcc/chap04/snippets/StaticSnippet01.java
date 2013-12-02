package cn.nbcc.chap04.snippets;

import cn.nbcc.chap04.entities.Student;

public class StaticSnippet01 {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Student(""+i,""+i);
		}
		System.out.println(Student.count+"个学生对象被创建");
		//清理
		System.gc();
		System.runFinalization();
		System.out.println(Student.finalizedCount+"个对象空间被回收");
		
	}

}
