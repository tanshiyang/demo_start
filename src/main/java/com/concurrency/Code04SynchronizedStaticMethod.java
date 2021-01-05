package com.concurrency;

/**
 * @author tanshiyang
 */
public class Code04SynchronizedStaticMethod implements Runnable {
    static Code04SynchronizedStaticMethod instance1 = new Code04SynchronizedStaticMethod();
    static Code04SynchronizedStaticMethod instance2 = new Code04SynchronizedStaticMethod();


    public static synchronized void method() {
            System.out.println("线程:" + Thread.currentThread().getName() + "开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:" + Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
    }

    @Override
    public void run() {
        method();
    }
}
