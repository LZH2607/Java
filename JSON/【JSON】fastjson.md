# 【JSON】fastjson



[toc]



类 ↔ String ↔ JSONObject



## 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>2.0.25</version>
    </dependency>
</dependencies>
```



## 类 → String

```java
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        C c = new C();
        c.i = 1;
        c.s = "Hello, World!";
        String s = JSONObject.toJSONString(c);
        System.out.println(s);
    }
}

class C {
    int i;

    String s;

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }
}
```

运行结果：

```
{"i":1,"s":"Hello, World!"}
```



## 类 ← String

```java
import com.alibaba.fastjson2.JSON;

public class Demo {
    public static void main(String[] args) {
        String s = "{\"i\":1,\"s\":\"Hello, World!\"}";
        C c = JSON.parseObject(s, C.class);
        System.out.println(c);
    }
}

class C {
    int i;

    String s;

    public void setI(int i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "C{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}
```

运行结果：

```
C{i=1, s='Hello, World!'}
```



## String → JSONObject

```java
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        String s = "{\"i\":1,\"s\":\"Hello, World!\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);
    }
}
```

运行结果：

```
{"s":"Hello, World!","i":1}
```



## String ← JSONObject

```java
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("i", 1);
        jsonObject.put("s", "Hello, World!");
        String s = jsonObject.toJSONString();
        System.out.println(s);
    }
}
```

运算结果：

```
{"s":"Hello, World!","i":1}
```



## 类 → JSONObject

```java
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        C c = new C();
        c.i = 1;
        c.s = "Hello, World!";
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(c));
        System.out.println(jsonObject);
    }
}

class C {
    int i;

    String s;

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }
}
```

运行结果：

```
{"s":"Hello, World!","i":1}
```



## 类 ← JSONObject

```java
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("i", 1);
        jsonObject.put("s", "Hello, World!");
        C c = JSON.parseObject(jsonObject.toJSONString(), C.class);
        System.out.println(c);
    }
}

class C {
    int i;

    String s;

    public void setI(int i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "C{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}
```

运行结果：

```
C{i=1, s='Hello, World!'}
```

