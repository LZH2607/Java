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



## 打印

### 打印基本数据类型的ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
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



### 打印引用数据类型的ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
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
        List<String> l = new ArrayList<>();
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



#### 删除ArrayList中的基本数据类型

##### 方法一

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



##### 方法二

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



### retainAll

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
        l2.add("jkl");
        l1.retainAll(l2);
        System.out.println(l1.size());
        System.out.println(l1);
    }
}
```

运行结果：

```
2
[abc, def]
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



## 改变元素

### set

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        l.set(1, "jkl");
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[abc, jkl, ghi]
```



### replaceAll

```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        l.replaceAll(e -> e.toUpperCase());
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[ABC, DEF, GHI]
```



```java
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.replaceAll(e -> e * 2);
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[2, 4, 6]
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
        System.out.println(l.indexOf("def"));
    }
}
```

运行结果：

```
1
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

相关链接：
[Interface Iterator<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)![](D:\Notes\Java\Java集合\img\Iterator All Methods.png)

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
            it.remove();
        }
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
abc
def
ghi
0
[]
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
        ListIterator<String> it = l.listIterator(1);
        System.out.println(it.nextIndex() + " " + it.next());
    }
}
```

运行结果：

```
1 def
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



## 排序

### 自然顺序

#### sort

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("def");
        l.add("ghi");
        l.add("abc");
        l.sort(Comparator.naturalOrder());
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
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(1);
        l.add(2);
        l.sort(Comparator.naturalOrder());
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[1, 2, 3]
```



#### Collections.sort

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("def");
        l.add("ghi");
        l.add("abc");
        Collections.sort(l, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(1);
        l.add(2);
        Collections.sort(l, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[1, 2, 3]
```



### 倒序

#### sort

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        l.sort(Comparator.reverseOrder());
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[ghi, def, abc]
```



```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.sort(Comparator.reverseOrder());
        System.out.println(l.size());
        System.out.println(l);
    }
}
```

运行结果：

```
3
[3, 2, 1]
```



### 自定义排序

#### sort

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<C> l = new ArrayList<>();
        l.add(new C(1, 3));
        l.add(new C(2, 2));
        l.add(new C(2, 1));
        l.add(new C(1, 1));
        l.add(new C(2, 3));
        l.add(new C(1, 2));
        l.sort(new Comparator<C>() {
            public int compare(C c1, C c2) {
                if (c1.i1 != c2.i1) {
                    return c1.i1 - c2.i1;
                }
                return c1.i2 - c2.i2;
            }
        });
        System.out.println(l.size());
        System.out.println(l);
    }
}

class C {
    int i1;
    int i2;

    C(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public String toString() {
        return "C{i1:" + i1 + ", i2:" + i2 + "}";
    }
}
```

运行结果：

```
6
[C{i1:1, i2:1}, C{i1:1, i2:2}, C{i1:1, i2:3}, C{i1:2, i2:1}, C{i1:2, i2:2}, C{i1:2, i2:3}]
```



#### Collections.sort

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<C> l = new ArrayList<>();
        l.add(new C(1, 3));
        l.add(new C(2, 2));
        l.add(new C(2, 1));
        l.add(new C(1, 1));
        l.add(new C(2, 3));
        l.add(new C(1, 2));
        Collections.sort(l, new Comparator<C>() {
            public int compare(C c1, C c2) {
                if (c1.i1 != c2.i1) {
                    return c1.i1 - c2.i1;
                }
                return c1.i2 - c2.i2;
            }
        });
        System.out.println(l.size());
        System.out.println(l);
    }
}

class C {
    int i1;
    int i2;

    C(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public String toString() {
        return "C{i1:" + i1 + ", i2:" + i2 + "}";
    }
}
```

运行结果：

```
6
[C{i1:1, i2:1}, C{i1:1, i2:2}, C{i1:1, i2:3}, C{i1:2, i2:1}, C{i1:2, i2:2}, C{i1:2, i2:3}]
```



## 转换

### ArrayList → 数组：toArray

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
        String[] arr = l.toArray(new String[l.size()]);
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



### 数组 → List：Arrays.asList

转换后：受限（不能添加、删除元素）

```java
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] arr = {"abc", "def", "ghi"};
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



### ArrayList → HashSet

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        l.add("ghi");
        Set<String> s = new HashSet<>(l);
        System.out.println(l);
        System.out.println(s);
    }
}
```

运行结果：

```
[abc, def, ghi]
[abc, def, ghi]
```



### HashSet → ArrayList

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("abc");
        s.add("def");
        s.add("ghi");
        List<String> l = new ArrayList<>(s);
        System.out.println(s);
        System.out.println(l);
    }
}
```

运行结果：

```
[abc, def, ghi]
[abc, def, ghi]
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



## 示例

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();

        l.add(new Student("张三", 18));
        l.add(new Student("李四", 19));
        l.add(new Student("王五", 20));
        System.out.println(l.size());
        System.out.println(l);

        l.remove(new Student("李四", 19));
        System.out.println(l.size());
        System.out.println(l);

        for (Student s : l) {
            System.out.println(s);
        }

        ListIterator<Student> it = l.listIterator();
        while (it.hasNext()) {
            System.out.println(it.nextIndex() + " " + it.next());
        }
        while (it.hasPrevious()) {
            System.out.println(it.previousIndex() + " " + it.previous());
        }

        System.out.println(l.contains(new Student("张三", 18)));

        System.out.println(l.indexOf(new Student("王五", 20)));

        System.out.println(l.isEmpty());
    }
}

class Student {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{Name:" + name + ", Age:" + age + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (this.name == s.name && this.age == s.age) {
                return true;
            }
        }
        return false;
    }
}
```

运行结果：

```
3
[Student{Name:张三, Age:18}, Student{Name:李四, Age:19}, Student{Name:王五, Age:20}]
2
[Student{Name:张三, Age:18}, Student{Name:王五, Age:20}]
Student{Name:张三, Age:18}
Student{Name:王五, Age:20}
0 Student{Name:张三, Age:18}
1 Student{Name:王五, Age:20}
1 Student{Name:王五, Age:20}
0 Student{Name:张三, Age:18}
true
1
false
```

