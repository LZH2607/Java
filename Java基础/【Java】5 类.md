# 【Java】类



[toc]



## 类

### 封装

封装：高内聚、低耦合

类的五大成员：属性、方法、构造器、代码块、内部类



### 简单示例

```java
class Student {
    int id;
    String name;
    int age;

    void printInfor() {
        System.out.println("Student{ID:" + id + ", Name:" + name + ", Age:" + age + "}");
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

运行结果：

```
Student{ID:1, Name:Tom, Age:18}
```



### 构造器

构造器 / 构造方法：
	由系统调用
	初始化对象（不是创建对象）

对象的初始化：默认初始化 → 显式初始化 → 构造器初始化

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
        System.out.println("Student{ID:" + id + ", Name:" + name + ", Age:" + age + "}");
    }
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student(1, "Tom", 18);
        s.printInfor();
    }
}
```

运行结果：

```
Student{ID:1, Name:Tom, Age:18}
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
        System.out.println("Student{ID:" + id + ", Name:" + name + ", Age:" + age + "}");
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

运行结果：

```
Student{ID:1, Name:Unknown, Age:18}
Student{ID:2, Name:Tom, Age:18}
Student{ID:3, Name:Jack, Age:19}
```



### 类的传参

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



## 变量

### 作用域

成员变量、局部变量可以重名：就近原则

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.f1();
		c.f2();
	}
}

class C {
	int i = 1;

	public void f1() {
		System.out.println(i);
	}

	public void f2() {
		int i = 2;
		System.out.println(i);
	}
}
```

运行结果：

```
1
2
```



### 默认赋值

全局变量（成员变量）：有默认赋值
局部变量：没有默认赋值

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



```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.f();
	}
}

class C {
	public void f() {
		int i;
		System.out.println(i);
	}
}
```

异常：

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The local variable i may not have been initialized
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



### 重载

重载
	方法名：相同
	形参列表：不相同（参数的类型/个数/顺序）
	返回类型：任意
	访问权限：任意

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



### 可变参数

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		int sum1 = c.add();
		int sum2 = c.add(1);
		int sum3 = c.add(1, 2);
		int sum4 = c.add(1, 2, 3);
		int sum5 = c.add(1, 2, 3, 4);
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(sum4);
		System.out.println(sum5);
	}
}

class C {
	public int add(int... is) {
		int sum = 0;
		for (int i = 0; i < is.length; i++) {
			sum += is[i];
		}
		return sum;
	}
}
```

运行结果：

```
0
1
3
6
10
```



```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		int[] arr1 = {};
		int[] arr2 = { 1 };
		int[] arr3 = { 1, 2 };
		int[] arr4 = { 1, 2, 3 };
		int[] arr5 = { 1, 2, 3, 4 };
		int sum1 = c.add(arr1);
		int sum2 = c.add(arr2);
		int sum3 = c.add(arr3);
		int sum4 = c.add(arr4);
		int sum5 = c.add(arr5);
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(sum4);
		System.out.println(sum5);
	}
}

class C {
	public int add(int... is) {
		int sum = 0;
		for (int i = 0; i < is.length; i++) {
			sum += is[i];
		}
		return sum;
	}
}
```

运行结果：

```
0
1
3
6
10
```



```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.add("Sum of 0 variable: ");
		c.add("Sum of 1 variable: ", 1);
		c.add("Sum of 2 variables: ", 1, 2);
		c.add("Sum of 3 variables: ", 1, 2, 3);
		c.add("Sum of 4 variables: ", 1, 2, 3, 4);
	}
}

class C {
	public void add(String s, int... is) {
		int sum = 0;
		for (int i = 0; i < is.length; i++) {
			sum += is[i];
		}
		System.out.println(s + sum);
	}
}
```

运行结果：

```
Sum of 0 variable: 0
Sum of 1 variable: 1
Sum of 2 variables: 3
Sum of 3 variables: 6
Sum of 4 variables: 10
```



## 访问修饰符

访问修饰符：private、default、protected、public

|              | private | default | protected | public |
| :----------: | :-----: | :-----: | :-------: | :----: |
|     同类     |    √    |    √    |     √     |   √    |
|  同包的子类  |         |    √    |     √     |   √    |
|  同文件的类  |         |    √    |     √     |   √    |
|   同包的类   |         |    √    |     √     |   √    |
| 不同包的子类 |         |         |     √     |   √    |
|  不同包的类  |         |         |           |   √    |

√：可以访问



### 同类

```java
public class Test {
    public static void main(String[] args) {
        C c = new C(1, 2, 3, 4);
        c.func();
    }
}

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

    public void func() {
        // 同类可以访问private、default、protected、public
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
```



### 同包的子类

p.Test.java：

```java
package p;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1, 2, 3, 4);
        c.func();
    }
}
```

p.C1.java：

```java
package p;

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
}
```

p.C2.java：

```java
package p;

class C2 extends C1 {
    public C2(int i1, int i2, int i3, int i4) {
        super(i1, i2, i3, i4);
    }

    public void func() {
        // 同包的子类可以访问父类的default、protected、public
        System.out.println("i2: " + i2);
        System.out.println("i3: " + i3);
        System.out.println("i4: " + i4);
        f2();
        f3();
        f4();
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



### 同文件的类

```java
public class Test {
    public static void main(String[] args) {
        // 同文件的类可以访问default、protected、public
        C c = new C(1, 2, 3, 4);
        System.out.println("i2: " + c.i2);
        System.out.println("i3: " + c.i3);
        System.out.println("i4: " + c.i4);
        c.f2();
        c.f3();
        c.f4();
    }
}

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



### 同包的类

p.Test.java：

```java
package p;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.func();
    }
}
```

p.C.java：

```java
package p;

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

p.A.java：

```java
package p;

class A {
    public void func() {
        // 同包的类可以访问default、protected、public
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

运行结果：

```
i2: 2
i3: 3
i4: 4
f2
f3
f4
```



### 不同包的子类

p.Test.java：

```java
package p;

import a.C2;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1, 2, 3, 4);
        c.func();
    }
}
```

p.C1.java：

```java
package p;

public class C1 {
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
}
```

a.C2.java：

```java
package a;

import p.C1;

public class C2 extends C1 {
    public C2(int i1, int i2, int i3, int i4) {
        super(i1, i2, i3, i4);
    }

    public void func() {
        // 不同包的子类只能访问父类的protected、public
        System.out.println("i3: " + i3);
        System.out.println("i4: " + i4);
        f3();
        f4();
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



### 不同包的类

p.Test.java

```java
package p;

import a.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.func();
    }
}
```

p.C.java

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

a.A.java

```java
package a;

import p.C;

public class A {
    public void func() {
        // 不同包的类只能访问public
        C c = new C(1, 2, 3, 4);
        System.out.println("i4: " + c.i4);
        c.f4();
    }
}
```

运行结果：

```
i4: 4
f4
```



## static关键字

static：
	静态属性、静态方法
	静态代码块
	静态导入



### 静态属性、静态方法

静态属性、静态方法：从属于类
成员属性、成员方法：从属于对象

static variable / class variable：静态属性 / 静态变量 / 类属性 / 类变量
staitc method / class method：静态方法 / 静态函数 / 类方法 / 类函数
instance variable：成员属性 / 成员变量 / 实例属性 / 实例变量
instance method：成员方法 / 成员函数 / 实例方法 / 实例函数

|          | 静态属性 | 静态方法 | 成员属性 | 成员方法 |
| :------: | :------: | :------: | :------: | :------: |
| 成员方法 |    √     |    √     |    √     |    √     |
| 静态方法 |    √     |    √     |    ×     |    ×     |

（√：可访问、×：不可访问）



#### 静态属性

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.i++;
        C.i++;
        System.out.println(c.i);
        System.out.println(C.i);
    }
}

class C {
    static int i = 0;
}
```

运行结果：

```
2
2
```



#### 静态方法

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
        C.f();
    }
}

class C {
    static void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
f
```



```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        C.func1();
        c.func2();
    }
}

class C {
    static int i1 = 1;
    int i2 = 2;

    static void f1() {
        System.out.println("f1");
    }

    void f2() {
        System.out.println("f2");
    }

    static void func1() {  // 静态方法只能访问静态属性、静态方法
        System.out.println(i1);
        System.out.println(C.i1);
        f1();
        C.f1();
    }

    void func2() {  // 成员方法可以访问静态属性、静态方法、成员属性、成员方法
        System.out.println(i1);
        System.out.println(C.i1);
        f1();
        C.f1();
        System.out.println(i2);
        System.out.println(this.i2);
        f2();
        this.f2();
    }
}
```

运行结果：

```
1
1
f1
f1
1
1
f1
f1
2
2
f2
f2
```



### 静态代码块

|   代码块   |                         执行时间                         | 执行次数 |
| :--------: | :------------------------------------------------------: | :------: |
| 静态代码块 | 加载类（创建对象、创建子类对象、访问静态属性、静态方法） |   1次    |
| 普通代码块 |                  创建对象、创建子类对象                  |   多次   |

```java
public class Test {
    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
    }
}

class C {
    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }
}
```

运行结果：

```
static block
block
block
```



```java
public class Test {
    public static void main(String[] args) {
        C2 c1 = new C2();
        C2 c2 = new C2();
    }
}

class C1 {
    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }
}

class C2 extends C1 {

}
```

运行结果：

```
static block
block
block
```



```java
public class Test {
    public static void main(String[] args) {
        System.out.println(C.i);
        C.f();
    }
}

class C {
    static int i = 1;

    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }

    static void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
static block
1
f
```



执行顺序（优先级）：
	① 父类：初始化静态属性、静态代码块
	② 子类：初始化静态属性、静态代码块
	③ 父类：初始化成员属性、普通代码块
	④ 父类：构造器
	⑤ 子类：初始化成员属性、普通代码块
	⑥ 子类：构造器

相关视频：
[【零基础 快速学Java】韩顺平 零基础30天学会Java 0387\_韩顺平Java\_代码块使用细节2](https://www.bilibili.com/video/BV1fh411y7R8?p=388)
[【零基础 快速学Java】韩顺平 零基础30天学会Java 0388\_韩顺平Java\_代码块使用细节3](https://www.bilibili.com/video/BV1fh411y7R8?p=389)
[【零基础 快速学Java】韩顺平 零基础30天学会Java 0389\_韩顺平Java\_代码块使用细节4](https://www.bilibili.com/video/BV1fh411y7R8?p=390)

```java
public class Test {
    public static void main(String[] args) {
        C3 c = new C3();
    }
}

class C1 {
    static int s1 = 1;
    int i1 = 11;

    static {
        System.out.println("C1: static block");
        System.out.println("C1.s1: " + s1);
    }

    {
        System.out.println("C1: block");
        System.out.println("C1.i1: " + i1);
    }

    C1() {
        System.out.println("C1: constructor");
    }
}

class C2 extends C1 {
    static int s2 = 2;
    int i2 = 12;

    static {
        System.out.println("C2: static block");
        System.out.println("C2.s2: " + s2);
    }

    {
        System.out.println("C2: block");
        System.out.println("C2.i2: " + i2);
    }

    C2() {
        // super();
        System.out.println("C2: constructor");
    }
}

class C3 extends C2 {
    static int s3 = 3;
    int i3 = 13;

    static {
        System.out.println("C3: static block");
        System.out.println("C3.s3: " + s3);
    }

    {
        System.out.println("C3: block");
        System.out.println("C3.i3: " + i3);
    }

    C3() {
        // super();
        System.out.println("C3: constructor");
    }
}
```

运行结果：

```
C1: static block
C1.s1: 1
C2: static block
C2.s2: 2
C3: static block
C3.s3: 3
C1: block
C1.i1: 11
C1: constructor
C2: block
C2.i2: 12
C2: constructor
C3: block
C3.i3: 13
C3: constructor
```



|   代码块   |                可以访问                |
| :--------: | :------------------------------------: |
| 静态代码块 |           静态属性、静态方法           |
| 普通代码块 | 静态属性、静态方法、成员属性、成员方法 |

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
    }
}

class C {
    static int i1 = 1;
    int i2 = 2;

    static void f1() {
        System.out.println("f1");
    }

    void f2() {
        System.out.println("f2");
    }

    static {
        // 静态代码块只能访问静态属性、静态方法
        System.out.println("i1: " + i1);
        f1();
    }

    {
        // 普通代码块可以访问静态属性、静态方法、成员属性、成员方法
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);
        f1();
        f2();
    }
}
```

运行结果：

```
i1: 1
f1
i1: 1
i2: 2
f1
f2
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



## final关键字

final修饰类：阻止继承
final修饰方法：阻止重写（可以重载）
final修饰属性：常量



### final修饰类

final修饰类：阻止继承

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
    }
}

final class C1 {

}

class C2 extends C1 {

}
```

编译错误：

```
java: 无法从最终C1进行继承
```



### final修饰方法

final修饰方法：阻止重写（可以重载）

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
    }
}

class C1 {
    final void f() {
        System.out.println("C1.f");
    }
}

class C2 extends C1 {
    void f() {
        System.out.println("C2.f");
    }
}
```

编译错误：

```
java: C2中的f(int)无法覆盖C1中的f(int)
  被覆盖的方法为final
```



```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f(1);
        c.f(1.1);
    }
}

class C {
    final void f(int i) {
        System.out.println(i);
    }

    final void f(double d) {
        System.out.println(d);
    }
}
```

运行结果：

```
1
1.1
```



```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        c1.f(1);
        c2.f(1.1);
    }
}

class C1 {
    final void f(int i) {
        System.out.println(i);
    }
}

class C2 extends C1 {
    void f(double d) {
        System.out.println(d);
    }
}
```

运行结果：

```
1
1.1
```



### final修饰属性

final修饰属性：常量



#### final修饰静态属性

初始化final修饰的静态属性：
	① 在定义时
	② 在静态代码块中

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(C.I);
    }
}

class C {
    static final int I = 1;
}
```

运行结果：

```
1
```



```java
public class Test {
    public static void main(String[] args) {
        System.out.println(C.I);
    }
}

class C {
    static final int I;

    static {
        I = 1;
    }
}
```

运行结果：

```
1
```



#### final修饰成员属性

初始化final修饰的成员属性：
	① 在定义时
	② 在构造器中
	③ 在普通代码块中

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.I);
    }
}

class C {
    final int I = 1;
}
```

运行结果：

```
1
```



```java
public class Test {
    public static void main(String[] args) {
        C c = new C(1);
        System.out.println(c.I);
    }
}

class C {
    final int I;

    C(int i) {
        this.I = i;
    }
}
```

运行结果：

```
1
```



```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.I);
    }
}

class C {
    final int I;

    {
        I = 1;
    }
}
```

运行结果：

```
1
```



#### final修饰局部变量

初始化final修饰的局部变量：在定义时

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

class C {
    void f() {
        final int I = 1;
        System.out.println(I);
    }
}
```

运行结果：

```
1
```



## 继承

类的三大特性：封装、继承、多态

默认父类：java.lang.Object

查看类的继承结构：Ctrl + H（IntelliJ IDEA）

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



### 访问父类的私有属性、私有方法

使用父类提供的方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.setI(1);
        int i = c.getI();
        System.out.println(i);
        c.callF();
    }
}

class C1 {
    private int i;

    private void f() {
        System.out.println("f");
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void callF() {
        f();
    }
}

class C2 extends C1 {
}
```

运行结果：

```
1
f
```



### super

访问父类的构造方法
访问父类的属性
访问父类的方法



#### 1. 访问父类的构造方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
    }
}

class C1 {
    C1() {
        System.out.println("C1");
    }
}

class C2 extends C1 {
    C2() {
        super();  // 默认调用，可以省略
        System.out.println("C2");
    }
}
```

运行结果：

```
C1
C2
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



问题：

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
    }
}

class C1 {
    C1() {
        this(1);
        System.out.println("C1");
    }

    C1(int i) {
        System.out.println("C1: " + i);
    }
}

class C2 extends C1 {
    C2() {
        this(1);
        System.out.println("C2");
    }

    C2(int i) {
        System.out.println("C2: " + i);
    }
}
```

运行结果：

```
C1: 1
C1
C2: 1
C2
```



#### 2. 访问父类的属性

##### 同包的子类

同包的子类可以访问父类的default、protected、public属性

p.Test.java：

```java
package p;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f();
    }
}
```

p.C1.java：

```java
package p;

class C1 {
    private int i1 = 1;
    int i2 = 2;
    protected int i3 = 3;
    public int i4 = 4;
}
```

p.C2.java：

```java
package p;

class C2 extends C1 {
    private int i1 = 11;
    int i2 = 12;
    protected int i3 = 13;
    public int i4 = 14;

    public void f() {
        System.out.println(super.i2);
        System.out.println(super.i3);
        System.out.println(super.i4);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }
}
```

运行结果：

```
2
3
4
11
12
13
14
```



##### 不同包的子类

不同包的子类只能访问父类的protected、public属性

p.Test.java：

```java
package p;

import a.C2;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f();
    }
}
```

p.C1.java：

```java
package p;

public class C1 {
    private int i1 = 1;
    int i2 = 2;
    protected int i3 = 3;
    public int i4 = 4;
}
```

a.C2.java：

```java
package a;

import p.C1;

public class C2 extends C1 {
    private int i1 = 11;
    int i2 = 12;
    protected int i3 = 13;
    public int i4 = 14;

    public void f() {
        System.out.println(super.i3);
        System.out.println(super.i4);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }
}
```

运行结果：

```
3
4
11
12
13
14
```



#### 3. 访问父类的方法

##### 同包的子类

同包的子类可以访问父类的default、protected、public方法

p.Test.java：

```java
package p;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f();
    }
}
```

p.C1.java：

```java
package p;

class C1 {
    private void f1() {
        System.out.println("C1: f1");
    }

    void f2() {
        System.out.println("C1: f2");
    }

    protected void f3() {
        System.out.println("C1: f3");
    }

    public void f4() {
        System.out.println("C1: f4");
    }
}
```

p.C2.java：

```java
package p;

class C2 extends C1 {
    private void f1() {
        System.out.println("C2: f1");
    }

    void f2() {
        System.out.println("C2: f2");
    }

    protected void f3() {
        System.out.println("C2: f3");
    }

    public void f4() {
        System.out.println("C2: f4");
    }

    public void f() {
        super.f2();
        super.f3();
        super.f4();
        f1();
        f2();
        f3();
        f4();
    }
}
```

运行结果：

```
C1: f2
C1: f3
C1: f4
C2: f1
C2: f2
C2: f3
C2: f4
```



##### 不同包的子类

不同包的子类只能访问父类的protected、public方法

p.Test.java：

```java
package p;

import a.C2;

public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f();
    }
}
```

p.C1.java：

```java
package p;

public class C1 {
    private void f1() {
        System.out.println("C1: f1");
    }

    void f2() {
        System.out.println("C1: f2");
    }

    protected void f3() {
        System.out.println("C1: f3");
    }

    public void f4() {
        System.out.println("C1: f4");
    }
}
```

a.C2.java：

```java
package a;

import p.C1;

public class C2 extends C1 {
    private void f1() {
        System.out.println("C2: f1");
    }

    void f2() {
        System.out.println("C2: f2");
    }

    protected void f3() {
        System.out.println("C2: f3");
    }

    public void f4() {
        System.out.println("C2: f4");
    }

    public void f() {
        super.f3();
        super.f4();
        f1();
        f2();
        f3();
        f4();
    }
}
```

运行结果：

```
C1: f3
C1: f4
C2: f1
C2: f2
C2: f3
C2: f4
```



#### super、this、直接访问

访问父类的重名属性、方法：super
访问子类的重名属性、方法：this、直接访问
访问父类的非重名属性、方法：super、this、直接访问
访问子类的非重名属性、方法：this、直接访问



##### 访问父类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1: f");
    }
}

class C2 extends C1 {
    int i = 2;

    void f() {
        System.out.println("C2: f");
    }

    void func() {
        System.out.println(super.i);
        super.f();
    }
}
```

运行结果：

```
1
C1: f
```



##### 访问子类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1: f");
    }
}

class C2 extends C1 {
    int i = 2;

    void f() {
        System.out.println("C2: f");
    }

    void func() {
        System.out.println(this.i);
        System.out.println(i);
        this.f();
        f();
    }
}
```

运行结果：

```
2
2
C2: f
C2: f
```



##### 访问父类的非重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("f");
    }
}

class C2 extends C1 {
    void func() {
        System.out.println(super.i);
        System.out.println(this.i);
        System.out.println(i);
        super.f();
        this.f();
        f();
    }
}
```

运行结果：

```
1
1
1
f
f
f
```



##### 访问子类的非重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
}

class C2 extends C1 {
    int i = 1;

    void f() {
        System.out.println("f");
    }

    void func() {
        System.out.println(this.i);
        System.out.println(i);
        this.f();
        f();
    }
}
```

运行结果：

```
1
1
f
f
```



### 重写

重写：子类对父类的方法重新编写
	方法名：相同
	形参列表：相同
	返回类型：相同/父类方法返回类型的子类
	访问权限：≥ 父类方法的访问权限（public > protected > default > private）

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



```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.i1 = 1;
        c.i2 = 2;
        System.out.println(c.f());
    }
}

class C1 {
    int i1;

    public Object f() {
        return "i1: " + i1;
    }
}

class C2 extends C1 {
    int i2;

    public String f() {
        return "i1: " + i1 + ", i2: " + i2;
    }
}
```

运行结果：

```
i1: 1, i2: 2
```



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

    void f() {
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



#### 重写、重载

|          |      重写（override）       |        重载（overload）        |
| :------: | :-------------------------: | :----------------------------: |
|   发生   |            子类             |              同类              |
|  方法名  |            相同             |              相同              |
| 形参列表 |            相同             | 不相同（参数的类型/个数/顺序） |
| 返回类型 | 相同/父类方法返回类型的子类 |              任意              |
| 访问权限 |    ≥ 父类方法的访问权限     |              任意              |



#### 隐藏、覆盖

|   重名   |     现象     | RRIT |
| :------: | :----------: | :--: |
| 静态属性 |     隐藏     |  ×   |
| 静态方法 |     隐藏     |  ×   |
| 成员属性 |     隐藏     |  ×   |
| 成员方法 | 覆盖（重写） |  √   |



## 转型

转型：编译类型 ≠/= 运行类型
	向上转型：编译类型 ≠ 运行类型
	向下转型：编译类型 = 运行类型

|          |       向上转型       | 向下转型（强制类型转换） |
| :------: | :------------------: | :----------------------: |
|   实现   | 父类引用指向子类对象 |   子类引用指向子类对象   |
| 编译类型 |         父类         |           子类           |
| 运行类型 |         子类         |           子类           |

访问属性：根据编译类型
访问方法：根据运行类型



### 向上转型

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        System.out.println(c.i);
        c.f();
        c = new C2();  // 向上转型
        System.out.println(c.i);
        c.f();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1");
    }
}

class C2 extends C1 {
    int i = 2;

    void f() {
        System.out.println("C2");
    }
}
```

运行结果：

```
1
C1
1
C2
```



### 向下转型（强制类型转换）

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C2();  // 向上转型
        System.out.println(c1.i);
        c1.f();
        C2 c2 = (C2) c1;  // 向下转型
        System.out.println(c2.i);
        c2.f();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1");
    }
}

class C2 extends C1 {
    int i = 2;

    void f() {
        System.out.println("C2");
    }
}
```

运行结果：

```
1
C2
2
C2
```



问题：

```java
public class Test {
    public static void main(String[] args) {
        C2 a = new C2();
        System.out.println(a.i);
        a.f();
        C1 b = a;
        System.out.println(a == b);
        System.out.println(b.i);
        b.f();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1");
    }
}

class C2 extends C1 {
    int i = 2;

    void f() {
        System.out.println("C2");
    }
}
```

运行结果：

```
2
C2
true
1
C2
```



### instanceof

instanceof：判断运行类型是否为某类或其子类

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        C1 c3 = new C2();

        System.out.println(c1 instanceof Object);
        System.out.println(c1 instanceof C1);
        System.out.println(c1 instanceof C2);

        System.out.println(c2 instanceof Object);
        System.out.println(c2 instanceof C1);
        System.out.println(c2 instanceof C2);

        System.out.println(c3 instanceof Object);
        System.out.println(c3 instanceof C1);
        System.out.println(c3 instanceof C2);
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
true
true
true
```



### 动态绑定

相关视频：
[【零基础 快速学Java】韩顺平 零基础30天学会Java P315 0314\_韩顺平Java\_动态绑定机制](https://www.bilibili.com/video/BV1fh411y7R8/?p=315)

|          |         访问方法          |         访问属性          |
| :------: | :-----------------------: | :-----------------------: |
|   绑定   |         运行类型          |            无             |
| 查找顺序 | 运行类型 → 运行类型的父类 | 访问类型 → 访问类型的父类 |

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C2();  // 向上转型
        System.out.println(c.add1(3));
        System.out.println(c.add2(3));
    }
}

class C1 {
    int i = 1;

    public int getI() {
        return i;
    }

    public int add1(int j) {
        return i + j;
    }

    public int add2(int j) {
        return getI() + j;
    }
}

class C2 extends C1 {
    int i = 2;

    public int getI() {
        return i;
    }
}
```

运行结果：

```
4
5
```



### 示例

```java
public class Test {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Tom", 18);
        persons[1] = new Student("Jack", 19, 80);
        persons[2] = new Student("Mike", 20, 90);
        persons[3] = new Teacher("Smith", 29, 15000);
        persons[4] = new Teacher("John", 30, 18000);

        for (Person person : persons) {
            person.printInfor();
            if (person instanceof Student) {
                ((Student) person).study();
            } else if (person instanceof Teacher) {
                ((Teacher) person).teach();
            }
        }
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printInfor() {
        System.out.println("Person{Name:" + name + ", Age" + age + "}");
    }
}

class Student extends Person {
    double score;

    Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    void printInfor() {
        System.out.println("Student{Name:" + name + ", Age:" + age + ", Score:" + score + "}");
    }

    void study() {
        System.out.println("Student " + name + " is studying.");
    }
}

class Teacher extends Person {
    double salary;

    Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    void printInfor() {
        System.out.println("Teacher{Name:" + name + ", Age:" + age + ", Salary:" + salary + "}");
    }

    void teach() {
        System.out.println("Teacher " + name + " is teaching.");
    }
}
```

运行结果：

```
Person{Name:Tom, Age18}
Student{Name:Jack, Age:19, Score:80.0}
Student Jack is studying.
Student{Name:Mike, Age:20, Score:90.0}
Student Mike is studying.
Teacher{Name:Smith, Age:29, Salary:15000.0}
Teacher Smith is teaching.
Teacher{Name:John, Age:30, Salary:18000.0}
Teacher John is teaching.
```



## 多态

多态
	编译时多态：编译期间
	运行时多态：运行期间（JVM）

|          | 编译时多态 |   运行时多态    |
| :------: | :--------: | :-------------: |
|   发生   |  编译期间  | 运行期间（JVM） |
|  方法名  |    相同    |      相同       |
| 形参列表 |    不同    |      相同       |
|   实现   |    重载    |   继承、重写    |
|   原理   |   编译器   |     方法表      |



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



## Object

相关链接：
[Class Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
![](D:\Notes\Java\Java基础\img\Object All Methods.png)



### ==、equals

#### ==

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



#### equals

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



### toString

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
        return "C{i:" + i + "}";
    }
}
```

运行结果：

```
C{i:1}
C{i:1}
```



### hashCode

```java
public class Test {
    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        C c3 = c1;
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}

class C {

}
```

运行结果：

```
356573597
1735600054
356573597
```



#### hashCode、toString

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.hashCode());
        System.out.println(Integer.toHexString(c.hashCode()));
        System.out.println(c);
        System.out.println(c.toString());
    }
}

class C {

}
```

运行结果：

```
356573597
1540e19d
C@1540e19d
C@1540e19d
```



### finalize

```java
public class Test {
    public static void main(String[] args) {
        C c = new C(1);
        c = null;
        System.gc();
    }
}

class C {
    int i;

    C(int i) {
        this.i = i;
    }

    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
```

运行结果：

```
finalize
```



## main

相关视频：
[【零基础 快速学Java】韩顺平 零基础30天学会Java P383 0382\_韩顺平Java\_main语法说明](https://www.bilibili.com/video/BV1fh411y7R8?p=383)
[【零基础 快速学Java】韩顺平 零基础30天学会Java P385 0384\_韩顺平Java\_main动态传值](https://www.bilibili.com/video/BV1fh411y7R8?p=385)



### 示例

Test.java：

```java
public class Test {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
```

编译：

```
javac Test.java
```

执行：

```
java Test abc def ghi
```

运行结果：

```
abc
def
ghi
```



## abstract关键字

abstract修饰类：抽象类（不能用final修饰）
abstract修饰方法：抽象方法（不能用private、final、static修饰）

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1);
        System.out.println(c.i);
        c.f1();
        c.f2();
    }
}

abstract class C1 {
    int i;

    abstract void f1();

    void f2() {
        System.out.println("f2");
    }

    C1(int i) {
        this.i = i;
    }
}

class C2 extends C1 {
    C2(int i) {
        super(i);
    }

    void f1() {
        System.out.println("f1");
    }
}
```

运行结果：

```
1
f1
f2
```



```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        c1.f2();
        c2.f2();
    }
}

abstract class B {
    abstract void f1();

    void f2() {
        f1();
    }
}

class C1 extends B {
    void f1() {
        System.out.println("C1");
    }
}

class C2 extends B {
    void f1() {
        System.out.println("C2");
    }
}
```

运行结果：

```
C1
C2
```



## 接口

### 示例

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
}

interface I {
    void f();
}

class C implements I {
    public void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
```



### 方法

接口中的方法都是public方法

JDK 7.0及以前：接口中的方法都是抽象方法（可以省略abstract关键字）
JDK 8.0及以后：接口中的方法可以具体实现
	静态方法：使用static关键字修饰
	默认方法：使用default关键字修饰

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f();
        I.s();
        c.d();
    }
}

interface I {
    void f();

    static void s() {
        System.out.println("s");
    }

    default void d() {
        System.out.println("d");
    }
}

class C implements I {
    public void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
s
d
```



### 属性

接口中的属性都是public static final属性：

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(I.i);
        System.out.println(C.i);
        System.out.println(c.i);
    }
}

interface I {
    int i = 1;
}

class C implements I {
}
```

运算结果：

```
1
1
1
```



### 实现接口

用抽象类实现接口时，可以不实现接口的抽象方法：

I.java：

```java
public interface I {
    void f1();

    void f2();
}
```

C.java：

```java
public abstract class C implements I {
    public void func() {
        System.out.println("func");
    }
}
```



一个类可以同时实现多个接口：

I1.java：

```java
public interface I1 {
    void f1();
}
```

I2.java：

```java
public interface I2 {
    void f2();
}
```

C.java：

```java
public class C implements I1, I2 {
    public void f1() {
        System.out.println("f1");
    }

    public void f2() {
        System.out.println("f2");
    }
}
```

Test.java：

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.f1();
		c.f2();
	}
}
```

运行结果：

```
f1
f2
```



### 继承接口

一个接口可以继承多个接口：

I1.java：

```java
public interface I1 {
    void f1();
}
```

I2.java：

```java
public interface I2 {
    void f2();
}
```

I3.java：

```java
public interface I3 extends I1, I2 {
    void f3();
}
```

C.java：

```java
public class C implements I3 {
    public void f1() {
        System.out.println("f1");
    }

    public void f2() {
        System.out.println("f2");
    }

    public void f3() {
        System.out.println("f3");
    }
}
```

Test.java：

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.f1();
        c.f2();
        c.f3();
    }
}
```

运行结果：

```
f1
f2
f3
```



### 继承类、实现接口

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f1();
        c.f2();
        c.func();
    }
}

interface I1 {
    void f1();
}

interface I2 {
    void f2();
}

class C1 {
    void func() {
        System.out.println("func");
    }
}

class C2 extends C1 implements I1, I2 {
    public void f1() {
        System.out.println("f1");
    }

    public void f2() {
        System.out.println("f2");
    }
}
```

运行结果：

```
f1
f2
func
```



```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

interface I {
    int i = 0;

    void f();
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1");
    }
}

class C2 extends C1 implements I {
    int i = 2;

    public void f() {
        System.out.println("C2");
    }

    void func() {
        System.out.println(I.i);
        System.out.println(super.i);
        System.out.println(i);
        super.f();
        f();
    }
}
```

运行结果：

```
0
1
2
C1
C2
```



### 多态

```java
public class Test {
    public static void main(String[] args) {
        I1 i1 = new C();
        I2 i2 = new C();
        i1.f();
        i2.f();
    }
}

interface I1 {
    void f();
}

interface I2 extends I1 {

}

class C implements I2 {
    public void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
f
```



I.java：

```java
public interface I {
    void f();
}
```

C1.java：

```java
public class C1 implements I {
    public void f() {
        System.out.println("C1");
    }
}
```

C2.java：

```java
public class C2 implements I {
    public void f() {
        System.out.println("C2");
    }
}
```

C.java：

```java
public class C {
    public void func(I i) {
        i.f();
    }
}
```

Test.java：

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        C c = new C();
        c.func(c1);
        c.func(c2);
    }
}
```

运行结果：

```
C1
C2
```



## 抽象类

抽象方法不能用private、static、final修饰



### 示例

```java
public class Test {
    public static void main(String[] args) {
        C c = new C() {
            @Override
            void f() {
                System.out.println("f");
            }
        };
        c.f();
    }
}

abstract class C {
    abstract void f();
}
```

运行结果：

```
f
```



抽象类中可以没有抽象方法：

```java
public class Test {
    public static void main(String[] args) {
        C c = new C() {
        };
        c.f();
    }
}

abstract class C {
    void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
```



### 继承抽象类

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.f();
    }
}

abstract class C1 {
    abstract void f();
}

class C2 extends C1 {
    @Override
    void f() {
        System.out.println("f");
    }
}
```

运行结果：

```
f
```



```java
public class Test {
    public static void main(String[] args) {
        C3 c = new C3();
        c.f1();
        c.f2();
    }
}

abstract class C1 {
    abstract void f1();
}

abstract class C2 extends C1 {
    abstract void f2();
}

class C3 extends C2 {
    @Override
    void f1() {
        System.out.println("f1");
    }

    @Override
    void f2() {
        System.out.println("f2");
    }
}
```

运行结果：

```
f1
f2
```



## 内部类

内部类：
	定义在外部类的局部位置：
		局部内部类（有类名）
		匿名内部类（无类名）
	定义在外部类的成员位置：
		成员内部类（无static修饰）
		静态内部类（有static修饰）

|   外部类   | private | default | protected | public |
| :--------: | :-----: | :-----: | :-------: | :----: |
| 局部内部类 |    √    |    √    |     √     |   √    |
| 匿名内部类 |    √    |    √    |     √     |   √    |
| 成员内部类 |    √    |    √    |     √     |   √    |
| 静态内部类 | static  | static  |  static   | static |



### 局部内部类

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    void func() {
        class C2 {
            void f() {
                System.out.println("f");
            }
        }
        C2 c = new C2();
        c.f();
        System.out.println(c.getClass());
    }
}
```

运行结果：

```
f
class C1$1C2
```



#### 访问外部类的属性、方法

局部内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1(1, 2, 3, 4);
        c.func();
    }
}

class C1 {
    private int i1;
    int i2;
    protected int i3;
    public int i4;

    C1(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

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

    void func() {
        class C2 {
            void f() {
                System.out.println(i1);
                System.out.println(i2);
                System.out.println(i3);
                System.out.println(i4);
                f1();
                f2();
                f3();
                f4();
            }
        }
        C2 c = new C2();
        c.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



#### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1.f");
    }

    void func() {
        class C2 {
            int i = 2;

            void f() {
                System.out.println("C2.f");
            }

            void fun() {
                System.out.println(C1.this.i);
                System.out.println(i);
                C1.this.f();
                f();
            }
        }
        C2 c = new C2();
        c.fun();
    }
}
```

运行结果：

```
1
2
C1.f
C2.f
```



### 匿名内部类

#### 基于接口的匿名内部类

##### 用法一

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.func();
    }
}

interface I {
    void f();
}

class C {
    void func() {
        // i的编译类型：interface I
        // i的运行类型：class C$1
        I i = new I() {
            @Override
            public void f() {
                System.out.println("f");
            }
        };
        i.f();
        System.out.println(i.getClass());
    }
}
```

运行结果：

```
f
class C$1
```



###### 访问外部类的属性、方法

基于接口的匿名内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C c = new C(1, 2, 3, 4);
        c.func();
    }
}

interface I {
    void f();
}

class C {
    private int i1;
    int i2;
    protected int i3;
    public int i4;

    C(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

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

    void func() {
        I i = new I() {
            @Override
            public void f() {
                System.out.println(i1);
                System.out.println(i2);
                System.out.println(i3);
                System.out.println(i4);
                f1();
                f2();
                f3();
                f4();
            }
        };
        i.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



###### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.func();
    }
}

interface I {
    void f();

    void fun();
}

class C {
    int i = 2;

    void f() {
        System.out.println("C.f");
    }

    void func() {
        I i = new I() {
            int i = 1;

            @Override
            public void f() {
                System.out.println("I.f");
            }

            @Override
            public void fun() {
                System.out.println(C.this.i);
                System.out.println(i);
                C.this.f();
                f();
            }
        };
        i.fun();
    }
}
```

运行结果：

```
2
1
C.f
I.f
```



##### 用法二

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.func(new I() {
            @Override
            public void f() {
                System.out.println("f");
            }
        });
    }
}

interface I {
    void f();
}

class C {
    void func(I i) {
        i.f();
        System.out.println(i.getClass());
    }
}
```

运行结果：

```
f
class Test$1
```



###### 访问外部类的属性、方法

基于接口的匿名内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1, 2, 3, 4);
        c.func();
    }
}

interface I {
    void f();
}

class C1 {
    void fun(I i) {
        i.f();
    }
}

class C2 {
    private int i1;
    int i2;
    protected int i3;
    public int i4;

    C2(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

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

    void func() {
        C1 c = new C1();
        c.fun(new I() {
            @Override
            public void f() {
                System.out.println(i1);
                System.out.println(i2);
                System.out.println(i3);
                System.out.println(i4);
                f1();
                f2();
                f3();
                f4();
            }
        });
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



###### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

interface I {
    void f();

    void fun();
}

class C1 {
    void m(I i) {
        i.fun();
    }
}

class C2 {
    int i = 2;

    void f() {
        System.out.println("C2.f");
    }

    void func() {
        C1 c = new C1();
        c.m(new I() {
            int i = 1;

            @Override
            public void f() {
                System.out.println("I.f");
            }

            @Override
            public void fun() {
                System.out.println(C2.this.i);
                System.out.println(i);
                C2.this.f();
                f();
            }
        });
    }
}
```

运行结果：

```
2
1
C2.f
I.f
```



#### 基于类的匿名内部类

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {

}

class C2 {
    void func() {
        C1 c1 = new C1();
        C1 c2 = new C1() {

        };
        System.out.println(c1.getClass());
        System.out.println(c2.getClass());
    }
}
```

运行结果：

```
class C1
class C2$1
```



##### 用法一

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    void f() {
        System.out.println("1");
    }
}

class C2 {
    void func() {
        C1 c1 = new C1();
        C1 c2 = new C1() {
            @Override
            void f() {
                System.out.println("2");
            }
        };
        c1.f();
        c2.f();
    }
}
```

运行结果：

```
1
2
```



###### 访问外部类的属性、方法

基于类的匿名内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1, 2, 3, 4);
        c.func();
    }
}

class C1 {
    void f() {

    }
}

class C2 {
    private int i1;
    int i2;
    protected int i3;
    private int i4;

    public C2(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

    private void f1() {
        System.out.println("f1");
    }

    void f2() {
        System.out.println("f2");
    }

    protected void f3() {
        System.out.println("f3");
    }

    private void f4() {
        System.out.println("f4");
    }

    void func() {
        C1 c = new C1() {
            @Override
            void f() {
                System.out.println(i1);
                System.out.println(i2);
                System.out.println(i3);
                System.out.println(i4);
                f1();
                f2();
                f3();
                f4();
            }
        };
        c.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



###### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    void fun() {

    }
}

class C2 {
    int i = 2;

    void f() {
        System.out.println("C2.f");
    }

    void func() {
        C1 c = new C1() {
            int i = 1;

            void f() {
                System.out.println("C1.f");
            }

            @Override
            void fun() {
                System.out.println(C2.this.i);
                System.out.println(i);
                C2.this.f();
                f();
            }
        };
        c.fun();
    }
}
```

运行结果：

```
2
1
C2.f
C1.f
```



##### 用法二

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {
    void f() {
        System.out.println("1");
    }
}

class C2 {
    void func() {
        new C1() {
            @Override
            void f() {
                System.out.println("2");
            }
        }.f();
    }
}
```

运行结果：

```
2
```



###### 访问外部类的属性、方法

基于类的匿名内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2(1, 2, 3, 4);
        c.func();
    }
}

class C1 {
    void f() {

    }
}

class C2 {
    private int i1;
    int i2;
    protected int i3;
    private int i4;

    public C2(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

    private void f1() {
        System.out.println("f1");
    }

    void f2() {
        System.out.println("f2");
    }

    protected void f3() {
        System.out.println("f3");
    }

    private void f4() {
        System.out.println("f4");
    }

    void func() {
        new C1() {
            @Override
            void f() {
                System.out.println(i1);
                System.out.println(i2);
                System.out.println(i3);
                System.out.println(i4);
                f1();
                f2();
                f3();
                f4();
            }
        }.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



###### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C2 c = new C2();
        c.func();
    }
}

class C1 {

}

class C2 {
    int i = 2;

    void f() {
        System.out.println("C2.f");
    }

    void func() {
        new C1() {
            int i = 1;

            void f() {
                System.out.println("C1.f");
            }

            void fun() {
                System.out.println(i);
                System.out.println(C2.this.i);
                f();
                C2.this.f();
            }
        }.fun();
    }
}
```

运行结果：

```
1
2
C1.f
C2.f
```



### 成员内部类

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    void f() {
        System.out.println("C1.f");
    }

    class C2 {
        void f() {
            System.out.println("C2.f");
        }
    }

    void func() {
        C2 c = new C2();
        f();
        c.f();
        System.out.println(c.getClass());
    }
}
```

运行结果：

```
C1.f
C2.f
class C1$C2
```



#### 访问外部类的属性、方法

成员内部类可以访问外部类的private、default、protected、public

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1(1, 2, 3, 4);
        c.func();
    }
}

class C1 {
    private int i1;
    int i2;
    protected int i3;
    public int i4;

    public C1(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

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

    class C2 {
        void f() {
            System.out.println(i1);
            System.out.println(i2);
            System.out.println(i3);
            System.out.println(i4);
            f1();
            f2();
            f3();
            f4();
        }
    }

    void func() {
        C2 c = new C2();
        c.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



#### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    int i = 1;

    void f() {
        System.out.println("C1.f");
    }

    class C2 {
        int i = 2;

        void f() {
            System.out.println("C2.f");
        }

        void fun() {
            System.out.println(C1.this.i);
            System.out.println(i);
            C1.this.f();
            f();
        }
    }

    void func() {
        C2 c = new C2();
        c.fun();
    }
}
```

运行结果：

```
1
2
C1.f
C2.f
```



#### 外部其他类访问成员内部类

##### 方法一

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C1.C2 c2 = c1.new C2();
        c2.f();
    }
}

class C1 {
    class C2 {
        void f() {
            System.out.println("f");
        }
    }
}
```

运行结果：

```
f
```



```java
public class Test {
    public static void main(String[] args) {
        C1.C2 c2 = new C1().new C2();
        c2.f();
    }
}

class C1 {
    class C2 {
        void f() {
            System.out.println("f");
        }
    }
}
```

运行结果：

```
f
```



##### 方式二

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C1.C2 c2 = c1.getC2();
        c2.f();
    }
}

class C1 {
    class C2 {
        void f() {
            System.out.println("f");
        }
    }

    C2 getC2() {
        return new C2();
    }
}
```

运行结果：

```
f
```



```java
public class Test {
    public static void main(String[] args) {
        C1.C2 c2 = new C1().getC2();
        c2.f();
    }
}

class C1 {
    class C2 {
        void f() {
            System.out.println("f");
        }
    }

    C2 getC2() {
        return new C2();
    }
}
```

运行结果：

```
f
```



### 静态内部类

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    static class C2 {
        static void f() {
            System.out.println("f");
        }
    }

    void func() {
        C2.f();
    }
}
```

运行结果：

```
f
```



#### 访问外部类的属性、方法

静态内部类可以访问外部类的private static、default static、protected static、public static

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1(1, 2, 3, 4);
        c.func();
    }
}

class C1 {
    private static int i1;
    static int i2;
    protected static int i3;
    public static int i4;

    public C1(int i1, int i2, int i3, int i4) {
        C1.i1 = i1;
        C1.i2 = i2;
        C1.i3 = i3;
        C1.i4 = i4;
    }

    private static void f1() {
        System.out.println("f1");
    }

    static void f2() {
        System.out.println("f2");
    }

    protected static void f3() {
        System.out.println("f3");
    }

    public static void f4() {
        System.out.println("f4");
    }

    static class C2 {
        static void f() {
            System.out.println(i1);
            System.out.println(i2);
            System.out.println(i3);
            System.out.println(i4);
            f1();
            f2();
            f3();
            f4();
        }
    }

    void func() {
        C2.f();
    }
}
```

运行结果：

```
1
2
3
4
f1
f2
f3
f4
```



#### 访问外部类的重名属性、方法

```java
public class Test {
    public static void main(String[] args) {
        C1 c = new C1();
        c.func();
    }
}

class C1 {
    static int i = 1;

    static void f() {
        System.out.println("C1.f");
    }

    static class C2 {
        static int i = 2;

        static void f() {
            System.out.println("C2.f");
        }

        static void fun() {
            System.out.println(C1.i);
            System.out.println(i);
            C1.f();
            f();
        }
    }

    void func() {
        C2.fun();
    }
}
```

运行结果：

```
1
2
C1.f
C2.f
```



#### 外部其他类访问静态内部类

##### 方式一

```java
public class Test {
    public static void main(String[] args) {
        C1.C2 c2 = new C1.C2();
        c2.f();
    }
}

class C1 {
    static class C2 {
        void f() {
            System.out.println("f");
        }
    }
}
```

运行结果：

```
f
```



##### 方式二

```java
public class Test {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C1.C2 c2 = c1.getC2();
        c2.f();
    }
}

class C1 {
    static class C2 {
        void f() {
            System.out.println("f");
        }
    }

    C2 getC2() {
        return new C2();
    }
}
```

运行结果：

```
f
```



```java
public class Test {
    public static void main(String[] args) {
        C1.C2 c2 = new C1().getC2();
        c2.f();
    }
}

class C1 {
    static class C2 {
        void f() {
            System.out.println("f");
        }
    }

    C2 getC2() {
        return new C2();
    }
}
```

运行结果：

```
f
```



```java
public class Test {
    public static void main(String[] args) {
        C1.C2 c2 = C1.getC2();
        c2.f();
    }
}

class C1 {
    static class C2 {
        void f() {
            System.out.println("f");
        }
    }

    static C2 getC2() {
        return new C2();
    }
}
```

运行结果：

```
f
```



##### 方式三

```java
public class Test {
    public static void main(String[] args) {
        C1.C2.f();
    }
}

class C1 {
    static class C2 {
        static void f() {
            System.out.println("f");
        }
    }
}
```

运行结果：

```
f
```

