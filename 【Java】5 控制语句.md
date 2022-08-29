# 【Java】控制语句



[toc]



## 单分支

```java
public class Test {
	public static void main(String[] args) {
		boolean b = true;
		if (b) {
			System.out.println("1");
		}
	}
}
```

运行结果：

```
1
```



## 双分支

```java
public class Test {
	public static void main(String[] args) {
		boolean b = true;
		if (b) {
			System.out.println("1");
		} else {
			System.out.println("2");
		}
	}
}
```

运行结果：

```
1
```



## 多分支

```java
public class Test {
	public static void main(String[] args) {
		boolean b1 = false;
		boolean b2 = true;
		if (b1) {
			System.out.println("1");
		} else if (b2) {
			System.out.println("2");
		} else {
			System.out.println("3");
		}
	}
}
```

运行结果：

```
2
```



经典问题：

```java
public class Test {
	public static void main(String[] args) {
		boolean b = true;
		if (b = false) {
			System.out.println("1");
		} else if (b) {
			System.out.println("2");
		} else if (!b) {
			System.out.println("3");
		} else {
			System.out.println("4");
		}
	}
}
```

运行结果：

```
3
```



## switch分支

```java
public class Test {
	public static void main(String[] args) {
		char c = 'a';
		switch (c) {
		case 'a':
			System.out.println("1");
			break;
		case 'b':
			System.out.println("2");
			break;
		case 'c':
			System.out.println("3");
			break;
		case 'd':
			System.out.println("4");
			break;
		default:
			System.out.println("5");
		}
	}
}
```

运行结果：

```
1
```



switch分支可以使用的数据类型：byte、short、int、char、enum、String

```java
public class Test {
	public static void main(String[] args) {
		String s = "abc";
		switch (s) {
		case "abc":
			System.out.println("1");
			break;
		case "def":
			System.out.println("2");
			break;
		case "ghi":
			System.out.println("3");
			break;
		default:
			System.out.println("4");
		}
	}
}
```

运行结果：

```
1
```



```java
public class Test {
	public static void main(String[] args) {
		char c = 'A'; // 65
		switch (c) {
		case 65:
			System.out.println("1");
			break;
		case 66:
			System.out.println("2");
			break;
		case 67:
			System.out.println("3");
			break;
		default:
			System.out.println("4");
		}
	}
}
```

运行结果：

```
1
```



```java
public class Test {
	public static void main(String[] args) {
		char c = 'A';
		switch (c) {
		case 'A':
			System.out.println("1");
			break;
		case 'A' + 1:
			System.out.println("2");
			break;
		case 'A' + 2:
			System.out.println("3");
			break;
		default:
			System.out.println("4");
		}
	}
}
```

运行结果：

```
1
```



```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("请输入月份：");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("春季");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏季");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋季");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("冬季");
		}
	}
}
```

