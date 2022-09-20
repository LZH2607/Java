# 【Java集合】TreeMap



[toc]



## TreeMap

相关链接：
[Class TreeMap<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)
![](D:\Notes\Java\Java集合\img\TreeMap All Methods.png)



## 示例

### 写法一

```java
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) {
		TreeMap<Student, Integer> t = new TreeMap<Student, Integer>();
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		t.put(s1, 1);
		t.put(s2, 2);
		t.put(s3, 3);
		System.out.println(t.size());
		System.out.println(t);

		t.remove(new Student("李四", 19));
		System.out.println(t.size());
		System.out.println(t);

		for (Student key : t.keySet()) {
			System.out.println(key + ": " + t.get(key));
		}

		for (Entry<Student, Integer> e : t.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}

		System.out.println(t.containsKey(new Student("张三", 18)));

		System.out.println(t.containsValue(1));

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
{Student[Name:张三 Age:18]=1, Student[Name:李四 Age:19]=2, Student[Name:王五 Age:20]=3}
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



### 写法二

```java
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		TreeMap<Student, Integer> t = new TreeMap<Student, Integer>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int i1 = s1.getName().compareTo(s2.getName());
				int i2 = s1.getAge() - s2.getAge();
				return i1 == 0 ? i2 : i1;
			}
		});
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 19);
		Student s3 = new Student("王五", 20);

		t.put(s1, 1);
		t.put(s2, 2);
		t.put(s3, 3);
		System.out.println(t.size());
		System.out.println(t);

		t.remove(new Student("李四", 19));
		System.out.println(t.size());
		System.out.println(t);

		for (Student key : t.keySet()) {
			System.out.println(key + ": " + t.get(key));
		}

		for (Entry<Student, Integer> e : t.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}

		System.out.println(t.containsKey(new Student("张三", 18)));

		System.out.println(t.containsValue(1));

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
{Student[Name:张三 Age:18]=1, Student[Name:李四 Age:19]=2, Student[Name:王五 Age:20]=3}
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

