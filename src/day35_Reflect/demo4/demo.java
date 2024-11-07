package day35_Reflect.demo4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class demo {
    /*
       Class类中用于获取成员方法的方法
            Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
            Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的
            Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共成员方法对象
            Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象


       Method类中用于创建对象的方法
            Object invoke(Object obj, Object... args)：运行方法
            参数一：用obj对象调用该方法
            参数二：调用方法的传递的参数（如果没有就不写）
            返回值：方法的返回值（如果没有就不写）

        获取方法的修饰符
        获取方法的名字
        获取方法的形参
        获取方法的返回值
        获取方法的抛出的异常

    */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 1.获取class字节码文件对象
        Class clazz = Class.forName("day35_Reflect.demo4.Student");

        // 2.获取里面所有的方法对象(包含父类中所有的公共方法)
        System.out.println("-------- getMethods 获取所有** 公共 **方法对象的数组 ----------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 3.获取里面所有的方法对象(不能获取父类的，但是可以获取本类中私有的)
        System.out.println();
        System.out.println("-------- getDeclaredMethods 获取所有方法对象的数组 ----------");
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        System.out.println();
        System.out.println("-------- getMethod 获取单个公共方法对象 ----------");
        Method sleep = clazz.getMethod("sleep");
        System.out.println(sleep);

        System.out.println();
        System.out.println("-------- getDeclaredMethod 获取单个方法对象 ----------");
        Method eatM = clazz.getDeclaredMethod("eat", String.class, int.class);
        System.out.println(eatM);

        // 获取方法的修饰符
        int modifiers = eatM.getModifiers();
        System.out.println(modifiers);

        // 获取方法的名字
        String name = eatM.getName();
        System.out.println(name);

        // 获取方法的形参
        Parameter[] parameters = eatM.getParameters();
        System.out.println(Arrays.toString(parameters));

        // 获取方法的抛出的异常
        Class[] exceptionTypes = eatM.getExceptionTypes();
        System.out.println(Arrays.toString(exceptionTypes));

        System.out.println("-------- 使用invoke方法调用方法 ----------");
        //方法运行
        /*Method类中用于创建对象的方法
        Object invoke(Object obj, Object... args)：运行方法
        参数一：用obj对象调用该方法
        参数二：调用方法的传递的参数（如果没有就不写）
        返回值：方法的返回值（如果没有就不写）*/

        Student s = new Student();
        eatM.setAccessible(true);
        String result = (String) eatM.invoke(s, "燕窝", 3);
        System.out.println(result);
    }
}
