package com.atguigu.exer.maipiao;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

class phone{

    public static synchronized void sendSMS(){
        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("---sendSMS");
    }
    public static synchronized void sendEmail(){
        System.out.println("---sendEmail");
    }
    public void openPhone(){
        System.out.println("---openPhone");
    }
}
/*
* 笔记：
* 一个对象如果有多个synchronized方法，某一时刻内，只要一个线程去调用其中一个synchronized方法，
* 其它线程都只能等待，换句话说，莫一时刻内，只能有唯一一个线程去访问这些synchronized方法
* 锁的是当前对象this，被锁定后，其它线程都不能进入到当前对象的其它synchronized方法
*
* 加个普通方法后，发现和同步锁无关
* 换成两个对象，不是同一把锁了，情况立刻变化
*
* 都换成静态方法后，情况又有变化
* 所有的非静态方法用的都是同一把锁——实例对象本身
*
* synchronized实现同步方法的基础：Java中的每一个对象都可以作为锁
* 具体表现为以下3种形式：
* 对于普通同步方法，锁的都是当前实例对象
* 对于静态同步方法，锁的都是当前类的class对象
* 对于同步方法块，锁的是synchronized括号里配置的对象
*
* 当一个线程试图访问同步代码块时，它首先必须先得到锁，退出或跑出异常低必须释放锁
*
* 也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其它非静态方法必须等待获取锁的方法释放锁后才能获取锁
*  可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁
*  所以无需等待该实例对象已获取锁的非静态同步方法释放锁，就可以获取他们自己的锁
*
*  所有的静态同步方法用的也是同一把锁——类对象本身
*  这两把锁是两个不同的对象，所以静态同步与非静态同步方法之间是不会有竞态条件 的
*  但是一旦一个静态同步方法获取锁后，其它静态同步方法都必须等待该方法释放锁后才能获取锁
*  而不管是同一个实例对象的静态同步方法之间，还是不同实例对象的静态同步方法之间，只要他们是同一个类的实例对象
*
* */

public class Lock8 {

    public static void main(String[] args) {
        phone phone = new phone();
        phone phone2= new phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        },"A").start();

        try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            try {
//                phone.sendEmail();
//                phone.openPhone();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        },"B").start();
    }
}
