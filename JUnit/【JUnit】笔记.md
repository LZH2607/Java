# 【JUnit】笔记



[toc]



测试驱动开发（Test-Driven Development，TDD）

编写接口 → 编写测试 → 编写实现 → 运行测试 → 任务完成



JUnit设计：
	TestCase：一个测试
	TestSuite：一组测试，包含一组TestCase
	TestFixture：测试环境
	TestResult：收集测试结果
	TestRunner：运行测试
	TestListener：监听测试过程，收集测试数据
	Assert：断言测试



## 示例

Demo.java：

```java
package test;

public class Demo {
	public int add(int i1, int i2) {
		return i1 + i2;
	}

	public int minus(int i1, int i2) {
		return i1 - i2;
	}
}
```

DemoTest.java：

```java
package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest {

	@Test
	public void testAdd() {
		assertEquals(3, new Demo().add(1, 2));
	}

	@Test
	public void testMinus() {
		assertEquals(-1, new Demo().minus(1, 2));
	}

}
```



## Assert断言

junit.framework.TestCase：

断言相等：

```java
public static void assertEquals(byte expected, byte actual);
public static void assertEquals(short expected, short actual);
public static void assertEquals(int expected, int actual);
public static void assertEquals(long expected, long actual);
public static void assertEquals(float expected, float actual, float delta);
public static void assertEquals(double expected, double actual, double delta);
public static void assertEquals(char expected, char actual);
public static void assertEquals(boolean expected, boolean actual);
···
```

断言为null：

```java
public static void assertNull(Object object);
public static void assertNull(String message, Object object);
```

断言不为null：

```java
public static void assertNotNull(Object object);
public static void assertNotNull(String message, Object object);
```

断言为true：

```java
public static void assertTrue(boolean condition);
public static void assertTrue(String message, boolean condition);
```



## @Before、@After、@BeforeClass、@AfterClass

相关视频：


