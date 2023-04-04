# 【Java】反射



[toc]



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



## Class

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
        Object instance = clazz.newInstance();
        System.out.println(clazz);
        System.out.println(instance);
        System.out.println(instance.getClass());
    }
}
```

运行结果：

```
class org.example.C
org.example.C@74a14482
class org.example.C
```



## Method

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
        Object instance = clazz.newInstance();
        method.invoke(instance);
    }
}
```

运行结果：

```
f
```



## Field

只能获取public成员变量

C.java：

```java
package org.example;

public class C {
    public int i = 1;
}
```

Demo.java：

```java
package org.example;

import java.lang.Class;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        String fieldName = "i";
        Class clazz = Class.forName(className);
        Field field = clazz.getField(fieldName);
        Object instance = clazz.newInstance();
        Object object = field.get(instance);
        System.out.println(object);
    }
}
```

运行结果：

```
1
```



C.java：

```java
package org.example;

public class C {
    public int i = 1;
}
```

Demo.java：

```java
package org.example;

import java.lang.Class;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        String fieldName = "i";
        Class clazz = Class.forName(className);
        Field field = clazz.getField(fieldName);
        Object instance = clazz.newInstance();
        System.out.println(field.get(instance));
        field.set(instance, 2);
        System.out.println(field.get(instance));
    }
}
```

运行结果：

```
1
2
```



C.java：

```java
package org.example;

public class C {
    public byte b = 1;
    public short s = 2;
    public int i = 3;
    public long l = 4;
}
```

Demo.java：

```java
package org.example;

import java.lang.Class;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        Class clazz = Class.forName(className);
        Field[] fields = clazz.getFields();
        Object instance = clazz.newInstance();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.get(instance));
        }
    }
}
```

运行结果：

```
b
1
s
2
i
3
l
4
```



## Constructor

C.java：

```java
package org.example;

public class C {
    int i = 1;

    public C() {
    }

    public C(int i) {
        this.i = i;
    }
}
```

Demo.java：

```java
package org.example;

import java.lang.Class;
import java.lang.reflect.Constructor;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        Class clazz = Class.forName(className);
        Constructor constructor1 = clazz.getConstructor();
        Constructor constructor2 = clazz.getConstructor(int.class);
        System.out.println(constructor1);
        System.out.println(constructor2);
    }
}
```

运行结果：

```
public org.example.C()
public org.example.C(int)
```



