# 【Java】IO



[toc]



## 概念

流的分类：
	按数据单位分：字节流、字符流
	按数据流向分：输入流、输出流
	按角色分：节点流、处理流 / 包装流

输入流：程序（内存） ← 文件（磁盘）
输出流：程序（内存） → 文件（磁盘）

|        |           字节流           |        字符流        |
| :----: | :------------------------: | :------------------: |
| 输入流 | InputStream（字节输入流）  | Reader（字符输入流） |
| 输出流 | OutputStream（字节输出流） | Writer（字符输出流） |



### 节点流

程序 ← 文件：FileInputStream（文件字节输入流）、FileReader（文件字符输入流）
程序 → 文件：FileOutputStream（文件字节输出流）、FileWriter（文件字符输出流）

程序 ← 数组：ByteArrayInputStream（字节数组输入流）、CharArrayInputStream（字符数组输入流）
程序 → 数组：ByteArrayOutputStream（字节数组输出流）、CharArrayOutputStream（字符数组输出流）

程序 ← 管道：PipedInputStream（管道字节输入流）、PipedReader（管道字符输入流）
程序 → 管道：PipedOutputStream（管道字节输出流）、PipedWriter（管道字符输出流）

程序 ← 字符串：StringReader（字符串输入流）
程序 → 字符串：StringWriter（字符串输出流）



### 处理流 / 包装流

装饰器模式

字节流
	InputStream（字节输入流）
		BufferedInputStream（缓冲区字节输入流）
		ObjectInputStream（对象字节输入流）
	OutputStream（字节输出流）
		BufferedOutputStream（缓冲区字节输出流）
		ObjectOutputStream（对象字节输出流）

字符流
	Reader（字符输入流）
		BufferedReader（缓冲区字符输入流）
		InputStreamReader（）
	Writer（字符输出流）
		BufferedWriter（缓冲区字符输出流）
		OutputStreamWriter（）



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
        String parentPath = "D:\\";
        String childPath = "demo\\file.txt";
        File parentFile = new File(parentPath);
        File childFile = new File(parentFile, childPath);
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
        String parentPath = "D:\\";
        String childPath = "demo\\file.txt";
        File file = new File(parentPath, childPath);
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



## FileInputStream、FileOutputStream

### FileInputStream

```java
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        int i;
        while ((i = fileInputStream.read()) != -1) {
            System.out.println((char) i);
        }
        fileInputStream.close();
    }
}
```

file.txt：

```
Hello, World!
```

运行结果：

```
H
e
l
l
o
,
 
W
o
r
l
d
!
```



```java
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] arr = new byte[5];
        while ((fileInputStream.read(arr)) != -1) {
            System.out.println(new String(arr));
        }
        fileInputStream.close();
    }
}
```

file.txt：

```
Hello, World!
```

运行结果：

```
Hello
, Wor
ld!or
```



```java
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] arr = new byte[5];
        int len;
        while ((len = fileInputStream.read(arr)) != -1) {
            System.out.println(new String(arr, 0, len));
        }
        fileInputStream.close();
    }
}
```

file.txt：

```
Hello, World!
```

运行结果：

```
Hello
, Wor
ld!
```



### FileOutputStream

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write('a');
        fileOutputStream.close();
    }
}
```

file.txt（程序运行后）：

```
a
```



```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        FileOutputStream fileOutputStream1 = new FileOutputStream(path1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(path2);
        String str = "Hello, World!";
        fileOutputStream1.write(str.getBytes());
        fileOutputStream2.write(str.getBytes(), 8, 3);
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
```

file1.txt（程序运行后）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
orl
```



```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path, true);
        String str = "abc";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
}
```

file.txt（程序运行前）：

```
Hello, World!
```

file.txt（程序运行后）：

```
Hello, World!abc
```



### 拷贝文件

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        byte[] arr = new byte[5];
        int len;
        while ((len = fileInputStream.read(arr)) != -1) {
            fileOutputStream.write(arr, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
```

file1.txt（程序运行前）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
Hello, World!
```



## FileReader、FileWriter

###  FileReader

```java
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileReader fileReader = new FileReader(path);
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.println((char) i);
        }
        fileReader.close();
    }
}
```

file.txt：

```
Hello, World!
你好，世界！
```

运行结果：

```
H
e
l
l
o
,
 
W
o
r
l
d
!



你
好
，
世
界
！
```



```java
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileReader fileReader = new FileReader(path);
        char[] arr = new char[5];
        while ((fileReader.read(arr)) != -1) {
            System.out.println(new String(arr));
        }
        fileReader.close();
    }
}
```

file.txt：

```
Hello, World!
你好，世界！
```

运行结果：

```
Hello
, Wor
ld!

你好，世界
！好，世界
```



```java
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileReader fileReader = new FileReader(path);
        char[] arr = new char[5];
        int len;
        while ((len = fileReader.read(arr)) != -1) {
            System.out.println(new String(arr, 0, len));
        }
        fileReader.close();
    }
}
```

file.txt：

```
Hello, World!
你好，世界！
```

运行结果：

```
Hello
, Wor
ld!

你好，世界
！
```



### FileWriter

```java
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write('a');
        fileWriter.close();
    }
}
```

file.txt（程序运行后）：

```
a
```



```java
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        FileWriter fileWriter1 = new FileWriter(path1);
        FileWriter fileWriter2 = new FileWriter(path2);
        String str = "Hello, World!";
        fileWriter1.write(str.toCharArray());
        fileWriter2.write(str.toCharArray(), 8, 3);
        fileWriter1.close();
        fileWriter2.close();
    }
}
```

file1.txt（程序运行后）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
orl
```



```java
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        FileWriter fileWriter1 = new FileWriter(path1);
        FileWriter fileWriter2 = new FileWriter(path2);
        String str = "Hello, World!";
        fileWriter1.write(str);
        fileWriter2.write(str, 8, 3);
        fileWriter1.close();
        fileWriter2.close();
    }
}
```

file1.txt（程序运行后）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
orl
```



### 拷贝文件

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        FileReader fileReader = new FileReader(path1);
        FileWriter fileWriter = new FileWriter(path2);
        char[] arr = new char[5];
        int len;
        while ((len = fileReader.read(arr)) != -1) {
            fileWriter.write(arr, 0, len);
        }
        fileReader.close();
        fileWriter.close();
    }
}
```

file1.txt（程序运行前）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
Hello, World!
```



## BufferedInputStream、

### BufferedInputStream

```java
```



```
```



### 

```java
```



```
```



### 拷贝文件

```java
```



```
```





## BufferedReader、BufferedWriter

### BufferedReader

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
    }
}
```

file.txt：

```
abc
def
ghi
```

运行结果：

```
abc
def
ghi
```



### BufferedWriter

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        String[] arr = {"abc", "def", "ghi"};
        for (String str : arr) {
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
    }
}
```

file.txt（程序运行后）：

```
abcdefghi
```



```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        String[] arr = {"abc", "def", "ghi"};
        for (String str : arr) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
```

file.txt（程序运行后）：

```
abc
def
ghi

```



### 拷贝文件

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path2));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

file1.txt（程序运行前）：

```
abc
def
ghi
```

file2.txt（程序运行后）：

```
abc
def
ghi

```

