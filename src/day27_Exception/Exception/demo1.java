package day27_Exception.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo1 {
    public static void main(String[] args) {

        // 编译时异常：在编译阶段，必须手动处理，否则代码报错
        String time = "2024年10月16日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//            Date date = sdf.parse(time);
//            System.out.println(date);


        // 运行异常：在编译阶段是不需要处理的，是代码运行时才出现的异常
        int[] arr = {1,3,5,7,8};
        System.out.println(arr[8]); // ArrayIndexOutOfBoundsException

    }
}
