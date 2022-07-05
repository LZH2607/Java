# 【Java】类



[toc]



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

```java
class Student {
	int id;
	String name;
	int age;

	Student() {

	}

	Student(int id) {
		this.id = id;
	}

	Student(int id, String name) {
		this(id);
		this.name = name;
	}

	Student(int id, String name, int age) {
		this(id, name);
		this.age = age;
	}

	void printInfor() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

public class Test {
	public static void main(String[] args) {
		Student s = new Student(1, "Tom", 18);
		s.printInfor();
	}
}
```



## static关键字

static：静态属性、静态方法、静态代码块、静态导入

静态属性、静态方法：从属于类
成员属性、成员方法：从属于对象

static variable / class variable：静态属性 / 静态变量
staitc method / class method：静态方法 / 静态函数
instance variable：成员属性 / 成员变量
instance method：成员方法 / 成员函数

|          | 静态属性 | 静态方法 | 成员属性 | 成员方法 |
| :------: | :------: | :------: | :------: | :------: |
| 成员方法 |    √     |    √     |    √     |    √     |
| 静态方法 |    √     |    √     |    ×     |    ×     |

（√：可访问、×：不可访问）

```java
public class Test {
	static String ss = "This is a static string.";
	String is;

	Test() {
		this.is = "This is an instance string.";
	}

	public static void sm1() {
		System.out.println("This is static method 1.");
	}

	public static void sm2() {
		System.out.println("This is static method 2.");
		System.out.println(ss);
		System.out.println(Test.ss);
		sm1();
		Test.sm1();
	}

	public void im1() {
		System.out.println("This is instance method 1.");
	}

	public void im2() {
		System.out.println("This is instance method 2.");
		System.out.println(ss);
		System.out.println(Test.ss);
		System.out.println(is);
		System.out.println(this.is);
		sm1();
		Test.sm1();
		im1();
		this.im1();
	}

	public static void main(String[] args) {
		System.out.println(ss);
		System.out.println(Test.ss);
		sm1();
		Test.sm1();

		Test t = new Test();
		System.out.println(t.is);
		t.im2();
	}
}
```

运行结果：

```
This is a static string.
This is a static string.
This is static method 1.
This is static method 1.
This is an instance string.
This is instance method 2.
This is a static string.
This is a static string.
This is an instance string.
This is an instance string.
This is static method 1.
This is static method 1.
This is instance method 1.
This is instance method 1.
```

静态代码块：

```java
public class Test {
	static String s;

	static {
		System.out.println("Running static block...");
		s = "This is a static string.";
	}

	public static void main(String[] args) {
		System.out.println(Test.s);
	}
}
```

运行结果：

```
Running static block...
This is a static string.
```

静态导入：

```java
import static java.lang.Math.PI;

public class Test {
	public static void main(String[] args) {
		System.out.println(PI);
	}
}
```

运行结果：

```
3.141592653589793
```



## 类的传参

```java
public class Test {
	int i;

	Test(int i) {
		this.i = i;
	}

	public void func1(Test t, int i) {
		t.i = i;
	}

	public void func2(Test t, int i) {
		t = new Test(i);
	}

	public static void main(String[] args) {
		Test t = new Test(0);
		t.func1(t, 1);
		System.out.println(t.i);
		t.func2(t, -1);
		System.out.println(t.i);
	}
}
```

运行结果：

```
1
1
```



## 继承

类的三大特性：封装、继承、多态

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2();
		c.i1 = 1;
		c.i2 = 2;
		c.f1();
		c.f2();
	}
}

class C1 {
	int i1;

	public void f1() {
		System.out.println("i1: " + i1);
	}
}

class C2 extends C1 {
	int i2;

	public void f2() {
		System.out.println("i2: " + i2);
	}
}
```

运行结果：

```
i1: 1
i2: 2
```

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2(1, 2);
		c.f1();
		c.f2();
	}
}

class C1 {
	int i1;

	public C1() {

	}

	public C1(int i1) {
		this.i1 = i1;
	}

	public void f1() {
		System.out.println("i1: " + i1);
	}
}

class C2 extends C1 {
	int i2;

	public C2() {

	}

	public C2(int i1, int i2) {
		super(i1);
		this.i2 = i2;
	}

	public void f2() {
		System.out.println("i2: " + i2);
	}
}
```

运行结果：

```
i1: 1
i2: 2
```

