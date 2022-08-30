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
数据类型[] 数组名;
数据类型 数组名[];
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



## 长度

```java
public class Test {
	public static void main(String[] args) {
		int arr[] = new int[5];
		System.out.println(arr.length);
	}
}
```

运行结果：

```
5
```



## 初始化

### 静态初始化

```
数据类型 数组名[] = {元素1, 元素2, ···, 元素n};
```



```java
public class Test {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		User userArr[] = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
		for (int i = 0; i < userArr.length; i++) {
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



### 动态初始化

#### 方式1

```
数据类型 数组名[] = new 数据类型[大小];
```



```java
public class Test {
	public static void main(String[] args) {
		int arr[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
0
0
0
0
```



```java
public class Test {
	public static void main(String[] args) {
		int arr[] = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		User userArr[] = new User[3];
		userArr[0] = new User(1, "Tom");
		userArr[1] = new User(2, "Jack");
		userArr[2] = new User(3, "Mike");
		for (int i = 0; i < userArr.length; i++) {
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



#### 方式2

```
数据类型 数组名[];
数组名 = new 数据类型[大小];
```



```java
public class Test {
	public static void main(String[] args) {
		int arr[];
		arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
0
0
0
0
```



```java
public class Test {
	public static void main(String[] args) {
		int arr[];
		arr = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		User userArr[];
		userArr = new User[3];
		userArr[0] = new User(1, "Tom");
		userArr[1] = new User(2, "Jack");
		userArr[2] = new User(3, "Mike");
		for (int i = 0; i < userArr.length; i++) {
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
		int arr[] = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		User userArr[] = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
		for (int i = 0; i < userArr.length; i++) {
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
		int arr[] = { 0, 1, 2, 3, 4 };
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		User userArr[] = { new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike") };
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



## 自动类型转换

```java
public class Test {
	public static void main(String[] args) {
		double arr[] = { 0, 1.1, 2, 3.3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0.0
1.1
2.0
3.3
4.0
```



## 默认赋值

| 数据类型 | 默认赋值 |
| :------: | :------: |
|   byte   |    0     |
|  short   |    0     |
|   int    |    0     |
|   long   |    0     |
|  float   |   0.0    |
|  double  |   0.0    |
|   char   |  \u0000  |
| boolean  |  false   |
|  String  |   null   |



## 赋值

引用传递/地址传递

```java
public class Test {
	public static void main(String[] args) {
		int arr1[] = { 0, 1, 2, 3, 4 };
		int arr2[] = arr1;
		arr2[0] = -1;
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}
}
```

运行结果：

```
-1
1
2
3
4
-1
1
2
3
4
```



## 拷贝

```java
public class Test {
	public static void main(String[] args) {
		int arr1[] = { 0, 1, 2, 3, 4 };
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
0
1
2
3
4
```



## 扩容

```java
public class Test {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4 };
		int temp[] = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = 5;
		arr = temp;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
0
1
2
3
4
5
```



## 查找

### 顺序查找

```
```



### 二分查找

```
```



## 反转

### 方法1

```java
public class Test {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4 };
		for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
4
3
2
1
0
```



### 方法2

```java
public class Test {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4 };
		int temp[] = new int[arr.length];
		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			temp[j] = arr[i];
		}
		arr = temp;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
4
3
2
1
0
```



## 排序

### 冒泡排序

```java
public class Test {
	public static void main(String[] args) {
		int arr[] = { 24, 69, 80, 57, 13 };
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
```

运行结果：

```
13
24
57
69
80
```

