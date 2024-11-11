package day37.Anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        // 1.获取MyTestDemo这个类的字节码文件对象
        Class clazz = Class.forName("day37.Anno.MyTestDemo");

        // 补一个对象
        MyTestDemo mtd = new MyTestDemo();

        // 2.获取所有方法
        Method[] methods = clazz.getDeclaredMethods();
        // 3.遍历得到每一个方法
        for (Method method : methods) {
            // 4.临时修改权限
            method.setAccessible(true);
            // 5.判断当前方法上面是否有MyTest注解
            if (method.isAnnotationPresent(MyTest.class)){
                method.invoke(mtd);
            }
        }
    }
}
