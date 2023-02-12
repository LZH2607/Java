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
		DataFormatException
		TimeoutException
		······



## try、catch、finally

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



## throw

```java
```



```
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

