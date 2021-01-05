package com.concurrency;

/**
 * @author tanshiyang
 */
public class Code01DisappearRequest implements Runnable {
    static Code01DisappearRequest instance = new Code01DisappearRequest();
    static int i = 0;
    static final int TIMES = 100000;


    /**
     * 此方法没有加synchronized
     */
    @Override
    public void run() {
        for (int j = 0; j < TIMES; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
