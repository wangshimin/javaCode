package day19_API_Regex;

import com.google.gson.internal.bind.util.ISO8601Utils;

public class demo1 {
    public static void main(String[] args) {
        d3();
    }

    private static void d4() {
    }

    private static void d3() {
        /**
         *  \ 转义字符，改变后面哪个字符原本的含义
         *  练习：以字符串的形式打印一个双引号
         */
        System.out.println("我说：\"好好学习，天天向上\"。");

        // .表示任意一个字符
        System.out.println("----------- 1 -----------");
        System.out.println("你".matches("."));// true
        System.out.println("你".matches(".."));// false
        System.out.println("你呀".matches(".."));// true

        // \\d只能是任意的一个数字
        // 简单来记： 两个\表示一个\
        System.out.println("----------- 2 -----------");
        System.out.println("a".matches("\\d")); // false
        System.out.println("5".matches("\\d")); // true
        System.out.println("3".matches("\\d"));// true

        //  \w只能是一位单词字符 [a-zA-Z0-9_]
        System.out.println("----------- 3 -----------");
        System.out.println("a".matches("\\w")); // true
        System.out.println("3".matches("\\w")); // true
        System.out.println("_".matches("\\w")); // true
        System.out.println("24".matches("\\w")); // false
        System.out.println("你".matches("\\w")); // false

        // 非单词字符
        System.out.println("----------- 4 -----------");
        System.out.println("你".matches("\\W")); //  true
        System.out.println("你呀".matches("\\W")); //  false
        /**********  以上正则匹配只能检验单个字符 ***********/

        // 必须是数字、字母、下划线，至少6位
        System.out.println("2442fsfsf".matches("\\w{6,}")); // true
        System.out.println("244f".matches("\\w{6,}")); // false

        // 必须是数字和字符，必须是4位
        System.out.println("----------- 5 -----------");
        System.out.println("23dF".matches("[a-zA-Z0-9]{4}")); // true
        System.out.println("23_F".matches("[a-zA-Z0-9]{4}")); // false
        System.out.println("23dF".matches("[\\w&&[^_]]{4}")); // true
        System.out.println("23_F".matches("[\\w&&[^_]]{4}")); // false


    }

    /**
     * 需求：校验QQ号码，满足如下条件：
     * 1. 6-20位
     * 2. 0不能在第一位，必须全是数字
     */
    private static void d1() {
        String qq = "123456789e034";
        System.out.println(qq.matches("[1-9]\\d{5,19}"));
    }

    private static void d2() {
        // public boolean matches(String regex)：判断是否与正则表达式匹配，匹配返回true

        // 只能是 a b c
        System.out.println("----------1---------");
        System.out.println("a".matches("[abc]"));// true
        System.out.println("z".matches("[abc]"));// false
        System.out.println("ab".matches("[abc]"));// false
        System.out.println("acbb".matches("[abc]{0,4}"));// true

        // 不能出现 a b c
        System.out.println("----------2---------");
        System.out.println("a".matches("[^abc]"));// false
        System.out.println("z".matches("[^abc]"));// true
        System.out.println("zz".matches("[^abc]"));// false
        System.out.println("zz".matches("[^abc][^abc]]"));// false

        // a到z A到Z（包括头尾的范围）
        System.out.println("----------3---------");
        System.out.println("a".matches("[a-zA-Z]")); // true
        System.out.println("A".matches("[a-zA-Z]")); // true
        System.out.println("aa".matches("[a-zA-Z]")); // false
        System.out.println("zz".matches("[a-zA-Z]")); // false
        System.out.println("0".matches("[a-zA-Z]")); // false

        // [a-d[m-p]] a到d,或m到p
        System.out.println("----------4---------");
        System.out.println("a".matches("[a-d[m-p]]"));// true
        System.out.println("d".matches("[a-d[m-p]]"));// true
        System.out.println("m".matches("[a-d[m-p]]"));// true
        System.out.println("p".matches("[a-d[m-p]]"));// true
        System.out.println("e".matches("[a-d[m-p]]"));// false
        System.out.println("0".matches("[a-d[m-p]]"));// false

        // [a-z&&[def]] a-z和def的交集，为：d,e,f
        System.out.println("----------5---------");
        System.out.println("a".matches("[a-z&&[def]]")); // false
        System.out.println("e".matches("[a-z&&[def]]")); // true
        System.out.println("0".matches("[a-z&&[def]]")); // fales

        // [a-z&&[^bc]] a-b和非bc的交集，等同于[ad-z]
        System.out.println("----------6---------");
        System.out.println("a".matches("[a-z&&[^bc]]")); // true
        System.out.println("b".matches("[a-z&&[^bc]]")); // false
        System.out.println("0".matches("[a-z&&[^bc]]")); // false

        // [a-z&&[^m-p]] a-z和非m-p的交集，等同于[a-lq-z]
        System.out.println("----------7---------");
        System.out.println("a".matches("[a-z&&[^m-p]]")); // true
        System.out.println("m".matches("[a-z&&[^m-p]]")); // false
        System.out.println("0".matches("[a-z&&[^m-p]]")); // false
    }


}
