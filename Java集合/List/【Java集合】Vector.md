# 【Java集合】Vector



[toc]



## Vector

Vector：有序、有下标、元素可重复
	实现：数组
	查询：快
	增删：慢
	运行效率：慢
	线程：安全
	JDK≥1.0

相关链接：
[Class Vector<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)



## 添加元素

### add

```java
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		System.out.println(v.size());
		System.out.println(v);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



```java
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add(1, "ghi");
		System.out.println(v.size());
		System.out.println(v);
	}
}
```

运行结果：

```
3
[abc, ghi, def]
```



### addAll

```java
```

运行结果：

```
```



```java
```

运行结果：

```
```



## 获取元素

### get

```java
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		Object o = v.get(0);
		String s = (String) v.get(1);
		System.out.println(o);
		System.out.println(s);
	}
}
```

运行结果：

```
abc
def
```



### firstElement、lastElement

```java
import java.util.Enumeration;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		String f = (String) v.firstElement();
		String l = (String) v.lastElement();
		System.out.println(f);
		System.out.println(l);
	}
}
```

运行结果：

```
abc
ghi
```



### elementAt

```java
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		String s = (String) v.elementAt(1);
		System.out.println(s);
	}
}
```

运行结果：

```
def
```



## 遍历元素

### for



### elements

```java
import java.util.Enumeration;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			Object o = en.nextElement();
			System.out.println(o);
		}
	}
}
```

运行结果：

```
abc
def
ghi
```



```java
import java.util.Enumeration;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add("def");
		v.add("ghi");
		Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			String s = (String) en.nextElement();
			System.out.println(s);
		}
	}
}
```

运行结果：

```
abc
def
ghi
```



