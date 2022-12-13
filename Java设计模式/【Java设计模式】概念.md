# 【Java设计模式】概念



[toc]



相关视频：
[黑马程序员Java设计模式详解， 23种Java设计模式（图解+框架源码分析+实战）](https://www.bilibili.com/video/BV1Np4y1z7BU/)



## 设计模式

软件设计模式/设计模式

1995年：
	《设计模式：可复用面向对象软件的基础》（Design Patterns: Elements of Reusable Object-Oriented Software）
	GoF（Gang of Four，四人组）：Erich Gamma、Richard Helm、Ralph Johnson、John Vlissides

设计模式（Design pattern）：23种
	创建者模式（Creational pattern）：5种
	结构型模式（Structural pattern）：7种
	行为型模式（Behavioral pattern）：11种



## UML

UML（Unified Modeling Language，统一建模语言）：
	用例图
	类图
	对象图
	状态图
	活动图
	时序图
	协作图
	构件图
	部署图



### 类图

类图：静态结构
	类名
	属性（field）
	方法（method）	

可见性（访问修饰符）的符号：
	+：public
	-：private
	#：protected
	无：default



### 类之间的关系

类之间的关系：
	关联关系：
		单向关联
		双向关联
		自关联
		聚合关系
		组合关系
	依赖关系
	继承关系：父类、子类
	实现关系：接口、实现类

耦合性最弱：依赖关系
耦合性最强：继承关系、实现关系



## 设计原则

设计原则：
	开闭原则：
		对扩展开放，对修改关闭（热插拔）
		使用：接口、抽象类
	里氏代换原则：
		子类：扩展父类的功能，不改变父类原有的功能
	依赖倒转原则
	迪米特法则
	合成复用原则