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



### FileChannel

打开FileChannel：InputStream、OutputStream、RandomAccessFile



#### 读数据

```java
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\demo\\file.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                stringBuilder.append((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
        System.out.println(stringBuilder);
        fileChannel.close();
        randomAccessFile.close();
    }
}
```

file.txt（程序运行前）：

```
Hello, World!
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
        String path = "D:\\demo\\file.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        String str = "Hello, World!";
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            fileChannel.write(byteBuffer);
        }
        fileChannel.close();
        randomAccessFile.close();
    }
}
```

file.txt（程序运行后）：

```
Hello, World!
```



#### 常用方法

##### transferFrom

```java
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";

        RandomAccessFile file1 = new RandomAccessFile(path1, "rw");
        RandomAccessFile file2 = new RandomAccessFile(path2, "rw");

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

file1.txt（程序运行前）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
Hello, World!
```



##### transferTo

```java
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Demo {
    public static void main(String[] args) throws Exception {
        String path1 = "D:\\demo\\file1.txt";
        String path2 = "D:\\demo\\file2.txt";

        RandomAccessFile file1 = new RandomAccessFile(path1, "rw");
        RandomAccessFile file2 = new RandomAccessFile(path2, "rw");

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

file1.txt（程序运行前）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
Hello, World!
```



### ServerSocketChannel

Client.java：

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = bufferedReader.readLine();
        System.out.println(str);
        bufferedReader.close();
        socket.close();
    }
}
```

Server.java：

```java
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                Thread.sleep(2000);
            } else {
                System.out.println(socketChannel.socket().getRemoteSocketAddress());
                String str = "Hello, World!";
                ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
                socketChannel.write(byteBuffer);
                socketChannel.close();
                break;
            }
        }
        serverSocketChannel.close();
    }
}
```

先运行Server.java，再运行Client.java

Client.java的运行结果：

```
Hello, World!
```

Server.java的运行结果：

```
/7.249.48.104:50709
```



### SocketChannel

（存疑）

Client.java：

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = socketChannel.read(byteBuffer);
        System.out.print(new String(byteBuffer.array(), 0, len));
        socketChannel.close();
    }
}
```

Server.java：

```java
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                Thread.sleep(2000);
            } else {
                System.out.println(socketChannel.socket().getRemoteSocketAddress());
                String str = "Hello, World!";
                ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
                socketChannel.write(byteBuffer);
                socketChannel.close();
                break;
            }
        }
        serverSocketChannel.close();
    }
}
```

先运行Server.java，再运行Client.java

Client.java的运行结果：

```
Hello, World!
```

Server.java的运行结果：

```
/127.0.0.1:64505
```

