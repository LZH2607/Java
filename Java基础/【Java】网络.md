# 【Java】网络



[toc]



TCP：Socket、ServerSocket
UDP：DatagramSocket、DatagramPacket



## InetAddress

### getLocalHost

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
    }
}
```

运行结果：

```
DESKTOP-91HA06P/192.168.56.1
```



### getByName

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-91HA06P");
        System.out.println(inetAddress);
    }
}
```

运行结果：

```
DESKTOP-91HA06P/192.168.56.1
```



```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
    }
}
```

运行结果：

```
www.baidu.com/14.119.104.189
```



### getHostAddress、getHostName

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        String hostAddress = inetAddress.getHostAddress();
        String hostName = inetAddress.getHostName();
        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}
```

运行结果：

```
14.119.104.189
www.baidu.com
```



## Socket、ServerSocket

Client.java：

```java
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println(socket);
        socket.close();
    }
}
```

Server.java：

```java
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println(socket);
        socket.close();
        serverSocket.close();
    }
}
```

先运行Server.java，再运行Client.java

Client.java的运行结果：

```
Socket[addr=DESKTOP-91HA06P/192.168.56.1,port=9999,localport=53362]
```

Server.java的运行结果：

```
Socket[addr=/192.168.56.1,port=53362,localport=9999]
```



### getInputStream、getOutputStream

#### 示例

Client.java：

```java
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String str = "Client: Hello!";
        outputStream.write(str.getBytes());
        socket.shutdownOutput();

        byte[] arr = new byte[5];
        int len;
        while ((len = inputStream.read(arr)) != -1) {
            System.out.print(new String(arr, 0, len));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
```

Server.java：

```java
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] arr = new byte[5];
        int len;
        while ((len = inputStream.read(arr)) != -1) {
            System.out.print(new String(arr, 0, len));
        }

        String str = "Server: Hello!";
        outputStream.write(str.getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
```

先运行Server.java，再运行Client.java

Client.java的运行结果：

```
Server: Hello!
```

Server.java的运行结果：

```
Client: Hello!
```



### 使用BufferedReader、BufferedWriter

#### 传输文本

Client.java：

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        String str1 = "客户端：你好！";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(str1);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str2 = bufferedReader.readLine();
        System.out.println(str2);

        bufferedReader.close();
        bufferedWriter.close();

        socket.close();
    }
}
```

Server.java：

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str1 = bufferedReader.readLine();
        System.out.println(str1);

        String str2 = "服务端：你好！";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(str2);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();

        socket.close();
        serverSocket.close();
    }
}
```

先运行Server.java，再运行Client.java

Client.java的运行结果：

```
服务端：你好！
```

Server.java的运行结果：

```
客户端：你好！
```



### 使用BufferedInputStream、BufferedOutputStream

#### 传输文件

Client.java：

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        String path = "D:\\demo\\file1.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] byteArray = Utils.getByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(byteArray);

        bufferedInputStream.close();
        bufferedOutputStream.close();

        socket.close();
    }
}
```

Server.java：

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] byteArray = Utils.getByteArray(bufferedInputStream);

        String path = "D:\\demo\\file2.txt";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(byteArray);

        bufferedInputStream.close();
        bufferedOutputStream.close();

        socket.close();
        serverSocket.close();
    }
}
```

Utils.java：

```java
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static byte[] getByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arr = new byte[5];
        int len;
        while ((len = inputStream.read(arr)) != -1) {
            byteArrayOutputStream.write(arr, 0, len);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
```

先运行Server.java，再运行Client.java

file1.txt（程序运行前）：

```
Hello, World!
```

file2.txt（程序运行后）：

```
Hello, World!
```



## DatagramSocket、DatagramPacket

### send、receive

#### 示例

Sender.java：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        String str = "Hello, World!";
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
```

Receiver.java：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] arr = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(arr, arr.length);
        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String str = new String(data, 0, length);
        System.out.println(str);

        datagramSocket.close();
    }
}
```

先运行Receiver.java，再运行Sender.java

Receiver.java的运行结果：

```
Hello, World!
```



9998 → 9999（C1: Hello!）
10000 ← 10001（C2: Hello!）

C1.java：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class C1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket1 = new DatagramSocket(9998);
        DatagramSocket datagramSocket2 = new DatagramSocket(10000);

        String str = "C1: Hello!";
        DatagramPacket datagramPacket1 = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getLocalHost(), 9999);
        datagramSocket1.send(datagramPacket1);

        byte[] arr = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(arr, arr.length);
        datagramSocket2.receive(datagramPacket2);

        int length = datagramPacket2.getLength();
        byte[] data = datagramPacket2.getData();
        str = new String(data, 0, length);
        System.out.println(str);

        datagramSocket1.close();
        datagramSocket2.close();
    }
}
```

C2.java：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class C2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket1 = new DatagramSocket(9999);
        DatagramSocket datagramSocket2 = new DatagramSocket(10001);

        byte[] arr = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(arr, arr.length);
        datagramSocket1.receive(datagramPacket1);

        int length = datagramPacket1.getLength();
        byte[] data = datagramPacket1.getData();
        String str = new String(data, 0, length);
        System.out.println(str);

        str = "C2: Hello!";
        DatagramPacket datagramPacket2 = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getLocalHost(), 10000);
        datagramSocket2.send(datagramPacket2);

        datagramSocket1.close();
        datagramSocket2.close();
    }
}
```

先运行C2.java，再运行C1.java

C1.java的运行结果：

```
C2: Hello!
```

C2.java的运行结果：

```
C1: Hello!
```

