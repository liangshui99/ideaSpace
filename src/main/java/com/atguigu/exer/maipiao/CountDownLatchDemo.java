package com.atguigu.exer.maipiao;

import java.util.concurrent.CountDownLatch;

//其它线程干完活主线程才干活
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        teat();
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t同学走了");
                countDownLatch.countDown();
                    },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t      班长走了");
    }

    public static void teat()throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国被灭");
                countDownLatch.countDown();
                    },CountryEnum.foreach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"一同");
    }

}
