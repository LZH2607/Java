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



## for循环

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
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
5
6
7
8
9
```



```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0, j = 0; i < 10; i++, j += 2) {
			System.out.println(i + " " + j);
		}
	}
}
```

运行结果：

```
0 0
1 2
2 4
3 6
4 8
5 10
6 12
7 14
8 16
9 18
```



for死循环：

```
public class Test {
	public static void main(String[] args) {
		for (;;) {
			System.out.println("Hello, World!");
		}
	}
}
```



## while循环

```java
public class Test {
	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
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
6
7
8
9
```



## do-while循环

```java
public class Test {
	public static void main(String[] args) {
		int i = 0;
		do {
			System.out.println(i);
			i++;
		} while (i < 10);
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
6
7
8
9
```



## break

```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
1 0
1 1
2 0
2 1
3 0
3 1
```



```java
public class Test {
	public static void main(String[] args) {
		label: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break label;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
```



```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			label: for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break label;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
1 0
1 1
2 0
2 1
3 0
3 1
```



## continue

```java
public class Test {
	public static void main(String[] args) {
		int i = 0;
		while (i < 4) {
			i++;
			if (i == 2) {
				continue;
			}
			System.out.println(i);
		}
	}
}
```

运行结果：

```
1
3
4
```



```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					continue;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
0 3
0 4
1 0
1 1
1 3
1 4
2 0
2 1
2 3
2 4
3 0
3 1
3 3
3 4
```



```java
public class Test {
	public static void main(String[] args) {
		label: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					continue label;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
1 0
1 1
2 0
2 1
3 0
3 1
```



```java
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			label: for (int j = 0; j < 5; j++) {
				if (j == 2) {
					continue label;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
```

运行结果：

```
0 0
0 1
0 3
0 4
1 0
1 1
1 3
1 4
2 0
2 1
2 3
2 4
3 0
3 1
3 3
3 4
```



## return

略
