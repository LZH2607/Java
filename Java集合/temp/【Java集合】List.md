# 【Java集合】List



[toc]



## List

List：有序、有下标、元素可重复

相关链接：
[Interface List<E>](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
![](D:\Notes\Java\Java集合\img\List All Methods.png)



## 添加元素

### add

#### 用法一

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
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



#### 用法二

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList();
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

#### 用法一

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
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



#### 用法二

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
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

#### 用法一

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
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



#### 用法二

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
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



#### 删除List中的基本数据类型

方式一：

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
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

public class Test {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
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
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
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
		List<String> l = new ArrayList<>();
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
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		String s = (String) l.get(1);
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

#### 方式一

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
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



#### 方式二

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		for (String s : l) {
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



### Iterator

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		Iterator<String> it = l.iterator();
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
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		ListIterator<String> it = l.listIterator();
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
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
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
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
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
		List<String> l = new ArrayList<>();
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
		List<String> l = new ArrayList<>();
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



### equals

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		l1.add("abc");
		l1.add("def");
		l2.add("abc");
		l2.add("def");
		System.out.println(l1.equals(l2));
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
		List<String> l1 = new ArrayList<>();
		l1.add("abc");
		l1.add("def");
		l1.add("ghi");
		l1.add("jkl");
		List<String> l2 = l1.subList(1, 2);
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



## 转换

### List → 数组：toArray

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		String arr[] = l.toArray(new String[l.size()]);
		System.out.println(l);
		System.out.println(Arrays.toString(arr));
	}
}
```

运行结果：

```
[abc, def, ghi]
[abc, def, ghi]
```



### 数组 → List：asList（Arrays）

转换后：受限（不能添加、删除元素）



#### 基本数据类型的数组 → List

```java
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3 };
		List<Integer> l = Arrays.asList(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(l);
	}
}
```

运行结果：

```
[1, 2, 3]
[1, 2, 3]
```



#### 引用数据类型的数组 → List

```java
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String arr[] = { "abc", "def", "ghi" };
		List<String> l = Arrays.asList(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(l);
	}
}
```

运行结果：

```
[abc, def, ghi]
[abc, def, ghi]
```

