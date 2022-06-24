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



## 类的定义和构造

```java
class Student {
	int id;
	String name;
	int age;

	void printInfor() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

public class Test {
	public static void main(String[] args) {
		Student s = new Student();
		s.id = 1;
		s.name = "Tom";
		s.age = 18;
		s.printInfor();
	}
}
```



