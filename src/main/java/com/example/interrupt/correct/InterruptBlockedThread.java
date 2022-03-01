package com.example.interrupt.correct;

/**
 * 处于阻塞状态的子线程，无法通过标志位的改变，立即中断，
 * 此时可以通过 interrupt() + InterruptedException/ClosedByInterruptException，
 * 中断子线程。
 */
public class InterruptBlockedThread {
    private static volatile boolean stop = false;

    /**
     * 这种 try-catch 放在循环外面的写法，当在执行循环时发生中断，interrupt status 被设置，
     * 一执行到耗时操作（可以抛出 InterruptedException/ClosedByInterruptException），
     * 就立即停止。
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                while (!stop) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("i - " + i++);
                        System.out.println("t1 interrupt status:" + Thread.currentThread().isInterrupted());
                    }
                }

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end.");
        }, "t1");
        t1.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        stop = true;
    }

}
