package org.yzh.client.netty;

@FunctionalInterface
public interface MessageHandler<T> {

    Object handleMessage(T message);

}