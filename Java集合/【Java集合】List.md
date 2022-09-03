# 【Java集合】List



[toc]



## List

List：有序、有下标、元素可重复

相关链接：
[Interface List<E>](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
![](D:\Notes\Java\Java集合\img\List All Methods.png)



## 添加元素

### add

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		System.out.println(l.size());
		System.out.println(l);
	}
}
```

运行结果：

```
3
[abc, def, ghi]
```



```javascript
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add(1, "ghi");
		System.out.println(l.size());
		System.out.println(l);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("abc");
		l2.add("def");
		l2.add("ghi");
		l1.addAll(l2);
		System.out.println(l1.size());
		System.out.println(l1);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("abc");
		l2.add("def");
		l2.add("ghi");
		l1.addAll(0, l2);
		System.out.println(l1.size());
		System.out.println(l1);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		l.remove("abc");
		System.out.println(l.size());
		System.out.println(l);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		l.remove(1);
		System.out.println(l.size());
		System.out.println(l);
	}
}
```

运行结果：

```
2
[abc, ghi]
```



删除List中的int类型：

方式一：

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.remove((Object) 20);
		System.out.println(l.size());
		System.out.println(l);
	}
}
```

运行结果：

```
2
[10, 30]
```



方式二：

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.remove(new Integer(20));
		System.out.println(l.size());
		System.out.println(l);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("abc");
		l1.add("def");
		l1.add("ghi");
		l2.add("abc");
		l2.add("def");
		l1.removeAll(l2);
		System.out.println(l1.size());
		System.out.println(l1);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		l.clear();
		System.out.println(l.size());
		System.out.println(l);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		Object o = l.get(0);
		String s = (String) l.get(1);
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		for (Object o : l) {
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



### iterator

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		Iterator it = l.iterator();
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

相关链接：
[Interface ListIterator<E>](https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html)
![](D:\Notes\Java\Java集合\img\ListIterator All Methods.png)

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		ListIterator it = l.listIterator();
		while (it.hasNext()) {
			System.out.println(it.nextIndex());
			System.out.println(it.next());
		}
		while (it.hasPrevious()) {
			System.out.println(it.previousIndex());
			System.out.println(it.previous());
		}
	}
}
```

运行结果：

```
0
abc
1
def
2
ghi
2
ghi
1
def
0
abc
```



## 查找元素

### contains

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		System.out.println(l.contains("abc"));
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		l1.add("abc");
		l1.add("def");
		l1.add("ghi");
		l2.add("abc");
		l2.add("def");
		System.out.println(l1.containsAll(l2));
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		System.out.println(l.isEmpty());
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		System.out.println(l.indexOf("abc"));
	}
}
```

运行结果：

```
0
```



## 获取子列

### subList

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		l1.add("abc");
		l1.add("def");
		l1.add("ghi");
		l1.add("jkl");
		List l2 = l1.subList(1, 2);
		System.out.println(l2.size());
		System.out.println(l2);
	}
}
```

运行结果：

```
1
[def]
```

