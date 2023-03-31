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

BufferedInputStream（缓冲区字节输入流）、BufferedOutputStream（缓冲区字节输出流）
BufferedReader（缓冲区字符输入流）、BufferedWriter（缓冲区字符输出流）

ObjectInputStream（对象字节输入流）、ObjectOutputStream（对象字节输出流）

转换流（字节流 → 字符流）：InputStreamReader、OutputStreamWriter



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
            System.out.print((char) i);
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
Hello, World!
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
            System.out.print(new String(arr));
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
Hello, World!or
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
            System.out.print(new String(arr, 0, len));
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
Hello, World!
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
            System.out.print((char) i);
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
Hello, World!
你好，世界！
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
            System.out.print(new String(arr));
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
Hello, World!
你好，世界！好，世界
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
            System.out.print(new String(arr, 0, len));
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
Hello, World!
你好，世界！
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



## BufferedInputStream、BufferedOutputStream

### BufferedInputStream

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] arr = new byte[5];
        while ((bufferedInputStream.read(arr)) != -1) {
            System.out.print(new String(arr));
        }
        bufferedInputStream.close();
    }
}
```

file.txt：

```
abcdef
ghijkl
mnopqr
```

运行结果：

```
abcdef
ghijkl
mnopqrnop
```



```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] arr = new byte[5];
        int len;
        while ((len = bufferedInputStream.read(arr)) != -1) {
            System.out.print(new String(arr, 0, len));
        }
        bufferedInputStream.close();
    }
}
```

file.txt：

```
abcdef
ghijkl
mnopqr
```

运行结果：

```
abcdef
ghijkl
mnopqr
```



### BufferedOutputStream

```java
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(path1));
        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(path2));
        String str = "Hello, World!";
        bufferedOutputStream1.write(str.getBytes());
        bufferedOutputStream2.write(str.getBytes(), 8, 3);
        bufferedOutputStream1.close();
        bufferedOutputStream2.close();
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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path2));
        byte[] arr = new byte[5];
        int len;
        while ((len = bufferedInputStream.read(arr)) != -1) {
            bufferedOutputStream.write(arr, 0, len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
```

file1.txt（程序运行前）：

```
abcdef
ghijkl
mnopqr
```

file2.txt（程序运行后）：

```
abcdef
ghijkl
mnopqr
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



## ObjectOutputStream、ObjectInputStream

### ObjectOutputStream

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4L;
        float f = 0.1F;
        double d = 3.14;
        char ch = 'a';
        boolean bool = true;
        String str = "Hello, World!";
        C c = new C(1);
        objectOutputStream.writeByte(b);
        objectOutputStream.writeShort(s);
        objectOutputStream.writeInt(i);
        objectOutputStream.writeLong(l);
        objectOutputStream.writeFloat(f);
        objectOutputStream.writeDouble(d);
        objectOutputStream.writeChar(ch);
        objectOutputStream.writeBoolean(bool);
        objectOutputStream.writeUTF(str);
        objectOutputStream.writeObject(c);
        objectOutputStream.close();
    }
}

class C implements Serializable {
    int i;

    public C(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "C{" +
                "i=" + i +
                '}';
    }
}
```



### ObjectInputStream

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "D:\\demo\\file.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        byte b = objectInputStream.readByte();
        short s = objectInputStream.readShort();
        int i = objectInputStream.readInt();
        long l = objectInputStream.readLong();
        float f = objectInputStream.readFloat();
        double d = objectInputStream.readDouble();
        char ch = objectInputStream.readChar();
        boolean bool = objectInputStream.readBoolean();
        String str = objectInputStream.readUTF();
        C c = (C) objectInputStream.readObject();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(ch);
        System.out.println(bool);
        System.out.println(str);
        System.out.println(c);
        objectInputStream.close();
    }
}

class C implements Serializable {
    int i;

    public C(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "C{" +
                "i=" + i +
                '}';
    }
}
```

运行结果：

```
1
2
3
4
0.1
3.14
a
true
Hello, World!
C{i=1}
```



## System.in、System.out

|            |  编译类型   |      运行类型       | 默认设备 |
| :--------: | :---------: | :-----------------: | :------: |
| System.in  | InputStream | BufferedInputStream |   键盘   |
| System.out | PrintStream |     PrintStream     |  显示器  |

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
    }
}
```

运行结果：

```
class java.io.BufferedInputStream
class java.io.PrintStream
```



## InputStreamReader、OutputStreamWriter

转换流（字节流 → 字符流）InputStreamReader、OutputStreamWriter



### InputStreamReader

```java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
    }
}
```

file.txt（ANSI编码）：

```
你好，世界！
```

运行结果：

```
你好，世界！
```



### OutputStreamWriter

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), "gbk");
        String str = "你好，世界！";
        outputStreamWriter.write(str);
        outputStreamWriter.close();
    }
}
```

file.txt（程序运行后，ANSI编码）：

```
你好，世界！
```



## PrintStream、PrintWriter

PrintStream（字节打印流）
PrintWriter（字符打印流）



### PrintStream

```java
import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        String str = "Hello, World!";
        printStream.print(str);
        printStream.close();
    }
}
```

运行结果：

```
Hello, World!
```



```java
import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        String str = null;
        printStream.print(str);
        printStream.close();
    }
}
```

运行结果：

```
null
```



```java
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\demo\\file.txt";
        PrintStream printStream = new PrintStream(path);
        String str = "Hello, World!";
        printStream.print(str);
        printStream.close();
    }
}
```

file.txt（程序运行后）：

```
Hello, World!
```



### PrintWriter

```java
import java.io.PrintWriter;

public class Demo {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out);
        String str = "Hello, World!";
        printWriter.print(str);
        printWriter.close();
    }
}
```

运行结果：

```
Hello, World!
```



```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\demo\\file.txt";
        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        String str = "Hello, World!";
        printWriter.print(str);
        printWriter.close();
    }
}
```

file.txt（程序运行后）：

```
Hello, World!
```



## Properties

### load、list、getProperty

```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "src\\project.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        properties.list(System.out);
    }
}
```

project.properties：

```
name=Tom
age=18
```

运行结果：

```
-- listing properties --
age=18
name=Tom
```



```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "src\\project.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        String name = properties.getProperty("name");
        System.out.println(name);
    }
}
```

project.properties：

```
name=Tom
age=18
```

运行结果：

```
Tom
```



### setProperty、store

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "Jack");
        properties.setProperty("age", "20");

        String path = "src\\project.properties";
        properties.store(new FileOutputStream(path), "This is a comment.");
    }
}
```

project.properties（程序运行后）：

```
#This is a comment.
#Sun Mar 26 20:02:20 CST 2023
age=20
name=Jack

```



```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "小明");
        properties.setProperty("age", "22");

        String path = "src\\project.properties";
        properties.store(new FileOutputStream(path), null);
    }
}
```

project.properties（程序运行后）：

```
#Sun Mar 26 20:03:17 CST 2023
age=22
name=\u5C0F\u660E

```

