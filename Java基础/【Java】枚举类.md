# 【Java】枚举类



[toc]



## 自定义

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.FALL);
        System.out.println(Season.WINTER);
    }
}

class Season {
    private final String NAME;
    private final String DESC;
    public static final Season SPRING = new Season("春季", "温暖");
    public static final Season SUMMER = new Season("夏季", "炎热");
    public static final Season FALL = new Season("秋季", "凉爽");
    public static final Season WINTER = new Season("冬季", "寒冷");

    public String getNAME() {
        return NAME;
    }

    public String getDESC() {
        return DESC;
    }

    private Season(String NAME, String DESC) {
        this.NAME = NAME;
        this.DESC = DESC;
    }

    @Override
    public String toString() {
        return "Season{" +
                "NAME='" + NAME + '\'' +
                ", DESC='" + DESC + '\'' +
                '}';
    }
}
```

运行结果：

```
Season{NAME='春季', DESC='温暖'}
Season{NAME='夏季', DESC='炎热'}
Season{NAME='秋季', DESC='凉爽'}
Season{NAME='冬季', DESC='寒冷'}
```



## enum

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.FALL);
        System.out.println(Season.WINTER);
    }
}

enum Season {
    SPRING("春季", "温暖"),
    SUMMER("夏季", "炎热"),
    FALL("秋季", "凉爽"),
    WINTER("冬季", "寒冷");

    private final String NAME;
    private final String DESC;

    public String getNAME() {
        return NAME;
    }

    public String getDESC() {
        return DESC;
    }

    private Season(String NAME, String DESC) {
        this.NAME = NAME;
        this.DESC = DESC;
    }

    @Override
    public String toString() {
        return "Season{" +
                "NAME='" + NAME + '\'' +
                ", DESC='" + DESC + '\'' +
                '}';
    }
}
```

运行结果：

```
Season{NAME='春季', DESC='温暖'}
Season{NAME='夏季', DESC='炎热'}
Season{NAME='秋季', DESC='凉爽'}
Season{NAME='冬季', DESC='寒冷'}
```

