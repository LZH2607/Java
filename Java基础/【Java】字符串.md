# 【Java】字符串



[toc]



## String

### ==、equals、intern

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);  // false
        System.out.println(s1.equals(s2));  // true
        System.out.println(s1 == s1.intern());  // true
        System.out.println(s2 == s2.intern());  // false
        System.out.println(s1.intern() == s2.intern());  // true
    }
}
```

运行结果：

```
false
true
true
false
true
```



```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);  // false
        System.out.println(s3.equals(s4));  // true
        System.out.println(s3 == s4.intern());  // true
        System.out.println(s4 == s4.intern());  // false
    }
}
```

运行结果：

```
false
true
true
false
```



### length

```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.length());
    }
}
```

运行结果：

```
3
```



### equals、equalsIgnoreCase

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "Abc";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}
```

运算结果：

```
false
true
```



### indexOf、lastIndexOf

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abcabc";
        String s2 = "ab";
        char c = 'b';
        System.out.println(s1.indexOf(s2));
        System.out.println(s1.indexOf(c));
        System.out.println(s1.lastIndexOf(s2));
        System.out.println(s1.lastIndexOf(c));
    }
}
```

运行结果：

```
0
1
3
4
```



### charAt

```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.charAt(0));
    }
}
```

运行结果：

```
a
```



### contains

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        System.out.println(s1.contains(s2));
    }
}
```

运行结果：

```
true
```



### substring

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = s1.substring(2);
        String s3 = s1.substring(2, 4);
        System.out.println(s2);
        System.out.println(s3);
    }
}
```

运行结果：

```
cdef
cd
```



### split

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "/a/b//c/";
        String[] arr1 = s.split("/");
        String[] arr2 = s.split("/+");
        String[] arr3 = s.split("(?<=/)");
        String[] arr4 = s.split("((?<=/)|(?=/))");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
}
```

运行结果：

```
[, a, b, , c]
[, a, b, c]
[/, a/, b/, /, c/]
[/, a, /, b, /, /, c, /]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "+a-b*c/d+";
        String[] arr1 = s.split("\\+|-|\\*|/");
        String[] arr2 = s.split("(?<=\\+|-|\\*|/)");
        String[] arr3 = s.split("((?<=\\+|-|\\*|/)|(?=\\+|-|\\*|/))");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
```

运行结果：

```
[, a, b, c, d]
[+, a-, b*, c/, d+]
[+, a, -, b, *, c, /, d, +]
```



### concat、+

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = s1.concat(s2);
        String s4 = s1 + s2;
        System.out.println(s3);
        System.out.println(s4);
    }
}
```

运行结果：

```
abcdef
abcdef
```



### replace、replaceFirst、replaceAll

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "/a/b//c/";
        String s2 = s1.replace("/", "+");
        String s3 = s1.replaceFirst("/", "+");
        String s4 = s1.replaceAll("/", "+");
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
```

运行结果：

```
+a+b++c+
abc
```



```java
public class Test {
    public static void main(String[] args) {
        String s1 = "ABC/abc/123";
        String s2 = s1.replaceFirst("[A-Za-z0-9]", "+");
        String s3 = s1.replaceAll("[A-Za-z0-9]", "+");
        System.out.println(s2);
        System.out.println(s3);
    }
}
```

运行结果：

```
+BC/abc/123
+++/+++/+++
```



```java
public class Test {
    public static void main(String[] args) {
        String s1 = "ABC/abc/123";
        String s2 = s1.replaceFirst("[^A-Za-z0-9]", "+");
        String s3 = s1.replaceAll("[^A-Za-z0-9]", "+");
        System.out.println(s2);
        System.out.println(s3);
    }
}
```

运行结果：

```
ABC+abc/123
ABC+abc+123
```



### toCharArray

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "abc";
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[a, b, c]
```



### char[] → String

```java
public class Test {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        String s = new String(arr);
        System.out.println(s);
    }
}
```

运行结果：

```
abc
```



### toLowerCase、toUpperCase

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "ABCdef";
        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();
        System.out.println(s2);
        System.out.println(s3);
    }
}
```

运行结果：

```
abcdef
ABCDEF
```



### format

```java
public class Test {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 255;
        float f = 0.1F;
        double d = 3.14;
        char c = 'a';
        boolean bool = true;
        String str1 = "abc";
        String str2 = String.format("%d %3d %03d %x %f %.3f %c %s", b, s, i, l, f, d, c, bool, str1);
        System.out.println(str2);
    }
}
```

运行结果：

```
1   2 003 ff 0.100000 3.140 a true
```



### 问题

相关视频：
[【零基础 快速学Java】韩顺平 零基础30天学会Java P470 0469_韩顺平Java_String对象特性1](https://www.bilibili.com/video/BV1fh411y7R8/?p=470)
[【零基础 快速学Java】韩顺平 零基础30天学会Java P471 0470_韩顺平Java_String对象特性2](https://www.bilibili.com/video/BV1fh411y7R8/?p=471)

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f(c.s, c.arr);
        System.out.println(c.s);
        System.out.println(c.arr);
    }
}

class C {
    String s = new String("abc");
    char[] arr = {'a', 'b', 'c'};

    void f(String s, char[] arr) {
        s = "def";
        arr[0] = 'd';
    }
}
```

运行结果：

```
abc
dbc
```



```java
public class Test {
    public static void main(String[] args) {
        String s = "xyz";
        C c = new C();

        c.f(s);
        c.f(c.s);
        System.out.println(s);
        System.out.println(c.s);
    }
}

class C {
    String s;

    C() {
        s = "abc";
    }

    void f(String s) {
        s = "def";
    }
}
```

运行结果：

```
xyz
abc
```



## StringBuffer

### String→ StringBuffer

#### 方式一

```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        StringBuffer stringBuffer = new StringBuffer(s);
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
abc
```



#### 方式二

```java
public class Test {
    public static void main(String[] args) {
        String s = "abc";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
abc
```



### StringBuffer → String

#### 方式一

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc");
        String s = stringBuffer.toString();
        System.out.println(s);
    }
}
```

运行结果：

```
abc
```



#### 方式二

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc");
        String s = new String(stringBuffer);
        System.out.println(s);
    }
}
```

运行结果：

```
abc
```



### length

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer("abc");
        System.out.println(stringBuffer1.length());
        System.out.println(stringBuffer2.length());
    }
}
```

运行结果：

```
0
3
```



### append

```java
public class Test {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 0.1F;
        double d = 3.14;
        char c = 'a';
        boolean bool = true;
        String str = "abc";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b);
        stringBuffer.append(s);
        stringBuffer.append(i);
        stringBuffer.append(l);
        stringBuffer.append(f);
        stringBuffer.append(d);
        stringBuffer.append(c);
        stringBuffer.append(bool);
        stringBuffer.append(str);
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
12340.13.14atrueabc
```



### delete

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcdef");
        stringBuffer.delete(2, 4);
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
abef
```



### insert

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.insert(1, "def");
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
adefbc
```



### replace

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcdef");
        stringBuffer.replace(1, 5, "ghi");
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
aghif
```



### reverse

```java
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
cba
```



### 问题

```java
public class Test {
    public static void main(String[] args) {
        String s = null;
        StringBuffer stringBuffer = new StringBuffer(s);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
	at java.base/java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:117)
	at java.base/java.lang.StringBuffer.<init>(StringBuffer.java:158)
	at Test.main(Test.java:4)
```



```java
public class Test {
    public static void main(String[] args) {
        String s = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);
    }
}
```

运行结果：

```
4
null
```



## StringBuilder

同StringBuffer



## 对比：String、StringBuffer、StringBuilder

|               | 字符序列 |  线程  |
| :-----------: | :------: | :----: |
|    String     |  不可变  |  安全  |
| StringBuffer  |   可变   |  安全  |
| StringBuilder |   可变   | 不安全 |

效率：String < StringBuffer < StringBuilder

使用：
	String：很少修改、被多个对象引用、配置信息
	StringBuffer：大量修改、多线程
	StringBuilder：大量修改、单线程
