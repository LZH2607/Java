# 【Java集合】Collections



[toc]



## Collections

相关链接：
[Class Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)
![](D:\Notes\Java\Java集合\img\Collections All Methods.png)



## 排序

### sort

```java
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(4);
		a.add(1);
		a.add(3);
		a.add(2);
		a.add(0);
		System.out.println(a);
		Collections.sort(a);
		System.out.println(a);
	}
}
```

运行结果：

```
[4, 1, 3, 2, 0]
[0, 1, 2, 3, 4]
```



## 搜索

### binarySearch

```java
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(a);
		int i = Collections.binarySearch(a, 2);
		System.out.println(i);
	}
}
```

运行结果：

```
[0, 1, 2, 3, 4]
2
```



## 反转

### reverse

```java
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(a);
		Collections.reverse(a);
		System.out.println(a);
	}
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[4, 3, 2, 1, 0]
```



## 打乱

### shuffle

```java
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(a);
		Collections.shuffle(a);
		System.out.println(a);
	}
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[3, 4, 1, 0, 2]
```

