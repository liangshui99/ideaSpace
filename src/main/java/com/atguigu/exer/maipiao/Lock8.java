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
