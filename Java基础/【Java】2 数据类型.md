# 【Java】数据类型



[toc]



## 数据类型

数据类型
	基本数据类型
		数值型：
			整数型：byte、short、int、long
			浮点型：float、double
		字符型：char
		布尔型：boolean
	引用数据类型
		类：class
		接口：interface
		数组：[]

|  数据  | 默认数据类型 |
| :----: | :----------: |
|  整数  |     int      |
| 浮点数 |    double    |



## 基本数据类型

### 整数型

byte：8位 / 1字节
short：16位 / 2字节
int：32位 / 4字节
long：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		int i = 3;
		long l = 4L;
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
	}
}
```

运行结果：

```
1
2
3
4
```



二进制：0b
八进制：0
十进制：无
十六进制：0x

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 0b11111111;
		int i2 = 0377;
		int i3 = 255;
		int i4 = 0xff;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
	}
}
```

运行结果：

```
255
255
255
255
```



### 浮点型

float：32位 / 4字节
double：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		float f = 3.14F;
		double d = 3.14;
		System.out.println(f);
		System.out.println(d);
	}
}
```

运行结果：

```
3.14
3.14
```



```java
public class Test {
	public static void main(String[] args) {
		double d = 1D;
		System.out.println(d);
	}
}
```

运行结果：

```
1.0
```



科学计数法

```java
public class Test {
	public static void main(String[] args) {
		float f = 314e-2F;
		double d = 314e-2;
		System.out.println(f);
		System.out.println(d);
	}
}
```

运行结果：

```
3.14
3.14
```



浮点型的问题

```java
public class Test {
	public static void main(String[] args) {
		float f = 0.1F;
		double d = 1.0 / 10;
		System.out.println(f);
		System.out.println(d);
		System.out.println(f == d);
	}
}
```

运行结果：

```
0.1
0.1
false
```



```java
public class Test {
	public static void main(String[] args) {
		float f1 = 2.7F;
		float f2 = 8.1F / 3;
		double d1 = 2.7;
		double d2 = 8.1 / 3;

		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f1 == f2);

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1 == d2);
	}
}
```

运行结果：

```
2.7
2.7
true
2.7
2.6999999999999997
false
```



```java
public class Test {
	public static void main(String[] args) {
		float f1 = 100000000F;
		float f2 = f1 + 1;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f1 == f2);
	}
}
```

运行结果：

```
1.0E8
1.0E8
true
```



### 字符型

char：16位 / 2字节

Unicode：\u0000~\uffff（0~65535）

用单引号表示字符

```java
public class Test {
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = '中';
		char c3 = 97;
		char c4 = 20013;
		char c5 = '\u0061';
		char c6 = '\u4e2d';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}
}
```

运行结果：

```
a
中
a
中
a
中
```



```java
public class Test {
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = '中';
		System.out.println((int) c1);
		System.out.println((int) c2);
	}
}
```

运行结果：

```
97
20013
```



```java
public class Test {
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = 'a' + 10;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println((int) c1);
		System.out.println((int) c2);
	}
}
```

运行结果：

```
a
k
97
107
```



| 转义字符 |  含义  | Unicode |
| :------: | :----: | :-----: |
|    \b    |  退格  | \\u0008 |
|    \n    |  换行  | \\u000a |
|    \r    |  回车  | \\u000d |
|    \t    | 制表符 | \\u0009 |
|   \\'    | 单引号 | \\u0027 |
|   \\"    | 双引号 | \\u0022 |
|   \\\    | 反斜杠 | \\u005c |
|    \0    | 空字符 | \u0000  |

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("aaa\bbbb");  // \b
        System.out.println("aaa\nbbb");  // \n
        System.out.println("aaa\rbbb");  // \r
        System.out.println("aaa\tbbb");  // \t
        System.out.println("aaa\'bbb");  // \'
        System.out.println("aaa\"bbb");  // \"
        System.out.println("aaa\\bbb");  // \\
        System.out.println("aaa\0bbb");  // \0
    }
}
```

运行结果：

```
aabbb
aaa
bbb
bbb
aaa	bbb
aaa'bbb
aaa"bbb
aaa\bbb
aaa bbb
```



### 布尔型

boolean：

```java
public class Test {
	public static void main(String[] args) {
		boolean b = true;
		System.out.println(b);
	}
}
```

运行结果：

```
true
```



### 自动类型转换

byte → short → int → long → float → double

|     →      | byte | short | int  | long | float | double |
| :--------: | :--: | :---: | :--: | :--: | :---: | :----: |
|  **byte**  |  √   |   √   |  √   |  √   |   √   |   √    |
| **short**  |      |   √   |  √   |  √   |   √   |   √    |
|  **int**   |      |       |  √   |  √   |   √   |   √    |
|  **long**  |      |       |      |  √   |   √   |   √    |
| **float**  |      |       |      |      |   √   |   √    |
| **double** |      |       |      |      |       |   √    |

```java
public class Test {
	public static void main(String[] args) {
		byte b = 1;
		short s = b;
		int i = b;
		long l = b;
		float f = b;
		double d = b;
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
	}
}
```

运行结果：

```
1
1
1
1
1.0
1.0
```



char → int → long → float → double

|     →      | byte | short | **char** | int  | long | float | double |
| :--------: | :--: | :---: | :------: | :--: | :--: | :---: | :----: |
|  **byte**  |  √   |   √   |          |  √   |  √   |   √   |   √    |
| **short**  |      |   √   |          |  √   |  √   |   √   |   √    |
|  **char**  |      |       |    √     |  √   |  √   |   √   |   √    |
|  **int**   |      |       |          |  √   |  √   |   √   |   √    |
|  **long**  |      |       |          |      |  √   |   √   |   √    |
| **float**  |      |       |          |      |      |   √   |   √    |
| **double** |      |       |          |      |      |       |   √    |

```java
public class Test {
    public static void main(String[] args) {
        char c = 97;
        int i = c;
        long l = c;
        float f = c;
        double d = c;
        System.out.println(c);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }
}
```

运行结果：

```
a
97
97
97.0
97.0
```



### 常见误区：类型转换

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 1000000000;
		int i2 = 10;
		int i3 = i1 * i2;
		long l1 = i1 * i2;
		long l2 = (long) i1 * i2;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(l1);
		System.out.println(l2);
	}
}
```

运行结果：

```
1000000000
10
1410065408
1410065408
10000000000
```



byte、short、char在计算时首先转换为int

```java
public class Test {
	public static void main(String[] args) {
		byte b1 = 1;
		byte b2 = 2;
		byte b3 = b1 + b2;

		short s1 = 3;
		short s2 = 4;
		short s3 = s1 + s2;

		char c1 = 5;
		char c2 = 6;
		char c3 = c1 + c2;

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
```

运行结果：

```
Test.java:5: error: incompatible types: possible lossy conversion from int to byte
        byte b3 = b1 + b2;
                     ^
Test.java:9: error: incompatible types: possible lossy conversion from int to short
        short s3 = s1 + s2;
                      ^
Test.java:13: error: incompatible types: possible lossy conversion from int to char
        char c3 = c1 + c2;
                     ^
3 errors
```



### 强制类型转换

```java
public class Test {
	public static void main(String[] args) {
		byte b = (byte) 2000; // 数据溢出
		int i = (int) 1.9; // 精度损失
		System.out.println(b);
		System.out.println(i);
	}
}
```

运行结果：

```
-48
1
```



强制类型转换只对最近的操作数有效：

```java
public class Test {
	public static void main(String[] args) {
		int i = (int) 8 * 1.8 + 6 * 1.6;
		System.out.println(i);
	}
}
```

运行结果：

```
Test.java:3: error: incompatible types: possible lossy conversion from double to int
        int i = (int) 8 * 1.8 + 6 * 1.6;
                              ^
1 error
```

使用括号：

```java
public class Test {
	public static void main(String[] args) {
		int i = (int) (8 * 1.8 + 6 * 1.6);
		System.out.println(i);
	}
}
```

运行结果：

```
24
```



byte、short、char可以接收int常量，不能接收int变量：

```java
public class Test {
	public static void main(String[] args) {
		int i = 100;
		byte b1 = 100;
		byte b2 = i;
		short s1 = 100;
		short s2 = i;
		char c1 = 100;
		char c2 = i;
		System.out.println(i);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(c1);
		System.out.println(c2);
	}
}
```

运行结果：

```
Test.java:5: error: incompatible types: possible lossy conversion from int to byte
        byte b2 = i;
                  ^
Test.java:7: error: incompatible types: possible lossy conversion from int to short
        short s2 = i;
                   ^
Test.java:9: error: incompatible types: possible lossy conversion from int to char
        char c2 = i;
                  ^
3 errors
```

使用强制转换：

```java
public class Test {
	public static void main(String[] args) {
		int i = 100;
		byte b1 = 100;
		byte b2 = (byte) i;
		short s1 = 100;
		short s2 = (short) i;
		char c1 = 100;
		char c2 = (char) i;
		System.out.println(i);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(c1);
		System.out.println(c2);
	}
}
```

运行结果：

```
100
100
100
100
100
d
d
```





### 基本数据类型 → String

#### 方式一

```java
public class Test {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 1.0F;
        double d = 3.14;
        char c = 'a';
        boolean bool = true;

        String str1 = String.valueOf(b);
        String str2 = String.valueOf(s);
        String str3 = String.valueOf(i);
        String str4 = String.valueOf(l);
        String str5 = String.valueOf(f);
        String str6 = String.valueOf(d);
        String str7 = String.valueOf(c);
        String str8 = String.valueOf(bool);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }
}
```

运行结果：

```
1
2
3
4
1.0
3.14
a
true
```



#### 方式二

```java
public class Test {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 1.0F;
        double d = 3.14;
        char c = 'a';
        boolean bool = true;

        String str1 = "" + b;
        String str2 = "" + s;
        String str3 = "" + i;
        String str4 = "" + l;
        String str5 = "" + f;
        String str6 = "" + d;
        String str7 = "" + c;
        String str8 = "" + bool;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }
}
```

运行结果：

```
1
2
3
4
1.0
3.14
a
true
```



### String → 基本数据类型

```java
public class Test {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        String str5 = "0.1";
        String str6 = "3.14";
        String str7 = "a";
        String str8 = "true";

        byte b = Byte.parseByte(str1);
        short s = Short.parseShort(str2);
        int i = Integer.parseInt(str3);
        long l = Long.parseLong(str4);
        float f = Float.parseFloat(str5);
        double d = Double.parseDouble(str6);
        char c = str7.charAt(0);
        boolean bool = Boolean.parseBoolean(str8);

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



## 包装类

| 基本数据类型 |  包装类   |
| :----------: | :-------: |
|     byte     |   Byte    |
|    short     |   Short   |
|     int      |  Integer  |
|     long     |   Long    |
|    float     |   Float   |
|    double    |  Double   |
|     char     | Character |
|   boolean    |  Boolean  |



### 装箱、拆箱

#### 自动装箱

```java
public class Test {
    public static void main(String[] args) {
        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 4L;
        Float f = 0.1F;
        Double d = 3.14;
        Character c = 'a';
        Boolean bool = true;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



#### 手动装箱

##### 方式一

```java
public class Test {
    public static void main(String[] args) {
        Byte b = new Byte((byte) 1);
        Short s = new Short((short) 2);
        Integer i = new Integer(3);
        Long l = new Long(4L);
        Float f = new Float(0.1F);
        Double d = new Double(3.14);
        Character c = new Character('a');
        Boolean bool = new Boolean(true);
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



##### 方式二

```java
public class Test {
    public static void main(String[] args) {
        Byte b = Byte.valueOf((byte) 1);
        Short s = Short.valueOf((short) 2);
        Integer i = Integer.valueOf(3);
        Long l = Long.valueOf(4L);
        Float f = Float.valueOf(0.1F);
        Double d = Double.valueOf(3.14);
        Character c = Character.valueOf('a');
        Boolean bool = Boolean.valueOf(true);
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



#### 自动拆箱

```java
public class Test {
    public static void main(String[] args) {
        Byte b1 = 1;
        byte b2 = b1;

        Short s1 = 2;
        short s2 = s1;

        Integer i1 = 3;
        int i2 = i1;

        Long l1 = 4L;
        long l2 = l1;

        Float f1 = 0.1F;
        float f2 = f1;

        Double d1 = 3.14;
        double d2 = d1;

        Character c1 = 'a';
        char c2 = c1;

        Boolean bool1 = true;
        boolean bool2 = bool1;

        System.out.println(b2);
        System.out.println(s2);
        System.out.println(i2);
        System.out.println(l2);
        System.out.println(f2);
        System.out.println(d2);
        System.out.println(c2);
        System.out.println(bool2);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



#### 手动拆箱

```java
public class Test {
    public static void main(String[] args) {
        Byte b1 = 1;
        byte b2 = b1.byteValue();

        Short s1 = 2;
        short s2 = s1.shortValue();

        Integer i1 = 3;
        int i2 = i1.intValue();

        Long l1 = 4L;
        long l2 = l1.longValue();

        Float f1 = 0.1F;
        float f2 = f1.floatValue();

        Double d1 = 3.14;
        double d2 = d1.doubleValue();

        Character c1 = 'a';
        char c2 = c1.charValue();

        Boolean bool1 = true;
        boolean bool2 = bool1.booleanValue();

        System.out.println(b2);
        System.out.println(s2);
        System.out.println(i2);
        System.out.println(l2);
        System.out.println(f2);
        System.out.println(d2);
        System.out.println(c2);
        System.out.println(bool2);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



### Byte

Byte：8位 / 1字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Byte.TYPE);  // byte
        System.out.println(Byte.SIZE);  // 8
        System.out.println(Byte.MIN_VALUE);  // -128
        System.out.println(Byte.MAX_VALUE);  // 127

        byte b1 = 1;
        byte b2 = 2;
        System.out.println(Byte.compare(b1, b2));  // -1
    }
}
```

运行结果：

```
byte
8
-128
127
-1
```



### Short

Short：16位 / 2字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Short.TYPE);  // short
        System.out.println(Short.SIZE);  // 16
        System.out.println(Short.MIN_VALUE);  // -32768
        System.out.println(Short.MAX_VALUE);  // 32767

        short s1 = 1;
        short s2 = 2;
        System.out.println(Short.compare(s1, s2));  // -1
    }
}
```

运行结果：

```
short
16
-32768
32767
-1
```



### Integer

Integer：32位 / 4字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.TYPE);  // int
        System.out.println(Integer.SIZE);  // 32
        System.out.println(Integer.MIN_VALUE);  // -2147483648
        System.out.println(Integer.MAX_VALUE);  // 2147483647

        int i1 = 1;
        int i2 = 2;
        System.out.println(Integer.compare(i1, i2));  // -1
        System.out.println(Integer.max(i1, i2));  // 2
        System.out.println(Integer.min(i1, i2));  // 1
    }
}
```

运行结果：

```
int
32
-2147483648
2147483647
-1
2
1
```



### Long

Long：64位 / 8字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Long.TYPE);  // long
        System.out.println(Long.SIZE);  // 64
        System.out.println(Long.MIN_VALUE);  // -9223372036854775808
        System.out.println(Long.MAX_VALUE);  // 9223372036854775807

        long l1 = 1L;
        long l2 = 2L;
        System.out.println(Long.compare(l1, l2));  // -1
        System.out.println(Long.max(l1, l2));  // 2
        System.out.println(Long.min(l1, l2));  // 1
    }
}
```

运行结果：

```
long
64
-9223372036854775808
9223372036854775807
-1
2
1
```



### Float

Float：32位 / 4字节


```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Float.TYPE);  // float
        System.out.println(Float.SIZE);  // 32
        System.out.println(Float.MIN_EXPONENT);  // -126
        System.out.println(Float.MIN_NORMAL);  // 1.1754944E-38
        System.out.println(Float.MIN_VALUE);  // 1.4E-45
        System.out.println(Float.MAX_EXPONENT);  // 127
        System.out.println(Float.MAX_VALUE);  // 3.4028235E38
        System.out.println(Float.NEGATIVE_INFINITY);  // -Infinity
        System.out.println(Float.POSITIVE_INFINITY);  // Infinity
        System.out.println(Float.NaN);  // NaN

        Float f1 = 3.14F;
        Float f2 = 2.72F;
        System.out.println(Float.isFinite(f1));  // true
        System.out.println(Float.isInfinite(f1));  // false
        System.out.println(Float.isNaN(f1));  // false
        System.out.println(Float.compare(f1, f2));  // 1
        System.out.println(Float.max(f1, f2));  // 3.14
        System.out.println(Float.min(f1, f2));  // 2.72
    }
}
```

运行结果：

```
float
32
-126
1.1754944E-38
1.4E-45
127
3.4028235E38
-Infinity
Infinity
NaN
true
false
false
1
3.14
2.72
```



### Double

Double：64位 / 8字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Double.TYPE);  // double
        System.out.println(Double.SIZE);  // 64
        System.out.println(Double.MIN_EXPONENT);  // -1022
        System.out.println(Double.MIN_NORMAL);  // 2.2250738585072014E-308
        System.out.println(Double.MIN_VALUE);  // 4.9E-324
        System.out.println(Double.MAX_EXPONENT);  // 1023
        System.out.println(Double.MAX_VALUE);  // 1.7976931348623157E308
        System.out.println(Double.NEGATIVE_INFINITY);  // -Infinity
        System.out.println(Double.POSITIVE_INFINITY);  // Infinity
        System.out.println(Double.NaN);  // NaN

        Double d1 = 3.14;
        Double d2 = 2.72;
        System.out.println(Double.isFinite(d1));  // true
        System.out.println(Double.isInfinite(d1));  // false
        System.out.println(Double.isNaN(d1));  // false
        System.out.println(Double.compare(d1, d2));  // 1
        System.out.println(Double.max(d1, d2));  // 3.14
        System.out.println(Double.min(d1, d2));  // 2.72
    }
}
```

运行结果：

```
double
64
-1022
2.2250738585072014E-308
4.9E-324
1023
1.7976931348623157E308
-Infinity
Infinity
NaN
true
false
false
1
3.14
2.72
```



### Character

Character：16位 / 2字节

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Character.TYPE);  // char
        System.out.println(Character.SIZE);  // 16
        System.out.println((int) Character.MIN_VALUE);  // 0
        System.out.println((int) Character.MAX_VALUE);  // 65535

        Character c1 = 'a';
        Character c2 = 'b';
        System.out.println(Character.isWhitespace(c1));  // false
        System.out.println(Character.isDigit(c1));  // false
        System.out.println(Character.isLetter(c1));  // true
        System.out.println(Character.isLetterOrDigit(c1));  // true
        System.out.println(Character.isLowerCase(c1));  // true
        System.out.println(Character.isUpperCase(c1));  // false
        System.out.println(Character.toLowerCase(c1));  // a
        System.out.println(Character.toUpperCase(c1));  // A
        System.out.println(Character.compare(c1, c2));  // -1
    }
}
```

运行结果：

```
char
16
0
65535
false
false
true
true
true
false
a
A
-1
```



### Boolean

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Boolean.TYPE);  // boolean
        System.out.println(Boolean.TRUE);  // true
        System.out.println(Boolean.FALSE);  // false
    }
}
```

运行结果：

```
boolean
true
false
```



### 包装类 → String

#### 方法一

```java
public class Test {
    public static void main(String[] args) {
        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 4L;
        Float f = 0.1F;
        Double d = 3.14;
        Character c = 'a';
        Boolean bool = true;

        String str1 = b.toString();
        String str2 = s.toString();
        String str3 = i.toString();
        String str4 = l.toString();
        String str5 = f.toString();
        String str6 = d.toString();
        String str7 = c.toString();
        String str8 = bool.toString();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



#### 方法二

```java
public class Test {
    public static void main(String[] args) {
        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 4L;
        Float f = 0.1F;
        Double d = 3.14;
        Character c = 'a';
        Boolean bool = true;

        String str1 = String.valueOf(b);
        String str2 = String.valueOf(s);
        String str3 = String.valueOf(i);
        String str4 = String.valueOf(l);
        String str5 = String.valueOf(f);
        String str6 = String.valueOf(d);
        String str7 = String.valueOf(c);
        String str8 = String.valueOf(bool);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



#### 方法三

```java
public class Test {
    public static void main(String[] args) {
        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 4L;
        Float f = 0.1F;
        Double d = 3.14;
        Character c = 'a';
        Boolean bool = true;

        String str1 = "" + b;
        String str2 = "" + s;
        String str3 = "" + i;
        String str4 = "" + l;
        String str5 = "" + f;
        String str6 = "" + d;
        String str7 = "" + c;
        String str8 = "" + bool;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
```



### String → 包装类

#### 方法一

```java
public class Test {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        String str5 = "0.1";
        String str6 = "3.14";
        String str7 = "true";
        
        Byte b = Byte.valueOf(str1);
        Short s = Short.valueOf(str2);
        Integer i = Integer.valueOf(str3);
        Long l = Long.valueOf(str4);
        Float f = Float.valueOf(str5);
        Double d = Double.valueOf(str6);
        Boolean bool = Boolean.valueOf(str7);
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
true
```



#### 方法二

```java
public class Test {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        String str5 = "0.1";
        String str6 = "3.14";
        String str7 = "true";
        
        Byte b = new Byte(str1);
        Short s = new Short(str2);
        Integer i = new Integer(str3);
        Long l = new Long(str4);
        Float f = new Float(str5);
        Double d = new Double(str6);
        Boolean bool = new Boolean(str7);
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
true
```



### 问题

```java
public class Test {
    public static void main(String[] args) {
        Object o1 = true ? new Integer(0) : new Double(1.0);
        Object o2;
        if (true) {
            o2 = new Integer("0");
        } else {
            o2 = new Double(1.0);
        }
        System.out.println(o1);
        System.out.println(o2);
    }
}
```

运行结果：

```
0.0
0
```



```java
public class Test {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);

        Integer i3 = 1;
        Integer i4 = 1;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
    }
}
```

运行结果：

```
false
true
false
```



```java
public class Test {
    public static void main(String[] args) {
        Integer i1 = 128;
        int i2 = 128;
        System.out.println(i1 == i2);
    }
}
```

运行结果：

```
true
```



```java
public class Test {
    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
    }
}
```

运行结果：

```
false
```



## BigInterger、BigDecimal

### BigInterger

可进行任意精度的整数运算

```java
import java.math.*;

public class Test {
	public static void main(String[] args) {
		BigInteger bi1 = BigInteger.valueOf(100000000);
		BigInteger bi2 = bi1.add(BigInteger.valueOf(1));
		System.out.println(bi1);
		System.out.println(bi2);
		System.out.println(bi1.compareTo(bi2));
	}
}
```

运行结果：

```
100000000
100000001
-1
```



### BigDecimal

可进行任意精度的浮点运算

```java
import java.math.*;

public class Test {
	public static void main(String[] args) {
		BigDecimal bd1 = BigDecimal.valueOf(0.1);
		BigDecimal bd2 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(10));
		System.out.println(bd1);
		System.out.println(bd2);
		System.out.println(bd1.compareTo(bd2));
	}
}
```

运行结果：

```
0.1
0.1
0
```

