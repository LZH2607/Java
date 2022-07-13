# 【Java】数组



[toc]



数组：
	长度确定（不可改变）
	属于引用数据类型
	可以看作对象（元素相当于成员变量）
	元素类型相同



## 声明、初始化、赋值

声明：两种方式

```
type[] name;
type name[];
```

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
	}
}
```



## 遍历

```java
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
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





