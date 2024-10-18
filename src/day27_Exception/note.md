## Exception
### 1. 概述
叫做异常，代表程序可能出现的问题。我们通常会用Exception以及它的子类来封装程序出现的问题。   

异常分为两类：编译时异常、运行时异常。
-   运行时异常： 运行时异常，编译阶段不需要处理。例如：空指针异常，数组越界异常。编译阶段不会出现异常提醒。  
-   编译时异常： 编译时异常，编译阶段必须处理。例如：文件不存在，类未找到，日期解析异常。  

编译时异常和运行时异常的区别：  
-   编译时异常：没有继承RuntimeException，需要处理，否则程序无法运行。  
-   运行时异常：继承了RuntimeException或者就是本身，可以不处理，程序可以运行。
    
### 2. 异常的作用
- 作用一：异常是用来查询bug的关键参考信息
- 作用二：异常可以作为方法内部的一种特殊返回值，以便通知调用者底层的执行情况
### 3.处理异常
#### 3.1 JVM默认处理异常的方式
JVM默认处理异常的方式：
1. 把异常的名称，异常原因及异常出现的位置等信息输出在了控制台
2. 程序停止执行，异常下面的代码不会再执行了  

**总结： 把异常信息以红色字体打印在控制台，并结束程序。**
#### 3.2 自定义处理异常的方式(捕获异常) try ... catch

```shell
// 格式如下：

try{
      //可能产生异常的代码
}catch(异常类名 变量名){
     //异常的处理逻辑
}
// 好处:可以让程序继续往下执行，不会停止
```
**总结：一般用在调用处，能让代码继续往下运行。**
##### 3.2.1 如果try中没有遇到问题，怎么执行？
会把try中的代码执行完毕，不会执行catch中的代码，程序继续往下执行，直到遇到return为止。

##### 3.2.2 如果try中可能会遇到多个问题，怎么执行？
会写多个catch与之对应。如果我们要捕获多个异常，这些异常中如果存在父子关系的话，那么父类一定要写在下面

##### 3.2.3 如果try中遇到问题没有被捕获，怎么执行？
相当于try...catch的代码白写了，当前异常会交给虚拟机进行处理。


##### 3.2.4 如果try中遇到了问题，那么try下面的其他代码还会被执行吗？
下面的代码不会执行了，程序会直接跳到对应的catch中，然后执行catch里面的的语句体。
如果没有对应到catch，则交给虚拟机进行处理。

#### 3.3 Throwable的成员方法

| 方法名称 | 说明                     |
|------|------------------------|
|public String getMessage()      | 返回此 throwable 的详细消息字符串 |
|public String toString()      | 返回此可抛出的简短描述            |
|public void printStackTrace()      | 把异常的错误信息输出在控制台         |

#### 3.4  抛出异常 throw throws

throws：在方法声明中，声明异常，告诉调用者，使用本方法可能会有哪些异常。
```shell
public void 方法() throws 异常类名1, 异常类名2...{
        ...
}
// 编译时异常：必须要写
// 运行时异常：可以不写
```

throw：在方法内，手动抛出异常，把异常抛出，让调用者处理。方法中下面的代码就不再执行了。
```shell
public void 方法(){
  throw new NullPointerException();
  System.out.println("一旦抛出异常，我就执行不到啦");
}
```
**总结：在方法中，出现异常了，方法就没有继续运行下去的意义了，采取抛出处理。目的是让该方法结束运行并告诉调用者出现了问题。**

## File
### 1. 概述  
- File对象就表示一个路径，可以是文件的路径，也可以是文件夹的路径。
- 这个路径可以是存在的，也允许是不存在的。
- File对象不能直接操作文件，只能操作路径，所以要使用File对象，必须配合FileInputStream、FileOutputStream等流对象来完成文件的读写操作。

绝对路径： 带盘符的。
相对路径： 不带盘符的，默认到当前项目下去中找。

### 2. 常用方法
#### 三种构造方法

| 方法名称                                     | 说明                        |
|------------------------------------------|---------------------------|
| public File(String pathname)             | 根据文件路径创建文件对象              |
| public File(String parent, String child) | 根据父路径名字符串和子路径名字符串创建文件对象   |
| public File(File parent, String child)   | 根据父路径对应文件对象和子路径名字符串创建文件对象 |

#### 判断、获取相关的方法
| 方法名称                            | 说明                  |
|---------------------------------|---------------------|
| public boolean isDirectory()    | 判断此路径名表示的File是否为文件夹 |
| public boolean isFile()         | 判断此路径名表示的File是否是为文件 |
| public boolean exists()         | 判断此路径名表示的File是否存在   |
| public long length()            | 返回文件的大小（字节数量）       |
| public String getAbsolutePath() | 返回文件的绝对路径           |
| public String getPath()         | 返回定义文件时使用的路径        |
| public String getName()         | 返回文件的名称，带后缀         |
| public long lastModified()      | 返回文件的最后修改时间（时间毫秒值）  |

#### 创建、删除相关的方法
| 方法名称                            | 说明                                       |
|---------------------------------|------------------------------------------|
| public boolean createNewFile() throws IOException | 创建一个新的空的文件                               |
| public boolean mkdir() | 创建单级文件夹                                  |
| public boolean mkdirs() | 创建多级文件夹                                  |
| public boolean delete() | 删除文件、文件夹 (只能删除文件和空文件夹，delete方法直接删除不走回收站) |

#### 获取并遍历的方法
| 方法名称                                            | 说明                   |
|-------------------------------------------------|----------------------|
| public File[] listFiles()                       | 获取当前该路径下索引内容         |
| public static File[] listRoots()                | 列出可用的文件系统根           |
| public String[] list()                          | 获取当前路径下所有内容          |
| public String[] list(FilenameFilter filter)     | 利用文件名过滤器获取当前该路径下所有内容 |
| public File[] listFiles()                       | 获取当前该路径下所有内容         |
| public File[] listFiles(FileFilter filter)      | 利用文件名过滤器获取当前该路径下所有内容 |
| public File[] listFiles(FilenameFilter filter)  | 利用文件名过滤器获取当前该路径下所有内容 |

