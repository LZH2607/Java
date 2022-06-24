# 【Java】数据类型



[toc]



数据类型
	基本数据类型
		整数型：byte、short、int、long
		浮点型：float、double
		字符型：char
		布尔型：boolean
	引用数据类型
		类：class
		接口：interface
		数组



## 常量

final

```java
public class Test {
	public static void main(String[] args) {
		final double PI = 3.14;
		System.out.println(PI);
	}
}
```



## 整数型

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

Byte：8位 / 1字节
Short：16位 / 2字节
Integer：32位 / 4字节
Long：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		Byte b = 1;
		Short s = 2;
		Integer i = 3;
		Long l = 4L;
		
		System.out.println(b);
		System.out.println(Byte.SIZE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println(s);
		System.out.println(Short.SIZE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		System.out.println(i);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(l);
		System.out.println(Long.SIZE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
```

运行结果：

```
1
8
-128
127
2
16
-32768
32767
3
32
-2147483648
2147483647
4
64
-9223372036854775808
9223372036854775807
```



## 浮点型

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

浮点型的问题

```java
public class Test {
	public static void main(String[] args) {
		float f = 0.1F;
		double d = 1.0 / 10;
		System.out.println(f == d);
	}
}
```

```java
public class Test {
	public static void main(String[] args) {
		float f1 = 100000000F;
		float f2 = f1 + 1;
		System.out.println(f1 == f2);
	}
}
```

Float：32位 / 4字节
Double：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		Float f = 3.14F;
		Double d = 3.14;
		
		System.out.println(f);
		System.out.println(Float.SIZE);
		System.out.println(Float.MIN_EXPONENT);
		System.out.println(Float.MIN_NORMAL);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_EXPONENT);
		System.out.println(Float.MAX_VALUE);
		
		System.out.println(d);
		System.out.println(Double.SIZE);
		System.out.println(Double.MIN_EXPONENT);
		System.out.println(Double.MIN_NORMAL);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_EXPONENT);
		System.out.println(Double.MAX_VALUE);
	}
}
```

运行结果：

```
3.14
32
-126
1.17549435E-38
1.4E-45
127
3.4028235E38
3.14
64
-1022
2.2250738585072014E-308
4.9E-324
1023
1.7976931348623157E308
```



## BigInterger

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



## BigDecimal

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



## 字符型

char：2字节

Unicode：\u0000~\uffff（0~65535）

用单引号表示字符

```java
public class Test {
	public static void main(String[] args) {
		char c1 = 'a';
		char c2 = '中';
		char c3 = '\u0061';
		char c4 = '\u4e2d';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
}
```

| 转义字符 | 含义 | Unicode |
| :------: | :--: | :-----: |
|    \b    | 退格 | \\u0008 |
|    \n    | 换行 | \\u000a |
|    \r    | 回车 | \\u000d |
|    \t    | 制表符 | \\u0009 |
|    \\'    | 单引号 | \\u0027 |
|    \\"    | 双引号 | \\u0022 |
| \\\ | 反斜杠 | \\u005c |



## 布尔型

boolean：1位

```java
public class Test {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1);
		System.out.println(b2);
	}
}
```



## 自动类型转化

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



## 常见误区：类型转化

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



