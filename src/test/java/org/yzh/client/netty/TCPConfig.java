package org.yzh.client.netty;

public class TCPConfig {

    protected final String ip;
    protected final int port;
    protected final int maxFrameLength;
    protected final byte[] delimiter;
    protected final MessageCoder coder;

    private TCPConfig(String ip,
                      int port,
                      int maxFrameLength,
                      byte[] delimiter,
                      MessageCoder coder
    ) {
        this.ip = ip;
        this.port = port;
        this.maxFrameLength = maxFrameLength;
        this.delimiter = delimiter;
        this.coder = coder;
    }

    public static TCPConfig.Builder custom() {
        return new Builder();
    }

    public static class Builder {

        private String ip;
        private int port;
        private int maxFrameLength;
        private byte[] delimiters;
        private MessageCoder coder;

        public Builder() {
        }

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setMaxFrameLength(int maxFrameLength) {
            this.maxFrameLength = maxFrameLength;
            return this;
        }

        public Builder setDelimiters(byte[] delimiters) {
            this.delimiters = delimiters;
            return this;
        }

        public Builder setCoder(MessageCoder coder) {
            this.coder = coder;
            return this;
        }

        public TCPConfig build() {
            return new TCPConfig(
                    this.ip,
                    this.port,
                    this.maxFrameLength,
                    this.delimiters,
                    this.coder
            );
        }
    }
}