package com.atguigu.exer.maipiao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int numbers = 40;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (numbers>0){
                System.out.println(Thread.currentThread().getName()+"卖出第："+(numbers--)+"\t还剩："+numbers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class saleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

       new Thread(() ->{for (int i = 1; i <=40 ; i++)  ticket.sale(); },"a").start();

        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.sale(); },"A").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.sale(); },"B").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.sale(); },"C").start();

    }
}
