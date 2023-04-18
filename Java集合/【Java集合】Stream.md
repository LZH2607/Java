# 【Java集合】Stream



[toc]



相关视频：
[黑马Java基础教程，3小时Java-Stream流从入门到精通](https://www.bilibili.com/video/BV1te411w722/)



## 获取Stream

单列集合：集合.stream
双列集合：需转换成单列集合后获取
数组：Arrays.stream
Stream.of



### 单列集合

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



### 双列集合

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 1);
        map.put("Jack", 2);
        map.put("Mike", 3);

        Set<String> set1 = map.keySet();
        Stream<String> stream1 = set1.stream();
        stream1.forEach(s -> System.out.println(s));

        Set<Map.Entry<String, Integer>> set2 = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream2 = set2.stream();
        stream2.forEach(e -> System.out.println(e));
    }
}
```

运行结果：

```
Mike
Tom
Jack
Mike=3
Tom=1
Jack=2
```



### 数组

```java
import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        String[] arr = {"abc", "def", "ghi"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



### Stream.of

#### 用法一

```java
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("abc", "def", "ghi");
        stream.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



#### 用法二

```java
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        String[] arr = {"abc", "def", "ghi"};  // 引用数据类型的数组
        Stream<String> stream = Stream.of(arr);
        stream.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



## 操作Stream

中间方法：filter、limit、skip、distinct、concat、map
终结方法：forEach、count、toArray、collect

**Stream被操作后即关闭，故Stream只能被操作一次**



### filter

#### 写法一

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");

        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 1;
            }
        });
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
ab
abc
```



#### 写法二

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");

        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.filter(s -> s.length() > 1);
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
ab
abc
```



### limit

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.limit(2);
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
```



### skip

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.skip(2);
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
ghi
```



### distinct

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("abc");

        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.distinct();
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



### concat

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("def");

        List<String> list2 = new ArrayList<>();
        list2.add("abc");
        list2.add("ghi");

        Stream<String> stream1 = list1.stream();
        Stream<String> stream2 = list2.stream();
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
abc
ghi
```



### map

#### 写法一

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Stream<String> stream1 = list.stream();
        Stream<Double> stream2 = stream1.map(new Function<String, Double>() {
            @Override
            public Double apply(String s) {
                return Double.valueOf(s);
            }
        });
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
1.0
2.0
3.0
```



#### 写法二

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Stream<String> stream1 = list.stream();
        Stream<Double> stream2 = stream1.map(s -> Double.valueOf(s));
        stream2.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
1.0
2.0
3.0
```



### forEach

#### 写法一

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
```



#### 写法二

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
abc
def
ghi
```



### count

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
```

运行结果：

```
3
```



### toArray

#### 用法一

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        Object[] arr = stream.toArray();
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[abc, def, ghi]
```



#### 用法二（写法一）

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        String[] arr = stream.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[abc, def, ghi]
```



#### 用法二（写法二）

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Stream<String> stream = list.stream();
        String[] arr = stream.toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr));
    }
}
```

运行结果：

```
[abc, def, ghi]
```



### collect

#### Collectors.toList

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("def");
        list1.add("ghi");

        Stream<String> stream = list1.stream();
        List<String> list2 = stream.collect(Collectors.toList());
        System.out.println(list2);
    }
}
```

运行结果：

```
[abc, def, ghi]
```



#### Collectors.toSet

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("abc");

        Stream<String> stream = list.stream();
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }
}
```

运行结果：

```
[abc, def, ghi]
```



#### Collectors.toMap（写法一）

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom:1");
        list.add("Jack:2");
        list.add("Mike:3");

        Stream<String> stream = list.stream();
        Map<String, Integer> map = stream.collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split(":")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.valueOf(s.split(":")[1]);
                    }
                }));
        System.out.println(map);
    }
}
```

运行结果：

```
{Mike=3, Tom=1, Jack=2}
```



#### Collectors.toMap（写法二）

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom:1");
        list.add("Jack:2");
        list.add("Mike:3");

        Stream<String> stream = list.stream();
        Map<String, Integer> map = stream.collect(Collectors.toMap(
                s -> s.split(":")[0]
                , s -> Integer.valueOf(s.split(":")[1])
        ));
        System.out.println(map);
    }
}
```

运行结果：

```
{Mike=3, Tom=1, Jack=2}
```



## 综合案例

### 案例一

```java
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("d");
        list.add("de");
        list.add("def");

        list.stream()
                .filter(s -> s.contains("a"))
                .filter(s -> s.length() > 1)
                .forEach(s -> System.out.println(s));
    }
}
```

运行结果：

```
ab
abc
```



### 案例二

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        List<Integer> list2 = list1.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n + 1)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
```

运行结果：

```
[3, 5, 7]
```

