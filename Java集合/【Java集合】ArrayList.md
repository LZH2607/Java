# 【Java集合】ArrayList



[toc]



## ArrayList

List：有序、有下标、元素可重复

相关链接：
[Class ArrayList<E>](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
![](D:\Notes\Java\Java集合\img\ArrayList All Methods.png)



## 添加元素

### add

```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
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



```java
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
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

public class Test {
	public static void main(String[] args) {
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
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

public class Test {
	public static void main(String[] args) {
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
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

public class Test {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
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

public class Test {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
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



### removeAll



### clear



## 获取元素

### get



## 遍历元素

### for



## 查找元素



## 获取子列

