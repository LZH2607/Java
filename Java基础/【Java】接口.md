# 【Java】接口



[toc]



## 简单示例

### 示例一

I.java：

```java
public interface I {
	public void f1();

	public void f2();
}
```

C1.java：

```java
public class C1 implements I {
	public void f1() {
		System.out.println("C1: f1");
	}

	public void f2() {
		System.out.println("C1: f2");
	}
}
```

C2.java：

```java
public class C2 implements I {
	public void f1() {
		System.out.println("C2: f1");
	}

	public void f2() {
		System.out.println("C2: f2");
	}
}
```

C.java：

```java
public class C {
	public void func(I i) {
		i.f1();
		i.f2();
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
C1: f1
C1: f2
C2: f1
C2: f2
```



### 示例二

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

interface I {
	public void f1();

	public void f2();
}

class C1 implements I {
	public void f1() {
		System.out.println("C1: f1");
	}

	public void f2() {
		System.out.println("C1: f2");
	}
}

class C2 implements I {
	public void f1() {
		System.out.println("C2: f1");
	}

	public void f2() {
		System.out.println("C2: f2");
	}
}

class C {
	public void func(I i) {
		i.f1();
		i.f2();
	}
}
```

运行结果：

```
C1: f1
C1: f2
C2: f1
C2: f2
```



## 方法

接口中的方法都是public方法

JDK 7.0及以前：接口中的方法都是抽象方法（可以省略abstract关键字）
JDK 8.0及以后：接口中的方法可以具体实现
	静态方法：使用static关键字修饰
	默认方法：使用default关键字修饰

```java
public interface I {
	public void f1();

	public void f2();

	public static void s() {
		System.out.println("I: s");
	}

	public default void d() {
		System.out.println("I: d");
	}
}
```



## 属性

接口中的属性都是public static final属性：

```java
public class Test {
	public static void main(String[] args) {
		System.out.println(I.i);
	}
}

interface I {
	int i = 1;
}
```

运算结果：

```
1
```



## 实现

用抽象类实现接口时，可以不实现接口的抽象方法：

I.java：

```java
public interface I {
	public void f1();

	public void f2();
}
```

C.java：

```java
public abstract class C implements I{
	public void func() {
		System.out.println("Hello, World!");
	}
}
```



一个类可以同时实现多个接口：

I1.java：

```java
public interface I1 {
	public void f1();
}
```

I2.java：

```java
public interface I2 {
	public void f2();
}
```

C.java：

```java
public class C implements I1, I2 {
	public void f1() {
		System.out.println("C: f1");
	}

	public void f2() {
		System.out.println("C: f2");
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
C: f1
C: f2
```



## 继承

一个接口可以继承多个接口：

I1.java：

```java
public interface I1 {
	public void f1();
}
```

I2.java：

```java
public interface I2 {
	public void f2();
}
```

I3.java：

```java
public interface I3 extends I1, I2 {
	public void f3();
}
```

C.java：

```java
public class C implements I3 {
	public void f1() {
		System.out.println("C: f1");
	}

	public void f2() {
		System.out.println("C: f2");
	}

	public void f3() {
		System.out.println("C: f3");
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
C: f1
C: f2
C: f3
```

