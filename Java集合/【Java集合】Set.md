# 【Java集合】Set



[toc]



## Set

Set：无序、无下标、元素不可重复

相关链接：
[Interface Set<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)



## 添加元素

### add

```java
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("abc");
		s.add("abc");
		s.add("def");
		s.add("ghi");
		System.out.println(s.size());
		System.out.println(s);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



### addAll

```java
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("abc");
		s1.add("def");
		s2.add("abc");
		s2.add("ghi");
		s1.addAll(s2);
		System.out.println(s1.size());
		System.out.println(s1);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



## 删除元素

### remove

```java
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("abc");
		s.add("def");
		s.add("ghi");
		s.remove("abc");
		System.out.println(s.size());
		System.out.println(s);
	}
}
```

运行结果：

```
2
[def, ghi]
```



## 遍历元素

### for

```java
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("abc");
		s.add("def");
		s.add("ghi");
		for (String str : s) {
			System.out.println(str);
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



### Iterator

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("abc");
		s.add("def");
		s.add("ghi");
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
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

