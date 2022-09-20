# 【Java集合】HashSet



[toc]



## HashSet

HashSet：无序、无下标、元素不可重复
	存储结构：哈希表
	实现：数组 + 链表 + 红黑树（JDK≥1.8）
	计算元素存放位置：hashCode

相关链接：
[Class HashSet<E>](https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html)
![](D:\Notes\Java\Java集合\img\HashSet All Methods.png)



## 添加元素

### add

```java
import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		h.add("abc");
		h.add("abc");
		h.add("def");
		h.add("ghi");
		System.out.println(h.size());
		System.out.println(h);
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

```
```



## 遍历元素

### for

```java
import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		h.add("abc");
		h.add("def");
		h.add("ghi");
		for (String s : h) {
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
import java.util.HashSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		h.add("abc");
		h.add("def");
		h.add("ghi");
		Iterator<String> it = h.iterator();
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



## 示例

```java
import java.util.HashSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		HashSet<Student> h = new HashSet<Student>();
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		h.add(s1);
		h.add(s2);
		h.add(s3);
		System.out.println(h.size());
		System.out.println(h);

		h.remove(new Student("李四", 19));
		System.out.println(h.size());
		System.out.println(h);

		for (Student s : h) {
			System.out.println(s);
		}

		Iterator<Student> it = h.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(h.contains(new Student("张三", 18)));

		System.out.println(h.isEmpty());
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
		return "Student[Name:" + name + " Age:" + age + "]";
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

	public int hashCode() {
		return name.hashCode() + age;
	}
}
```

运行结果：

```
3
[Studnet[Name:张三 Age:18], Studnet[Name:王五 Age:20], Studnet[Name:李四 Age:19]]
2
[Studnet[Name:张三 Age:18], Studnet[Name:王五 Age:20]]
Studnet[Name:张三 Age:18]
Studnet[Name:王五 Age:20]
Studnet[Name:张三 Age:18]
Studnet[Name:王五 Age:20]
true
false
```

