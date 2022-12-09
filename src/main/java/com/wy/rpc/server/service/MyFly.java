package com.wy.rpc.server.service;

import com.wy.rpc.common.service.Fly;

/**
 * @author: 
 * @create: 2020-08-16 19:08
 */
public class MyFly implements Fly {

    @Override
    public void xxoo(String msg) {
        System.out.println("server,get client arg:"+msg);
    }
}
