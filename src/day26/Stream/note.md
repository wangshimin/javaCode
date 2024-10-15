### Stream流
#### 作用
 结合了Lambda表达式，简化集合、数组的操作

| 获取方式 | 方法 | 说明  |
|-----|----|---|
| 单列集合 | default Stream<E> stream()|  获取集合的Stream流，Collection接口中的默认方法 |
| 双列集合 | 无  |无法直接使用Stream流|
| 数组  | public static <T> Stream<T> stream(T[] array) |获取数组的Stream流，Arrays工具中的静态方法|
| 一堆散列数据 | public static Stream<T> of(T... values) | Stream接口中的静态方法|

#### 使用步骤
1. 先创建一个Stream流（流水线），并把数据放上去
2. 利用流中的API进行各种操作
    - 2.1 使用**中间方法**对流水线上的数据进行操作
    - 2.2 使用**终结方法**对流水线上的数据进行操作
