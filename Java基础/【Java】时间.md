# 【Java】时间



[toc]



## Date

### Date

```java
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
```

运行结果：

```
Mon Mar 06 21:44:59 CST 2023
```



### Date → String

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        String s = dateFormat.format(date);
        System.out.println(s);
    }
}
```

运行结果：

```
2023-03-06 09:46:14:760
```



```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println(dateFormat.format(new Date(-2L)));
        System.out.println(dateFormat.format(new Date(-1L)));
        System.out.println(dateFormat.format(new Date(0L)));
        System.out.println(dateFormat.format(new Date(1L)));
        System.out.println(dateFormat.format(new Date(2L)));
    }
}
```

运行结果：

```
1970-01-01 07:59:59:998
1970-01-01 07:59:59:999
1970-01-01 08:00:00:000
1970-01-01 08:00:00:001
1970-01-01 08:00:00:002
```



### String → Date

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws ParseException {
        String s = "2022-12-31 23:59:59:999";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        Date date = dateFormat.parse(s);
        System.out.println(date);
    }
}
```

运行结果：

```
Sat Dec 31 23:59:59 CST 2022
```



### before、after、equals

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        Date date1 = dateFormat.parse("2022-12-31 23:59:59:999");
        Date date2 = dateFormat.parse("2023-01-01 00:00:00:000");
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
        System.out.println(date1.equals(date2));
    }
}
```

运行结果：

```
true
false
false
```



### compareTo

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        Date date1 = dateFormat.parse("2022-12-31 23:59:59:999");
        Date date2 = dateFormat.parse("2023-01-01 00:00:00:000");
        System.out.println(date1.compareTo(date2));
        System.out.println(date2.compareTo(date1));
    }
}
```

运行结果：

```
-1
1
```
