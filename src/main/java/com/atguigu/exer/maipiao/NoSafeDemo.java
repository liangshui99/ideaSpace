package com.atguigu.exer.maipiao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class NoSafeDemo {
    public static void main(String[] args) {
//        List<String>list= new CopyOnWriteArrayList<>();//写时复制
//
//        for (int i = 1; i <=30 ; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,4));
//                System.out.println(list);
//            } ,String.valueOf(i)).start();
//        };

//        Set<String> set = new CopyOnWriteArraySet<>();
//        for (int i = 1; i <=30 ; i++) {
//            new Thread(()-> {set.add(UUID.randomUUID().toString().substring(0,4));
//                System.out.println(set);},String.valueOf(i)).start();
//        }

        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 4));
                System.out.println(map);
            },String.valueOf(i) ).start();
        }


    }
}
