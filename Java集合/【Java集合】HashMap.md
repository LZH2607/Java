# 【Java集合】HashMap



[toc]



## HashMap

HashMap：
	键值对：无序、无下标
		键：不可重复（唯一）
		值：可重复
	实现：哈希表（数组 + 链表 + 红黑树）

相关链接：
[Class HashMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
![](D:\Notes\Java\Java集合\img\HashMap All Methods.png)



## 添加元素

### put

```java
import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("Tom", 1);
		h.put("Jack", 2);
		h.put("Mike", 3);
		h.put("Mike", 4);
		System.out.println(h.size());
		System.out.println(h);
	}
}
```

运行结果：

```
3
{Mike=4, Tom=1, Jack=2}
```



## 源码分析

相关视频：
[千锋教育新版Java集合框架详解（从入门到上手） P37 13.37 HashMap源码分析（1）](https://www.bilibili.com/video/BV16K4y1x7Gi/?p=37)
[千锋教育新版Java集合框架详解（从入门到上手） P37 13.37 HashMap源码分析（2）](https://www.bilibili.com/video/BV16K4y1x7Gi/?p=38)
[千锋教育新版Java集合框架详解（从入门到上手） P37 13.37 HashMap源码分析（3）](https://www.bilibili.com/video/BV16K4y1x7Gi/?p=39)

默认容量：16

```java
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
```

默认加载因子：0.75

```java
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```

哈希表的数组：

```java
transient Node<K,V>[] table;
```

元素个数：

```java
transient int size;
```





## 示例

```java
import java.util.HashMap;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) {
		HashMap<Student, Integer> h = new HashMap<Student, Integer>();
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		h.put(s1, 1);
		h.put(s2, 2);
		h.put(s3, 3);
		System.out.println(h.size());
		System.out.println(h);

		h.remove(new Student("李四", 19));
		System.out.println(h.size());
		System.out.println(h);

		for (Student key : h.keySet()) {
			System.out.println(key + ": " + h.get(key));
		}

		for (Entry<Student, Integer> e : h.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}

		System.out.println(h.containsKey(new Student("张三", 18)));

		System.out.println(h.containsValue(1));

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
{Student[Name:张三 Age:18]=1, Student[Name:王五 Age:20]=3, Student[Name:李四 Age:19]=2}
2
{Student[Name:张三 Age:18]=1, Student[Name:王五 Age:20]=3}
Student[Name:张三 Age:18]: 1
Student[Name:王五 Age:20]: 3
Student[Name:张三 Age:18]: 1
Student[Name:王五 Age:20]: 3
true
true
false
```

