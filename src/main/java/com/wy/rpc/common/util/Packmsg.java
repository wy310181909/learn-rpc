package com.wy.rpc.common.util;


import com.wy.rpc.common.rpc.protocol.MyContent;
import com.wy.rpc.common.rpc.protocol.Myheader;

/**
 * @author: 
 * @create: 2020-07-19 20:47
 */
public class Packmsg {

    Myheader header;
    MyContent content;

    public Myheader getHeader() {
        return header;
    }

    public void setHeader(Myheader header) {
        this.header = header;
    }

    public MyContent getContent() {
        return content;
    }

    public void setContent(MyContent content) {
        this.content = content;
    }

    public Packmsg(Myheader header, MyContent content) {
        this.header = header;
        this.content = content;
    }
}
