package org.yzh.client.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础消息解码
 * @author yezhihao
 * home https://gitee.com/yezhihao/jt808-server
 */
@ChannelHandler.Sharable
public class MessageDecoder extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(MessageDecoder.class.getSimpleName());

    private MessageCoder decoder;

    public MessageDecoder(MessageCoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            if (!buf.isReadable())
                return;
            log.info("<<<<<{}", ByteBufUtil.hexDump(buf));
            try {
                Object message = decoder.decode(buf);
                log.info("<<<<<<<<<<{}", message);
                if (message != null)
                    ctx.fireChannelRead(message);
                buf.skipBytes(buf.readableBytes());
            } catch (Exception e) {
                throw new DecoderException(ByteBufUtil.hexDump(buf), e);
            } finally {
                buf.release();
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}