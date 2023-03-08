# 【Java】NIO



[toc]



## 概念

|   IO   |    NIO     |
| :----: | :--------: |
| 面向流 | 面向缓冲区 |
| 阻塞IO |  非阻塞IO  |

NIO
	Channel
	Buffer
	Selector



## Channel

Channel
	FileChannel：文件
	DatagramChannel：UDP
	SocketChannel：TCP
	ServerSocketChannel：TCP

DatagramChannel：传输数据
SocketChannel：传输数据
ServerSocketChannel：监听传入的连接、创建新的SocketChannel对象



### FileChannel

打开FileChannel：InputStream、OutputStream、RandomAccessFile



#### 读数据

```java
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\demo\\file.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        StringBuilder stringBuilder = new StringBuilder();
        while (channel.read(buffer) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                stringBuilder.append((char) buffer.get());
            }
            buffer.clear();
        }
        System.out.println(stringBuilder);
        channel.close();
        file.close();
    }
}
```

运行结果：

```
Hello, World!
```



#### 写数据

```java
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\demo\\file.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        String str = "Hello, World!";
        buffer.put(str.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        channel.close();
        file.close();
    }
}
```

file.txt：

```
Hello, World!
```



#### 常用方法

```
position
size
truncate
force
transferTo
transferFrom
```



```java
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file1 = new RandomAccessFile("D:\\demo\\file1.txt", "rw");
        RandomAccessFile file2 = new RandomAccessFile("D:\\demo\\file2.txt", "rw");

        FileChannel channel1 = file1.getChannel();
        FileChannel channel2 = file2.getChannel();

        channel2.transferFrom(channel1, 0, channel1.size());

        channel1.close();
        channel2.close();

        file1.close();
        file2.close();
    }
}
```

file1.txt：

```
Hello, World!
```

file2.txt：

```
Hello, World!
```



```java
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file1 = new RandomAccessFile("D:\\demo\\file1.txt", "rw");
        RandomAccessFile file2 = new RandomAccessFile("D:\\demo\\file2.txt", "rw");

        FileChannel channel1 = file1.getChannel();
        FileChannel channel2 = file2.getChannel();

        channel1.transferTo(0, channel1.size(), channel2);

        channel1.close();
        channel2.close();

        file1.close();
        file2.close();
    }
}
```

file1.txt：

```
Hello, World!
```

file2.txt：

```
Hello, World!
```



### SocketChannel

