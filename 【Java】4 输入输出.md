# 【Java】输入输出



[toc]



## 输入

### 用Scanner接收字符串：java.util.Scanner.next()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(s);
	}
}
```



### 用Scanner接收字符串：java.util.Scanner.nextLine()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println(s);
	}
}
```



### 用Scanner接收boolean类型：java.util.Scanner.nextBoolean()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean b = scanner.nextBoolean();
		System.out.println(b);
	}
}
```



### 用Scanner接收byte类型：java.util.Scanner.nextByte()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte b = scanner.nextByte();
		System.out.println(b);
	}
}
```



### 用Scanner接收short类型：java.util.Scanner.nextShort()

```c++
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		short s = scanner.nextShort();
		System.out.println(s);
	}
}
```



### 用Scanner接收int类型：java.util.Scanner.nextInt()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		System.out.println(i);
	}
}
```



### 用Scanner接收long类型：java.util.Scanner.nextLong()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long l = scanner.nextLong();
		System.out.println(l);
	}
}
```



### 用Scanner接收float类型：java.util.Scanner.nextFloat()

```c++
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float f = scanner.nextFloat();
		System.out.println(f);
	}
}
```



### 用Scanner接收double类型：java.util.Scanner.nextDouble()

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double d = scanner.nextDouble();
		System.out.println(d);
	}
}
```



### 用Scanner接收char类型：java.util.Scanner.next().charAt(0)

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char c = scanner.next().charAt(0);
		System.out.println(c);
	}
}
```



## 输出

### System.out.print()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
	}
}
```



### System.out.println()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
```



### System.out.printf()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d%n", i);
		}
	}
}
```



## 综合样例

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = scanner.next();
		System.out.println("请输入年龄：");
		int age = scanner.nextInt();
		System.out.println("您的姓名：" + name);
		System.out.println("您的年龄：" + age);
	}
}
```

