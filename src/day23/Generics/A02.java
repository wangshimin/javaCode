package day23.Generics;
// 使用泛型类
public class A02 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(list.get(0));
        System.out.println(list);

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        System.out.println(list2.get(1));
        System.out.println(list2);
        System.out.println(list2.get(1).compareTo(21));
    }
}
