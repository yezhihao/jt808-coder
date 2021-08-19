package org.yzh.client;

import io.netty.buffer.ByteBuf;
import org.yzh.client.netty.MessageCoder;
import org.yzh.client.netty.TCPClient;
import org.yzh.client.netty.TCPConfig;
import org.yzh.protocol.BeanTest;
import org.yzh.protocol.JT808Beans;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.codec.JTMessageDecoder;
import org.yzh.protocol.codec.JTMessageEncoder;

import java.util.Scanner;

public class JTClient {

    public static final MessageCoder MessageCoder = new MessageCoder() {
        JTMessageEncoder encoder = new JTMessageEncoder("org.yzh.protocol");
        JTMessageDecoder decoder = new JTMessageDecoder("org.yzh.protocol");

        @Override
        public ByteBuf encode(Object message) {
            return encoder.encode((JTMessage) message);
        }

        @Override
        public Object decode(ByteBuf input) {
            return decoder.decode(input);
        }
    };

    public static final TCPConfig TCPConfig = new TCPConfig.Builder()
            .setIp("127.0.0.1")
            .setPort(7611)
            .setMaxFrameLength(2 + 21 + 1023 * 2 + 1 + 2)
            .setDelimiters(new byte[]{0x7e})
            .setCoder(MessageCoder)
            .build();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        TCPClient tcpClient = new TCPClient("0", TCPConfig, new JTHandler()).start();

        while (true) {
            System.out.println("选择发送的消息：1.注册 2.位置信息上报");
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                switch (i) {
                    case 0:
                        tcpClient.stop();
                        return;
                    case 1:
                        tcpClient.writeObject(BeanTest.H2019(JT808Beans.T0100()));
                        break;
                    case 2:
                        tcpClient.writeObject(BeanTest.H2019(JT808Beans.T0200Attributes()));
                        break;
                }
            }
        }
    }
}