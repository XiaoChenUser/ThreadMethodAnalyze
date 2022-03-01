package com.example.object;

// 生产者 可以有很多生产者卖货给这个店员
class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i<20; i++) {
            System.out.println(Thread.currentThread().getName() + " run num-" + i + " at " + System.currentTimeMillis());
            try {
                Thread.sleep(100); //放大问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}
