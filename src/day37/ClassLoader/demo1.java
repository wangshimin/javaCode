package day37.ClassLoader;
/**
 * 类加载器：负责将.class文件（存储的物理文件）加载到内存中
 *
 * 类加载的时机：用到就加载，不用不加载
 * 1.创建类的实例（对象）
 * 2.调用类的类方法
 * 3.访问类或者接口的类变量，或者为该类变量赋值
 * 4.使用反射方式来强制创建某个类或者接口对应的java.lang.Class对象
 * 5.初始化某个类的子类
 * 6.直接使用java.exe命令来运行某个主类
 *
 * 类加载的过程：
 * 1.加载
 *      通过类的全限定名获取其二进制字节流                （说人话：通过包名+类名，获取这个类，准备用流进行传输）
 *      将字节流转换成方法区内的运行时数据结构             （说人话：将这个类加载到内存中）
 *      在内存中生成一个代表这个类的 java.lang.Class 对象 （说人话：加载完毕创建一个class对象）
 * 2.验证
 *      确保被加载类的字节码符合 JVM 规范，没有安全问题
 * 3.准备
 *      为类的静态变量（被static修饰的变量）分配内存，并设置默认初始值。 （说人话：初始化静态变量）
 * 4.解析
 *      将类的二进制数据流中的符号引用替换成直接引用     （说人话：本类中如果用到类其他类，此时就需要找到对应的类）
 * 5.初始化
 *      执行类的初始化代码，包括静态变量赋值和静态代码块  （说人话：静态变量赋值以及初始化其他资源）
 *
 *
 * 类加载的过程的小结：
 * 1.当一个类被使用的时候，才会加载到内存
 * 2.类加载的过程如下：加载、验证、准备、解析、初始化
 *
 */
public class demo1 {

    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        // 获取系统类加载器的父类加载器 -- 平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();

        // 获取平台类加载器的父类加载器  -- 启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println("系统类加载器 " + systemClassLoader);
        System.out.println("平台类加载器 " + classLoader1);
        System.out.println("启动类加载器 " + classLoader2);
    }
}
