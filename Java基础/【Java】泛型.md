# 【Java】泛型



[toc]



## 泛型类

### 写法一

```java
public class Test {
	public static void main(String[] args) {
		C<Integer> c1 = new C(1);
		C<Double> c2 = new C(1.0);
		C<String> c3 = new C("Hello, World!");

		System.out.println(c1.getT());
		System.out.println(c2.getT());
		System.out.println(c3.getT());
	}
}

class C<T> {
	T t;

	C(T t) {
		this.t = t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```



### 写法二

```java
public class Test {
	public static void main(String[] args) {
		C<Integer> c1 = new C<Integer>(1);
		C<Double> c2 = new C<Double>(1.0);
		C<String> c3 = new C<String>("Hello, World!");

		System.out.println(c1.getT());
		System.out.println(c2.getT());
		System.out.println(c3.getT());
	}
}

class C<T> {
	T t;

	C(T t) {
		this.t = t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```



### 写法三

```java
public class Test {
	public static void main(String[] args) {
		C<Integer> c1 = new C<>(1);
		C<Double> c2 = new C<>(1.0);
		C<String> c3 = new C<>("Hello, World!");

		System.out.println(c1.getT());
		System.out.println(c2.getT());
		System.out.println(c3.getT());
	}
}

class C<T> {
	T t;

	C(T t) {
		this.t = t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```



## 泛型接口

### 方法一

```java
public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1();
		C2 c2 = new C2();
		C3 c3 = new C3();

		c1.func(1);
		c2.func(1.0);
		c3.func("Hello, World!");
	}
}

interface I<T> {
	void func(T t);
}

class C1 implements I<Integer> {
	public void func(Integer i) {
		System.out.println(i);
	}
}

class C2 implements I<Double> {
	public void func(Double d) {
		System.out.println(d);
	}
}

class C3 implements I<String> {
	public void func(String s) {
		System.out.println(s);
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```



### 方法二

```java
public class Test {
	public static void main(String[] args) {
		C<Integer> c1 = new C<Integer>();
		C<Double> c2 = new C<Double>();
		C<String> c3 = new C<String>();

		c1.func(1);
		c2.func(1.0);
		c3.func("Hello, World!");
	}
}

interface I<T> {
	void func(T t);
}

class C<T> implements I<T> {
	public void func(T t) {
		System.out.println(t);
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```



## 泛型方法

```java
public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.func(1);
		c.func(1.0);
		c.func("Hello, World!");
	}
}

class C {
	public <T> void func(T t) {
		System.out.println(t);
	}
}
```

运行结果：

```
1
1.0
Hello, World!
```

