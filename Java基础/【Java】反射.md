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
    public int i1 = 1;
    public int i2 = 2;
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
i1
1
i2
2
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



## 获取Class

### Class.forName

```java
package org.example;

public class Demo {
    public static void main(String[] args) throws ReflectiveOperationException {
        String className = "org.example.C";
        Class clazz = Class.forName(className);
        System.out.println(clazz);
    }
}
```

运行结果：

```
class org.example.C
```



### 类名.class

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz = C.class;
        System.out.println(clazz);
    }
}
```

运行结果：

```
class org.example.C
```



### 对象名.getClass

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        C c = new C();
        Class clazz = c.getClass();
        System.out.println(clazz);
    }
}
```

运行结果：

```
class org.example.C
```



### 基本数据类型.class

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz1 = byte.class;
        Class clazz2 = short.class;
        Class clazz3 = int.class;
        Class clazz4 = long.class;
        Class clazz5 = float.class;
        Class clazz6 = double.class;
        Class clazz7 = char.class;
        Class clazz8 = boolean.class;

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
    }
}
```

运行结果：

```
byte
short
int
long
float
double
char
boolean
```



### 包装类.TYPE

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz1 = Byte.TYPE;
        Class clazz2 = Short.TYPE;
        Class clazz3 = Integer.TYPE;
        Class clazz4 = Long.TYPE;
        Class clazz5 = Float.TYPE;
        Class clazz6 = Double.TYPE;
        Class clazz7 = Character.TYPE;
        Class clazz8 = Boolean.TYPE;

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
    }
}
```

运行结果：

```
byte
short
int
long
float
double
char
boolean
```



基本数据类型.class == 包装类.TYPE：

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz1 = byte.class;
        Class clazz2 = short.class;
        Class clazz3 = int.class;
        Class clazz4 = long.class;
        Class clazz5 = float.class;
        Class clazz6 = double.class;
        Class clazz7 = char.class;
        Class clazz8 = boolean.class;

        Class clazz9 = Byte.TYPE;
        Class clazz10 = Short.TYPE;
        Class clazz11 = Integer.TYPE;
        Class clazz12 = Long.TYPE;
        Class clazz13 = Float.TYPE;
        Class clazz14 = Double.TYPE;
        Class clazz15 = Character.TYPE;
        Class clazz16 = Boolean.TYPE;

        System.out.println(clazz1 == clazz9);
        System.out.println(clazz2 == clazz10);
        System.out.println(clazz3 == clazz11);
        System.out.println(clazz4 == clazz12);
        System.out.println(clazz5 == clazz13);
        System.out.println(clazz6 == clazz14);
        System.out.println(clazz7 == clazz15);
        System.out.println(clazz8 == clazz16);
    }
}
```

运行结果：

```
true
true
true
true
true
true
true
true
```



注意：包装类.class != 包装类.TYPE

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz1 = Byte.class;
        Class clazz2 = Short.class;
        Class clazz3 = Integer.class;
        Class clazz4 = Long.class;
        Class clazz5 = Float.class;
        Class clazz6 = Double.class;
        Class clazz7 = Character.class;
        Class clazz8 = Boolean.class;

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
    }
}
```

运行结果：

```
class java.lang.Byte
class java.lang.Short
class java.lang.Integer
class java.lang.Long
class java.lang.Float
class java.lang.Double
class java.lang.Character
class java.lang.Boolean
```



## 存在Class对象的类型

基本数据类型
外部类
内部类
接口
数组
枚举类
注解
void

C1.java：

```java
package org.example;

public class C1 {
    class C2 {
    }
}
```

E.java：

```java
package org.example;

public enum E {
}
```

I.java：

```java
package org.example;

public interface I {
}
```

Demo.java：

```java
package org.example;

public class Demo {
    public static void main(String[] args) {
        Class clazz1 = C1.class;
        Class clazz2 = C1.C2.class;
        Class clazz3 = I.class;
        Class clazz4 = int[].class;
        Class clazz5 = int[][].class;
        Class clazz6 = E.class;
        Class clazz7 = Override.class;
        Class clazz8 = void.class;

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
    }
}
```

运行结果：

```
class org.example.C1
class org.example.C1$C2
interface org.example.I
class [I
class [[I
class org.example.E
interface java.lang.Override
void
```



## 类加载

|          | 加载类 |
| :------: | :----: |
| 静态加载 | 编译时 |
| 动态加载 | 运行时 |

