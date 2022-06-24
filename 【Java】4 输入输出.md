# 【Java】输入输出



[toc]



## java.util.Scanner.nextLine()

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



## java.util.Scanner.nextBoolean()

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



## java.util.Scanner.nextByte()

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



## java.util.Scanner.nextShort()

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



## java.util.Scanner.nextInt()

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



## java.util.Scanner.nextLong()

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



## java.util.Scanner.nextFloat()

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



## java.util.Scanner.nextDouble()

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



## System.out.print()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
	}
}
```



## System.out.println()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
```



## System.out.printf()

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d%n", i);
		}
	}
}
```



