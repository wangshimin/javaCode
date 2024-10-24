## IO流
### 什么是IO流？
存储和读取数据的解决方案。I是指input,O是指output，流是指像水流一样传输数据。
### IO流的作用？
用于读写数据（本地文件、网络）
### IO流按照流向可以分类哪两种流？
1. 输入流（InputStream）：负责把本地文件读入到程序当中。
2. 输出流（OutputStream)：负责把程序读取的数据写入到本地文件中。
### IO流按照操作文件的类型可以分类哪两种流？
字节流：可以操作所有类型的文件
字符流：只能操作纯文本文件
### 什么是纯文本文件？
用Windows记事本打开并能读懂的文件，如：.txt、.md、.xml、.lrc等。

***

## 字节流
### FileOutputStream
操作本地文件的字节输出流，可以把程序中的数据写到本地文件中，是字节流的基本流。  
**操作步骤如下** 
1. 创建字节输出对象  
    - 细节1：参数是字符串表示的路近或File对象都是可以的
    - 细节2：如果文件不存在会创建一个新的文件，但是要保证父级路径是存在的。
    - 细节3:如果文件存在，会清空文件内容
2. 写数据  
    - 细节1：write方法的参数是整数，但是实际上写到本地文件中的是整数在ASCII表中对应的字符
3. 释放资源  
    - 细节1：每次使用完只要都要释放资源，否则会占用内存
#### FileOutputStream 写入数据的三种方式

| 方法名称                 | 说明             |
|----------------------|----------------|
| void write(int b)    | 一次写一个字节数据      |
| void write(byte[] b) | 一次写一个字节数组数据    |
| void write(byte[] b, int off, int len)| 一次写一个字节数组的部分数据 |

### FileInputStream
操作本地文件的字节输入流，可以把本地文件中的数据读取到程序中，是字节流的基本流。  
**操作步骤如下**
1. 创建字节输入流对象  
   - 细节1：如果文件不存在，就直接报错。
2. 写数据
   - 细节1：一次读一个字节，读出来的是数据在ASCII上对应的数字
   - 细节2：读到文件末尾了，read方法返回-1。
3. 释放资源
   - 细节1：每次使用完流之后都要释放资源

#### FileInputStream 一次读取多个字节

| 方法名称                           | 说明          |
|--------------------------------|-------------|
| public int read()              | 一次读一个字节数据   |
| public int read(byte[] buffer) | 一次读一个字节数组数据 |

### 字节缓冲流
字节缓冲流分为 字节缓冲输入流（BufferedInputSream）和字节缓冲输出流（BufferedOutputStream）。

| 方法名称                                         | 说明                   |
|----------------------------------------------|----------------------|
| public BufferedInputStream(InputStream is)   | 把基本流包装成高级流，提高读取数据的性能 |
| public BufferedOutputStream(OutputStream os) | 把基本流包装成高级流，提高写出数据的性能 |

> 原理：底层自带了长度为8192的缓冲区提高性能。


### 编码解码
编码：把字符串变成字节数组。
解码：把字节数组变成字符串。

| String类中的方法                                | 说明            |
|--------------------------------------------|---------------|
| public byte[] getBytes()                   | 使用默认方式进行编码    |
| public byte[] getBytes(String charsetName) | 使用指定的编码方式进行编码 |                  |            |
| String(byte[] bytes)                       | 使用默认方式进行解码    |
| String(byte[] bytes, String charsetName)   | 使用指定的编码方式进行解码 |                                     |               |

### 乱码
#### 为什么会有乱码？
1. 读取数据时未读完整个汉字 （处理方案：使用字符流）
2. 编码和解码时的方式不统一
#### 如何不产生乱码？
1. 不用字节流读取文本文件
2. 编码解码时使用同一个码表，同一个编码方式

### 序列化流/对象操作输出流
序列化流是把对象变成字节数组，再写入到文件中，是序列化的基本流。

| 构造方法                                        | 说明         |
|---------------------------------------------|------------|
| public ObjectOutputStream(OutputStream out) | 把基本流包装成高级流 |

| 成员方法                                      | 说明              |
|-------------------------------------------|-----------------|
| public final void writeObject(Object obj) | 把对象序列化（写出）到文件中去 |

> 细节：
> 1. 使用对象流将对象保存到文件时会出现**NotSerializableException**异常  
>  解决办法：在Javabean类上实现**Serializable**接口，表示当前类可以序列化。
> 2. 序列化流写到文件中的数据是不能修改的，一旦修改就无法再次读回来了。
> 3. 如果对象中的某个成员变量的值不想被序列化，可以使用**transient**关键字修饰，该关键字标记的成员不参与序列化过程。
***

### 反序列化流/对象操作输入流
反序列化流是把文件中的字节数组还原为对象，是反序列化的基本流。

| 构造方法                                      | 说明         |
|-------------------------------------------|------------|
| public ObjectInputStream(InputStream out) | 把基本流包装成高级流 |

| 成员方法                                 | 说明                        |
|--------------------------------------|---------------------------|
| public Object readObject() | 把序列化（写出）到本地文件中的对象，读取到程序中来 |

> **细节**
> 序列化对象后，修改了Javabean类，再次反序列化，会出现**InvalidClassException**异常。
> 解决办法：给Javabean类添加一个版本号 SerialVersionUID，让反序列化时，版本号一致才能反序列化成功。


## 字符流
字符流是操作纯文本文件的，是字符流的基本流。只不过是在字节流的基础上添加字符集概念，在读取时遇到中文的话，会默认一次读取多个字节。  
字符流 = 字节流 + 字符集
#### 字符流的特点
1. 输入流：一次读一个字节，**遇到中文时，一次读多个字节**，（如：用GBK编码解码，一次读一个字节，遇到中文时，一次读两个字节；用UTF-8编码解码，一次读一个字节，遇到中文时，一次读三个字节）
2. 输出流：底层会把数据按照指定的编码方式进行编码，变成字节再写到文件中。一次写一个字节，一次写一个字符，（如：用GBK编码编码，一次写一个字节，一次写一个字符；用UTF-8编码编码，一次写一个字节，一次写一个字符）
#### 字符流的使用场景
对于纯文本文件进行读写操作。

### FileReader
**操作步骤如下**
1. 创建字符输入流对象
   - 细节1：如果文件不存在，就直接报错。
      
   | 构造方法                         | 说明            |
   |------------------------------|---------------|
   | public FileReader(File file) | 创建字符输入流关联本地文件 |
   | public FileReader(String fileName) | 创建字符输入流关联本地文件 |                      |               |
> **底层原理**  
> 
> 关联文件，并创建缓冲区（长度为8192的字节数组）
2. 读取数据
      
   | 成员方法                           | 说明              |
   |--------------------------------|-----------------|
   | public int read()              | 读取数据，读到末尾返回-1   |
   | public int read(char[] buffer) | 读取多个数据，读到末尾返回-1 |

   - 细节1: 按字节进行读取，遇到中文时，一次读多个字节，读取后解码，返回一个整数。
   - 细节2: 读到文件末尾了，read方法返回-1。
> **底层原理**
>
> 1. 判断缓冲区中是否有数据可以读取
> 2. 缓冲区没有数据：从文件中获取数据，装到缓冲区中，每次尽可能装满缓冲区。如果文件中也没有数据了，返回-1
> 3. 缓冲区有数据：就从缓冲区读取。
>    - 空参的read方法：一次读取一个字节，遇到中文一次读多个字节，把字节解码并转成十进制返回
>    - 有参的read方法：把读取字节，转码，强转三步合并了，强转之后的字符放到数组中
3. 释放资源
      
   | 成员方法               | 说明      |
   |--------------------|---------|
   | public int close() | 释放资源/关流 |


### FileWriter
**操作步骤如下**
1. 创建字符输出流对象
   - 细节1：参数是字符串表示的路径或者File对象都是可以的
   - 细节2：如果文件不存在会创建一个新的文件，但是要保证父级路径是存在的
   - 细节3:如果文件存在，会清空文件内容，如果不想清空可以打开续写开关

   | 构造方法                                               | 说明               |
   |----------------------------------------------------|------------------|
   | public FileWriter(File file)                       | 创建字符输出流关联本地文件    |
   | public FileWriter(String pathname)                 | 创建字符输出流关联本地文件    |
   | public FileWriter(File file, boolean append)       | 创建字符输出流关联本地文件，续写 |
   | public FileWriter(String pathname, boolean append) |创建字符输出流关联本地文件，续写|

2. 写数据

      | 成员方法                                    | 说明           |
      |-----------------------------------------|--------------|
      | void write(int c)                       | 写出一个字符       |
      | void write(String str)                  | 写出一个字符串      |
      | void write(String str, int off, int len) | 写出一个字符串的一部分  |
      | void write(char[] cbuf)                 | 写出一个字符数组     |
      | void write(char[] cbuf, int off, int len)| 写出一个字符数组的一部分 |
   - 细节: 如果write方法的参数是整数，但是实际上写到本地文件中的是整数在字符集上对应的字符
3. 释放资源

   | 成员方法                | 说明                | 注意点                        |
   |---------------------|-------------------|----------------------------|
   | public void flush() | 将缓冲区中的数据，刷新到本地文件中 | lush刷新：刷新之后，还可以继续往文件中写出数据。 |
   | public int close()  | 释放资源/关流| close关流：断开通道，无法再往文件中写出数据。  |
   - 细节：每次使用完流之后都要释放资源

## 字符缓冲流
字节缓冲流分为 字符缓冲输入流（BufferedReader）和字符缓冲输出流（BufferedWriter）。

| 方法名称                            | 说明                   |
|---------------------------------|----------------------|
| public BufferedReader(Reader r) | 把基本流包装成高级流，提高读取数据的性能 |
| public BufferedWriter(Writer r) | 把基本流包装成高级流，提高写出数据的性能 |

字符缓冲输入流特有的方法：  
public String readerLine() 读取一行数据，如果没有数据可读了，会返回null  

字符缓冲输出流特有方法：  
public void newLine() 跨平台换行

> 原理：底层自带了长度为8192的缓冲区提高性能。

## 转换流
转换流是字符流和字节流之间的桥梁。
### 转换流的名字是什么？
- 字符转换输入流：InputStreamReader
- 字符转换输出流：OutputStreamWriter
### 转换流的作用
- 指定字符集读写数据（JDK11之后已淘汰）
- 字节流想要使用字符流中的方法了，必须经过转换流。

## 打印流  
分类：打印流一般是指：PrintStream 和 PrintWriter 两个类。
- 特点1：打印流只操作文件目的地，不操作数据源
- 特点2:特有的写出方法可以实现，比如数据原样写出，并且可以指定格式。
- 特点3:特有的写出方法，可以实现自动刷新、自动换行
### 字节打印流：默认自动刷新，特有的println自动换行

| 构造方法                                                    | 说明              |
|---------------------------------------------------------|-----------------|
| public PrintStream(OutputStream/File/String)            | 关联字节输出流/文件/文件路径 |
| public PrintStream(String fileName, Charset charset)    | 指定字符编码          |                                 |                 |
| public PrintStream(OutputStream out, boolean autoFlush) | 自动刷新            |                                         |                 |
| public PrintStream(OutputStream out, boolean autoFlush, String encoding)       | 指定字符编码且自动刷新     |

**注意：字节流底层没有缓冲区，开不开自动刷新都一样。**

| 成员方法                                               | 说明                    |
|----------------------------------------------------|-----------------------|
| public void write(int b)                           | 常规方法：规则跟之前一样，将指定的字节写出 |
| public void println(Xxx xx)                        | 特有方法：打印任意数据，自动刷新，自动换行 |
| public void print(Xxx xx)                          | 特有方法：打印任意数据，不换行       |
| public void println(String format, Object... args) | 特有方法：带有占位符的打印语句，不换行   |

### 字符打印流：自动刷新需要开启，特有的println自动换行

| 构造方法                                                 | 说明              |
|------------------------------------------------------|-----------------|
| public PrintWriter(Write/File/String)                | 关联字节输出流/文件/文件路径 |
| public PrintWriter(String fileName, Charset charset) | 指定字符编码          |
| public PrintWriter(Write w, boolean autoFlush)       | 自动刷新            |
| public PrintWriter(Write w, boolean autoFlush, Charset charset)       | 指定字符编码且自动刷新     |                                         |                 |

**注意：字符流层有缓冲区，想要自动刷新需要开启。**


| 成员方法                                               | 说明                     |
|----------------------------------------------------|------------------------|
| public void write(int b)                           | 常规方法：规则跟之前一样，写出字节或者字符串 |
| public void println(Xxx xx)                        | 特有方法：打印任意数据，自动刷新，自动换行  |
| public void print(Xxx xx)                          | 特有方法：打印任意数据，不换行        |
| public void println(String format, Object... args) | 特有方法：带有占位符的打印语句，不换行    |


## 压缩解压
### 压缩本质：把每一个（文件/文件夹）看成ZipEntry对象放到压缩包中
### 解压本质：把每一个ZipEntry对象按照层级拷贝到本地另一个文件夹中。

## 常用工具包 Commons-io
Commons-io是Apache基金会提供的一组有关IO操作的的Java开源工具包。  
作用：提高IO流的开发效率。 
### 使用步骤  
1. 在项目中创建一个文件夹：lib
2. 将jar包复制粘贴到lib文件夹中
3. 右键lib文件夹，选择Add As Library -》 点击 OK
4. 在类中导包使用

| FileUtils类（文件/文件夹相关）                                            | 说明             |
|-----------------------------------------------------------------|----------------|
| static void copyFile(File srcFile, File destFile)               | 复制文件           |
| static void copyDirectory(File srcDir, File destDir)            | 复制文件夹          | 
| static void copyDirectoryToDirectory(File srcDir, File destDir) | 复制文件夹          |
| static void deleteDirectory(File directory)                     | 删除文件夹          |
| static void cleanDirectory(File directory)                      | 清空文件夹          |
| static String readFileToString(File file, Charset encoding)     | 读取文件夹中的数据变成字符串 |
| static void write(File file, CharSequence data, Charset encoding)| 写出数据           |


| IOUtils类（字节流相关）                                                | 说明    |
|----------------------------------------------------------------|-------|
| public static int copy(InputStream input, OutputStream output) | 复制文件  |
| public static int copyLarge(Reader input, Writer output)       | 复制大文件 |
| public static String readLines(Reader input)                   | 读取数据  |
| public static void write(String data, OutputStream output)     | 写出数据  |
