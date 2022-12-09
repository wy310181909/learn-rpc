package com.wy.rpc.client.rpc.transport;


import com.wy.rpc.client.rpc.ResponseMappingCallback;
import com.wy.rpc.common.util.Packmsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: 
 * @create: 2020-08-16 18:24
 */
public class ClientResponses  extends ChannelInboundHandlerAdapter {

    //consumer.....
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Packmsg responsepkg = (Packmsg) msg;
        //曾经我们没考虑返回的事情
        ResponseMappingCallback.runCallBack(responsepkg);
    }
}
