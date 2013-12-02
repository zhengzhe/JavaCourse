package cn.nbcc.chap05.snippets;

import java.text.SimpleDateFormat;
import java.util.Date;

class StudentThread extends Thread {
	int workingTime;
	String name;
	private String taskName;

	public StudentThread(String name, String taskName, int wokingTime) {
		this.name = name;
		this.taskName = taskName;
		this.workingTime = wokingTime;
	}

	public void run() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		try {
			System.out.println(df.format(new Date(System.currentTimeMillis()))
					+ name + "寮�" + taskName);
			Thread.sleep(workingTime);
			System.out.println(df.format(new Date(System.currentTimeMillis()))
					+ workingTime / 1000 + "灏忔椂鍚庯紝" + name + "瀹屾垚浠诲姟");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("涓�０浠や笅锛屽ぇ鎵櫎寮�鍠�");
		StudentThread t1 = new StudentThread("寮犱笁", "澶ф壂闄�, 1000);
		t1.start();
		StudentThread t2 = new StudentThread("鏉庡洓", "鎿︾幓鐠�, 3000);
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("澶ф壂闄ゅ畬鎴�);
	}
}
