# 【Java设计模式】创建者模式



[toc]



## 创建者模式

创建者模式（Creational pattern）：5种
	单例模式（Singleton pattern）
	工厂方法模式
	抽象工厂模式
	原型模式
	建造者模式



## 单例模式

角色：
	单例类：创建一个实例
	访问类：使用单例类

单例模式：饿汉式、懒汉式

|          | 饿汉式 |  懒汉式  |
| :------: | :----: | :------: |
| 创建实例 | 加载类 | 首次使用 |
| 内存浪费 |   √    |    ×     |



### 饿汉式

#### 方式一：静态变量

```java
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```



#### 方式二：静态代码块

```java
public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```



#### 方式三：枚举方式

线程安全
只装载一次
唯一一种不会被破坏的单例模式的实现方式

```java
public enum Singleton {
    INSTANCE;
}
```



### 懒汉式

#### 方式一（1）：无synchronized关键字

线程不安全

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```



#### 方式一（2）：有synchronized关键字

线程安全

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```



#### 方式二（1）：双重检查锁

线程安全、有空指针问题

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

空指针问题
	原因：JVM（优化、指令重排序）
	解决：volatile关键字



#### 方式二（2）：双重检查锁

线程安全、无空指针问题

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```



#### 方式三：静态内部类

线程安全
开源项目中常用

```java
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```



### 破坏单例模式

#### 方式一：反序列化

单例：实现Serializable接口

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        writeSingletonToFile();
        Singleton instance1 = readSingletonFromFile();
        Singleton instance2 = readSingletonFromFile();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    static void writeSingletonToFile() throws Exception {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("instance.txt"));
        objectOutputStream.writeObject(instance);
        objectOutputStream.close();
    }

    static Singleton readSingletonFromFile() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("instance.txt"));
        Singleton instance = (Singleton) objectInputStream.readObject();
        objectInputStream.close();
        return instance;
    }
}
```

运行结果：

```
Singleton@17d10166
Singleton@1b9e1916
false
```



#### 方式二：反射

```java
import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance1 = constructor.newInstance();
        Singleton instance2 = constructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance1);
        System.out.println(instance1 == instance2);
    }
}
```

运行结果：

```
Singleton@27d6c5e0
Singleton@27d6c5e0
false
```



### 防止破坏单例模式

#### 方式一：防止反序列化方式

单例实现Serializable接口时，添加readResolve方法

```java
import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Serializable {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Serial
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
```



#### 方式二：防止反射方式

```java
public class Singleton implements {
    private static boolean flag = false;

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
        synchronized (Singleton.class) {
            if (flag) {
                throw new RuntimeException();
            }
            flag = true;
        }
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```



## 简单工厂模式

Simple Factory Pattern



## 静态工厂模式

Static Factory Pattern



## 工厂方法模式

Factory Method Pattern

主要角色：
	抽象工厂
	具体工厂
	抽象产品
	具体产品



## 抽象工厂模式（Abstract Factory Pattern）

主要角色：
	抽象工厂
	具体工厂
	抽象产品
	具体产品



## 简单工厂模式 + 配置文件 → 解除耦合



## 原型模式

Prototype Pattern

克隆：
	浅克隆
	深克隆

主要角色：
	抽象原型：Cloneable
	具体原型



