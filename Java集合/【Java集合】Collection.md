# 【Java集合】Collection



[toc]



## Collection

相关链接：
[Interface Collection<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
![](D:\Notes\Java\Java集合\img\Collection All Methods.png)



## 添加元素

### add

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		System.out.println(c.size());
		System.out.println(c);
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
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		c1.add("abc");
		c2.add("def");
		c2.add("ghi");
		c1.addAll(c2);
		System.out.println(c1.size());
		System.out.println(c1);
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
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		c.remove("abc");
		System.out.println(c.size());
		System.out.println(c);
	}
}
```

运行结果：

```
2
[def, ghi]
```



#### 删除Collection中的基本数据类型

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(10);
		c.add(20);
		c.add(30);
		c.remove(20);
		System.out.println(c.size());
		System.out.println(c);
	}
}
```

运行结果：

```
2
[10, 30]
```



```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(1.1);
		c.add(2.2);
		c.add(3.3);
		c.remove(2.2);
		System.out.println(c.size());
		System.out.println(c);
	}
}
```

运行结果：

```
2
[1.1, 3.3]
```



### clear

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		c.clear();
		System.out.println(c.size());
		System.out.println(c);
	}
}
```

运行结果：

```
0
[]
```



### removeAll

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		c1.add("abc");
		c1.add("def");
		c1.add("ghi");
		c2.add("abc");
		c2.add("def");
		c1.removeAll(c2);
		System.out.println(c1.size());
		System.out.println(c1);
	}
}
```

运行结果：

```
1
[ghi]
```



## 遍历元素

### for

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		for (Object o : c) {
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

相关链接：
[Interface Iterator<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)![](D:\Notes\Java\Java集合\img\Iterator All Methods.png)

```java
boolean java.util.Iterator.hasNext();
Object java.util.Iterator.next();
void java.util.Iterator.remove();
```

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		Iterator it = c.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
			it.remove();
		}
		System.out.println(c.size());
		System.out.println(c);
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



## 查找元素

### contains

```java
import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		System.out.println(c.contains("abc"));
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
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		c1.add("abc");
		c1.add("def");
		c1.add("ghi");
		c2.add("abc");
		System.out.println(c1.containsAll(c2));
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
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add("def");
		c.add("ghi");
		System.out.println(c.isEmpty());
	}
}
```

运行结果：

```
false
```



## 示例

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		c.add(s1);
		c.add(s2);
		c.add(s3);
		System.out.println(c.size());
		System.out.println(c);

		c.remove(new Student("李四", 19));
		System.out.println(c.size());
		System.out.println(c);

		for (Object o : c) {
			Student s = (Student) o;
			System.out.println(s);
		}

		Iterator it = c.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s);
		}

		System.out.println(c.isEmpty());
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
		return "Name:" + name + " Age:" + age;
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
[Name:张三 Age:18, Name:李四 Age:19, Name:王五 Age:20]
2
[Name:张三 Age:18, Name:王五 Age:20]
Name:张三 Age:18
Name:王五 Age:20
Name:张三 Age:18
Name:王五 Age:20
false
```

