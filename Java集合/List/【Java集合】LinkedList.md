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
![](D:\Notes\Java\Java集合\img\LinkedList All Methods.png)



## 打印

### 打印基本数据类型的LinkedList

```java
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
    }
}
```

运行结果：

```
[1, 2, 3]
```



### 打印引用数据类型的LinkedList

```java
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> l = new LinkedList<>();
        l.add(new Student("Tom", 18));
        l.add(new Student("Jack", 19));
        l.add(new Student("Mike", 20));
        System.out.println(l);
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student{Name:" + name + ", Age:" + age + "}";
    }
}
```

运行结果：

```
[Student{Name:Tom, Age:18}, Student{Name:Jack, Age:19}, Student{Name:Mike, Age:20}]
```



## 添加元素

### add

#### 用法一

```java
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
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
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
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
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l1 = new LinkedList<>();
        List<String> l2 = new LinkedList<>();
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
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l1 = new LinkedList<>();
        List<String> l2 = new LinkedList<>();
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
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
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
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
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



#### 删除ArrayList中的基本数据类型

##### 方法一



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

