package com.example.object;

/**
 * spurious wakeup
 */
public class FailedClerk {
    //TOTAL表示我的店最大可以容纳的总量
    private static final int TOTAL=1; //数字取1是为了放大问题
    private int num=0; //店里当前的货物量

    public synchronized void get() { //店员进货  每次进货一个
        if(num >= TOTAL) {
            System.out.println("库存已满，无法进货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName()+" : "+ (++num));
            this.notifyAll();
        }
    }

    public synchronized void sale() { //店员卖货 每次卖掉一个货
        if(num<=0) {
            System.out.println("库存已空，无法卖货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName()+" : "+(--num));
            this.notifyAll();
        }
    }
}
