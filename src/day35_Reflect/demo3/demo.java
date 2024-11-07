package day35_Reflect.demo3;

import java.lang.reflect.Field;

public class demo {
    /*
       Class类中用于获取成员变量的方法
            Field[] getFields()：                返回所有公共成员变量对象的数组
            Field[] getDeclaredFields()：        返回所有成员变量对象的数组
            Field getField(String name)：        返回单个公共成员变量对象
            Field getDeclaredField(String name)：返回单个成员变量对象

       Field类中用于创建对象的方法
            void set(Object obj, Object value)：赋值
            Object get(Object obj)              获取值

    */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        // 1.获取class字节码文件的对象
        Class clazz = Class.forName("day35_Reflect.demo3.Student");

        // 2.获取成员对象
        System.out.println("-------- getFields() 返回**所有公共**成员变量对象的数组 ----------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();
        System.out.println("-------- getDeclaredFields() 返回所有成员变量对象的数组 ----------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println();
        System.out.println("-------- getField(String name) 返回单个公共成员变量对象 ----------");
        Field gender = clazz.getField("gender");
        System.out.println(gender+ "，权限修饰符为：" + gender.getModifiers() + "，成员变量名为：" + gender.getName() + ",数据类型为：" + gender.getType());

        System.out.println();
        System.out.println("-------- getDeclaredField(String name) 返回单个成员变量对象 ----------");
        Field name = clazz.getDeclaredField("name");
        System.out.println(name + "，权限修饰符为：" + name.getModifiers()+ "，成员变量名为：" + name.getName() + ",数据类型为：" + name.getType());
        Field age = clazz.getDeclaredField("age");
        System.out.println(age + "，权限修饰符为：" + age.getModifiers()+ "，成员变量名为：" + age.getName() + ",数据类型为：" + age .getType());

        // 获取权限修饰符
        int modifiers = name.getModifiers();
        System.out.println(modifiers);

        // 获取成员变量的名字
        String n = name.getName();
        System.out.println(n);

        // 获取成员变量的数据类型
        Class<?> type = name.getType();
        System.out.println(type);

        // 获取成员变量记录的值
        Student s = new Student("zhangsan", 18, "男");
        name.setAccessible(true);
        String value = (String)name.get(s);
        System.out.println(value);

        // 修改对象里面记录的值
        name.set(s, "李四");
        gender.set(s, "女");
        System.out.println(s);

    }
}
