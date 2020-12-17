部标808协议快速开发包
====================
# 项目介绍
* 基于Netty-buffer，实现JT/T808部标协议的编码解码

问题交流群：[906230542]

# 主要特性
* 代码足够精简，便于二次开发；
* 使用注解描述协议，告别繁琐的封包、解包；
* 兼容2011、2013、2019部标协议版本，支持分包请求；
* 支持JT/T1078音视频协议，T/JSATL12苏标主动安防协议；
* 提供报文解释器（解析过程分析工具），编码解码不再抓瞎；
* 全覆盖的测试用例，稳定发版。

# 代码仓库
 * Gitee仓库地址：[https://gitee.com/yezhihao/jt808-coder/tree/master](https://gitee.com/yezhihao/jt808-coder/tree/master)
 * Github仓库地址：[https://github.com/yezhihao/jt808-coder/tree/master](https://github.com/yezhihao/jt808-coder/tree/master)

# 下载方式
 * Gitee下载命令：`git clone https://gitee.com/yezhihao/jt808-coder -b master`
 * Github下载命令：`git clone https://github.com/yezhihao/jt808-coder -b master`

## 项目结构：
```sh
└── protocol
    ├── basics 部标协议通用消息头，以及公共的消息定义
    ├── codec 部标编码解码工具
    ├── commons 部标协议ID，工具类等
    ├── jsatl12 T/JSATL12 苏标协议（已完成）
    ├── t808 JT/T808 部标协议（已完成）
    └── t1078 JT/T1078 音视频协议（已完成）
 ```
 消息定义样例：
 ```java
@Message(JT808.定位数据批量上传)
public class T0704 extends AbstractMessage<Header> {

    private Integer total;
    private Integer type;
    private List<Item> items;

    @Field(index = 0, type = DataType.WORD, desc = "数据项个数")
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    @Field(index = 2, type = DataType.BYTE, desc = "位置数据类型 0：正常位置批量汇报，1：盲区补报")
    public Integer getType() { return type; }
    public void setType(Integer type) { this.type = type; }

    @Field(index = 3, type = DataType.LIST, desc = "位置汇报数据项")
    public List<Item> getItems() { return items; }    
    public void setItems(List<Item> items) { this.items = items; this.total = items.size(); }
}
```

## 4.test 808协议全覆盖的测试用例，以及报文解释器

* Beans 测试数据
* TestBeans 消息对象的封包解包
* TestHex 原始报文测试

* Elucidator 报文解释器 - 解码
* DarkRepulsor 报文解释器 - 编码

分析报文内每个属性所处的位置以及转换后的值，以便查询报文解析出错的原因

Elucidator 运行效果如下：
```
0	[0200] 消息ID: 512
2	[4061] 消息体属性: 16481
4	[01] 协议版本号: 1
5	[00000000017299841738] 终端手机号: 17299841738
15	[ffff] 流水号: 65535
0	[00000400] 报警标志: 1024
4	[00000800] 状态: 2048
8	[06eeb6ad] 纬度: 116307629
12	[02633df7] 经度: 40058359
16	[0138] 海拔: 312
18	[0003] 速度: 3
20	[0063] 方向: 99
22	[200707192359] 时间: 2020-07-07T19:23:59
0	[01] 附加信息ID: 1
1	[04] 参数值长度: 4
2	[0000000b] 参数值: {0,0,0,11}
0	[02] 附加信息ID: 2
1	[02] 参数值长度: 2
2	[0016] 参数值: {0,22}
0	[03] 附加信息ID: 3
1	[02] 参数值长度: 2
2	[0021] 参数值: {0,33}
0	[04] 附加信息ID: 4
1	[02] 参数值长度: 2
2	[002c] 参数值: {0,44}
0	[05] 附加信息ID: 5
1	[03] 参数值长度: 3
2	[373737] 参数值: {55,55,55}
0	[11] 附加信息ID: 17
1	[05] 参数值长度: 5
2	[4200000042] 参数值: {66,0,0,0,66}
0	[12] 附加信息ID: 18
1	[06] 参数值长度: 6
2	[4d0000004d4d] 参数值: {77,0,0,0,77,77}
0	[13] 附加信息ID: 19
1	[07] 参数值长度: 7
2	[00000058005858] 参数值: {0,0,0,88,0,88,88}
0	[25] 附加信息ID: 37
1	[04] 参数值长度: 4
2	[00000063] 参数值: {0,0,0,99}
0	[2a] 附加信息ID: 42
1	[02] 参数值长度: 2
2	[000a] 参数值: {0,10}
0	[2b] 附加信息ID: 43
1	[04] 参数值长度: 4
2	[00000014] 参数值: {0,0,0,20}
0	[30] 附加信息ID: 48
1	[01] 参数值长度: 1
2	[1e] 参数值: {30}
0	[31] 附加信息ID: 49
1	[01] 参数值长度: 1
2	[28] 参数值: {40}
28	[01040000000b02020016030200210402002c05033737371105420000004212064d0000004d4d1307000000580058582504000000632a02000a2b040000001430011e310128] 位置附加信息: [BytesAttribute[id=1,value={0,0,0,11}], BytesAttribute[id=2,value={0,22}], BytesAttribute[id=3,value={0,33}], BytesAttribute[id=4,value={0,44}], BytesAttribute[id=5,value={55,55,55}], BytesAttribute[id=17,value={66,0,0,0,66}], BytesAttribute[id=18,value={77,0,0,0,77,77}], BytesAttribute[id=19,value={0,0,0,88,0,88,88}], BytesAttribute[id=37,value={0,0,0,99}], BytesAttribute[id=42,value={0,10}], BytesAttribute[id=43,value={0,0,0,20}], BytesAttribute[id=48,value={30}], BytesAttribute[id=49,value={40}]]
020040610100000000017299841738ffff000004000000080006eeb6ad02633df701380003006320070719235901040000000b02020016030200210402002c05033737371105420000004212064d0000004d4d1307000000580058582504000000632a02000a2b040000001430011e31012863
```

JT/T808服务端：https://gitee.com/yezhihao/jt808-server

项目会不定期进行更新，建议star和watch一份，您的支持是我最大的动力。

如有任何疑问或者BUG，请联系我，非常感谢。

技术交流QQ群：[906230542]
