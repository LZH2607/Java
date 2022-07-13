# 【Java】特色



[toc]



## 带标签的break和continue

```java
public class Test {
	public static void main(String[] args) {
		// 打印2~100之间的质数
		c: for (int i = 2; i <= 100; i++) {
			for (int j = 2; j < i / 2; j++) {
				if (i % j == 0) {
					continue c;
				}
			}
			System.out.println(i);
		}

	}
}
```



## 方法的调用

```java
public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.printTest();
	}

	void printTest() {
		System.out.println("This is a test.");
	}
}
```

```java
public class Test {
	public static void main(String[] args) {
		printTest();
	}

	static void printTest() {
		System.out.println("This is a test.");
	}
}
```

```java
public class Test {
	public static void main(String[] args) {
		printTest();
	}

	public static void printTest() {
		System.out.println("This is a test.");
	}
}
```



## 方法的重载

```java
public class Test {
	public static void main(String[] args) {
		System.out.println(add(1, 2));
		System.out.println(add(1, 2, 3));
	}

	static int add(int a, int b) {
		return a + b;
	}

	static int add(int a, int b, int c) {
		return a + b + c;
	}
}
```

```java
public class Test {
	public static void main(String[] args) {
		System.out.println(add(1, 2));
		System.out.println(add(1.0, 2.0));
	}

	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	}
}
```



## final

final：
	修饰变量：常量
	修饰方法：不可被子类重写，但可以被重载
	修饰类：不可被继承



### final修饰变量

```java
public class Test {
	public static void main(String[] args) {
		final double PI = 3.14;
		System.out.println(PI);
	}
}
```



### final修饰方法

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.f(1);
		c.f(1, 2);
	}
}

class C {
	final public void f(int i) {
		System.out.println("i: " + i);
	}
	
	final public void f(int i1, int i2) {
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
	}
}
```

运行结果：

```
i: 1
i1: 1
i2: 2
```



### final修饰类

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c);
	}
}

final class C {
	public String toString() {
		return "C";
	}
}
```

运行结果：

```
C
```

