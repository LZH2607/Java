# 【Java集合】概念



[toc]



## 集合

集合：
	单列集合：Collection
	双列集合：Map

|      |            数组            |     集合     |
| :--: | :------------------------: | :----------: |
| 长度 |            固定            |    不固定    |
| 存储 | 基本数据类型、引用数据类型 | 引用数据类型 |



### 单列集合

Iterable（接口）
	Collection（接口）
		List（接口）：有序、有下标、元素可重复
			ArrayList（类）
			LinkedList（类）
			Vector（类）
		Set（接口）：无序、无下标、元素不可重复
			HashSet（类）
			SortedSet（接口）
				TreeSet（类）
			LinkedHashSet



### 双列集合

Map
	HashMap
		LinkedHashMap
	Hashtable
		Properties
	TreeMap



## List及其实现类

List及其实现类：有序、有下标、元素可重复

|          | ArrayList | Vector | LinkedList |
| :------: | :-------: | :----: | :--------: |
|   实现   |   数组    |  数组  |    链表    |
|   查询   |    快     |   快   |     慢     |
|   增删   |    慢     |   慢   |     快     |
| 运行效率 |    快     |   慢   |            |
|   线程   |  不安全   |  安全  |            |
|   JDK    |   ≥1.2    |  ≥1.0  |            |
