# 【Java】异常



[toc]



## 异常

异常
	Error：JVM无法解决
	Exception：JVM可以解决
		运行时异常：RuntimeException
		编译时异常：FileNotFoundException、······

Throwable
	Error
		StackOverflowError
		OutOfMemoryError
		······
	Exception
		RuntimeException
			NullPointerException
			ArithmeticException
			ArrayIndexOutOfBoundsException
			ClassCastException
			NumberFormatException
			······
		SQLException
		IOException
		FileNotFoundException
		EOFException
		ClassNotFoundException
		NoSuchFieldException
		NoSuchMethodException
		IllegalArgumentException
		TimeoutException
		······



## try、catch、finally

### try、catch、finally

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 0;
        try {
            System.out.println(i1 / i2);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }
}
```

运行结果：

```
java.lang.ArithmeticException: / by zero
finally
```



### try、catch

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 0;
        try {
            System.out.println(i1 / i2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.ArithmeticException: / by zero
```



### try、finally

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 0;
        try {
            System.out.println(i1 / i2);
        } finally {
            System.out.println("finally");
        }
    }
}
```

运行结果：

```
finally
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Test.main(Test.java:6)
```



### 捕获多个异常

捕获子类异常在前，捕获父类异常在后

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f(null, 1, 2);
        c.f("abc", 1, 0);
    }
}

class C {
    void f(String s, int i1, int i2) {
        try {
            System.out.println(s.length());
            System.out.println(i1 / i2);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
3
java.lang.ArithmeticException: / by zero
```



## throws

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        C c = new C();
        try {
            c.f("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}

class C {
    void f(String s) throws FileNotFoundException {
        FileInputStream f = new FileInputStream(s);
        System.out.println(f);
    }
}
```

运行结果：

```
java.io.FileNotFoundException: test.txt (系统找不到指定的文件。)
```



```java
import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) {
        C c = new C();
        try {
            c.f("test.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class C {
    void f(String s) throws Exception {
        FileInputStream f = new FileInputStream(s);
        System.out.println(f);
    }
}
```

运行结果：

```
java.io.FileNotFoundException: test.txt (系统找不到指定的文件。)
```



重写子类方法抛出的异常：
	与父类方法抛出的异常一致
	为父类方法抛出的异常的子类

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
    void f() throws RuntimeException {
        System.out.println("C1.f");
    }
}

class C2 extends C1 {
    @Override
    void f() throws RuntimeException {
        System.out.println("C2.f");
    }
}
```

运行结果：

```
C1.f
C2.f
```



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
    void f() throws RuntimeException {
        System.out.println("C1.f");
    }
}

class C2 extends C1 {
    @Override
    void f() throws NullPointerException {
        System.out.println("C2.f");
    }
}
```

运行结果：

```
C1.f
C2.f
```



## 运行时异常

RuntimeException：运行时异常
		NullPointerException：空指针异常
		ArithmeticException：算术异常
		ArrayIndexOutOfBoundsException：数组下标越界异常
		ClassCastException：类型转换异常
		NumberFormatException：数字格式异常
		······



### NullPointerException（空指针异常）

```java
public class Test {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length());
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
	at Test.main(Test.java:4)
```



```java
public class Test {
    public static void main(String[] args) {
        String s = null;
        try {
            System.out.println(s.length());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
```



### ArithmeticException（算术异常）

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 0;
        System.out.println(i1 / i2);
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Test.main(Test.java:5)
```



```java
public class Test {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 0;
        try {
            System.out.println(i1 / i2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.ArithmeticException: / by zero
```



### ArrayIndexOutOfBoundsException（数组下标越界异常）

```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2};
        System.out.println(arr[3]);
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Test.main(Test.java:4)
```



```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2};
        try {
            System.out.println(arr[3]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
```



### ClassCastException（类型转换异常）

```java
public class Test {
    public static void main(String[] args) {
        C1 a = new C2();
        C3 b = (C3) a;
    }
}

class C1 {
}

class C2 extends C1 {
}

class C3 extends C1 {
}
```

运行结果：

```
Exception in thread "main" java.lang.ClassCastException: class C2 cannot be cast to class C3 (C2 and C3 are in unnamed module of loader 'app')
	at Test.main(Test.java:4)
```



```java
public class Test {
    public static void main(String[] args) {
        C1 a = new C2();
        try {
            C3 b = (C3) a;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class C1 {
}

class C2 extends C1 {
}

class C3 extends C1 {
}
```

运行结果：

```
java.lang.ClassCastException: class C2 cannot be cast to class C3 (C2 and C3 are in unnamed module of loader 'app')
```



### NumberFormatException（数字格式异常）

```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        int i = Integer.parseInt(s);
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:665)
	at java.base/java.lang.Integer.parseInt(Integer.java:781)
	at Test.main(Test.java:4)
```



```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        try {
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

运行结果：

```
java.lang.NumberFormatException: For input string: "abc"
```



## 自定义异常

### throw

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

class C {
    void f() {
        throw new RuntimeException("C.f");
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.RuntimeException: C.f
	at C.f(Test.java:10)
	at Test.main(Test.java:4)
```



### 自定义异常

自定义异常：
	编译时异常：继承Exception
	运行时异常：继承RuntimeException

```java
public class Test {
    public static void main(String[] args) {
        C c = new C(0);
        c.f();
    }
}

class E extends RuntimeException {
    E(String s) {
        super(s);
    }
}

class C {
    int i;

    C(int i) {
        this.i = i;
    }

    void f() {
        if (i == 0) {
            throw new E("" + i);
        }
    }
}
```

运行结果：

```
Exception in thread "main" E: 0
	at C.f(Test.java:23)
	at Test.main(Test.java:4)
```

