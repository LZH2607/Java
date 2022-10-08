# 【Java集合】TreeSet



[toc]



## TreeSet

TreeSet：有序、无下标、元素不可重复（基于排序实现）

相关链接：
[Class TreeSet<E>](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html)
![](D:\Notes\Java\Java集合\img\TreeSet All Methods.png)



## 添加元素

### add

```java
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<String>();
		t.add("abc");
		t.add("abc");
		t.add("def");
		t.add("ghi");
		System.out.println(t.size());
		System.out.println(t);
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



## 遍历元素

### for

```java
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<String>();
		t.add("abc");
		t.add("def");
		t.add("ghi");
		for (String s : t) {
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



## Iterator

```java
import java.util.TreeSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<String>();
		t.add("abc");
		t.add("def");
		t.add("ghi");
		Iterator<String> it = t.iterator();
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

### 写法一

```java
import java.util.TreeSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		TreeSet<Student> t = new TreeSet<Student>();
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		t.add(s1);
		t.add(s2);
		t.add(s3);
		System.out.println(t.size());
		System.out.println(t);

		t.remove(new Student("李四", 19));
		System.out.println(t.size());
		System.out.println(t);

		for (Student s : t) {
			System.out.println(s);
		}

		Iterator<Student> it = t.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(t.contains(new Student("张三", 18)));

		System.out.println(t.isEmpty());
	}
}

class Student implements Comparable<Student> {
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

	public int compareTo(Student s) {
		int i1 = name.compareTo(s.getName());
		int i2 = age - s.getAge();
		return i1 == 0 ? i2 : i1;
	}
}
```

运行结果：

```
3
[Student[Name:张三 Age:19], Student[Name:张三 Age:20], Student[Name:王五 Age:20]]
3
[Student[Name:张三 Age:19], Student[Name:张三 Age:20], Student[Name:王五 Age:20]]
Student[Name:张三 Age:19]
Student[Name:张三 Age:20]
Student[Name:王五 Age:20]
Student[Name:张三 Age:19]
Student[Name:张三 Age:20]
Student[Name:王五 Age:20]
false
false
```



### 写法二

```java
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		TreeSet<Student> t = new TreeSet<Student>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int i1 = s1.getName().compareTo(s2.getName());
				int i2 = s1.getAge() - s2.getAge();
				return i1 == 0 ? i2 : i1;
			}
		});
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		t.add(s1);
		t.add(s2);
		t.add(s3);
		System.out.println(t.size());
		System.out.println(t);

		t.remove(new Student("李四", 19));
		System.out.println(t.size());
		System.out.println(t);

		for (Student s : t) {
			System.out.println(s);
		}

		Iterator<Student> it = t.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(t.contains(new Student("张三", 18)));

		System.out.println(t.isEmpty());
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
[Student[Name:张三 Age:18], Student[Name:李四 Age:19], Student[Name:王五 Age:20]]
2
[Student[Name:张三 Age:18], Student[Name:王五 Age:20]]
Student[Name:张三 Age:18]
Student[Name:王五 Age:20]
Student[Name:张三 Age:18]
Student[Name:王五 Age:20]
true
false
```

