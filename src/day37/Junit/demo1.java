package day37.Junit;

import org.junit.Test;

public class demo1 {
    @Test
    // 1.用鼠标点击@Test
    // 2.按快捷键，alt + 回车
    // 3.选择导入的jar包，选择Junit4即可

    public void method1(){
        System.out.println(1/0);
        int a = 10;
        int b = 20;
        int result = a + b;
        System.out.println(result);
    }

    @Test
    public void method2(){
        int a = 20;
        int b = 30;
        int result = a + b;
        System.out.println(result);
    }

    @Test
    public void method3(){
        int a = 40;
        int b = 50;
        int result = a + b;
        System.out.println(result);
    }

    public int add(int a, int b) {
        return a + b;
    }
}