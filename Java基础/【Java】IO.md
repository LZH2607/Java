# 【Java】IO



[toc]



## 概念

输入流：程序（内存） ← 文件（磁盘）
输出流：程序（内存） → 文件（磁盘）

输入流
	InputStream
		FileInputStream
		BufferedInputStream
		ObjectInputStream
	Reader
		FileReader
		BufferedReader
		InputStreamReader
输出流
	OutputStream
		FileOutputStream
		BufferedOutputStream
		ObjectOutputStream
	Writer
		FileWriter
		BufferedWriter
		OutputStreamWriter



## File

**目录 = 文件**



### createNewFile

```java
import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo\\file.txt";
        File file = new File(path);
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

运行结果：

```
true
```



```java
import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        String parent = "D:\\";
        String child = "demo\\file.txt";
        File parentFile = new File(parent);
        File childFile = new File(parentFile, child);
        try {
            System.out.println(childFile.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

运行结果：

```
true
```



```java
import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        String parent = "D:\\";
        String child = "demo\\file.txt";
        File file = new File(parent, child);
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

运行结果：

```
true
```



### mkdir

```java
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo";
        File file = new File(path);
        System.out.println(file.mkdir());
    }
}
```

运行结果：

```
true
```



### mkdirs

```java
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo1\\demo2\\demo3";
        File file = new File(path);
        System.out.println(file.mkdirs());
    }
}
```

运行结果：

```
true
```



### 获取文件信息

```java
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo\\file.txt";
        File file = new File(path);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
```

运行结果：

```
file.txt
D:\demo\file.txt
D:\demo
0
true
true
false
```



### delete

```java
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo\\file.txt";
        File file = new File(path);
        System.out.println(file.delete());
    }
}
```

运行结果：

```
true
```



```java
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "D:\\demo";
        File file = new File(path);
        System.out.println(file.delete());
    }
}
```

运行结果：

```
true
```
