package com.example.interrupt.correct;

/**
 * 子线程中带有循环的，可以通过标志位中断其执行。
 */
public class FlagToInterruptThread {
    private static volatile boolean goon = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (goon) {
                System.out.println("i - " + i++);
                System.out.println("t1 interrupt status:" + Thread.currentThread().isInterrupted());
            }
            System.out.println("t1 end.");
        }, "t1");
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        t1.interrupt();
        goon = false;
    }
}
