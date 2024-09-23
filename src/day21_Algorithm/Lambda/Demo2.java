package day21_Algorithm.Lambda;

/**
 * Lambda
 * 基本作用：简化函数式接口的匿名内部类的写法。
 * 使用前提：必须是接口的匿名内部类，接口中只能有一个抽象方法。
 */
public class Demo2 {
    public static void main(String[] args) {
        /**
         * Lambda表达式的注意点
         *
         * 1.Lambda表达式可以用来简化匿名内部类的书写
         * 2.Lambda表达式只能简化函数式接口的匿名内部类的写法
         * 3.函数式接口：
         *          有且仅有一个抽象方法的接口叫做函数式接口，接口上方可以加@FunctionalInaterface注解
         */

        // 1.利用匿名内部类的形式去调用下面的方法
        // 调用一个方法的时候，如果方法的形参是一个接口，那么我们要传递这个接口的实现类对象
        // 如果实现类对象只要用到一次，就可以用匿名内部类的形式进行书写。
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("游泳啦");
            }
        });

        // 2.利用Lambda表达式进行改写

        method(
                ()-> {
                    System.out.println("正在使用Lambda表达式进行改写哦！游泳啦！");
                }
        );
    }

    public static void method(Swim s){
        s.swimming();
    }
}

@FunctionalInterface
interface Swim{
    public abstract void swimming();
}
