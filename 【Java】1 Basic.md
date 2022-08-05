# 【Java】Basic



[toc]



相关视频：
[【零基础 快速学Java】韩顺平 零基础30天学会Java](https://www.bilibili.com/video/BV1fh411y7R8)

[Oracle Java SE Support Roadmap](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)
![](D:\Notes\Java\Java.assets\Oracle Java SE Support Roadmap.png)
发明者：James Gosling
Java 8：最广泛的版本

Java的特性：
	面向对象（oop）
	健壮性：强类型机制、异常处理、垃圾回收机制、分布式、多线程
	跨平台性/可移植性（核心优势）：.class文件可以在多个系统上运行
	解释型：需要解释器（JVM）来执行（如JavaScript、PHP、java）
		编译型：直接被机器执行（如C/C++）

JavaSE（Java Standard Edition） / J2SE：标准版，个人计算机
JavaEE（Java Enterprise Edition） / J2EE：企业版，服务器
JavaME（Java Micro Edition） / J2ME：微型版，消费性电子产品

JVM（Java Virtual Machine）：Java虚拟机，执行字节码
JRE（Java Runtime Environment）：Java运行时环境，包含JVM、Java SE标准类库（Java核心类库）
JDK（Java Development Kit）：Java开发工具，包含JRE、开发工具集（java、javac、javadoc、javap······）

运行Java程序，不开发Java程序：安装JRE
运行Java程序，开发Java程序：安装JDK

a.java（源文件）
↓ 编译：javac a.java
a.class（字节码文件）
↓ 解释执行：java a
程序执行结果

源文件：public类 ≤ 1个
编译后：一个类对应一个class文件
如果源文件包含一个public类，则文件名必须按该类名命名
可以将main方法写在非public类中：运行该类的class文件时，则运行该类中的main方法

eclipse：
Ctrl + F11：运行
Ctrl + +：放大
Ctrl + -：缩小
main + Alt + / + Enter：public static void main(String[] args) {}
sysout + Alt + /：System.out.println();

初始化：
局部变量：初始化后才能使用
成员变量：如果不自行初始化，会自动初始化成默认值（int：0、double：0.0、char：'\u0000'、boolean：false）

生命周期：
局部变量：从属于方法
成员变量：从属于对象
静态变量：从属于类
