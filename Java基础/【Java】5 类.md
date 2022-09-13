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

```java
class Student {
	int id;
	String name;
	int age;

	Student() {

	}

	Student(int id) {
		this(id, "Unknown", 18);
	}

	Student(int id, String name) {
		this(id, name, 18);
	}

	Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
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
		Student s1 = new Student(1);
		Student s2 = new Student(2, "Tom");
		Student s3 = new Student(3, "Jack", 19);
		s1.printInfor();
		s2.printInfor();
		s3.printInfor();
	}
}
```



## 默认赋值

| 数据类型 | 默认赋值 |
| :------: | :------: |
|   byte   |    0     |
|  short   |    0     |
|   int    |    0     |
|   long   |    0     |
|  float   |   0.0    |
|  double  |   0.0    |
|   char   |  \u0000  |
| boolean  |  false   |
|  String  |   null   |

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.b);
		System.out.println(c.s);
		System.out.println(c.i);
		System.out.println(c.l);
		System.out.println(c.f);
		System.out.println(c.d);
		System.out.println(c.c);
		System.out.println(c.bool);
		System.out.println(c.str);
	}
}

class C {
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	char c;
	boolean bool;
	String str;
}
```

运行结果：

```
0
0
0
0
0.0
0.0

false
null
```



## 方法

### 自动类型转换

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		byte b1 = 1;
		byte b2 = 2;
		short s1 = 1;
		short s2 = 2;
		int i1 = 1;
		int i2 = 2;
		int sum1 = c.add(b1, b2);
		int sum2 = c.add(s1, s2);
		int sum3 = c.add(i1, i2);
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
	}
}

class C {
	public int add(int i1, int i2) {
		int sum = i1 + i2;
		return sum;
	}
}
```

运行结果：

```
3
3
3
```



### 克隆对象

#### 方法一

```java
public class Test {
	public static void main(String[] args) {
		C c1 = new C(1);
		C c2 = c1.copy();
		c2.i = 2;
		System.out.println(c1.i);
		System.out.println(c2.i);
	}
}

class C {
	int i;

	C() {

	}

	C(int i) {
		this.i = i;
	}

	public C copy() {
		C c = new C();
		c.i = this.i;
		return c;
	}
}
```

运行结果：

```
1
2
```



#### 方法二

```java
public class Test {
	public static void main(String[] args) {
		C c1 = new C(1);
		C c2 = new C(c1);
		c2.i = 2;
		System.out.println(c1.i);
		System.out.println(c2.i);
	}
}

class C {
	int i;

	C(int i) {
		this.i = i;
	}

	C(C c) {
		this.i = c.i;
	}
}
```

运行结果：

```
1
2
```



### 递归

#### 示例

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.f(10);
	}
}

class C {
	public void f(int n) {
		System.out.println(n);
		if (n > 1) {
			f(n - 1);
		}
	}
}
```

运行结果：

```
10
9
8
7
6
5
4
3
2
1
```



#### 阶乘

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.factorial(5));
	}
}

class C {
	public int factorial(int n) {
		if (n > 1) {
			return n * factorial(n - 1);
		} else {
			return 1;
		}
	}
}
```

运行结果：

```
120
```



#### 斐波那契数列

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.fibonacci(10));
	}
}

class C {
	public int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}
}
```

运行结果：

```
55
```



## static关键字

static：
	静态属性、静态方法
	静态代码块
	静态导入



### 静态属性、静态方法

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



### 静态代码块

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



### 静态导入

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

默认父类：java.lang.Object

查看类的继承结构：Ctrl + T

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



## super

访问父类的属性
访问父类的方法
访问父类的构造方法

### 1. 访问父类的属性

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2();
		c.f();
	}
}

class C1 {
	int i = 1;

	public void f() {
		System.out.println("i: " + i);
	}
}

class C2 extends C1 {
	int i = 2;

	public void f() {
		System.out.println("i: " + super.i);
		System.out.println("i: " + i);
	}
}
```

运行结果：

```
i: 1
i: 2
```



### 2. 访问父类的方法

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2();
		c.f();
	}
}

class C1 {
	int i = 1;

	public void f() {
		System.out.println("i: " + i);
	}
}

class C2 extends C1 {
	int i = 2;

	public void f() {
		super.f();
		System.out.println("i: " + i);
	}
}
```

运行结果：

```
i: 1
i: 2
```



### 3. 访问父类的构造方法

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

	public C1(int i1) {
		this.i1 = i1;
	}

	public void f1() {
		System.out.println("i1: " + i1);
	}
}

class C2 extends C1 {
	int i2;

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



所有的构造方法默认调用super（父类的构造方法）

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2();
	}
}

class C1 {
	public C1() {
		System.out.println("C1");
	}
}

class C2 extends C1 {
	public C2() {
		System.out.println("C2");
	}
}
```

运行结果：

```
C1
C2
```



## instanceof

```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1();
		C2 c2 = new C2();

		System.out.println(c1 instanceof Object);
		System.out.println(c1 instanceof C1);
		System.out.println(c1 instanceof C2);

		System.out.println(c2 instanceof Object);
		System.out.println(c2 instanceof C1);
		System.out.println(c2 instanceof C2);
	}
}

class C1 {

}

class C2 extends C1 {

}
```

运行结果：

```
true
true
false
true
true
true
```



## toString

```java
public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t);
		System.out.println(t.toString());
	}
}
```

运行结果：

```
Test@515f550a
Test@515f550a
```



```java
public class Test {
	public static void main(String[] args) {
		C c = new C(1);
		System.out.println(c);
		System.out.println(c.toString());
	}

}

class C {
	int i;

	public C(int i) {
		this.i = i;
	}

	public String toString() {
		return "i: " + i;
	}
}
```

运行结果：

```
i: 1
i: 1
```



## 重写

重写：子类对父类的方法重新编写

```java
public class Test {
	public static void main(String[] args) {
		C2 c = new C2();
		c.i1 = 1;
		c.i2 = 2;
		c.f();
	}
}

class C1 {
	int i1;

	public void f() {
		System.out.println("i1: " + i1);
	}
}

class C2 extends C1 {
	int i2;

	public void f() {
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
	}
}
```

运行结果：

```
i1: 1
i2: 2
```



## ==、equals

### ==

基本数据类型：比较值
引用数据类型：比较地址

```java
public class Test {
	public static void main(String[] args) {
		int i1 = 1;
		int i2 = 1;
		C c1 = new C(1);
		C c2 = new C(1);
		System.out.println(i1 == i2);
		System.out.println(c1 == c2);
	}
}

class C {
	int i;

	public C(int i) {
		this.i = i;
	}
}
```

运行结果：

```
true
false
```



```java
public class Test {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
	}
}
```

运行结果：

```
true
false
```



### equals

如果不重写equals，则equals与==等价

```java
public class Test {
	public static void main(String[] args) {
		C c1 = new C(1);
		C c2 = new C(1);
		System.out.println(c1.equals(c2));
	}
}

class C {
	int i;

	public C(int i) {
		this.i = i;
	}
}
```

运行结果：

```
false
```



```java
public class Test {
	public static void main(String[] args) {
		C c1 = new C(1);
		C c2 = new C(1);
		System.out.println(c1.equals(c2));
	}
}

class C {
	int i;

	public C(int i) {
		this.i = i;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		C o = (C) obj;
		return i == o.i;
	}
}
```

运行结果：

```
true
```



## 封装、访问修饰符

封装：高内聚、低耦合

访问修饰符：private、default、protected、public

|                | private | default | protected | public |
| :------------: | :-----: | :-----: | :-------: | :----: |
|    同一个类    |    √    |    √    |     √     |   √    |
|      子类      |         |    √    |     √     |   √    |
| 同一个文件的类 |         |    √    |     √     |   √    |
|  同一个包的类  |         |    √    |     √     |   √    |
|  不同包的子类  |         |         |     √     |   √    |
|   不同包的类   |         |         |           |   √    |

√：可以访问

```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1(1, 2, 3, 4);
		C2 c2 = new C2(1, 2, 3, 4);
		A a = new A();
		c1.func();
		c2.func();
		a.func();
	}
}

class C1 {
	private int i1;
	int i2;
	protected int i3;
	public int i4;

	private void f1() {
		System.out.println("f1");
	}

	void f2() {
		System.out.println("f2");
	}

	protected void f3() {
		System.out.println("f3");
	}

	public void f4() {
		System.out.println("f4");
	}

	public C1(int i1, int i2, int i3, int i4) {
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}

	public void func() {
		// 同一个类可以访问private、default、protected、public
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		System.out.println("i4: " + i4);
		f1();
		f2();
		f3();
		f4();
	}
}

class C2 extends C1 {
	public C2(int i1, int i2, int i3, int i4) {
		super(i1, i2, i3, i4);
	}

	public void func() {
		// 子类可以访问父类的default、protected、public
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		System.out.println("i4: " + i4);
		f2();
		f3();
		f4();
	}
}

class A {
	public void func() {
		// 同一个文件的类可以访问default、protected、public
		C1 c = new C1(1, 2, 3, 4);
		System.out.println("i2: " + c.i2);
		System.out.println("i3: " + c.i3);
		System.out.println("i4: " + c.i4);
		c.f2();
		c.f3();
		c.f4();
	}
}
```

运行结果：

```
i1: 1
i2: 2
i3: 3
i4: 4
f1
f2
f3
f4
i2: 2
i3: 3
i4: 4
f2
f3
f4
i2: 2
i3: 3
i4: 4
f2
f3
f4
```



(default package) Test.java：

```java
public class Test {
	public static void main(String[] args) {
		A a = new A();
		a.func();
	}
}

class A {
	public void func() {
		// 同一个包的类可以访问default、protected、public
		C c = new C(1, 2, 3, 4);
		System.out.println("i2: " + c.i2);
		System.out.println("i3: " + c.i3);
		System.out.println("i4: " + c.i4);
		c.f2();
		c.f3();
		c.f4();
	}
}
```

(default package) C.java：

```java
class C {
	private int i1;
	int i2;
	protected int i3;
	public int i4;

	private void f1() {
		System.out.println("f1");
	}

	void f2() {
		System.out.println("f2");
	}

	protected void f3() {
		System.out.println("f3");
	}

	public void f4() {
		System.out.println("f4");
	}

	public C(int i1, int i2, int i3, int i4) {
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}
}
```

运行结果：

```
i2: 2
i3: 3
i4: 4
f2
f3
f4
```



(default package) Test.java：

```java
import p.C;

public class Test {
	public static void main(String[] args) {
		A a = new A(1, 2, 3, 4);
		a.func();
	}
}

class A extends C {
	public A(int i1, int i2, int i3, int i4) {
		super(i1, i2, i3, i4);
	}

	public void func() {
		// 不同包的子类可以访问父类的protected、public
		System.out.println("i3: " + i3);
		System.out.println("i4: " + i4);
		f3();
		f4();
	}
}
```

p.C.java：

```java
package p;

public class C {
	private int i1;
	int i2;
	protected int i3;
	public int i4;

	private void f1() {
		System.out.println("f1");
	}

	void f2() {
		System.out.println("f2");
	}

	protected void f3() {
		System.out.println("f3");
	}

	public void f4() {
		System.out.println("f4");
	}

	public C(int i1, int i2, int i3, int i4) {
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}
}
```

运行结果：

```
i3: 3
i4: 4
f3
f4
```



(default package) Test.java：

```java
import p.C;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		a.func();
	}
}

class A {
	public void func() {
		// 不同包的类只能访问public
		C c = new C(1, 2, 3, 4);
		System.out.println("i4: " + c.i4);
		c.f4();
	}
}
```

p.C.java：

```java
package p;

public class C {
	private int i1;
	int i2;
	protected int i3;
	public int i4;

	private void f1() {
		System.out.println("f1");
	}

	void f2() {
		System.out.println("f2");
	}

	protected void f3() {
		System.out.println("f3");
	}

	public void f4() {
		System.out.println("f4");
	}

	public C(int i1, int i2, int i3, int i4) {
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}
}
```

运行结果：

```
i4: 4
f4
```



## 多态

多态
	编译时多态：编译期间决定目标方法
		方法名相同、参数不同
		通过重载实现
	运行时多态：运行期间（JVM）决定目标方法
		方法名相同、参数相同
		通过继承、重写实现
		实现原理：方法表



### 编译时多态	

```java
public class Test {	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.add(1, 2));
		System.out.println(t.add(1, 2, 3));
		System.out.println(t.add(3.17, 2.72));
	}
	
	public int add(int i1, int i2) {
		return i1 + i2;
	}
	
	public int add(int i1, int i2, int i3) {
		return i1 + i2 + i3;
	}
	
	public double add(double d1, double d2) {
		return d1 + d2;
	}
}
```

运行结果：

```
3
6
5.890000000000001
```



### 运行时多态

```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1();
		C2 c2 = new C2();
		C3 c3 = new C3();

		func(c1);
		func(c2);
		func(c3);

		func(new C1());
		func(new C2());
		func(new C3());
	}

	static void func(C1 c) {
		c.f();
	}
}

class C1 {
	public void f() {
		System.out.println("C1");
	}
}

class C2 extends C1 {
	public void f() {
		System.out.println("C2");
	}
}

class C3 extends C2 {
	public void f() {
		System.out.println("C3");
	}
}
```

运行结果：

```
C1
C2
C3
C1
C2
C3
```



```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1();
		C2 c2 = new C2();
		C3 c3 = new C3();

		func(c2);
		func(c3);

		func(new C2());
		func(new C3());
	}

	static void func(C2 c) {
		c.f();
	}
}

class C1 {
	public void f() {
		System.out.println("C1");
	}
}

class C2 extends C1 {
	public void f() {
		System.out.println("C2");
	}
}

class C3 extends C2 {
	public void f() {
		System.out.println("C3");
	}
}
```

运行结果：

```
C2
C3
C2
C3
```



## 转型

向上转型：父类引用指向子类对象
向下转型（强制类型转换）

```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C2();  // 向上转型
		C2 c2 = (C2) c1;  // 向下转型
		System.out.println(c1);
		System.out.println(c2);
	}
}

class C1 {
	public String toString() {
		return "C1";
	}
}

class C2 extends C1 {
	public String toString() {
		return "C2";
	}
}
```

运行结果：

```
C2
C2
```

