# 【Java】JUC



[toc]



相关视频：
[【尚硅谷】大厂必备技术之JUC并发编程](https://www.bilibili.com/video/BV1Kw411Z7dF/)



## Lock

Lock
	ReentrantLock
	ReentrantReadWriteLock



### ReentrantLock

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        C c = new C();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }).start();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }).start();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(c.resource);
        System.out.println(c.cnt);
    }
}

class C {
    Lock lock = new ReentrantLock();
    int resource = 10000;
    int cnt = 0;

    void f() {
        lock.lock();
        try {
            if (resource > 0) {
                resource--;
                cnt++;
            }
        } finally {
            lock.unlock();
        }
    }
}
```

运行结果：

```
0
10000

Process finished with exit code 0
```



#### 非公平锁

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }, "thread1").start();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }, "thread2").start();
    }
}

class C {
    Lock lock = new ReentrantLock(false);
    int resource = 10;

    void f() {
        lock.lock();
        try {
            if (resource > 0) {
                resource--;
                System.out.println(Thread.currentThread().getName() + ": " + resource);
            }
        } finally {
            lock.unlock();
        }
    }
}
```

运行结果：

```
thread1: 9
thread1: 8
thread1: 7
thread1: 6
thread1: 5
thread1: 4
thread1: 3
thread1: 2
thread1: 1
thread1: 0

Process finished with exit code 0
```



#### 公平锁

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }, "thread1").start();

        new Thread(() -> {
            while (c.resource > 0) {
                c.f();
            }
        }, "thread2").start();
    }
}

class C {
    Lock lock = new ReentrantLock(true);
    int resource = 10;

    void f() {
        lock.lock();
        try {
            if (resource > 0) {
                resource--;
                System.out.println(Thread.currentThread().getName() + ": " + resource);
            }
        } finally {
            lock.unlock();
        }
    }
}
```

运行结果：

```
thread1: 9
thread2: 8
thread1: 7
thread2: 6
thread1: 5
thread2: 4
thread1: 3
thread2: 2
thread1: 1
thread2: 0

Process finished with exit code 0
```



### ReentrantReadWriteLock

读读共享
读写互斥
写写互斥

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {
    public static void main(String[] args) {
        C c = new C();

        for (int i = 1; i <= 5; i++) {
            int resource = i;
            new Thread(() -> {
                c.write(resource);
            }).start();

            new Thread(() -> {
                c.read();
            }).start();
        }
    }
}

class C {
    int resource = 0;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ".read: " + resource);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            readLock.unlock();
        }
    }

    void write(int resource) {
        writeLock.lock();
        try {
            this.resource = resource;
            System.out.println(Thread.currentThread().getName() + ".write:  " + this.resource);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            writeLock.unlock();
        }
    }
}
```

运行结果：

```
Thread-0.write:  1
Thread-3.read: 1
Thread-1.read: 1
Thread-2.write:  2
Thread-4.write:  3
Thread-5.read: 3
Thread-6.write:  4
Thread-7.read: 4
Thread-8.write:  5
Thread-9.read: 5

Process finished with exit code 0
```



## 线程间通信

### synchronized

```java
public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}

class C {
    int resource = 0;

    synchronized void f1() throws InterruptedException {
        while (resource > 0) {
            this.wait();
        }
        resource++;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        while (resource < 1) {
            this.wait();
        }
        resource--;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }
}
```

运行结果：

```
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0

Process finished with exit code 0
```



#### 虚假唤醒问题

```java
public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread3").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread4").start();
    }
}

class C {
    int resource = 0;

    synchronized void f1() throws InterruptedException {
        if (resource > 0) {
            this.wait();
        }
        resource++;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        if (resource < 1) {
            this.wait();
        }
        resource--;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }
}
```

运行结果：

```
thread1: 1
thread4: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread4: -1
thread1: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0

Process finished with exit code 0
```



解决：改if为while

```java
public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread3").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread4").start();
    }
}

class C {
    int resource = 0;

    synchronized void f1() throws InterruptedException {
        while (resource > 0) {
            this.wait();
        }
        resource++;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        while (resource < 1) {
            this.wait();
        }
        resource--;
        System.out.println(Thread.currentThread().getName() + ": " + resource);
        this.notifyAll();
    }
}
```

运行结果：

```
thread1: 1
thread4: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread3: 1
thread2: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0
thread1: 1
thread4: 0

Process finished with exit code 0
```



### Lock、Condition

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}

class C {
    int resource = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void f1() throws InterruptedException {
        lock.lock();
        try {
            while (resource > 0) {
                condition.await();
            }
            resource++;
            System.out.println(Thread.currentThread().getName() + ": " + resource);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    void f2() throws InterruptedException {
        lock.lock();
        try {
            while (resource < 1) {
                condition.await();
            }
            resource--;
            System.out.println(Thread.currentThread().getName() + ": " + resource);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
```

运行结果：

```
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0
Thread-0: 1
Thread-1: 0

Process finished with exit code 0
```



## 线程间定制化通信

### Lock、Condition

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        C c = new C();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f1();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f2();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.f3();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}

class C {
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    void f1() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            System.out.println("f1");
            flag = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    void f2() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            System.out.println("f2");
            flag = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    void f3() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            System.out.println("f3");
            flag = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
```

运行结果：

```
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3
f1
f2
f3

Process finished with exit code 0
```



## 可重入锁

### 



## 死锁

### synchronized

```java
public class Demo {
    static final Object object1 = new Object();
    static final Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            synchronized (object1) {
                System.out.println(threadName + ": 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (object2) {
                    System.out.println(threadName + ": 2");
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            synchronized (object2) {
                System.out.println(threadName + ": 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (object1) {
                    System.out.println(threadName + ": 1");
                }
            }
        }, "thread2").start();
    }
}
```

运行结果（未结束）：

```
thread1: 1
thread2: 2
```



### Lock

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            lock1.lock();
            try {
                System.out.println(threadName + ": 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                lock2.lock();
                try {
                    System.out.println(threadName + ": 2");
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        }, "thread1").start();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            lock2.lock();
            try {
                System.out.println(threadName + ": 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                lock1.lock();
                try {
                    System.out.println(threadName + ": 2");
                } finally {
                    lock1.unlock();
                }
            } finally {
                lock2.unlock();
            }
        }, "thread2").start();
    }
}
```

运行结果（未结束）：

```
thread1: 1
thread2: 2
```



### 查看死锁

```
jps -l
```

运行结果：

```
...
28908 Demo
```



```
jstack 28908
```

运行结果：

```
...
Found one Java-level deadlock:
=============================
"thread1":
  waiting to lock monitor 0x0000015d3735e6f0 (object 0x000000071611f3d8, a java.lang.Object),
  which is held by "thread2"

"thread2":
  waiting to lock monitor 0x0000015d3730e230 (object 0x000000071611f3c8, a java.lang.Object),
  which is held by "thread1"

Java stack information for the threads listed above:
===================================================
"thread1":
        at Demo.lambda$main$0(Demo.java:16)
        - waiting to lock <0x000000071611f3d8> (a java.lang.Object)
        - locked <0x000000071611f3c8> (a java.lang.Object)
        at Demo$$Lambda$14/0x00000008010031f0.run(Unknown Source)
        at java.lang.Thread.run(java.base@19.0.2/Thread.java:1589)
"thread2":
        at Demo.lambda$main$1(Demo.java:31)
        - waiting to lock <0x000000071611f3c8> (a java.lang.Object)
        - locked <0x000000071611f3d8> (a java.lang.Object)
        at Demo$$Lambda$15/0x00000008010033f8.run(Unknown Source)
        at java.lang.Thread.run(java.base@19.0.2/Thread.java:1589)

Found 1 deadlock.
```



## 集合

### List

#### ArrayList（线程不安全）

```java
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }).start();
        }
    }
}
```

运行结果：

```
[a75]
[a75, 61d, a94]
[a75, 61d]
[a75, 61d, a94, b98]
[a75, 61d, a94, b98, 451]
[a75, 61d, a94, b98, 451, 725]
[a75, 61d, a94, b98, 451, 725, 0e6]
[a75, 61d, a94, b98, 451, 725, 0e6, af9]
[a75, 61d, a94, b98, 451, 725, 0e6, af9, f5c]
[a75, 61d, a94, b98, 451, 725, 0e6, af9, f5c, 4d1]

Process finished with exit code 0
```



#### Vector

```java
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new Vector<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }).start();
        }
    }
}
```

运行结果：

```
[bb1]
[bb1, a51, e64, 350]
[bb1, a51, e64, 350, 14d]
[bb1, a51, e64, 350, 14d, 375]
[bb1, a51, e64, 350, 14d, 375, 6ad]
[bb1, a51]
[bb1, a51, e64]
[bb1, a51, e64, 350, 14d, 375, 6ad, 4b6]
[bb1, a51, e64, 350, 14d, 375, 6ad, 4b6, 09b, a5d]
[bb1, a51, e64, 350, 14d, 375, 6ad, 4b6, 09b]

Process finished with exit code 0
```



#### Collections.synchronizedList

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }).start();
        }
    }
}
```

运行结果：

```
[f3b]
[f3b, e11, eae]
[f3b, e11]
[f3b, e11, eae, d2f]
[f3b, e11, eae, d2f, 5a0]
[f3b, e11, eae, d2f, 5a0, 086]
[f3b, e11, eae, d2f, 5a0, 086, f20]
[f3b, e11, eae, d2f, 5a0, 086, f20, c65]
[f3b, e11, eae, d2f, 5a0, 086, f20, c65, d84]
[f3b, e11, eae, d2f, 5a0, 086, f20, c65, d84, d06]

Process finished with exit code 0
```



#### CopyOnWriteArrayList

```java
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }).start();
        }
    }
}
```

运行结果：

```
[50c]
[50c, fbf, db8]
[50c, fbf]
[50c, fbf, db8, c76]
[50c, fbf, db8, c76, 5cc]
[50c, fbf, db8, c76, 5cc, d7a]
[50c, fbf, db8, c76, 5cc, d7a, b67]
[50c, fbf, db8, c76, 5cc, d7a, b67, 71b]
[50c, fbf, db8, c76, 5cc, d7a, b67, 71b, c2f]
[50c, fbf, db8, c76, 5cc, d7a, b67, 71b, c2f, ba2]

Process finished with exit code 0
```



### Set

#### HashSet（线程不安全）

```java
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(set);
            }).start();
        }
    }
}
```

运行结果：

```
[637]
[c15, 637]
[c15, d2d, 637, d90]
[c15, d2d, 866, 637, d90]
[c15, 637, d90]
[e50, 54a, c15, d2d, 866, 637, d90]
[e50, c15, d2d, 866, 637, d90]
[e50, 54a, c15, d2d, 866, 118, 637, d90]
[e50, 54a, fd0, c15, d2d, 866, 118, 637, d90]
[e50, 02c, 54a, fd0, c15, d2d, 866, 118, 637, d90]

Process finished with exit code 0
```



#### Collections.synchronizedSet

```java
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(set);
            }).start();
        }
    }
}
```

运行结果：

```
[a4f]
[a4f, a7a, 4fa]
[a4f, a7a]
[a4f, 602, a7a, 4fa]
[a4f, c25, 602, a7a, 4fa]
[a4f, c25, 602, a7a, 4fa, bea]
[a4f, c25, 602, a7a, 72f, 4fa, bea]
[a4f, c25, 602, a7a, 72f, 392, 4fa, bea]
[a4f, ffe, c25, 602, a7a, 72f, 392, 4fa, bea]
[a4f, ffe, c25, 602, 7e6, a7a, 72f, 392, 4fa, bea]

Process finished with exit code 0
```



#### CopyOnWriteArraySet

```java
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(set);
            }).start();
        }
    }
}
```

运行结果：

```
[80f]
[80f, 065]
[80f, 065, fff]
[80f, 065, fff, b47]
[80f, 065, fff, b47, 519, b81]
[80f, 065, fff, b47, 519]
[80f, 065, fff, b47, 519, b81, 173]
[80f, 065, fff, b47, 519, b81, 173, 00c]
[80f, 065, fff, b47, 519, b81, 173, 00c, 4af]
[80f, 065, fff, b47, 519, b81, 173, 00c, 4af, 047]

Process finished with exit code 0
```



### Map

#### HashMap（线程不安全）

```java
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, UUID.randomUUID().toString().substring(0, 3));
                System.out.println(map);
            }).start();
        }
    }
}
```

运行结果：

```
{8=6ec}
{0=836, 6=6f9, 8=6ec}
{6=6f9, 8=6ec}
{0=836, 5=c87, 6=6f9, 8=6ec}
{0=836, 5=c87, 6=6f9, 8=6ec, 9=5f9}
{0=836, 5=c87, 6=6f9, 7=4f6, 8=6ec, 9=5f9}
{0=836, 2=878, 5=c87, 6=6f9, 7=4f6, 8=6ec, 9=5f9}
{0=836, 2=878, 3=f0b, 5=c87, 6=6f9, 7=4f6, 8=6ec, 9=5f9}
{0=836, 1=634, 2=878, 3=f0b, 5=c87, 6=6f9, 7=4f6, 8=6ec, 9=5f9}
{0=836, 1=634, 2=878, 3=f0b, 4=186, 5=c87, 6=6f9, 7=4f6, 8=6ec, 9=5f9}

Process finished with exit code 0
```



#### Collections.synchronizedMap

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, UUID.randomUUID().toString().substring(0, 3));
                System.out.println(map);
            }).start();
        }
    }
}
```

运行结果：

```
{0=13f}
{0=13f, 4=bae}
{0=13f, 2=528, 4=bae, 7=d9b}
{0=13f, 2=528, 4=bae, 7=d9b, 8=a2e}
{0=13f, 2=528, 4=bae}
{0=13f, 2=528, 3=d24, 4=bae, 7=d9b, 8=a2e}
{0=13f, 2=528, 3=d24, 4=bae, 7=d9b, 8=a2e, 9=8c0}
{0=13f, 2=528, 3=d24, 4=bae, 5=1c3, 7=d9b, 8=a2e, 9=8c0}
{0=13f, 1=3a6, 2=528, 3=d24, 4=bae, 5=1c3, 7=d9b, 8=a2e, 9=8c0}
{0=13f, 1=3a6, 2=528, 3=d24, 4=bae, 5=1c3, 6=345, 7=d9b, 8=a2e, 9=8c0}

Process finished with exit code 0
```



#### ConcurrentHashMap

```java
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, UUID.randomUUID().toString().substring(0, 3));
                System.out.println(map);
            }).start();
        }
    }
}
```

运行结果：

```
{0=1c4}
{0=1c4, 2=401, 4=755}
{0=1c4, 2=401, 4=755, 6=7e5}
{0=1c4, 2=401, 4=755, 6=7e5, 7=e63}
{0=1c4, 4=755}
{0=1c4, 2=401, 4=755, 5=632, 6=7e5, 7=e63}
{0=1c4, 2=401, 3=0e4, 4=755, 5=632, 6=7e5, 7=e63}
{0=1c4, 1=c08, 2=401, 3=0e4, 4=755, 5=632, 6=7e5, 7=e63}
{0=1c4, 1=c08, 2=401, 3=0e4, 4=755, 5=632, 6=7e5, 7=e63, 9=468}
{0=1c4, 1=c08, 2=401, 3=0e4, 4=755, 5=632, 6=7e5, 7=e63, 8=af8, 9=468}

Process finished with exit code 0
```



## 辅助类

辅助类：
	CountDownLatch
	CyclicBarrier
	Semaphore



### CountDownLatch

```java
import java.util.concurrent.CountDownLatch;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ".run");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("main");
    }
}
```

运行结果：

```
Thread-4.run
Thread-0.run
Thread-5.run
Thread-3.run
Thread-2.run
Thread-1.run
main

Process finished with exit code 0
```



### CyclicBarrier

```java
import java.util.concurrent.CyclicBarrier;

public class Demo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
            System.out.println("CyclicBarrier.run");
        });
        for (int i = 1; i <= 24; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ".run");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }
}
```

运行结果：

```
Thread-3.run
Thread-4.run
Thread-1.run
Thread-7.run
Thread-9.run
Thread-11.run
Thread-13.run
Thread-16.run
Thread-14.run
Thread-6.run
Thread-2.run
Thread-5.run
Thread-0.run
Thread-8.run
Thread-22.run
Thread-15.run
Thread-12.run
CyclicBarrier.run
Thread-17.run
Thread-10.run
CyclicBarrier.run
Thread-18.run
Thread-19.run
CyclicBarrier.run
Thread-20.run
Thread-21.run
Thread-23.run
CyclicBarrier.run

Process finished with exit code 0
```



### Semaphore

```java
import java.util.concurrent.Semaphore;

public class Demo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                try {
                    semaphore.acquire();
                    System.out.println(threadName + ": acquire");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    semaphore.release();
                    System.out.println(threadName + ": release");
                }
            }).start();
        }
    }
}
```

运行结果：

```
Thread-0: acquire
Thread-2: acquire
Thread-2: release
Thread-5: acquire
Thread-4: acquire
Thread-0: release
Thread-1: acquire
Thread-5: release
Thread-3: acquire
Thread-3: release
Thread-4: release
Thread-1: release

Process finished with exit code 0
```



## 阻塞队列

BlockingQueue：
	ArrayBlockingQueue
	LinkedBlockingQueue
	DelayQueue
	PriorityBlockingQueue
	SynchronousQueue
	LinkedTransferQueue
	LinkedBlockingDeque



### 常用方法

|  方法  | 抛出异常 | 不抛出异常 | 阻塞等待 | 超时返回 |
| :----: | :------: | :--------: | :------: | :------: |
|  插入  |   add    |   offer    |   put    |  offer   |
|  删除  |  remove  |    poll    |   take   |   poll   |
| 头元素 | element  |    peek    |    无    |    无    |



#### add

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("abc"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.add("def"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.add("ghi"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.add("jkl"));
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
true
[abc, def]
true
[abc, def, ghi]
Exception in thread "main" java.lang.IllegalStateException: Queue full
	at java.base/java.util.AbstractQueue.add(AbstractQueue.java:98)
	at java.base/java.util.concurrent.ArrayBlockingQueue.add(ArrayBlockingQueue.java:329)
	at Demo.main(Demo.java:17)

Process finished with exit code 1
```



#### offer

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("abc"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("def"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("ghi"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("jkl"));
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
true
[abc, def]
true
[abc, def, ghi]
false
[abc, def, ghi]

Process finished with exit code 0
```



```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("abc", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("def", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("ghi", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.offer("jkl", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
true
[abc, def]
true
[abc, def, ghi]
false
[abc, def, ghi]

Process finished with exit code 0
```



#### put

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("abc");
        System.out.println(blockingQueue);

        blockingQueue.put("def");
        System.out.println(blockingQueue);

        blockingQueue.put("ghi");
        System.out.println(blockingQueue);

        blockingQueue.put("jkl");
        System.out.println(blockingQueue);
    }
}
```

运行结果（未结束）：

```
[abc]
[abc, def]
[abc, def, ghi]
```



#### remove

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("abc"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
abc
[]
Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.AbstractQueue.remove(AbstractQueue.java:117)
	at Demo.main(Demo.java:14)

Process finished with exit code 1
```



#### poll

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("abc"));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
abc
[]
null
[]

Process finished with exit code 0
```



```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("abc", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);

        System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));
        System.out.println(blockingQueue);
    }
}
```

运行结果：

```
true
[abc]
abc
[]
null
[]

Process finished with exit code 0
```



#### take

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("abc");
        System.out.println(blockingQueue);

        blockingQueue.take();
        System.out.println(blockingQueue);

        blockingQueue.take();
        System.out.println(blockingQueue);
    }
}
```

运行结果（未结束）：

```
[abc]
[]
```



#### element

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("abc");
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.element());

        blockingQueue.add("def");
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.element());

        blockingQueue.remove();
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.element());

        blockingQueue.remove();
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.element());
    }
}
```

运行结果：

```
[abc]
abc
[abc, def]
abc
[def]
def
[]
Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.AbstractQueue.element(AbstractQueue.java:136)
	at Demo.main(Demo.java:22)

Process finished with exit code 1
```



#### peek

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("abc");
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.peek());

        blockingQueue.add("def");
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.peek());

        blockingQueue.remove();
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.peek());

        blockingQueue.remove();
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.peek());
    }
}
```

运行结果：

```
[abc]
abc
[abc, def]
abc
[def]
def
[]
null

Process finished with exit code 0
```



## 线程池

newFixedThreadPool
newSingleThreadExecutor
newCachedThreadPool



### newFixedThreadPool

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
    }
}
```

运行结果：

```
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-5
pool-1-thread-2
pool-1-thread-2
pool-1-thread-3
pool-1-thread-4
pool-1-thread-1
pool-1-thread-5

Process finished with exit code 0
```



### newSingleThreadExecutor

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
    }
}
```

运行结果：

```
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1
pool-1-thread-1

Process finished with exit code 0
```



### newCachedThreadPool

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 20; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
    }
}
```

运行结果：

```
pool-1-thread-1
pool-1-thread-4
pool-1-thread-2
pool-1-thread-3
pool-1-thread-5
pool-1-thread-6
pool-1-thread-7
pool-1-thread-8
pool-1-thread-10
pool-1-thread-7
pool-1-thread-2
pool-1-thread-3
pool-1-thread-6
pool-1-thread-1
pool-1-thread-9
pool-1-thread-5
pool-1-thread-8
pool-1-thread-4
pool-1-thread-11
pool-1-thread-12

Process finished with exit code 0
```

