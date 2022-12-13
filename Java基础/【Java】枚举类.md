# 【Java】枚举类



[toc]



## 自定义

```java
public class Test {
    public static void main(String[] args) {
        C c1 = C.C1;
        C c2 = C.C2;
        C c3 = C.C3;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}

class C {
    private final String S;
    private final int I;
    public static final C C1 = new C("C1", 1);
    public static final C C2 = new C("C2", 2);
    public static final C C3 = new C("C3", 3);

    public String getS() {
        return S;
    }

    public int getI() {
        return I;
    }

    private C(String s, int i) {
        S = s;
        I = i;
    }

    @Override
    public String toString() {
        return "C{" +
                "S='" + S + '\'' +
                ", I=" + I +
                '}';
    }
}
```

运行结果：

```
C{S='C1', I=1}
C{S='C2', I=2}
C{S='C3', I=3}
```



## enum关键字

### 示例

```java
public class Test {
    public static void main(String[] args) {
        E e1 = E.E1;
        E e2 = E.E2;
        E e3 = E.E3;
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}

enum E {
    E1("E1", 1),
    E2("E2", 2),
    E3("E3", 3);

    private final String S;
    private final int I;

    public String getS() {
        return S;
    }

    public int getI() {
        return I;
    }

    E(String s, int i) {
        S = s;
        I = i;
    }

    @Override
    public String toString() {
        return "E{" +
                "S='" + S + '\'' +
                ", I=" + I +
                '}';
    }
}
```

运行结果：

```
E{S='E1', I=1}
E{S='E2', I=2}
E{S='E3', I=3}
```



用enum关键字实现的枚举类：
	默认继承Enum类
	final类

使用javap反编译E.class文件：

```
javap E.class
```

运行结果：

```
final class E extends java.lang.Enum<E> {
  public static final E E1;
  public static final E E2;
  public static final E E3;
  public static E[] values();
  public static E valueOf(java.lang.String);
  public java.lang.String getS();
  public int getI();
  public java.lang.String toString();
  static {};
}
```



### 使用无参构造器

可省略括号

```java
public class Test {
    public static void main(String[] args) {
        E e1 = E.E1;
        E e2 = E.E2;
        E e3 = E.E3;
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}

enum E {
    E1, E2, E3;

    private E() {
    }

    @Override
    public String toString() {
        return "E{}";
    }
}
```

运行结果：

```
E{}
E{}
E{}
```



```java
public class Test {
    public static void main(String[] args) {
        E e1 = E.E1;
        E e2 = E.E2;
        E e3 = E.E3;
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}

enum E {
    E1, E2, E3;
}
```

运行结果：

```
E1
E2
E3
```



### name

```java
public class Test {
    public static void main(String[] args) {
        E e1 = E.E1;
        E e2 = E.E2;
        E e3 = E.E3;
        System.out.println(e1.name());
        System.out.println(e2.name());
        System.out.println(e3.name());
    }
}

enum E {
    E1("E1", 1),
    E2("E2", 2),
    E3("E3", 3);

    private final String S;
    private final int I;

    public String getS() {
        return S;
    }

    public int getI() {
        return I;
    }

    E(String s, int i) {
        S = s;
        I = i;
    }

    @Override
    public String toString() {
        return "E{" +
                "S='" + S + '\'' +
                ", I=" + I +
                '}';
    }
}
```

运行结果：

```
E1
E2
E3
```



### ordinal

```java
public class Test {
    public static void main(String[] args) {
        E e1 = E.E1;
        E e2 = E.E2;
        E e3 = E.E3;
        System.out.println(e1.ordinal());
        System.out.println(e2.ordinal());
        System.out.println(e3.ordinal());
    }
}

enum E {
    E1("E1", 1),
    E2("E2", 2),
    E3("E3", 3);

    private final String S;
    private final int I;

    public String getS() {
        return S;
    }

    public int getI() {
        return I;
    }

    E(String s, int i) {
        S = s;
        I = i;
    }

    @Override
    public String toString() {
        return "E{" +
                "S='" + S + '\'' +
                ", I=" + I +
                '}';
    }
}
```

运行结果：

```
0
1
2
```



### values

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        E[] arr = E.values();
        System.out.println(Arrays.toString(arr));
    }
}

enum E {
    E1("E1", 1),
    E2("E2", 2),
    E3("E3", 3);

    private final String S;
    private final int I;

    public String getS() {
        return S;
    }

    public int getI() {
        return I;
    }

    E(String s, int i) {
        S = s;
        I = i;
    }

    @Override
    public String toString() {
        return "E{" +
                "S='" + S + '\'' +
                ", I=" + I +
                '}';
    }
}
```

运行结果：

```
[E{S='E1', I=1}, E{S='E2', I=2}, E{S='E3', I=3}]
```

