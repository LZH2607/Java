# 【Java】数组



[toc]



数组：
	长度确定（不可改变）
	属于引用数据类型
	可以看作对象（元素相当于成员变量）
	元素类型相同



## 声明

两种方式

```
type[] name;
type name[];
```

```java
public class Test {
	public static void main(String[] args) {
		int[] arr1;
		int arr2[];
		arr1 = new int[5];
		arr2 = new int[5];
	}
}
```



## 初始化

### 静态初始化

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}
}
```



```java
public class Test {
	public static void main(String[] args) {
		User[] userArr = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
		for (int i = 0; i < 3; i++) {
			userArr[i].printInfor();
		}
	}
}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfor() {
		System.out.println(id + " " + name);
	}
}
```

运行结果：

```
1 Tom
2 Jack
3 Mike
```



### 默认初始化

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}
}
```



### 动态初始化

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}
}
```



```java
public class Test {
	public static void main(String[] args) {
		User[] userArr = new User[3];
		userArr[0] = new User(1, "Tom");
		userArr[1] = new User(2, "Jack");
		userArr[2] = new User(3, "Mike");
		for (int i = 0; i < 3; i++) {
			userArr[i].printInfor();
		}
	}
}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfor() {
		System.out.println(id + " " + name);
	}
}
```

运行结果：

```
1 Tom
2 Jack
3 Mike
```



## 遍历

### for循环

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}
}
```



```java
public class Test {
	public static void main(String[] args) {
		User[] userArr = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
		for (int i = 0; i < 3; i++) {
			userArr[i].printInfor();
		}
	}
}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfor() {
		System.out.println(id + " " + name);
	}
}
```

运行结果：

```
1 Tom
2 Jack
3 Mike
```



### foreach循环

for循环：可以读取、可以修改
foreach循环：可以读取、不能修改

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
```



```java
public class Test {
	public static void main(String[] args) {
		User[] userArr = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
		for (User u : userArr) {
			u.printInfor();
		}
	}
}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfor() {
		System.out.println(id + " " + name);
	}
}
```

运行结果：

```
1 Tom
2 Jack
3 Mike
```

