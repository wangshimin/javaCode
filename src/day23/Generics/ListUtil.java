package day23.Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class ListUtil {
    private ListUtil(){}

    // 类中定义一个静态方法addAll，用来添加多个集合的元素。

    /**
     * 参数一： 集合
     * 参数二～最后：要添加的元素
     */
    public static<E> void addAll(ArrayList<E> list, E... elements){
//        for (E e : elements) {
//            list.add(e);
//        }

//        Arrays.stream(elements).forEach(list::add);

        Arrays.asList(elements).forEach(list::add);
    }
}
