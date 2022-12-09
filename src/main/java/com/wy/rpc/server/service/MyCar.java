package com.wy.rpc.server.service;

import com.wy.rpc.common.service.Car;

/**
 * @author: 
 * @create: 2020-08-16 19:04
 */
public class MyCar implements Car {

    @Override
    public String ooxx(String msg) {
//        System.out.println("server,get client arg:"+msg);
        return "server res "+ msg;
    }
}
