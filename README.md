# XG拟态

>  公众号 : XG小刚
> 
> 项目地址：https://github.com/xiaogang000/XG_NTAI

用于Webshell木马免杀、流量加密传输

免杀冰蝎、哥斯拉等Webshell的PHP、JSP木马文件，生成冰蝎流量加密传输配置文件

```
本工具仅用于授权测试，请勿用于非法用途
```



## 静态免杀

目前搭载7种php模板、7种jsp模板、7种waf页面、2种流量加密方式（注：jsp免杀最好JAVA8运行）

```
git clone https://github.com/xiaogang000/XG_NTAI.git
java -jar XG_NTAI.jar
```



### 使用方法

1、选择PHP、JSP页面，选择免杀模板，加密密钥可自定义(不重要)

2、源码区替换为冰蝎、哥斯拉、或其他恶意代码的php、jsp源码

3、点击免杀，获取免杀后代码即可

4、部分免杀马在第三文本框有使用注意事项

![image-20231220230202083](img/image-20231220230202083.png)

![image-20231220230233555](img/image-20231220230233555.png)



### 模拟页面

可在生成时添加模拟页面、目前支持7种waf页面

![image-20231123114749323](img/image-20231123114749323.png)

![image-20231031214827681](img/image-20231031214827681.png)

也可以选择custom添加自定义页面的base64编码

![image-20231031204208082](img/image-20231031204208082.png)



![image-20231031204252808](img/image-20231031204252808.png)



### 配置文件

部分demo需要加载配置文件XG_NTAI.properties才能使用

将XG_NTAI.properties放在同目录下运行即可

![image-20231122092044932](img/image-20231122092044932.png)

配置文件有需求加我微信咨询，进知识星球（黑灰产别来沾边）

![image-20231123114105369](img/image-20231123114105369.png)

### 注意

jsp免杀500等问题，受Tomcat版本、Java版本影响

JSP页面选择Tomcat版本为需要版本，然后再免杀

```
tomcat7.0.x/8.x	jdk6-8: 使用jsp_demo1、jsp_demo6、jsp_demo7
tomcat8.x/9.0.x	jdk8-21: 使用jsp_demo2、jsp_demo5、jsp_demo7
tomcat10.0.x	jdk8-21: 使用jsp_demo2、jsp_demo3、jsp_demo4、jsp_demo5、jsp_demo7
```

![image-20231220230331705](img/image-20231220230331705.png)



## 流量混淆

V2.0新增流量混淆功能

将Webshell交互流量，根据测试系统的正常业务请求和响应数据，伪造成为正常的业务交互流量，从而规避安全产品和混淆防守人员判断。

```
针对冰蝎4.0协议规则生成
```

![image-20231218175958933](img/image-20231218175958933.png)

网站正常业务流量

![image-20231218180547004](img/image-20231218180547004.png)

伪造Webshell交互流量

![image-20231218202254452](img/image-20231218202254452.png)



### 使用方法

1、根据正常业务，找到一个合适的POST数据包(js、json、html、图片、xml等)

![image-20231218180547004](img/image-20231218180547004.png)

2、将请求包数据和响应包数据，复制到Disguise功能指定位置

![image-20231218193942137](img/image-20231218193942137.png)

3、将标记`!!insertPoint!!`插入请求包和响应包合适位置

![image-20231218194128758](img/image-20231218194128758.png)

4、选择加密方式，输入配置文件名称后点击加密，即可在工具目录下生成xxxxxx.config配置文件

![image-20231218194300717](img/image-20231218194300717.png)

5、打开冰蝎4.0，打开传输协议并导入该配置文件

![image-20231218194902299](img/image-20231218194902299.png)

选择导入的协议后生成服务端文件，并保存

![image-20231218195226257](img/image-20231218195226257.png)

![image-20231218195251801](img/image-20231218195251801.png)

6、新建Webshell连接，加密类型选择自定义-传输协议

![image-20231218195555545](img/image-20231218195555545.png)

此时的webshell交互流量已经伪造成为正常业务流量

![image-20231218195837792](img/image-20231218195837792.png)

7、针对php木马，可以直接复制整个响应包数据

![image-20231218201711610](img/image-20231218201711610.png)

此时的webshell交互流量，会伪造业务的正常响应头内容

![image-20231218202254452](img/image-20231218202254452.png)

针对请求头还需要手动配置UA、Content-type等，才能达到完美



## 更新记录

(20231220): XG_NTAI_V2.0

新增JSP免杀选择tomcat版本功能

新增冰蝎流量混淆功能: Disguise

Disguise: 2base64、AesBase64

######################################

![image-20231220225802011](img/image-20231220225802011.png)
