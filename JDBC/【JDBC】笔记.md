# 【JDBC】笔记



[toc]



JDBC（Java Database Connectivity）：Java数据库连接
	关系型数据库
	标准接口 → 面向接口编程



## 示例

```java
package com.test;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db?useSSL=false";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 定义sql
        String sql = "update account set money = 1000 where id = 1";

        // 4. 获取执行sql的对象
        Statement statement = connection.createStatement();

        // 5. 执行sql
        int count = statement.executeUpdate(sql);

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        statement.close();
        connection.close();
    }
}
```

运行结果：

```
1
```



## DriverManager

DriverManager：
	注册驱动
	获取数据库连接



## Connection

java.sql.Connection：

```java
public abstract java.sql.Statement createStatement() throws java.sql.SQLException;
public abstract java.sql.PreparedStatement prepareStatement(String sql) throws java.sql.SQLException;
public abstract java.sql.CallableStatement prepareCall(String sql) throws java.sql.SQLException;
public abstract void setAutoCommit(boolean autoCommit) throws java.sql.SQLException;
public abstract void commit() throws java.sql.SQLException;
public abstract void rollback() throws java.sql.SQLException;
```



### 获取执行SQL的对象

普通的对象：

```java
public abstract java.sql.Statement createStatement() throws java.sql.SQLException;
```

预编译SQL的对象：防止SQL注入

```java
public abstract java.sql.PreparedStatement prepareStatement(String sql) throws java.sql.SQLException;
```

执行存储过程的对象：

```java
public abstract java.sql.CallableStatement prepareCall(String sql) throws java.sql.SQLException;
```



### 管理事务

| 事务管理 |            MySQL            |           JDBC            |
| :------: | :-------------------------: | :-----------------------: |
| 开启事务 | BEGIN; / START TRANSACTION; | setAutoCommit(autoCommit) |
| 提交事务 |           COMMIT;           |         commit()          |
| 回滚事务 |          ROLLBACK;          |        rollback()         |

autoCommit：
	true：自动提交事务
	false：手动提交事务

示例：

```java
package com.test;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db?useSSL=false";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 定义sql
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        // 4. 获取执行sql的对象
        Statement statement = connection.createStatement();

        try {
            // 开启事务
            connection.setAutoCommit(false);

            // 5. 执行sql
            int count1 = statement.executeUpdate(sql1);
            int count2 = statement.executeUpdate(sql2);

            // 6. 处理结果
            System.out.println(count1);
            System.out.println(count2);

            // 提交事务
            connection.commit();

        } catch (Exception throwables) {
            // 事务回滚
            connection.rollback();

            throwables.printStackTrace();
        }

        // 7. 释放资源
        statement.close();
        connection.close();
    }
}
```

运行结果：

```
1
1
```



## Statement

执行SQL语句

java.sql.Statement：

```java
public abstract int executeUpdate(String sql) throws java.sql.SQLException;
public abstract java.sql.ResultSet executeQuery(String sql) throws java.sql.SQLException;
```

执行DML、DDL语句：executeUpdate(sql)
执行DQL语句：executeQuery(sql)



## ResultSet

java.sql.ResultSet：

```java
public abstract boolean next() throws java.sql.SQLException;
byte getByte(int columnIndex) throws SQLException;
byte getByte(String columnLabel) throws SQLException;
short getShort(int columnIndex) throws SQLException;
short getShort(String columnLabel) throws SQLException;
int getInt(int columnIndex) throws SQLException;
int getInt(String columnLabel) throws SQLException;
long getLong(int columnIndex) throws SQLException;
long getLong(String columnLabel) throws SQLException;
float getFloat(int columnIndex) throws SQLException;
float getFloat(String columnLabel) throws SQLException;
double getDouble(int columnIndex) throws SQLException;
double getDouble(String columnLabel) throws SQLException;
boolean getBoolean(int columnIndex) throws SQLException;
boolean getBoolean(String columnLabel) throws SQLException;
String getString(int columnIndex) throws SQLException;
String getString(String columnLabel) throws SQLException;
···
```

示例：

```java
package com.test;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db?useSSL=false";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 定义sql
        String sql = "select * from account";

        // 4. 获取执行sql的对象
        Statement statement = connection.createStatement();

        // 5. 执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        // 6. 处理结果
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);
            System.out.println(id + " " + name + " " + money);
        }

        // 7. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

运行结果：

```
1 张三 1000.0
2 李四 1000.0
```

