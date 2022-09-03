# 【Maven】笔记



[toc]



## 简介

[Apache Maven Project](https://maven.apache.org/)

项目对象模型（POM）

Maven模型：
![](D:\Notes\Java\Maven\img\Maven模型.png)



## 项目结构

```
project
│ pom.xml
│
└─src
    ├─main
    │  ├─java
    │  ├─resources
    │  └─webapp
    └─test
        ├─java
        └─resources
```

project：项目文件夹
	pom.xml：项目配置文件
	src：代码文件夹
		main：源代码文件夹
			java：java源代码文件夹
			resources：配置文件文件夹
			webapp：Web项目文件夹
		test：测试代码文件夹
			java：java测试代码文件夹
			resources：配置文件文件夹



## 构建流程

编译 → 测试 → 打包 → 发布



## 仓库

本地仓库：个人计算机上
中央仓库：Maven团队维护
远程仓库（私服）：公司团队搭建



### 设置本地仓库

默认位置：

```
C:\Users\[用户账号]\.m2\repository
```

...\apache-maven-x.x.x\conf\settings.xml：

```xml
<localRepository>D:\Install\apache-maven-3.6.1\repository</localRepository>
```



### 设置远程仓库

...\apache-maven-x.x.x\conf\settings.xml：

```xml
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```



## 常用命令

|    命令     | 功能 |
| :---------: | :--: |
| mvn compile | 编译 |
|  mvn clean  | 清理 |
|  mvn test   | 测试 |
| mvn package | 打包 |
| mvn install | 安装 |

下载编译、清理、测试、打包、安装的插件：远程仓库 → 本地仓库



## 生命周期

清理工作
核心工作：编译、测试、打包、安装
产生报告、发布站点、······



## 坐标

Maven坐标：
	groupId：组织名（域名反写）
	artifactId：模块名（如：order-service、goods-service）
	version：版本号
	scope：范围（默认值：compile）
		相关视频：[黑马程序员最新版JavaWeb基础教程，Java web从入门到企业实战完整版 P46 05-依赖管理&依赖范围 ](https://www.bilibili.com/video/BV1Qf4y1T7Hx?p=46)

| scope值  | 编译 | 测试 | 运行 |
| :------: | :--: | :--: | :--: |
| compile  |  √   |  √   |  √   |
|   test   |      |  √   |      |
| provided |  √   |  √   |      |
| runtime  |      |  √   |  √   |
|  system  |  √   |  √   |      |

import：引入DependencyManagement

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.32</version>
</dependency>
```



## IntelliJ IDEA

相关视频：
[黑马程序员最新版JavaWeb基础教程，Java web从入门到企业实战完整版 P45 04-IDEA配置Maven](https://www.bilibili.com/video/BV1Qf4y1T7Hx?p=45)



## 依赖管理

相关视频：
[黑马程序员最新版JavaWeb基础教程，Java web从入门到企业实战完整版 P46 05-依赖管理&依赖范围 ](https://www.bilibili.com/video/BV1Qf4y1T7Hx?p=46)
