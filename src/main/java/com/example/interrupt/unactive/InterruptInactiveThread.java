package com.example.interrupt.unactive;

/**
 * 说明：interrupt un-active thread 没有任何效果
 */
public class InterruptInactiveThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println("i - " + i);
                System.out.println("t1 interrupt status:" + Thread.currentThread().isInterrupted());
            }
        }, "t1");
//        t1.start();

        t1.interrupt();
        System.out.println("main over");
    }
}
