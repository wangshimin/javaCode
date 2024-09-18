package day20_Paractive;
/**
 * 自己实现parseInt方法的效果，将字符串形式的数据转成整数。
 *
 * 要求：
 * 1. 字符串只能是数字，不能有其他字符
 * 2. 最少1位，最多10位
 * 3. 0不能开头
 */
public class Test2 {
    public static void main(String[] args) {

        // 1.定义一个字符串
        String str = "123456789";
        // 2.校验字符串
        // 先把异常数据进行过滤，剩下来就是正常的数据。
        if ( !str.matches("[1-9]\\d{0,9}") ){
            System.out.println("数据格式有误");
        }
        // 3.定义一个变量表示最终的结果
        int number = 0;
        // 4.遍历字符串得到里面的每一个字符
        for (int i = 0; i < str.length(); i++) {
            // 0的ASCII码是47，1的ASCII码是48，2的ASCII码是49，以此类推
            // 减去'0'就是数字本身
            int c = str.charAt(i) - '0';
            // 把每一位数字放到number当中
            number = number * 10 + c;
        }
        System.out.println(number + 1);
    }
}
