package com.work.multithread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {

        if(lock.tryLock()){
            try{
                System.out.println(Thread.currentThread().getName()+"获取到锁！");
                Thread.currentThread().sleep(5);
                System.out.println("执行结束，准备释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 不执行 lock.unlock(); lock将一直被A线程占用，即是A线程执行完毕终止，锁也不会释放！！
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+"未获取到锁");
        }


    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread thread1 = new Thread(new TestLock());
        thread1.setName("A");
        Thread thread2 = new Thread(new TestLock());
        thread2.setName("B");
        thread1.start();


        //让A线程先执行，先获取锁，这样B线程获取不到锁
        TimeUnit.SECONDS.sleep(3);
        thread2.start();


    }

}
