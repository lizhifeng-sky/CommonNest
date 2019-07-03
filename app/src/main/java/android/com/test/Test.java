package android.com.test;

public class Test {

    public static void main(String[] args){
        Object lock = new Object();
        Thread t1 = new Thread(new Test1(lock), "t1");
        Thread t2 = new Thread(new Test2(lock), "t2");

        t1.start();
        t2.start();

    }
}

