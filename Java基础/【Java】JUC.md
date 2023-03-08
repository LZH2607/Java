# 【Java】JUC



[toc]



## Lock

Lock
	ReentrantLock



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
```



#### 非公平锁

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
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + resource);
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
thread2: 0
```



#### 公平锁

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
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + resource);
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
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        while (resource < 1) {
            this.wait();
        }
        resource--;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
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
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        if (resource < 1) {
            this.wait();
        }
        resource--;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
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
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
        this.notifyAll();
    }

    synchronized void f2() throws InterruptedException {
        while (resource < 1) {
            this.wait();
        }
        resource--;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + resource);
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
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + resource);
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
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + resource);
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
```



## 可重入锁

### 



## 死锁

### synchronized

```java
public class Demo {
    static final Object object1 = new Object();
    static final Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {
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

    public static void main(String[] args) throws InterruptedException {
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
[38e]
[38e, 56b]
[38e, 56b, 0a3, b04]
[38e, 56b, 0a3]
[38e, 56b, 0a3, b04, 00e, cad]
[38e, 56b, 0a3, b04, 00e]
[38e, 56b, 0a3, b04, 00e, cad, b3e]
[38e, 56b, 0a3, b04, 00e, cad, b3e, 66e]
[38e, 56b, 0a3, b04, 00e, cad, b3e, 66e, 228]
[38e, 56b, 0a3, b04, 00e, cad, b3e, 66e, 228, 530]
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
[76d]
[76d, 343, 2ad, 524]
[76d, 343]
[76d, 343, 2ad]
[76d, 343, 2ad, 524, e82, ae5]
[76d, 343, 2ad, 524, e82]
[76d, 343, 2ad, 524, e82, ae5, d65]
[76d, 343, 2ad, 524, e82, ae5, d65, d32]
[76d, 343, 2ad, 524, e82, ae5, d65, d32, dc9]
[76d, 343, 2ad, 524, e82, ae5, d65, d32, dc9, 6f6]
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
[36a]
[36a, ba7, 3a8]
[36a, ba7, 3a8, 8dd]
[36a, ba7]
[36a, ba7, 3a8, 8dd, 496]
[36a, ba7, 3a8, 8dd, 496, fcf]
[36a, ba7, 3a8, 8dd, 496, fcf, 288]
[36a, ba7, 3a8, 8dd, 496, fcf, 288, f1c]
[36a, ba7, 3a8, 8dd, 496, fcf, 288, f1c, 5a9]
[36a, ba7, 3a8, 8dd, 496, fcf, 288, f1c, 5a9, ea4]
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
[a98]
[a98, cb0, 378]
[a98, cb0]
[a98, cb0, 378, da8, 362]
[a98, cb0, 378, da8]
[a98, cb0, 378, da8, 362, 0c3]
[a98, cb0, 378, da8, 362, 0c3, 0b8]
[a98, cb0, 378, da8, 362, 0c3, 0b8, 8d8]
[a98, cb0, 378, da8, 362, 0c3, 0b8, 8d8, b51]
[a98, cb0, 378, da8, 362, 0c3, 0b8, 8d8, b51, 6c2]
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
[fd1]
[48e, fd1]
[eea, 48e, fd1, 0d8]
[eea, 48e, fd1]
[eea, 48e, fd1, 0d8, b3f]
[eea, 48e, fd1, dfe, 0d8, b3f]
[eea, 48e, cf3, fd1, dfe, 0d8, b3f]
[eea, 48e, cf3, fd1, dfe, 0d8, b3f, 8bf]
[eea, 48e, cf3, fd1, dfe, b88, 0d8, b3f, 8bf]
[eea, 48e, cf3, fd1, dfe, 0e7, b88, 0d8, b3f, 8bf]
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
[d28]
[487, d28]
[04e, 487, b33, 0e9, d28]
[04e, 487, b33, 0e9, acf, d28]
[04e, 487, d28]
[04e, 487, 0e9, d28]
[396, 04e, 487, b33, 0e9, acf, d28]
[396, 04e, 487, b33, 0e9, acf, 6c6, d28]
[396, 04e, 487, b33, 0e9, 477, acf, 6c6, d28]
[396, 04e, 487, b33, 0e9, 477, acf, 5d5, 6c6, d28]
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
[b16]
[b16, 7fe]
[b16, 7fe, fa7]
[b16, 7fe, fa7, 6ec, 4ab, ca8]
[b16, 7fe, fa7, 6ec]
[b16, 7fe, fa7, 6ec, 4ab]
[b16, 7fe, fa7, 6ec, 4ab, ca8, 19a]
[b16, 7fe, fa7, 6ec, 4ab, ca8, 19a, 669]
[b16, 7fe, fa7, 6ec, 4ab, ca8, 19a, 669, 33f]
[b16, 7fe, fa7, 6ec, 4ab, ca8, 19a, 669, 33f, 9f1]
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
{4=506}
{4=506, 9=fbc}
{0=51b, 4=506, 7=2b2, 9=fbc}
{0=51b, 4=506, 9=fbc}
{0=51b, 4=506, 7=2b2, 8=791, 9=fbc}
{0=51b, 4=506, 6=b9f, 7=2b2, 8=791, 9=fbc}
{0=51b, 3=6dc, 4=506, 6=b9f, 7=2b2, 8=791, 9=fbc}
{0=51b, 2=564, 3=6dc, 4=506, 6=b9f, 7=2b2, 8=791, 9=fbc}
{0=51b, 1=1ff, 2=564, 3=6dc, 4=506, 6=b9f, 7=2b2, 8=791, 9=fbc}
{0=51b, 1=1ff, 2=564, 3=6dc, 4=506, 5=57f, 6=b9f, 7=2b2, 8=791, 9=fbc}
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
{0=5a3}
{0=5a3, 5=953, 8=276}
{0=5a3, 3=eea, 5=953, 8=276}
{0=5a3, 5=953}
{0=5a3, 3=eea, 5=953, 7=358, 8=276}
{0=5a3, 1=51d, 3=eea, 5=953, 7=358, 8=276}
{0=5a3, 1=51d, 2=f52, 3=eea, 5=953, 7=358, 8=276}
{0=5a3, 1=51d, 2=f52, 3=eea, 5=953, 6=56d, 7=358, 8=276}
{0=5a3, 1=51d, 2=f52, 3=eea, 5=953, 6=56d, 7=358, 8=276, 9=b48}
{0=5a3, 1=51d, 2=f52, 3=eea, 4=af8, 5=953, 6=56d, 7=358, 8=276, 9=b48}
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
{2=aae, 5=136}
{2=aae, 3=034, 5=136, 7=691}
{2=aae, 5=136, 7=691}
{0=d99, 2=aae, 3=034, 5=136, 7=691}
{2=aae, 5=136}
{0=d99, 2=aae, 3=034, 4=02a, 5=136, 7=691}
{0=d99, 1=57b, 2=aae, 3=034, 4=02a, 5=136, 7=691}
{0=d99, 1=57b, 2=aae, 3=034, 4=02a, 5=136, 7=691, 8=6ce}
{0=d99, 1=57b, 2=aae, 3=034, 4=02a, 5=136, 7=691, 8=6ce, 9=dbe}
{0=d99, 1=57b, 2=aae, 3=034, 4=02a, 5=136, 6=ca8, 7=691, 8=6ce, 9=dbe}
```



