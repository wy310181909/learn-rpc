package com.wy.rpc.client.rpc;

import com.wy.rpc.common.util.Packmsg;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 
 * @create: 2020-08-16 18:25
 */
public class ResponseMappingCallback {
    static ConcurrentHashMap<Long, CompletableFuture> mapping = new ConcurrentHashMap<>();

    public static void  addCallBack(long requestID,CompletableFuture cb){
        mapping.putIfAbsent(requestID,cb);
    }
    public static void runCallBack(Packmsg msg){
        CompletableFuture cf = mapping.get(msg.getHeader().getRequestID());
        cf.complete(msg.getContent().getRes());
        removeCB(msg.getHeader().getRequestID());
    }
    private static void removeCB(long requestID) {
        mapping.remove(requestID);
    }

}
