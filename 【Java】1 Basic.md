# 【Java】Basic



[toc]



Java的特性：跨平台/可移植性（核心优势）、面向对象、分布式、多线程

JavaSE（Java Standard Edition）：标准版，个人计算机
JavaEE（Java Enterprise Edition）：企业版，服务器
JavaME（Java Micro Edition）：微型版，消费性电子产品

JVM（Java Virtual Machine）：Java虚拟机，执行字节码
JRE（Java Runtime Environment）：Java运行时环境，包含JVM、库函数等
JDK（Java Development Kit）：Java开发工具，包含JRE、编译器、调试器

运行Java程序，不开发Java程序：安装JRE
运行Java程序，开发Java程序：安装JDK

a.java（源文件）
编译：javac a.java
a.class（字节码文件）
解释执行：java a

eclipse：
Ctrl + F11：运行
Ctrl + +：放大
Ctrl + -：缩小

初始化：
局部变量：初始化后才能使用
成员变量：如果不自行初始化，会自动初始化成默认值（int：0、double：0.0、char：'\u0000'、boolean：false）

生命周期：
局部变量：从属于方法
成员变量：从属于对象
静态变量：从属于类
