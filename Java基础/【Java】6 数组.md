# 【Java】数组



[toc]



数组：
	长度确定（不可改变）
	属于引用数据类型
	可以看作对象（元素相当于成员变量）
	元素类型相同



## 声明

两种方式

```
数据类型[] 数组名;
数据类型 数组名[];
```

```java
public class Test {
	public static void main(String[] args) {
		int[] arr1;
		int arr2[];
		arr1 = new int[5];
		arr2 = new int[5];
	}
}
```



## 长度

```java
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr.length);
    }
}
```

运行结果：

```
5
```



## 初始化

### 静态初始化

```
数据类型[] 数组名 = {元素1, 元素2, ···, 元素n};
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        User[] userArr = {new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike")};
        System.out.println(Arrays.toString(userArr));
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User{Id:" + id + ", Name:" + name + "}";
    }
}
```

运行结果：

```
[User{Id:1, Name:Tom}, User{Id:2, Name:Jack}, User{Id:3, Name:Mike}]
```



### 动态初始化

#### 方式1

```
数据类型[] 数组名 = new 数据类型[大小];
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 0, 0, 0, 0]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        User[] userArr = new User[3];
        userArr[0] = new User(1, "Tom");
        userArr[1] = new User(2, "Jack");
        userArr[2] = new User(3, "Mike");
        System.out.println(Arrays.toString(userArr));
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User{Id:" + id + ", Name:" + name + "}";
    }
}
```

运行结果：

```
[User{Id:1, Name:Tom}, User{Id:2, Name:Jack}, User{Id:3, Name:Mike}]
```



#### 方式2

```
数据类型[] 数组名;
数组名 = new 数据类型[大小];
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[5];
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 0, 0, 0, 0]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[5];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        User[] userArr;
        userArr = new User[3];
        userArr[0] = new User(1, "Tom");
        userArr[1] = new User(2, "Jack");
        userArr[2] = new User(3, "Mike");
        System.out.println(Arrays.toString(userArr));
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User{Id:" + id + ", Name:" + name + "}";
    }
}
```

运行结果：

```
[User{Id:1, Name:Tom}, User{Id:2, Name:Jack}, User{Id:3, Name:Mike}]
```



## 打印

### Arrays.toString

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
```



### 遍历

```java
public class Test {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[][] arr2 = {{11, 12, 13, 14}, {21, 22, 23, 24}, {21, 22, 23, 24}};
        Print.print1DArray(arr1);
        Print.print2DArray(arr2);
    }
}

class Print {
    static void print1DArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

运行结果：

```
1 2 3 4 5 
11 12 13 14 
21 22 23 24 
21 22 23 24 
```



## 遍历

### for循环

```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
    public static void main(String[] args) {
        User[] userArr = {new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike")};
        for (int i = 0; i < userArr.length; i++) {
            System.out.println(userArr[i]);
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User{Id:" + id + ", Name:" + name + "}";
    }
}
```

运行结果：

```
User{Id:1, Name:Tom}
User{Id:2, Name:Jack}
User{Id:3, Name:Mike}
```



### foreach循环

for循环：可以读取、可以修改
foreach循环：可以读取、不能修改

```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
```

运行结果：

```
0
1
2
3
4
```



```java
public class Test {
    public static void main(String[] args) {
        User[] userArr = {new User(1, "Tom"), new User(2, "Jack"), new User(3, "Mike")};
        for (User user : userArr) {
            System.out.println(user);
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User{Id:" + id + ", Name:" + name + "}";
    }
}
```

运行结果：

```
User{Id:1, Name:Tom}
User{Id:2, Name:Jack}
User{Id:3, Name:Mike}
```



## 自动类型转换

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        double[] arr = {0, 1.1, 2, 3.3, 4};
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0.0, 1.1, 2.0, 3.3, 4.0]
```



## 默认赋值

| 数据类型 | 默认赋值 |
| :------: | :------: |
|   byte   |    0     |
|  short   |    0     |
|   int    |    0     |
|   long   |    0     |
|  float   |   0.0    |
|  double  |   0.0    |
|   char   |  \u0000  |
| boolean  |  false   |
|  String  |   null   |

```java
public class Test {
    public static void main(String[] args) {
        byte[] b = new byte[1];
        short[] s = new short[1];
        int[] i = new int[1];
        long[] l = new long[1];
        float[] f = new float[1];
        double[] d = new double[1];
        char[] c = new char[1];
        boolean[] bool = new boolean[1];
        String[] str = new String[1];
        System.out.println(b[0]);
        System.out.println(s[0]);
        System.out.println(i[0]);
        System.out.println(l[0]);
        System.out.println(f[0]);
        System.out.println(d[0]);
        System.out.println(c[0]);
        System.out.println(bool[0]);
        System.out.println(str[0]);
    }
}
```

运行结果：

```
0
0
0
0
0.0
0.0

false
null
```



## 赋值

引用传递/地址传递

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = arr1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        arr2[0] = -1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[0, 1, 2, 3, 4]
[-1, 1, 2, 3, 4]
[-1, 1, 2, 3, 4]
```



## 填充

### Arrays.fill

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[1, 1, 1, 1, 1]
```



## 拷贝

### System.arraycopy

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[0, 1, 2, 3, 4]
```



### Arrays.copyOf

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[0, 1, 2, 3, 4]
```



### Arrays.copyOfRange

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = Arrays.copyOfRange(arr1, 1, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[1, 2, 3]
```



### 遍历

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4]
[0, 1, 2, 3, 4]
```



## 扩容

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[] temp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[temp.length - 1] = 5;
        arr = temp;
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[0, 1, 2, 3, 4, 5]
```



## 查找

### 顺序查找

```java
public class Test {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        int target = 80;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
```

运行结果：

```
2
```



## 反转

### Collections.reverse

```java
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4};
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[4, 3, 2, 1, 0]
```



### 手动反转（方法1）

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[4, 3, 2, 1, 0]
```



### 手动反转（方法2）

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            temp[j] = arr[i];
        }
        arr = temp;
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[4, 3, 2, 1, 0]
```



## 排序

### Arrays.sort

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[24, 69, 80, 57, 13]
[13, 24, 57, 69, 80]
```



### 冒泡排序

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println(Arrays.toString(arr));
        Sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Sort {
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
```

运行结果：

```
[24, 69, 80, 57, 13]
[13, 24, 57, 69, 80]
```



## 二维数组

### 声明

```
数据类型[][] 数组名;
数据类型 数组名[][];
数据类型[] 数组名[];
```

```java
public class Test {
	public static void main(String[] args) {
		int[][] arr1;
		int arr2[][];
		int[] arr3[];
		arr1 = new int[3][4];
		arr2 = new int[3][4];
		arr3 = new int[3][4];
	}
}
```



### 静态初始化

```
数据类型[][] 数组名 = {{元素1, 元素2, ···}, {元素1, 元素2, ···}, ···}
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2}, {10, 11, 12, 13}, {20, 21, 22, 23, 24}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
```

运行结果：

```
[0, 1, 2]
[10, 11, 12, 13]
[20, 21, 22, 23, 24]
```



### 动态初始化

```
数据类型[][] 数组名 = new 数据类型[大小][大小];
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 2;
        arr[0][3] = 3;
        arr[1][0] = 10;
        arr[1][1] = 11;
        arr[1][2] = 12;
        arr[1][3] = 13;
        arr[2][0] = 20;
        arr[2][1] = 21;
        arr[2][2] = 22;
        arr[2][3] = 23;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
```

运行结果：

```
[0, 1, 2, 3]
[10, 11, 12, 13]
[20, 21, 22, 23]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr;
        arr = new int[3][4];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 2;
        arr[0][3] = 3;
        arr[1][0] = 10;
        arr[1][1] = 11;
        arr[1][2] = 12;
        arr[1][3] = 13;
        arr[2][0] = 20;
        arr[2][1] = 21;
        arr[2][2] = 22;
        arr[2][3] = 23;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
```

运行结果：

```
[0, 1, 2, 3]
[10, 11, 12, 13]
[20, 21, 22, 23]
```



```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[4];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[1][0] = 10;
        arr[1][1] = 11;
        arr[1][2] = 12;
        arr[2][0] = 20;
        arr[2][1] = 21;
        arr[2][2] = 22;
        arr[2][3] = 23;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
```

运行结果：

```
[0, 1]
[10, 11, 12]
[20, 21, 22, 23]
```



### 遍历

```java
public class Test {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 3, 4}, {10, 11, 12, 13, 14}, {20, 21, 22, 23, 24}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

运行结果：

```
[I@1d44bcfa
[I@266474c2
[I@6f94fa3e
```



```java
public class Test {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 3, 4}, {10, 11, 12, 13, 14}, {20, 21, 22, 23, 24}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

运行结果：

```
0 1 2 3 4 
10 11 12 13 14 
20 21 22 23 24 
```

