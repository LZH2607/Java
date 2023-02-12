# 【Java】注解



[toc]



## 注解

注解：
	@Override
	@Deprecated
	@SuppressWarnings

注解类：
	@interface

元注解：修饰注解类的注解
	@Retention
	@Target
	@Documented
	@Inherited



## @Override

重写父类的方法

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        c1.f();
        c2.f();
    }
}

class C1 {
    void f() {
        System.out.println("C1.f");
    }
}

class C2 extends C1 {
    @Override
    void f() {
        System.out.println("C2.f");
    }
}
```

运行结果：

```
C1.f
C2.f
```



## @Deprecated

表示某个元素（如：类、属性、方法）已过时（该元素仍可以使用）

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

class C {
    @Deprecated
    void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
```



## @SuppressWarnings

抑制编辑器的警告

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

class C {
    @SuppressWarnings("all")
    void f() {
        List l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        for (Object o : l) {
            System.out.println(o);
        }
    }
}
```

运行结果：

```
abc
def
ghi
```



```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

@SuppressWarnings("all")
class C {
    void f() {
        List l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        for (Object o : l) {
            System.out.println(o);
        }
    }
}
```

运行结果：

```
abc
def
ghi
```

