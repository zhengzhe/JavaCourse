package cn.nbcc.chap05.snippets;
//建第一个线程类:

public class Thread01 extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(5000);//主线程挂起7秒
            System.out.println("one is start....");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
