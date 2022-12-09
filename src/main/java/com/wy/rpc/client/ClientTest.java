package com.wy.rpc.client;

import com.wy.rpc.client.proxy.MyProxy;
import com.wy.rpc.common.service.Car;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 
 * @create: 2020-07-12 20:08
 *
 * 12号的课开始手写RPC ，把前边的IO的课程都看看
 *http://mashibing.com/vip.html#%E5%91%A8%E8%80%81%E5%B8%88%E5%86%85%E5%AD%98%E4%B8%8Eio%E7%A3%81%E7%9B%98io%E7%BD%91%E7%BB%9Cio
 */

/*
    1，先假设一个需求，写一个RPC
    2，来回通信，连接数量，拆包？
    3，动态代理呀，序列化，协议封装
    4，连接池
    5，就像调用本地方法一样去调用远程的方法，面向java中就是所谓的 面向interface开发
 */


/**
 * 上节课，基本写了一个能发送
 * 小问题，当并发通过一个连接发送后，服务端解析bytebuf 转 对象的过程出错
 */
public class ClientTest {


    //模拟comsumer端
    @Test
    public void get(){

        AtomicInteger  num = new AtomicInteger(0);
        int size = 1;
        Thread[] threads = new Thread[size];
        for (int i = 0; i <size; i++) {
            threads[i] = new Thread(()->{
                Car car = MyProxy.proxyGet(Car.class);//动态代理实现
                String arg = "hello" + num.incrementAndGet();
                String res = car.ooxx(arg);
                System.out.println("client over msg: " + res+" src arg: "+ arg);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
