package day23.Generics;

import java.util.ArrayList;

public class A03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ListUtil.addAll(list, "hello", "world", "java");
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        ListUtil.addAll(list2, 111,222,333,444,555);
        System.out.println(list2);
    }
}
