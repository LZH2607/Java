# 【Java】运算



[toc]



## 赋值运算

=、+=、-=、*=、/=

```java
public class Test {
	public static void main(String[] args) {
		byte b = 1;
		b += 1; // b = (byte) (b + 1);
		System.out.println(b);
	}
}
```

运行结果：

```
2
```



## 取模运算

a % b = a - a / b * b

10 % 3
= 10 - 10 / 3 * 3
= 10 - 9
= 1

-10 % 3
= -10 - (-10) / 3 * 3
= -10 + 9
= -1

10 % -3
= 10 - 10 / (-3) * (-3)
= 10 - 9
= 1

-10 % -3
= -10 - (-10) / (-3) * (-3)
= -10 + 9
= -1

```java
public class Test {
	public static void main(String[] args) {
		System.out.println(10 % 3);
		System.out.println(-10 % 3);
		System.out.println(10 % -3);
		System.out.println(-10 % -3);
	}
}
```

运行结果：

```
1
-1
1
-1
```



## 自增、自减

自增：++
自减：--

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 1;
		int i2 = i1++; // i2 = i1; i1 = i1 + 1;
		int i3 = ++i1; // i1 = i1 + 1; i3 = i1;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}
}
```

运行结果：

```
3
1
3
```



```java
public class Test {
	public static void main(String[] args) {
		int i1 = 1;
		int i2 = i1--; // i2 = i1; i1 = i1 - 1;
		int i3 = --i1; // i1 = i1 - 1; i3 = i1;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}
}
```

运行结果：

```
-1
1
-1
```



```java
public class Test {
	public static void main(String[] args) {
		byte b = 1;
		b++; // b = (byte) (b + 1);
		System.out.println(b);
	}
}
```

运行结果：

```
2
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		int i = 1;
		i = i++;
		System.out.println(i);
		i = ++i;
		System.out.println(i);
	}
}
```

运行结果：

```
1
2
```



## 关系运算

==、!=、<、>、<=、>=、instanceof

```java
public class Test {
	public static void main(String[] args) {
		int i = 1;
		System.out.println(i instanceof Integer);
	}
}
```

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Incompatible conditional operand types int and Integer
```



```java
public class Test {
	public static void main(String[] args) {
		Integer i = 1;
		System.out.println(i instanceof Integer);
	}
}
```

运行结果：

```
true
```



## 逻辑运算

| 逻辑运算 | 运算符 |
| :------: | :----: |
|  逻辑与  |   &    |
|  逻辑或  |   \|   |
|  逻辑非  |   !    |
| 逻辑异或 |   ^    |
|  短路与  |   &&   |
|  短路或  |  \|\|  |

|  a   |  b   | a & b | a && b |
| :--: | :--: | :---: | :----: |
|  0   |  0   |   0   |   0    |
|  0   |  1   |   0   |   0    |
|  1   |  0   |   0   |   0    |
|  1   |  1   |   1   |   1    |

|  a   |  b   | a \| b | a \|\| b |
| :--: | :--: | :----: | :------: |
|  0   |  0   |   0    |    0     |
|  0   |  1   |   1    |    1     |
|  1   |  0   |   1    |    1     |
|  1   |  1   |   1    |    1     |

|  a   |  !a  |
| :--: | :--: |
|  0   |  1   |
|  1   |  0   |

|  a   |  b   | a ^ b |
| :--: | :--: | :---: |
|  0   |  0   |   0   |
|  0   |  1   |   1   |
|  1   |  0   |   1   |
|  1   |  1   |   0   |



```java
public class Test {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1 & b2);
		System.out.println(b1 | b2);
		System.out.println(b1 ^ b2);
		System.out.println(!b1);
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



```java
public class Test {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1 && b2);
		System.out.println(b1 || b2);
	}
}
```

运行结果：

```
false
true
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		if (x++ == 6 & ++y == 6) {
			x = 11;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
```

运行结果：

```
6
6
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		if (x++ == 6 && ++y == 6) {
			x = 11;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
```

运行结果：

```
6
5
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		if (x++ == 5 | ++y == 5) {
			x = 11;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
```

运行结果：

```
11
6
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		if (x++ == 5 || ++y == 5) {
			x = 11;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
```

运行结果：

```
11
5
```



问题：

```java
public class Test {
	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;
		short z = 46;
		if ((z++ == 46) && (y = true)) {
			z++;
		}
		if ((x = false) || (++z == 49)) {
			z++;
		}
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}
```

运行结果：

```
false
true
50
```

相关视频：
[0074\_韩顺平Java\_逻辑运算符练习](https://www.bilibili.com/video/BV1fh411y7R8?p=75)



## 位运算

| 位运算 |  运算符  |
| :----: | :------: |
|   &    |  按位与  |
|   \|   |  按位或  |
|   ^    | 按位异或 |
|   ~    | 按位取反 |
|   <<   |   左移   |
|   >>   | 算术右移 |
|  >>>   | 逻辑右移 |

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 5;
		int i2 = 4;
		System.out.println(i1 & i2);
		System.out.println(i1 | i2);
		System.out.println(i1 ^ i2);
		System.out.println(~i1);
		System.out.println(i1 << 1);
		System.out.println(i1 >> 1);
		System.out.println(i1 >>> 1);
	}
}
```

运行结果：

```
4
5
1
-6
10
2
2
```



## 字符串连接

+

```java
public class Test {
	public static void main(String[] args) {
		String s = "1";
		int i1 = 2;
		int i2 = 3;
		System.out.println(s + i1);
		System.out.println(i1 + s);
		System.out.println(s + i1 + i2);
		System.out.println(i1 + i2 + s);
		System.out.println(i1 + s + i2);
	}
}
```

运行结果：

```
12
21
123
51
213
```



## 三目运算符

```java
public class Test {
	public static void main(String[] args) {
		int i = 1;
		boolean b = i > 0 ? true : false;
		System.out.println(b);
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
		int a = 10;
		int b = 99;
		int c = a > b ? a++ : b--;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
```

运行结果：

```
10
98
99
```
