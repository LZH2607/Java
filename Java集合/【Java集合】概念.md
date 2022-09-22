# 【Java集合】概念



[toc]



相关视频：
[千锋教育新版Java集合框架详解（从入门到上手）](https://www.bilibili.com/video/BV16K4y1x7Gi)
[【韩顺平讲Java】Java集合专题 -ArrayList HashMap HashSet List Map TreeMap TreeSet等](https://www.bilibili.com/video/BV1YA411T76k)



## 集合

集合：
	单列集合：Collection
	双列集合：Map

|      |            数组            |     集合     |
| :--: | :------------------------: | :----------: |
| 长度 |            固定            |    不固定    |
| 存储 | 基本数据类型、引用数据类型 | 引用数据类型 |

有序：添加的顺序 = 遍历的顺序
无序：添加的顺序 ≠ 遍历的顺序



### 单列集合

Collection（接口）
	List（接口）：有序、有下标、元素可重复
		ArrayList（类）
		LinkedList（类）
		Vector（类）
	Set（接口）：无序、无下标、元素不可重复
		HashSet（类）
		TreeSet（类）



### 双列集合

Map（接口）
	HashMap（类）
		LinkedHashMap（类）
	TreeMap（类）
	Hashtable（类）
		Properties（类）



## List及其实现类

List：有序、有下标、元素可重复
ArrayList：有序、有下标、元素可重复
Vector：有序、有下标、元素可重复
LinkedList：有序、有下标、元素可重复

|          | ArrayList | Vector | LinkedList |
| :------: | :-------: | :----: | :--------: |
|   实现   |   数组    |  数组  |    链表    |
|   查询   |    快     |   快   |     慢     |
|   增删   |    慢     |   慢   |     快     |
| 运行效率 |    快     |   慢   |            |
|   线程   |  不安全   |  安全  |            |
|   JDK    |   ≥1.2    |  ≥1.0  |            |



## Set及其实现类

Set：无序、无下标、元素不可重复
HashSet：无序、无下标、元素不可重复
TreeSet：无序、无下标、元素不可重复（基于排序实现）

|          |             HashSet             |      |
| :------: | :-----------------------------: | :--: |
| 存储结构 |             哈希表              |      |
|   实现   | 数组 + 链表 + 红黑树（JDK≥1.8） |      |
|          |                                 |      |



## Map及其实现类

Map：
	存储键值对：无序、无下标
		键：不可重复（唯一）
		值：可重复

|                 | HashMap | Hashtable |
| :-------------: | :-----: | :-------: |
|      线程       | 不安全  |   安全    |
|    运行效率     |   快    |    慢     |
| 用null作为键/值 |  允许   |  不运行   |
|       JDK       |  ≥1.2   |   ≥1.0    |

