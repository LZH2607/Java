# 【Java】线程



[toc]



## 查看进程

```
jconsole
```



## 创建线程

创建线程：
	Thread
	Runnable
	Callable
	线程池



### Thread

```java
public class Demo {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T1.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T2.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
Thread-1.T2.run: 0
Thread-0.T1.run: 0
Thread-0.T1.run: 1
Thread-1.T2.run: 1
Thread-1.T2.run: 2
Thread-0.T1.run: 2
Thread-1.T2.run: 3
Thread-0.T1.run: 3
Thread-1.T2.run: 4
Thread-0.T1.run: 4
Thread-0.T1.run: 5
Thread-1.T2.run: 5
Thread-0.T1.run: 6
Thread-1.T2.run: 6
Thread-0.T1.run: 7
Thread-1.T2.run: 7
Thread-0.T1.run: 8
Thread-1.T2.run: 8
Thread-1.T2.run: 9
Thread-0.T1.run: 9
```



### Runnable

#### 写法一

```java
public class Demo {
    public static void main(String[] args) {
        R1 r1 = new R1();
        R2 r2 = new R2();
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }
}

class R1 implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".R1.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


class R2 implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".R2.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
Thread-0.R1.run: 0
Thread-1.R2.run: 0
Thread-1.R2.run: 1
Thread-0.R1.run: 1
Thread-0.R1.run: 2
Thread-1.R2.run: 2
Thread-0.R1.run: 3
Thread-1.R2.run: 3
Thread-1.R2.run: 4
Thread-0.R1.run: 4
Thread-0.R1.run: 5
Thread-1.R2.run: 5
Thread-1.R2.run: 6
Thread-0.R1.run: 6
Thread-1.R2.run: 7
Thread-0.R1.run: 7
Thread-0.R1.run: 8
Thread-1.R2.run: 8
Thread-0.R1.run: 9
Thread-1.R2.run: 9
```



#### 写法二

```java
public class Demo {
    public static void main(String[] args) {
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            int cnt = 0;
            while (cnt < 10) {
                System.out.println(threadName + ": " + cnt);
                cnt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            int cnt = 0;
            while (cnt < 10) {
                System.out.println(threadName + ": " + cnt);
                cnt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "thread2").start();
    }
}
```

运行结果：

```
thread1: 0
thread2: 0
thread2: 1
thread1: 1
thread2: 2
thread1: 2
thread2: 3
thread1: 3
thread2: 4
thread1: 4
thread2: 5
thread1: 5
thread2: 6
thread1: 6
thread2: 7
thread1: 7
thread2: 8
thread1: 8
thread2: 9
thread1: 9
```



### Callable

#### 写法一

```java
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();
        FutureTask<Integer> futureTask1 = new FutureTask<>(c1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(c2);
        Thread t1 = new Thread(futureTask1);
        Thread t2 = new Thread(futureTask2);
        t1.start();
        t2.start();
    }
}

class C1 implements Callable {
    @Override
    public Integer call() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".C1.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}

class C2 implements Callable {
    @Override
    public Integer call() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".C2.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
```

运行结果：

```
Thread-0.C1.run: 0
Thread-1.C2.run: 0
Thread-1.C2.run: 1
Thread-0.C1.run: 1
Thread-0.C1.run: 2
Thread-1.C2.run: 2
Thread-1.C2.run: 3
Thread-0.C1.run: 3
Thread-0.C1.run: 4
Thread-1.C2.run: 4
Thread-0.C1.run: 5
Thread-1.C2.run: 5
Thread-0.C1.run: 6
Thread-1.C2.run: 6
Thread-1.C2.run: 7
Thread-0.C1.run: 7
Thread-0.C1.run: 8
Thread-1.C2.run: 8
Thread-0.C1.run: 9
Thread-1.C2.run: 9
```



#### 写法二

```java
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask1 = new FutureTask<>(() -> {
            String threadName = Thread.currentThread().getName();
            int cnt = 0;
            while (cnt < 10) {
                System.out.println(threadName + ": " + cnt);
                cnt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            return 0;
        });

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            String threadName = Thread.currentThread().getName();
            int cnt = 0;
            while (cnt < 10) {
                System.out.println(threadName + ": " + cnt);
                cnt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            return 0;
        });

        new Thread(futureTask1, "thread1").start();
        new Thread(futureTask2, "thread2").start();
    }
}
```

运行结果：

```
Thread-0: 0
Thread-1: 0
Thread-1: 1
Thread-0: 1
Thread-1: 2
Thread-0: 2
Thread-0: 3
Thread-1: 3
Thread-1: 4
Thread-0: 4
Thread-1: 5
Thread-0: 5
Thread-1: 6
Thread-0: 6
Thread-1: 7
Thread-0: 7
Thread-0: 8
Thread-1: 8
Thread-1: 9
Thread-0: 9
```



## 常用方法

### setName、getName

```java
public class Demo {
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        t1.setName("t1");
        t2.setName("t2");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.start();
        t2.start();
    }
}

class T extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ": " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
t1
t2
t2: 0
t1: 0
t1: 1
t2: 1
t2: 2
t1: 2
t2: 3
t1: 3
t2: 4
t1: 4
t2: 5
t1: 5
t1: 6
t2: 6
t1: 7
t2: 7
t1: 8
t2: 8
t2: 9
t1: 9
```



### setPriority、getPriority

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.MIN_PRIORITY);  // 1
        System.out.println(Thread.NORM_PRIORITY);  // 5
        System.out.println(Thread.MAX_PRIORITY);  // 10
        T t1 = new T();
        T t2 = new T();
        t1.setPriority(1);
        t2.setPriority(2);
        System.out.println(t1.getPriority());  // 1
        System.out.println(t2.getPriority());  // 2
        t1.start();
        t2.start();
    }
}

class T extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ": " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
1
5
10
1
2
Thread-0: 0
Thread-1: 0
Thread-1: 1
Thread-0: 1
Thread-1: 2
Thread-0: 2
Thread-1: 3
Thread-0: 3
Thread-0: 4
Thread-1: 4
Thread-0: 5
Thread-1: 5
Thread-0: 6
Thread-1: 6
Thread-0: 7
Thread-1: 7
Thread-0: 8
Thread-1: 8
Thread-0: 9
Thread-1: 9
```



### interrupt

中断线程休眠

```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(5000);
        t.interrupt();
    }
}

class T extends Thread {
    @Override
    public void run() {
        Long time1 = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
```

运行结果：

```
sleep interrupted
5004
```



### join

```java
public class Demo {
    public static void main(String[] args) {
        T2 t = new T2();
        t.start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T1.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        T1 t = new T1();
        t.start();
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T2.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
                if (cnt == 5) {
                    t.join();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
Thread-0.T2.run: 0
Thread-1.T1.run: 0
Thread-1.T1.run: 1
Thread-0.T2.run: 1
Thread-0.T2.run: 2
Thread-1.T1.run: 2
Thread-0.T2.run: 3
Thread-1.T1.run: 3
Thread-0.T2.run: 4
Thread-1.T1.run: 4
Thread-1.T1.run: 5
Thread-1.T1.run: 6
Thread-1.T1.run: 7
Thread-1.T1.run: 8
Thread-1.T1.run: 9
Thread-0.T2.run: 5
Thread-0.T2.run: 6
Thread-0.T2.run: 7
Thread-0.T2.run: 8
Thread-0.T2.run: 9
```



### yield

```java
public class Demo {
    public static void main(String[] args) {
        T2 t = new T2();
        t.start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T1.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        T1 t = new T1();
        t.start();
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ".T2.run: " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (cnt == 5) {
                Thread.yield();
            }
        }
    }
}
```

运行结果：

```
Thread-0.T2.run: 0
Thread-1.T1.run: 0
Thread-1.T1.run: 1
Thread-0.T2.run: 1
Thread-1.T1.run: 2
Thread-0.T2.run: 2
Thread-0.T2.run: 3
Thread-1.T1.run: 3
Thread-0.T2.run: 4
Thread-1.T1.run: 4
Thread-1.T1.run: 5
Thread-0.T2.run: 5
Thread-1.T1.run: 6
Thread-0.T2.run: 6
Thread-0.T2.run: 7
Thread-1.T1.run: 7
Thread-0.T2.run: 8
Thread-1.T1.run: 8
Thread-1.T1.run: 9
Thread-0.T2.run: 9
```



### 线程退出

```java
public class Demo {
    public static void main(String[] args) {
        T t = new T();
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        t.setFlag(false);
    }
}

class T extends Thread {
    boolean flag = true;

    void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int cnt = 0;
        while (flag) {
            System.out.println(cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
0
1
2
```



### setDaemon

用户线程 / 工作线程
守护线程：setDaemon

```java
public class Demo {
    public static void main(String[] args) {
        T t = new T();
        t.setDaemon(true);
        t.start();
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(threadName + ": " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int cnt = 0;
        while (true) {
            System.out.println(threadName + ": " + cnt);
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
main: 0
Thread-0: 0
Thread-0: 1
main: 1
Thread-0: 2
main: 2
main: 3
Thread-0: 3
Thread-0: 4
main: 4
Thread-0: 5
main: 5
Thread-0: 6
main: 6
Thread-0: 7
main: 7
main: 8
Thread-0: 8
main: 9
Thread-0: 9
Thread-0: 10
```



## 线程状态

线程状态：
	New
	Runnable：Ready、Running
	Waiting
	TimedWaiting
	Blocked
	Terminated

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.State.NEW);  // NEW
        System.out.println(Thread.State.RUNNABLE);  // RUNNABLE
        System.out.println(Thread.State.BLOCKED);  // BLOCKED
        System.out.println(Thread.State.WAITING);  // WAITING
        System.out.println(Thread.State.TIMED_WAITING);  // TIMED_WAITING
        System.out.println(Thread.State.TERMINATED);  // TERMINATED
    }
}
```

运行结果：

```
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
```



### getState

```java
public class Demo {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.getState());
        t.start();
        int cnt = 0;
        while (cnt < 30) {
            System.out.println(t.getState());
            cnt++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        int cnt = 0;
        while (cnt < 10) {
            System.out.println(getState());
            cnt++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
```

运行结果：

```
NEW
RUNNABLE
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
RUNNABLE
TIMED_WAITING
TIMED_WAITING
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
TERMINATED
```



## synchronized

```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println(C.resource);
        System.out.println(C.cnt);
    }
}

class C {
    static int resource = 10000;
    static int cnt = 0;

    static void f() {
        if (resource > 0) {
            resource--;
            cnt++;
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (C.resource > 0) {
            C.f();
        }
    }
}
```

运行结果：

```
0
10005
```



### 同步方法

|   同步方法   |    锁     |
| :----------: | :-------: |
| 普通同步方法 | 实例对象  |
| 静态同步方法 | 类的Class |



```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println(C.resource);
        System.out.println(C.cnt);
    }
}

class C {
    static int resource = 10000;
    static int cnt = 0;

    synchronized static void f() {
        if (resource > 0) {
            resource--;
            cnt++;
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (C.resource > 0) {
            C.f();
        }
    }
}
```

运行结果：

```
0
10000
```



### 同步代码块

```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println(C.resource);
        System.out.println(C.cnt);
    }
}

class C {
    static int resource = 10000;
    static int cnt = 0;

    static void f() {
        synchronized (C.class) {
            if (resource > 0) {
                resource--;
                cnt++;
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (C.resource > 0) {
            C.f();
        }
    }
}
```

运行结果：

```
0
10000
```



```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        T t1 = new T(c);
        T t2 = new T(c);
        T t3 = new T(c);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println(c.resource);
        System.out.println(c.cnt);
    }
}

class C {
    int resource = 10000;
    int cnt = 0;

    void f() {
        synchronized (this) {
            if (resource > 0) {
                resource--;
                cnt++;
            }
        }
    }
}

class T extends Thread {
    C c;

    T(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (c.resource > 0) {
            c.f();
        }
    }
}
```

运行结果：

```
0
10000
```

