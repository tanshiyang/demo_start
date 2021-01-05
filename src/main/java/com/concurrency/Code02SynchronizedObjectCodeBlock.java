package com.concurrency;

/**
 * @author tanshiyang
 */
public class Code02SynchronizedObjectCodeBlock implements Runnable {
    static Code02SynchronizedObjectCodeBlock instance = new Code02SynchronizedObjectCodeBlock();


    @Override
    public void run() {
        synchronized (this) {
            System.out.println("线程:" + Thread.currentThread().getName() + "开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:" + Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
    }
}
