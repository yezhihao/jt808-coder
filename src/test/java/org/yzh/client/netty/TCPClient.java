package org.yzh.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class TCPClient {

    private static final Logger log = LoggerFactory.getLogger(TCPClient.class.getSimpleName());

    public final String name;
    private TCPConfig config;
    private MessageHandler messageHandler;
    private EventLoopGroup workerGroup;
    private Channel channel;

    public TCPClient(String name, TCPConfig config, MessageHandler messageHandler) {
        this.name = name;
        this.config = config;
        this.messageHandler = messageHandler;
    }

    private void startInternal() {
        try {
            this.workerGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(workerGroup);
            bootstrap.option(NioChannelOption.SO_REUSEADDR, true)
                    .option(NioChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        public void initChannel(NioSocketChannel ch) {
                            ch.pipeline()
                                    .addLast("frameDecoder", new DelimiterBasedFrameDecoder(config.maxFrameLength,
                                            Unpooled.wrappedBuffer(config.delimiter),
                                            Unpooled.wrappedBuffer(config.delimiter, config.delimiter)))
                                    .addLast("decoder", new MessageDecoder(config.coder))
                                    .addLast("encoder", new MessageEncoder(config.coder))
                                    .addLast("adapter", new TCPClientHandler(messageHandler));

                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(config.ip, config.port).sync();
            this.channel = channelFuture.channel();
            this.channel.closeFuture();
        } catch (Exception e) {
            log.error("===TCP Client异常关闭", e);
        }
    }

    public void writeObject(Object message) {
        channel.writeAndFlush(message);
    }

    public synchronized TCPClient start() {
        startInternal();
        log.warn("===TCP Client启动成功, name={}===", name);
        return this;
    }

    public synchronized void stop() {
        workerGroup.shutdownGracefully();
        log.warn("===TCP Client已经停止, name={}===", name);
    }
}