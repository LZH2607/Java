# 【Java集合】ArrayList



[toc]



## ArrayList

ArrayList：有序、有下标、元素可重复
	实现：数组
	查询：快
	增删：慢
	运行效率：快
	线程：不安全
	JDK≥1.2

相关链接：
[Class ArrayList<E>](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
![](D:\Notes\Java\Java集合\img\ArrayList All Methods.png)



## 添加元素

### add

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add(1, "ghi");
		System.out.println(a.size());
		System.out.println(a);
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
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("abc");
		a2.add("def");
		a2.add("ghi");
		a1.addAll(a2);
		System.out.println(a1.size());
		System.out.println(a1);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("abc");
		a2.add("def");
		a2.add("ghi");
		a1.addAll(0, a2);
		System.out.println(a1.size());
		System.out.println(a1);
	}
}
```

运行结果：

```
3
[def, ghi, abc]
```



## 删除元素

### remove

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		a.remove("abc");
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
2
[def, ghi]
```



```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		a.remove(1);
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
2
[abc, ghi]
```



#### 删除ArrayList中的基本数据类型

方法一：

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(10);
		a.add(20);
		a.add(30);
		a.remove((Object) 20);
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
2
[10, 30]
```



方法二：

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(10);
		a.add(20);
		a.add(30);
		a.remove(new Integer(20));
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
2
[10, 30]
```



### removeAll

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("abc");
		a1.add("def");
		a1.add("ghi");
		a2.add("abc");
		a2.add("def");
		a1.removeAll(a2);
		System.out.println(a1.size());
		System.out.println(a1);
	}
}
```

运行结果：

```
1
[ghi]
```



### clear

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		a.clear();
		System.out.println(a.size());
		System.out.println(a);
	}
}
```

运行结果：

```
0
[]
```



## 获取元素

### get

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		Object o = a.get(0);
		String s = (String) a.get(1);
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



## 遍历元素

### for

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
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
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		for (Object o : a) {
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



### Iterator

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		Iterator it = a.iterator();
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



### ListIterator

```java
import java.util.ArrayList;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		ListIterator it = a.listIterator();
		while (it.hasNext()) {
			System.out.println(it.nextIndex() + " " + it.next());
		}
		while (it.hasPrevious()) {
			System.out.println(it.previousIndex() + " " + it.previous());
		}
	}
}
```

运行结果：

```
0 abc
1 def
2 ghi
2 ghi
1 def
0 abc
```



## 查找元素

### contains

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		System.out.println(a.contains("abc"));
	}
}
```

运行结果：

```
true
```



### containsAll

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("abc");
		a1.add("def");
		a1.add("ghi");
		a2.add("abc");
		a2.add("def");
		System.out.println(a1.containsAll(a2));
	}
}
```

运行结果：

```
true
```



### isEmpty

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		System.out.println(a.isEmpty());
	}
}
```

运行结果：

```
false
```



### indexOf

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		System.out.println(a.indexOf("abc"));
	}
}
```

运行结果：

```
0
```



### equals

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("abc");
		a1.add("def");
		a2.add("abc");
		a2.add("def");
		System.out.println(a1.equals(a2));
	}
}
```

运行结果：

```
true
```



## 获取子列

### subList

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("abc");
		a.add("def");
		a.add("ghi");
		a.add("jkl");
		List l = a.subList(1, 2);
		System.out.println(l.size());
		System.out.println(l);
	}
}
```

运行结果：

```
1
[def]
```



## 源码分析

相关视频：
[千锋教育新版Java集合框架详解（从入门到上手） P12 13.12 ArrayList源码分析](https://www.bilibili.com/video/BV16K4y1x7Gi?p=12)

默认容量：10

```java
private static final int DEFAULT_CAPACITY = 10;
```

实现：数组

```java
transient Object[] elementData;
```

元素个数：

```java
private int size;
```

