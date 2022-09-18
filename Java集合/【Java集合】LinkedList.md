# 【Java集合】LinkedList



[toc]



## LinkedList

LinkedList：有序、有下标、元素可重复
	实现：链表
	查询：慢
	增删：快
	运行效率：
	线程：
	JDK

相关链接：
[Class LinkedList<E>](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)



## 添加元素

### add

```java
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
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
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
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



## 遍历元素

### for



### Iterator



### ListIterator



## 源码分析

相关视频：
[千锋教育新版Java集合框架详解（从入门到上手） P15 13.15 LinkedList源码分析](https://www.bilibili.com/video/BV16K4y1x7Gi?p=15)

元素个数：

```java
transient int size = 0;
```

头节点

```java
transient Node<E> first;
```

尾节点：

```java
transient Node<E> last;
```

