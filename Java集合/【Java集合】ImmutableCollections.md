#  【Java集合】ImmutableCollections



[toc]



ImmutableCollections：不可变集合
	增：×
	删：×
	改：×
	查：√



## List

### List.of

```java
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = List.of("abc", "def", "ghi");
        System.out.println(list);
    }
}
```

运行结果：

```
[abc, def, ghi]
```



## Set

### Set.of

```java
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<String> set = Set.of("abc", "def", "ghi");
        System.out.println(set);
    }
}
```

运行结果：

```
[abc, ghi, def]
```



## Map

### Map.of（键值对不超过10个）

```java
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("Tom", 1, "Jack", 2, "Mike", 3);
        System.out.println(map);
    }
}
```

运行结果：

```
{Jack=2, Mike=3, Tom=1}
```



### Map.ofEntries（键值对超过10个）

#### 写法一

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Tom", 1);
        map1.put("Jack", 2);
        map1.put("Mike", 3);
        Set<Map.Entry<String, Integer>> set = map1.entrySet();
        Map.Entry[] arr = set.toArray(new Map.Entry[0]);
        Map map2 = Map.ofEntries(arr);
        System.out.println(map2);
    }
}
```

运行结果：

```
{Jack=2, Mike=3, Tom=1}
```



#### 写法二

```java
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Tom", 1);
        map1.put("Jack", 2);
        map1.put("Mike", 3);
        Map map2 = Map.ofEntries(map1.entrySet().toArray(new Map.Entry[0]));
        System.out.println(map2);
    }
}
```

运行结果：

```
{Mike=3, Tom=1, Jack=2}
```



### Map.copyOf

```java
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Tom", 1);
        map1.put("Jack", 2);
        map1.put("Mike", 3);
        Map<String, Integer> map2 = Map.copyOf(map1);
        System.out.println(map2);
    }
}
```

运行结果：

```
{Mike=3, Jack=2, Tom=1}
```

