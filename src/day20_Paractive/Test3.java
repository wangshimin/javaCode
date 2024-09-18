package day20_Paractive;

/**
 * 定义一个方法自定实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制。
 */
public class Test3 {
    public static void main(String[] args) {
        /**
         * 提示：除基取余法 - 不断的除以基数（几进制，基数就是几）得到余数，直到商为0，再将余数倒着拼起来即可。
         */
        int n = 123;
        System.out.println(toBinaryString(n));
        System.out.println(Integer.toBinaryString(n));
    }

    /**
     * 将一个十进制整数转成字符串表示的二进制
     * @param number  int
     * @return result String
     *
     * 核心逻辑：不断去除以2，得到余数，直到商为0，将余数倒着拼接即可。
     */
    public static String toBinaryString(int number){

        // 定义一个StringBuilder用来拼接余数
        StringBuilder sb = new StringBuilder();
        // 利用循环不断的除以2获取余数
        while (true){
            if (number == 0){
                break;
            }
            // 获取余数
            int remainder = number % 2;
            // 倒着拼接
            sb.insert(0, remainder); // insert指定索引插入数据
            // 除以2
            number = number / 2;
        }
        return sb.toString();
    }
}
