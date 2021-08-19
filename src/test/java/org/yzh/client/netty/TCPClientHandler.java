package org.yzh.client.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
@ChannelHandler.Sharable
public class TCPClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(TCPClientHandler.class.getSimpleName());

    private MessageHandler handler;

    public TCPClientHandler(MessageHandler handler) {
        this.handler = handler;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object request) {
        if (request instanceof ByteBuf)
            return;

        try {
            Object response = handler.handleMessage(request);
            if (response != null) {
                ctx.channel().writeAndFlush(response);
            }
        } catch (Exception e) {
            log.warn(String.valueOf(request), e);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info(">>>>>连接到服务端{}", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.warn("<<<<<断开连接{}", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        log.error("<<<<<发生异常", e);
    }
}