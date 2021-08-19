package org.yzh.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yzh.client.netty.MessageHandler;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;
import org.yzh.protocol.t808.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class JTHandler implements MessageHandler<JTMessage> {

    private static final Logger log = LoggerFactory.getLogger(JTHandler.class.getSimpleName());

    private AtomicInteger serialNo = new AtomicInteger();

    private String mobileNo = "12345678901";

    public JTMessage 平台通用应答(T0001 message) {
        return null;
    }

    public T0001 服务器补传分包请求(T8003 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 查询服务器时间应答(T8004 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 终端注册应答(T8100 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 设置终端参数(T8103 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 查询终端参数(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 终端控制(T8105 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 查询指定终端参数(T8106 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 查询终端属性(T0107 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 下发终端升级包(T8108 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0200 位置信息查询(JTMessage message) {
        T0200 result = new T0200();
        //TODO
        return result;
    }

    public T0001 临时位置跟踪控制(T8202 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 人工确认报警消息(T8203 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 服务器向终端发起链路检测请求(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 文本信息下发(T8300 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 事件设置(T8301 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 提问下发(T8302 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 信息点播菜单设置(T8303 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 信息服务(T8304 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 电话回拨(T8400 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 设置电话本(T8401 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 车辆控制(T8500 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 删除圆形区域(T8601 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 设置圆形区域(T8600 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }


    public T0001 设置矩形区域(T8602 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 设置多边形区域(T8604 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 设置路线(T8606 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 查询区域或线路数据(T8608 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 行驶记录仪数据采集命令(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 行驶记录仪参数下传命令(T8701 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 上报驾驶员身份信息请求(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 多媒体数据上传应答(T8800 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 摄像头立即拍摄命令(T8801 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 存储多媒体数据检索(T8802 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 存储多媒体数据上传(T8803 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 录音开始命令(T8804 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 单条存储多媒体数据检索上传命令(T8805 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 数据下行透传(T8900 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    public T0001 平台RSA公钥(T0A00_8A00 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    private T0001 buildResult(JTMessage message, int resultCode) {
        T0001 result = new T0001();
        result.copyBy(message);
        result.setMessageId(JT808.终端通用应答);
        result.setClientId(mobileNo);
        result.setSerialNo(serialNo.addAndGet(1));

        result.setResponseSerialNo(message.getSerialNo());
        result.setResponseMessageId(message.getMessageId());
        result.setResultCode(resultCode);
        return result;
    }

    @Override
    public Object handleMessage(JTMessage message) {
        JTMessage msg = message;
        if (JT808.平台通用应答 == msg.getMessageId()) return this.平台通用应答((T0001) msg);
        if (JT808.服务器补传分包请求 == msg.getMessageId()) return this.服务器补传分包请求((T8003) msg);
        if (JT808.查询服务器时间应答 == msg.getMessageId()) return this.查询服务器时间应答((T8004) msg);
        if (JT808.终端注册应答 == msg.getMessageId()) return this.终端注册应答((T8100) msg);
        if (JT808.设置终端参数 == msg.getMessageId()) return this.设置终端参数((T8103) msg);
        if (JT808.查询终端参数 == msg.getMessageId()) return this.查询终端参数(msg);
        if (JT808.终端控制 == msg.getMessageId()) return this.终端控制((T8105) msg);
        if (JT808.查询指定终端参数 == msg.getMessageId()) return this.查询指定终端参数((T8106) msg);
        if (JT808.查询终端属性 == msg.getMessageId()) return this.查询终端属性((T0107) msg);
        if (JT808.下发终端升级包 == msg.getMessageId()) return this.下发终端升级包((T8108) msg);
        if (JT808.位置信息查询 == msg.getMessageId()) return this.位置信息查询(msg);
        if (JT808.临时位置跟踪控制 == msg.getMessageId()) return this.临时位置跟踪控制((T8202) msg);
        if (JT808.人工确认报警消息 == msg.getMessageId()) return this.人工确认报警消息((T8203) msg);
        if (JT808.服务器向终端发起链路检测请求 == msg.getMessageId()) return this.服务器向终端发起链路检测请求(msg);
        if (JT808.文本信息下发 == msg.getMessageId()) return this.文本信息下发((T8300) msg);
        if (JT808.事件设置 == msg.getMessageId()) return this.事件设置((T8301) msg);
        if (JT808.提问下发 == msg.getMessageId()) return this.提问下发((T8302) msg);
        if (JT808.信息点播菜单设置 == msg.getMessageId()) return this.信息点播菜单设置((T8303) msg);
        if (JT808.信息服务 == msg.getMessageId()) return this.信息服务((T8304) msg);
        if (JT808.电话回拨 == msg.getMessageId()) return this.电话回拨((T8400) msg);
        if (JT808.设置电话本 == msg.getMessageId()) return this.设置电话本((T8401) msg);
        if (JT808.车辆控制 == msg.getMessageId()) return this.车辆控制((T8500) msg);
        if (JT808.删除圆形区域 == msg.getMessageId()) return this.删除圆形区域((T8601) msg);
        if (JT808.设置圆形区域 == msg.getMessageId()) return this.设置圆形区域((T8600) msg);
        if (JT808.设置矩形区域 == msg.getMessageId()) return this.设置矩形区域((T8602) msg);
        if (JT808.设置多边形区域 == msg.getMessageId()) return this.设置多边形区域((T8604) msg);
        if (JT808.设置路线 == msg.getMessageId()) return this.设置路线((T8606) msg);
        if (JT808.查询区域或线路数据 == msg.getMessageId()) return this.查询区域或线路数据((T8608) msg);
        if (JT808.行驶记录仪数据采集命令 == msg.getMessageId()) return this.行驶记录仪数据采集命令(msg);
        if (JT808.行驶记录仪参数下传命令 == msg.getMessageId()) return this.行驶记录仪参数下传命令((T8701) msg);
        if (JT808.上报驾驶员身份信息请求 == msg.getMessageId()) return this.上报驾驶员身份信息请求(msg);
        if (JT808.多媒体数据上传应答 == msg.getMessageId()) return this.多媒体数据上传应答((T8800) msg);
        if (JT808.摄像头立即拍摄命令 == msg.getMessageId()) return this.摄像头立即拍摄命令((T8801) msg);
        if (JT808.存储多媒体数据检索 == msg.getMessageId()) return this.存储多媒体数据检索((T8802) msg);
        if (JT808.存储多媒体数据上传 == msg.getMessageId()) return this.存储多媒体数据上传((T8803) msg);
        if (JT808.录音开始命令 == msg.getMessageId()) return this.录音开始命令((T8804) msg);
        if (JT808.单条存储多媒体数据检索上传命令 == msg.getMessageId()) return this.单条存储多媒体数据检索上传命令((T8805) msg);
        if (JT808.数据下行透传 == msg.getMessageId()) return this.数据下行透传((T8900) msg);
        if (JT808.平台RSA公钥 == msg.getMessageId()) return this.平台RSA公钥((T0A00_8A00) msg);
        return null;
    }
}