package org.yzh.client.netty;

import io.netty.buffer.ByteBuf;

/**
 * JT消息编解码适配器
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public interface MessageCoder {

    ByteBuf encode(Object message);

    Object decode(ByteBuf input);

}