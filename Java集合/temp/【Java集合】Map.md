# 【Java集合】Map



[toc]



## Map

Map：
	键值对：无序、无下标
		键：不可重复（唯一）
		值：可重复

相关链接：
[Interface Map<K,V>](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
![](D:\Notes\Java\Java集合\img\Map All Methods.png)



## 添加键值对

### put

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		m.put("Mike", 4);
		System.out.println(m.size());
		System.out.println(m);
	}
}
```

运行结果：

```
3
{Mike=4, Tom=1, Jack=2}
```



## 删除键值对

### remove

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		m.remove("Tom");
		System.out.println(m.size());
		System.out.println(m);
	}
}
```

运行结果：

```
2
{Mike=3, Jack=2}
```



## 获取键

### keySet

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		Set<String> s = m.keySet();
		System.out.println(s.size());
		System.out.println(s);
	}
}
```

运行结果：

```
3
[Mike, Tom, Jack]
```



## 获取值

### get

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		int i = m.get("Tom");
		System.out.println(i);
	}
}
```

运行结果：

```
1
```



### values

```java
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		Collection<Integer> c = m.values();
		System.out.println(c);
	}
}
```

运行结果：

```
[3, 1, 2]
```



## 遍历键值对

### for

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		for (String key : m.keySet()) {
			System.out.println(key + ": " + m.get(key));
		}
	}
}
```

运行结果：

```
Mike: 3
Tom: 1
Jack: 2
```



### entrySet

效率更高（只遍历一遍）

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		for (Entry<String, Integer> e : m.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}
}
```

运行结果：

```
Mike: 3
Tom: 1
Jack: 2
```



## 查找键

### containsKey

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		System.out.println(m.containsKey("Tom"));
	}
}
```

运行结果：

```
true
```



## 查找值

### containsValue

```java
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 1);
		m.put("Jack", 2);
		m.put("Mike", 3);
		System.out.println(m.containsValue(1));
	}
}
```

运行结果：

```
true
```

