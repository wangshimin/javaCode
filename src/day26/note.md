### Stream流
#### 作用
 结合了Lambda表达式，简化集合、数组的操作

#### 使用步骤
1. 先创建一个Stream流（流水线），并把数据放上去

   | 获取方式 | 方法                                                | 说明 |
   |------|---------------------------------------------------|----|
   | 单列集合 | default Stream\<E\> stream()                      | 获取集合的Stream流，Collection接口中的默认方法   |
   | 双列集合 | 无                                                 | 无法直接使用Stream流  |
   | 数组   | public static \<T\> Stream\<T\> stream(T[] array) | 获取数组的Stream流，Arrays工具中的静态方法   |
   | 一堆散列数据 | public static Stream\<T\> of(T... values)                                                  | Stream接口中的静态方法   |


2. 利用流中的API进行各种操作
    - 2.1 使用**中间方法**对流水线上的数据进行操作
   
      | 名称                                                      | 说明                             |
      |---------------------------------------------------------|--------------------------------|
      | Stream\<T\> **filter**(Predicate<? super T> predicate)  | 过滤                             |
      | Stream\<T\> **limit**(long maxSize)                     | 获取前几个元素                        |
      | Stream\<T\> **skip**(long n)                            | 跳过前几个元素                        |                                                    |         |
      | Stream\<T\> **distinct**()                              | 元素去重，依赖（集合中的hashCode和equals方法） |
      | static \<T\> Stream\<T\> **concat**(Stream a, Stream b) | 合并两个流                          |
      | Stream\<R\> **map**(Function<T, R> mapper)              | 转换流中的数据类型                      |

      > 注意！！
      > - 中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
      > - 修改Sream流中的数据，不会影响原来的数据

   - 2.2 使用**终结方法**对流水线上的数据进行操作
            
      | 名称                                | 说明            |
      |-----------------------------------|---------------|
      | void **forEach**(Consumer action) | 遍历            |
      | long **count**()                  | 统计个数          |
      | **toArray**()                     | 收集流中的数据，放到数组中 |
      | **collect**(Collector collector)  | 收集流中的数据，放到集合中 |

### 方法引用
概述：方法引用是把已经存在的方法拿过来用，当作函数式接口中抽象方法的方法体。
#### 方法引用需要注意什么？
- 需要有函数式接口
- 被引用方法必须已经存在
- 被引用方法的形参和返回值需要跟抽象方法保持一致
- 被引用方法的功能要满足当前的需求
#### 方法引用的分类
##### 引用静态方法
> 格式：类名::静态方法名
> 示例：Integer::parseInt
##### 引用成员方法
> 格式：对象::成员方法名
> - 其他类：其他类对象::方法名
> - 本类：this::方法名
> - 父类：super::方法名
##### 引用构造方法
> 格式：类名::new
> 示例：Student::new
##### 使用类名引用成员方法
> 格式：类名::成员方法
> 示例：String::length， String::substring
##### 引用数组的构造方法
> 格式：类型[]::new
> 示例：String[]::new

