# 【Java】转义字符



```java
public class Test {
	public static void main(String[] args) {
		System.out.println("aaa\tbbb\tccc");  // \t
		System.out.println("aaa\nbbb\nccc");  // \n
		System.out.println("aaa\\bbb\\ccc");  // \\
		System.out.println("aaa\"bbb\"ccc");  // \"
		System.out.println("aaa\'bbb\'ccc");  // \'
		System.out.println("aaa\rbbb\rccc");  // \r
	}
}
```

运行结果：

```
aaa	bbb	ccc
aaa
bbb
ccc
aaa\bbb\ccc
aaa"bbb"ccc
aaa'bbb'ccc
aaa
bbb
ccc
```

