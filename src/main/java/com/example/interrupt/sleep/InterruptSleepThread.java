package com.example.interrupt.sleep;

/**
 * 说明：interrupt 处于 sleep/wait/join 的线程：
 * ①清除 interrupt status：t1.isInterrupted == false;
 * ②抛出 InterruptedException,中断还是继续执行取决于 catch 块中的语句。
 */
public class InterruptSleepThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println("i - " + i);
                System.out.println("t1 interrupt status:" + Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //这里因为 run() 不能抛出异常，捕获 InterruptedException 后的处理逻辑，将决定 t1 是继续执行还是中断
                    // throw new RuntimeException 将导致 t1 中断
                    e.printStackTrace();
//                    throw new RuntimeException(e.getMessage());
                }
            }
        }, "t1");
        t1.start();

        t1.interrupt();
    }
}
