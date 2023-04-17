# 【Java】引用



[toc]



|  引用  | 回收 |     条件     |
| :----: | :--: | :----------: |
| 强引用 |  ×   |              |
| 软引用 |  √   | 堆空间不足时 |
| 弱引用 |  √   |      无      |
| 虚引用 |  √   |      ?       |



## 强引用

```java
package org.example;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        c = null;
        System.gc();
        Thread.sleep(1000);
    }
}

class C {
    @Override
    protected void finalize() {
        System.out.println("finalize");
    }
}
```

运行结果：

```
finalize
```



## 软引用

```java
package org.example;

import java.lang.ref.SoftReference;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<C> softReference = new SoftReference<>(new C());
        System.out.println(softReference.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println(softReference.get());
    }
}

class C {
    @Override
    protected void finalize() {
        System.out.println("finalize");
    }
}
```

运行结果：

```
org.example.C@74a14482
org.example.C@74a14482
```



```java
package org.example;

import java.lang.ref.SoftReference;

public class Demo {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        byte[] arr = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get());
    }
}
```

运行参数：

```
-Xmx20m
```

运行结果：

```
[B@74a14482
null
```



```java
package org.example;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<SoftReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 2]);
            System.out.println(softReference.get());
            list.add(softReference);
        }

        System.out.println();

        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
    }
}
```

运行参数：

```
-Xmx10m
```

运行结果：

```
[B@74a14482
[B@1540e19d
[B@677327b6
[B@14ae5a5
[B@7f31245a

null
null
null
[B@14ae5a5
[B@7f31245a
```



### 软引用 + 引用队列

```java
package org.example;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        List<SoftReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 2], referenceQueue);
            System.out.println(softReference.get());
            list.add(softReference);
        }

        Reference<? extends byte[]> reference = referenceQueue.poll();
        while ((reference) != null) {
            list.remove(reference);
            reference = referenceQueue.poll();
        }

        System.out.println();

        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
    }
}
```

运行参数：

```
-Xmx10m
```

运行结果：

```
[B@74a14482
[B@1540e19d
[B@677327b6
[B@14ae5a5
[B@7f31245a

[B@14ae5a5
[B@7f31245a
```



## 弱引用

```java
package org.example;

import java.lang.ref.WeakReference;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<C> weakReference = new WeakReference<>(new C());
        System.out.println(weakReference.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println(weakReference.get());
    }
}

class C {
    @Override
    protected void finalize() {
        System.out.println("finalize");
    }
}
```

运行结果：

```
org.example.C@74a14482
finalize
null
```



```java
package org.example;

import java.lang.ref.WeakReference;

public class Demo {
    public static void main(String[] args) {
        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(weakReference.get());
        byte[] arr = new byte[1024 * 1024 * 10];
        System.out.println(weakReference.get());
    }
}
```

运行参数：

```
-Xmx20m
```

运行结果：

```
[B@74a14482
null
```



```java
package org.example;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024 * 2]);
            System.out.println(weakReference.get());
            list.add(weakReference);
        }

        System.out.println();

        for (WeakReference<byte[]> weakReference : list) {
            System.out.println(weakReference.get());
        }
    }
}
```

运行参数：

```
-Xmx10m
```

运行结果：

```
[B@74a14482
[B@1540e19d
[B@677327b6
[B@14ae5a5
[B@7f31245a

null
null
null
[B@14ae5a5
[B@7f31245a
```



### 弱引用 + 引用队列

```java
package org.example;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        List<WeakReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024 * 2], referenceQueue);
            System.out.println(weakReference.get());
            list.add(weakReference);
        }

        Reference<? extends byte[]> reference = referenceQueue.poll();
        while ((reference) != null) {
            list.remove(reference);
            reference = referenceQueue.poll();
        }

        System.out.println();

        for (WeakReference<byte[]> weakReference : list) {
            System.out.println(weakReference.get());
        }
    }
}
```

运行参数：

```
-Xmx10m
```

运行结果：

```
[B@74a14482
[B@1540e19d
[B@677327b6
[B@14ae5a5
[B@7f31245a

[B@14ae5a5
[B@7f31245a
```



## 虚引用

```java

```

