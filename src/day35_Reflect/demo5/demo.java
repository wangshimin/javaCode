package day35_Reflect.demo5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class demo {
    /*
        需求：对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
    */
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Student s = new Student("小A",23,'女',167.5,"睡觉");
        Teacher t = new Teacher("播妞",10000);
        saveObject(s, false);
        saveObject(t, true);
    }

    /**
     * 把对象里面所有的成员变量名和值保存到本地文件中
     * @param obj   对象
     * @param append 是否追加
     * @throws IllegalAccessException
     * @throws IOException
     */
    private static void saveObject(Object obj, boolean append) throws IllegalAccessException, IOException {
        // 1.获取字节码文件的对象
        Class clazz = obj.getClass();

        // 创建IO流
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/day35_Reflect/a.txt",append));

        // 2.获取所有的成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取成员变量的名字
            String fieldName = field.getName();
            // 获取成员变量的值
            Object fieldValue = field.get(obj);
            // 写出数据
            bw.write(fieldName + ":" +fieldValue);
            bw.newLine();
//            System.out.println(fieldName + ":" +fieldValue);
        }
        bw.flush();
        bw.close();

    }
}
