package com.example.object;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Producer producer=new Producer(clerk);
        Producer producer2=new Producer(clerk);
        Consumer consumer=new Consumer(clerk);
        Consumer consumer2=new Consumer(clerk);

        new Thread(producer,"生产者A1").start();
        new Thread(producer2,"生产者A2").start();
        new Thread(consumer,"消费者B1").start();
//        new Thread(consumer2,"消费者B2").start();


    }








}
