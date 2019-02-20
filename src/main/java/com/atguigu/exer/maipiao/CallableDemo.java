package com.atguigu.exer.maipiao;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("...come in");
        return 123;
    }
}
/*第三种获取到多线程的方式、
继承Thread    实现Runnable
  实现Callable
*/
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(()->{
            System.out.println("comein");
            return 200;
        });

        Thread t  = new Thread(futureTask,"A");
        t.start();
        System.out.println(futureTask.get());
    }
}
