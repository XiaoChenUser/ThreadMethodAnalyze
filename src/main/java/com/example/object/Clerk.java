package com.example.object;

public class Clerk{

    //TOTAL表示我的店最大可以容纳的总量
    private static final int TOTAL=1; //数字取1是为了放大问题
    private int num=0; //店里当前的货物量

    public synchronized void get() { //店员进货  每次进货一个
        while (num >= TOTAL) {
            System.out.println("库存已满，无法进货");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to wait().");
                this.wait();
                System.out.println(Thread.currentThread().getName() + " re-enabled from wait().");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ (++num));
        this.notifyAll();
    }

    public synchronized void sale() { //店员卖货 每次卖掉一个货
        while (num <= 0) {
            System.out.println("库存已空，无法卖货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+(--num));
        this.notifyAll();
    }
}
