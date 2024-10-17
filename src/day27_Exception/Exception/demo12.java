package day27_Exception.Exception;

public class demo12 {
    public static void main(String[] args) {
/*
        throws：写在方法定义处，表示声明一个异常。告诉调用者，使用本方法可能会有哪些异常。
        throw ：写在方法内，结束方法。手动抛出异常对象，交给调用者。方法中下面的代码不再执行了。


        需求：
            定义一个方法求数组的最大值
*/
        int[] arr = {};
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(max);
    }

    private static int getMax(int[] arr) /*throws NullPointerException, ArrayIndexOutOfBoundsException*/{
        if (arr == null) {
            // 手动创建一个异常对象，并把这个异常交给方法的调用者处理
            // 此时方法就会结束，下面的代码就不会再执行了。
            throw new NullPointerException("空指针异常");
        }
        if (arr.length == 0){
            // 手动创建一个异常对象，并把这个异常交给方法的调用者处理
            // 此时方法就会结束，下面的代码不会再执行了
            throw new ArrayIndexOutOfBoundsException("索引越界异常");
        }
        System.out.println("看看我执行了吗？");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
