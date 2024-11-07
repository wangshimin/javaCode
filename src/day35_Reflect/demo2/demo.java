package day35_Reflect.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class demo {
    /*
        Class类中用于获取构造方法的方法
            Constructor<?>[] getConstructors()                                返回所有公共构造方法对象的数组
            Constructor<?>[] getDeclaredConstructors()                        返回所有构造方法对象的数组
            Constructor<T> getConstructor(Class<?>... parameterTypes)         返回单个公共构造方法对象
            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象


        Constructor类中用于创建对象的方法
            T newInstance(Object... initargs)                                 根据指定的构造方法创建对象
            setAccessible(boolean flag)                                       设置为true,表示取消访问检查
    */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1.获取Class字节码文件对象
        Class clazz = Class.forName("day35_Reflect.demo2.Student");

        // 2.获取构造方法
        System.out.println("-------- getConstructors 获取所有** 公共 **构造方法对象的数组 ----------");
        Constructor[] cons1 = clazz.getConstructors();
        for (Constructor con : cons1) {
            System.out.println(con);
        }

        System.out.println();
        System.out.println("-------- getDeclaredConstructors 获取所有构造方法对象的数组 ----------");
        Constructor[] cons2 = clazz.getDeclaredConstructors(); //
        for (Constructor con : cons2) {
            System.out.println(con);
            System.out.printf("权限修饰符为：%s，参数个数为：%s， 参数为：%s %n", con.getModifiers(), con.getParameterCount(), Arrays.toString(con.getParameters()) );
            System.out.println();
        }

        System.out.println();
        System.out.println("-------- getDeclaredConstructor 获取单个构造方法对象 ----------");
        Constructor con3 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con3);
        Constructor con4 = clazz.getDeclaredConstructor(int.class);
        System.out.println(con4);

        System.out.println();
        System.out.println("-------- getConstructor 获取单个公共构造方法对象 ----------");
        Constructor con5 = clazz.getConstructor();
        System.out.println(con5);
        Constructor con6 = clazz.getConstructor(String.class);
        System.out.println(con6);

        System.out.println();
        System.out.println("-------------- 使用setAccessible临时取消权限校验，再使用newInstance根据指定的构造方法创建对象 ------------");
        con3.setAccessible(true); // 暴力反射：表示临时取消权限校验
        Student stu = (Student) con3.newInstance("小明", 18); // 创建对象
        System.out.println(stu);
    }
}
