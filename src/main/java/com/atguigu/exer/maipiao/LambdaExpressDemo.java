package com.atguigu.exer.maipiao;

import jdk.nashorn.internal.objects.annotations.Function;

@FunctionalInterface
interface Foo {
    // public void sayHi();
    public int add(int a, int b);
    public default int div(int a,int b){
        return a/b;
    };
}


public class LambdaExpressDemo {
//Lombda Express 拷贝小括号，写死右箭头 落地大括号
    //必须是函数式接口才能有lombda表达式
    //default支持接口 内有方法的实现
    public static void main(String[] args) {
       /* Foo foo = new Foo() {
            @Override
            public void sayHi() {
                System.out.println("@@@@@@@sayHi...");
            }
        };
        foo.sayHi();
        foo = () -> { System.out.println("******sayHi..."); };
        foo.sayHi();*/


        Foo foo = ( a, b) -> {
            return a+b;
        };
        System.out.println(foo.add(3,4));
        System.out.println(foo.div(10,5));
    }
}
