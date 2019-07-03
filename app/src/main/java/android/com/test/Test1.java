package android.com.test;

public class Test1 implements Runnable {
    private Object lock;

    public Test1(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()
                    + " get lock.");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " release lock.");
        }
    }
}
