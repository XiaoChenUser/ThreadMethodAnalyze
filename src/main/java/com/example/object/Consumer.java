package com.example.object;

//消费者：可以很多消费者找店员买货
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
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
            clerk.sale();
        }
    }
}
