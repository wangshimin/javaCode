package day19_API_Regex;

public class demo2 {
    public static void main(String[] args) {
        d5();
    }

    /**
     * 身份证号码的校验
     */
    private static void d5() {
        // 简单：18位，前17位任意数字，最后一位可以是数字、大写或小写的x
        String regex1 = "[1-9]\\d{16}(\\d|X|x)"; // 用｜表示或者
        String regex2 = "[1-9]\\d{16}[\\dXx]";   // 用方括号表示里面的内容出现一次，任选其一
        String regex4 = "[1-9]\\d{16}(\\d|(?i)x)";
        System.out.println("41048199012011457x".matches(regex1));
        System.out.println("41048199012011457x".matches(regex2));
        System.out.println("41048199012011457x".matches(regex4));

        // 忽略大小写的书写方式
        // 在匹配的时候忽略b的大小写
        String regex3 = "a((?i)b)c";
        System.out.println("abc".matches(regex3));
        System.out.println("aBc".matches(regex3));
        System.out.println("aBC".matches(regex3));  // false

        System.out.println("------- 身份证号码严格校验 -----------");
        // 410801 1993 02 28 457x
        // 前面6位：省份、市区、派出所等信息，第一位不能是0，前面5位是任意数字   [1-9]\\d{5}
        // 年的前半段：18 19 20                                         (18|19|20)
        // 年的后半段：任意数字出现2次                                    \\d{2}
        // 月份： 01～09 10 11 12                                       (0[1-9]|1[0-2])
        // 日期： 01～09 10～19 20～29 30 31                            (0[1-9]|[12]\\d|3[01])
        // 后面四位：任意数字出现3次，最后一位可以是数字也可以是大写X或小写x      \\d{3}[\\dXx]
        String regex5 = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dXx]";
        System.out.println("41080119930228457x".matches(regex5));

    }

    // 验证用户名是否满足要求
    // 要求：大小写字母、数字、下划线一共4-16位
    private static void d4() {
        String regex = "\\w{4,16}";
        System.out.println("zhangsan".matches(regex)); // true
        System.out.println("$345w".matches(regex));    // false
    }


    // 验证邮箱号
    private static void d3() {
        /**
         * 在书写邮箱号码正则的时候需要把正确的数据分为三部分
         * 一： @的左边  \\w+
         *              任意的字母数字下划线，至少出现一次就可以了
         * 二： @        只能出现一次
         * 三：
         *      3.1     .的左边   [\\w&&[^_]]{2,6}    任意字符且不包含下划线的，即任意的字母加数字，总共出现2-6次
         *      3.2     .        \\.
         *      3.3     大写字母、小写字母都可以，只能出现2-3次 [a-zA-Z]{2,3}
         *      3.4     我们可以把3.2和3.3看成一组，这一组可以出现1次或者2次
         */
        String regex = "\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("234634@qq.com".matches(regex));
        System.out.println("zhangsan@it.edu".matches(regex));
        System.out.println("lsdfsg@163.com".matches(regex));
        System.out.println("lisi@ij.com.cn".matches(regex));

        // 24小时正则表达式
        String regex2 = "(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        System.out.println("23:11:11".matches(regex2));

        String regex3 = "(?:[01]\\d|2[0-3])(:[0-5]\\d){2}";
        System.out.println("23:11:11".matches(regex3));

    }

    // 验证座机电话号码
    private static void d2() {
        // 在书写座机号正则的时候需要把正确的数据分为三部分
        // 一：区号  0\\d{2,3}
        //          0:表示区号一定是以0开头的
        //          \\d{2,3}：表示区号从第二位开始是任意的数字，可以出现2到3次。
        // 二：-     ?表示次数，0或1次
        // 三：号码   号码的第一位也不能以0开头，从第二位开始可以是任意的数字，号码的总长度：5-10位
        String regex = "0\\d{2,3}-?[1-9]\\d{4,9}";
        System.out.println("020-2324242".matches(regex));
        System.out.println("02122442".matches(regex));
        System.out.println("027-43434".matches(regex));
        System.out.println("0712-425254".matches(regex));
    }

    // 验证手机号码
    private static void d1() {
        // 1: 表示手机号码只能以1开头
        // [3-9]:表示手机号码第二位只能是3-9之间的
        // \\d{9}:表示任意数字可以出现9次，也只能出现9次
        String regex = "1[3-9]\\d{9}";
        System.out.println("18223874499".matches(regex)); // true
        System.out.println("15078293366".matches(regex)); // true
    }

}
