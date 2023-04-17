# 【Java】泛型



[toc]



## 泛型类

### 写法一

```java
public class Demo {
    public static void main(String[] args) {
        C1<String> c1 = new C1("Hello, World!");
        C2<Integer, Double> c2 = new C2(1, 3.14);

        System.out.println(c1);
        System.out.println(c2);
    }
}

class C1<T> {
    T t;

    C1(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "C1{" +
                "t=" + t +
                '}';
    }
}

class C2<T, S> {
    T t;
    S s;

    public C2(T t, S s) {
        this.t = t;
        this.s = s;
    }


    @Override
    public String toString() {
        return "C2{" +
                "t=" + t +
                ", s=" + s +
                '}';
    }
}
```

运行结果：

```
C1{t=Hello, World!}
C2{t=1, s=3.14}
```



### 写法二

```java
public class Demo {
    public static void main(String[] args) {
        C1<String> c1 = new C1<>("Hello, World!");
        C2<Integer, Double> c2 = new C2<>(1, 3.14);

        System.out.println(c1);
        System.out.println(c2);
    }
}

class C1<T> {
    T t;

    C1(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "C1{" +
                "t=" + t +
                '}';
    }
}

class C2<T, S> {
    T t;
    S s;

    public C2(T t, S s) {
        this.t = t;
        this.s = s;
    }


    @Override
    public String toString() {
        return "C2{" +
                "t=" + t +
                ", s=" + s +
                '}';
    }
}
```

运行结果：

```
C1{t=Hello, World!}
C2{t=1, s=3.14}
```



## 泛型接口

### 方法一

```java
public class Demo {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();

        c1.f("Hello, World!");
        c2.f(1, 3.14);
    }
}

interface I1<T> {
    void f(T t);
}

interface I2<T, S> {
    void f(T t, S s);
}

class C1 implements I1<String> {
    public void f(String s) {
        System.out.println("C1.f: " + s);
    }
}

class C2 implements I2<Integer, Double> {
    public void f(Integer i, Double d) {
        System.out.println("C2.f: " + i);
        System.out.println("C2.f: " + d);
    }
}
```

运行结果：

```
C1.f: Hello, World!
C2.f: 1
C2.f: 3.14
```



### 方法二

```java
public class Demo {
    public static void main(String[] args) {
        C1<String> c1 = new C1<>();
        C2<Integer, Double> c2 = new C2<>();

        c1.f("Hello, World!");
        c2.f(1, 3.14);
    }
}

interface I1<T> {
    void f(T t);
}

interface I2<T, S> {
    void f(T t, S s);
}

class C1<T> implements I1<T> {
    public void f(T t) {
        System.out.println("C1.f: " + t);
    }
}

class C2<T, S> implements I2<T, S> {
    public void f(T t, S s) {
        System.out.println("C2.f: " + t);
        System.out.println("C2.f: " + s);
    }
}
```

运行结果：

```
C1.f: Hello, World!
C2.f: 1
C2.f: 3.14
```



## 泛型方法

```java
public class Demo {
    public static void main(String[] args) {
        C c = new C();
        c.f1("Hello, World!");
        c.f2(1, 3.14);
    }
}

class C {
    public <T> void f1(T t) {
        System.out.println("f1: " + t);
    }

    public <T, S> void f2(T t, S s) {
        System.out.println("f2: " + t);
        System.out.println("f2: " + s);
    }
}
```

运行结果：

```
f1: Hello, World!
f2: 1
f2: 3.14
```



## 通配

|     泛型      |    类型     |    规定    |
| :-----------: | :---------: | :--------: |
|      <?>      |    任意     |     无     |
| <? extends C> | C类及其子类 | 泛型的上限 |
|  <? super C>  | C类及其父类 | 泛型的下限 |

```java
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<C1> list2 = new ArrayList<>();
        List<C2> list3 = new ArrayList<>();
        List<C3> list4 = new ArrayList<>();

        list1.add(new Object());
        list2.add(new C1());
        list3.add(new C2());
        list4.add(new C3());

        f(list1);
        f(list2);
        f(list3);
        f(list4);
    }

    public static void f(List<?> list) {
        System.out.println(list);
    }
}

class C1 {
}

class C2 extends C1 {
}

class C3 extends C2 {
}
```

运行结果：

```
[java.lang.Object@74a14482]
[C1@1540e19d]
[C2@677327b6]
[C3@14ae5a5]
```



```java
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<C1> list1 = new ArrayList<>();
        List<C2> list2 = new ArrayList<>();
        List<C3> list3 = new ArrayList<>();

        list1.add(new C1());
        list2.add(new C2());
        list3.add(new C3());

        f(list1);
        f(list2);
        f(list3);
    }

    public static void f(List<? extends C1> list) {
        System.out.println(list);
    }
}

class C1 {
}

class C2 extends C1 {
}

class C3 extends C2 {
}
```

运行结果：

```
[C1@74a14482]
[C2@1540e19d]
[C3@677327b6]
```



```java
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<C1> list2 = new ArrayList<>();
        List<C2> list3 = new ArrayList<>();
        List<C3> list4 = new ArrayList<>();

        list1.add(new Object());
        list2.add(new C1());
        list3.add(new C2());
        list4.add(new C3());

        f(list1);
        f(list2);
        f(list3);
        f(list4);
    }

    public static void f(List<? super C3> list) {
        System.out.println(list);
    }
}

class C1 {
}

class C2 extends C1 {
}

class C3 extends C2 {
}
```

运行结果：

```
[java.lang.Object@74a14482]
[C1@1540e19d]
[C2@677327b6]
[C3@14ae5a5]
```

