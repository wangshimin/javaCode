使用场景
1. 如果想要集合中的**元素可重复**：用**ArrayList**集合，基于数组的。
2. 如果想要集合中的元素可重复，且当前的**增删操作明显多于查询**：用**LinkedList**集合，基于链表的。
3. 如果想对集合中的**元素去重**：用**HashSet**集合，基于哈希表的。
4. 如果想对集合中的元素去重，而且**保证存取顺序**：用**LinkedHashSet**集合，基于哈希表和双链表，效率低于HashSet。
5. 如果想对集合中的元素进行**排序**：用**TreeSet**集合，基于红黑树。后续也可以用List集合实现排序。
