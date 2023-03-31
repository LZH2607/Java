# 【Java】反射



[toc]



## 示例

C.java：

```java
package org.example;

public class C {
}
```

Demo.java：

```java
package org.example;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        Class clazz = Class.forName(className);
        Object object = clazz.newInstance();
        System.out.println(object.getClass());
    }
}
```

运行结果：

```
class org.example.C
```



C.java：

```java
package org.example;

public class C {
    public void f() {
        System.out.println("f");
    }
}
```

Demo.java：

```java
package org.example;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        String methodName = "f";
        Class clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName);
        Object object = clazz.newInstance();
        method.invoke(object);
    }
}
```

运行结果：

```
f
```



## 概念

反射：
	判断一个对象所属的类
	构造一个类的对象
	获取一个类的成员变量和方法
	调用一个对象的成员变量和方法
	生成动态代理



|              类               |   代表   |
| :---------------------------: | :------: |
|        java.lang.Class        |    类    |
|   java.lang.reflect.Method    |   方法   |
|    java.lang.reflect.Field    | 成员变量 |
| java.lang.reflect.Constructor |  构造器  |

