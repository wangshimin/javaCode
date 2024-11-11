package day37.Anno;
public class MyAnnoDemo {

    String aaa;
    String bbb;
    @MyAnno1(name="小明",age=10)
    public void method1(){
        System.out.println("method1");
    }

    @MyAnno1(name="小红",age=20)
    public void method2(){
        System.out.println("method2");
    }
}
