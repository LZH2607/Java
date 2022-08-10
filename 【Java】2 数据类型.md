# 【Java】数据类型



[toc]



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
		数组：[ ]



|        | 默认数据类型 |
| :----: | :----------: |
|  整数  |     int      |
| 浮点数 |    double    |



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

### byte、short、int、long

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



### Byte

Byte：8位 / 1字节

```java
public class Test {
	public static void main(String[] args) {
		Byte b1 = 1;
		Byte b2 = 2;
		String s = "-1";

		System.out.println(b1);
		System.out.println(Byte.SIZE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.compare(b1, b2));
		System.out.println(Byte.valueOf(s));
		System.out.println(Byte.parseByte(s));
	}
}
```

运行结果：

```
1
8
-128
127
-1
-1
-1
```



### Short

Short：16位 / 2字节

```java
public class Test {
	public static void main(String[] args) {
		Short s1 = 1;
		Short s2 = 2;
		String ss = "-1";
		
		System.out.println(s1);
		System.out.println(Short.SIZE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.compare(s1, s2));
		System.out.println(Short.valueOf(ss));
		System.out.println(Short.parseShort(ss));
	}
}
```

运行结果：

```
1
16
-32768
32767
-1
-1
-1
```



### Integer

Integer：32位 / 4字节

```java
public class Test {
	public static void main(String[] args) {
		Integer i1 = 1;
		Integer i2 = 2;
		String s = "-1";

		System.out.println(i1);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.compare(i1, i2));
		System.out.println(Integer.max(i1, i2));
		System.out.println(Integer.min(i1, i2));
		System.out.println(Integer.valueOf(s));
		System.out.println(Integer.parseInt(s));
	}
}
```

运行结果：

```
1
32
-2147483648
2147483647
-1
2
1
-1
-1
```



### Long

Long：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		Long l1 = 1L;
		Long l2 = 2L;
		String s = "-1";
		
		System.out.println(l1);
		System.out.println(Long.SIZE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.compare(l1, l2));
		System.out.println(Long.max(l1, l2));
		System.out.println(Long.min(l1, l2));
		System.out.println(Long.valueOf(s));
		System.out.println(Long.parseLong(s));
	}
}
```

运行结果：

```
1
64
-9223372036854775808
9223372036854775807
-1
2
1
-1
-1
```



## 浮点型

### float、double

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



### Float

Float：32位 / 4字节


```java
public class Test {
	public static void main(String[] args) {
		Float f1 = 3.14F;
		Float f2 = 2.72F;
		String s = "-0.1";
		
		System.out.println(f1);
		System.out.println(Float.SIZE);
		System.out.println(Float.MIN_EXPONENT);
		System.out.println(Float.MIN_NORMAL);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_EXPONENT);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.NEGATIVE_INFINITY);
		System.out.println(Float.POSITIVE_INFINITY);
		System.out.println(Float.NaN);
		System.out.println(Float.isFinite(f1));
		System.out.println(Float.isInfinite(f1));
		System.out.println(Float.isNaN(f1));
		System.out.println(Float.compare(f1, f2));
		System.out.println(Float.max(f1, f2));
		System.out.println(Float.min(f1, f2));
		System.out.println(Float.valueOf(s));
		System.out.println(Float.parseFloat(s));
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
-Infinity
Infinity
NaN
true
false
false
1
3.14
2.72
-0.1
-0.1
```



### Double

Double：64位 / 8字节

```java
public class Test {
	public static void main(String[] args) {
		Double d1 = 3.14;
		Double d2 = 2.72;
		String s = "-0.1";
		
		System.out.println(d1);
		System.out.println(Double.SIZE);
		System.out.println(Double.MIN_EXPONENT);
		System.out.println(Double.MIN_NORMAL);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_EXPONENT);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(Double.NaN);
		System.out.println(Double.isFinite(d1));
		System.out.println(Double.isInfinite(d1));
		System.out.println(Double.isNaN(d1));
		System.out.println(Double.compare(d1, d2));
		System.out.println(Double.max(d1, d2));
		System.out.println(Double.min(d1, d2));
		System.out.println(Double.valueOf(s));
		System.out.println(Double.parseDouble(s));
	}
}
```

运行结果：

```
3.14
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
-0.1
-0.1
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



## 字符型 char

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

### boolean

boolean：4个字节 / 1个字节

相关文章：[答疑 | boolean类型占几个字节？](https://zhuanlan.zhihu.com/p/138648453)

```java
public class Test {
	public static void main(String[] args) {
		boolean b = true;
		System.out.println(b);
	}
}
```



### Boolean

```java
public class Test {
	public static void main(String[] args) {
		Boolean b = true;
		String s = "true";

		System.out.println(b);
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		System.out.println(Boolean.TYPE);
		System.out.println(Boolean.parseBoolean(s));
	}
}
```

运行结果：

```
true
true
false
boolean
true
```



## 自动类型转换

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

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from short to byte

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from int to byte
	Type mismatch: cannot convert from int to short

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from long to byte
	Type mismatch: cannot convert from long to short
	Type mismatch: cannot convert from long to int

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from float to byte
	Type mismatch: cannot convert from float to short
	Type mismatch: cannot convert from float to int
	Type mismatch: cannot convert from float to long

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from double to byte
	Type mismatch: cannot convert from double to short
	Type mismatch: cannot convert from double to int
	Type mismatch: cannot convert from double to long
	Type mismatch: cannot convert from double to float
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
		byte b = 1;
		short s = b;
		char c = b;
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

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from byte to char

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from short to byte
	Type mismatch: cannot convert from short to char

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from char to byte
	Type mismatch: cannot convert from char to short

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from int to byte
	Type mismatch: cannot convert from int to short
	Type mismatch: cannot convert from int to char

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from long to byte
	Type mismatch: cannot convert from long to short
	Type mismatch: cannot convert from long to char
	Type mismatch: cannot convert from long to int

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from float to byte
	Type mismatch: cannot convert from float to short
	Type mismatch: cannot convert from float to char
	Type mismatch: cannot convert from float to int
	Type mismatch: cannot convert from float to long

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from double to byte
	Type mismatch: cannot convert from double to short
	Type mismatch: cannot convert from double to char
	Type mismatch: cannot convert from double to int
	Type mismatch: cannot convert from double to long
	Type mismatch: cannot convert from double to float
```



## 常见误区：类型转换

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

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from int to byte
	Type mismatch: cannot convert from int to short
	Type mismatch: cannot convert from int to char
```



## 强制类型转换

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

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Type mismatch: cannot convert from double to int
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

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Type mismatch: cannot convert from int to byte
	Type mismatch: cannot convert from int to short
	Type mismatch: cannot convert from int to char
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



## 字符串 String

```java
public class Test {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "ab";
		char c = 'a';
		
		System.out.println(s1.length());
		System.out.println(s1.charAt(0));
		System.out.println(s1 + s2);
		System.out.println(s1.concat(s2));
		System.out.println(String.format("%s %s", s1, s2));
		System.out.println(s1.contains(s2));
		System.out.println(s1.indexOf(s2));
		System.out.println(s1.indexOf(c));
		System.out.println(s1.lastIndexOf(s2));
		System.out.println(s1.lastIndexOf(c));
	}
}
```

运行结果：

```
3
a
abcab
abcab
abc ab
true
0
0
0
0
```



基本数据类型 → String

```java
public class Test {
	public static void main(String[] args) {
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1;
		float f = 1.0F;
		double d = 1.0;
		char c = 'a';
		boolean bool = true;

		String s1 = b + "";
		String s2 = s + "";
		String s3 = i + "";
		String s4 = l + "";
		String s5 = f + "";
		String s6 = d + "";
		String s7 = c + "";
		String s8 = bool + "";

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
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
a
true
```



String → 基本数据类型

```java
public class Test {
	public static void main(String[] args) {
		String str = "1";

		byte b = Byte.parseByte(str);
		short s = Short.parseShort(str);
		int i = Integer.parseInt(str);
		long l = Long.parseLong(str);
		float f = Float.parseFloat(str);
		double d = Double.parseDouble(str);
		boolean bool = Boolean.parseBoolean(str);

		System.out.println(str);
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
1
1
1
1
1.0
1.0
false
```

