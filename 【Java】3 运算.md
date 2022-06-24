# 【Java】运算



[toc]



## 自增（++）与自减（--）

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



## 逻辑运算

| 逻辑运算 | 运算符 |
| :------: | :----: |
|  逻辑与  |   &    |
|  逻辑或  |   \|   |
|  逻辑非  |   !    |
| 逻辑异或 |   ^    |
|  短路与  |   &&   |
|  短路或  |  \|\|  |

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



## 位运算

| 位运算 |  运算符  |
| :----: | :------: |
|   &    |  按位与  |
|   \|   |  按位或  |
|   ^    | 按位异或 |
|   ~    | 按位取反 |
|   <<   |   左移   |
|   >>   |   右移   |

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 3;
		int i2 = 4;
		System.out.println(i1 & i2);
		System.out.println(i1 | i2);
		System.out.println(i1 ^ i2);
		System.out.println(~i1);
		System.out.println(i1 << 1);
		System.out.println(i1 >> 1);
	}
}
```



## 字符串连接（+）

```java
public class Test {
	public static void main(String[] args) {
		String s = "1";
		int i1 = 2;
		int i2 = 3;
		System.out.println(s + i1 + i2);
		System.out.println(i1 + i2 + s);
	}
}
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





