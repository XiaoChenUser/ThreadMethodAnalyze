package com.example.interrupt.running;

/**
 * 说明：t1.interrupt() 之后，
 * t1.isInterrupted() == true，
 * t1 继续执行。
 */
public class InterruptRunningThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println("i - " + i);
                    System.out.println("t1 interrupt status:" + Thread.currentThread().isInterrupted());
                }
            }
        }, "t1");
        t1.start();

        t1.interrupt();
    }


}
