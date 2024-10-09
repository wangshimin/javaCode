package day25_DouDiZhu.Demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    // 牌盒
    static ArrayList<String> list = new ArrayList<>();

    // 创建一个集合，用来添加牌的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        // 准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add(" 小王");
        list.add(" 大王");
//        System.out.println(list);

        // 指定牌的价值
        // 根据牌上的数字到Map集合中判断是否存在
        // 存在，获取价值
        // 不存在，本身的数字就是价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王",50);
        hm.put("大王",100);
    }
    public PokerGame()
    {
        // 洗牌
        Collections.shuffle(list);

        // 发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            // 发底牌
            if (i <= 2){
                lord.add(poker);
                continue;
            }
            // 给三个玩家发牌
            if (i % 3 == 0){
                player1.add(poker);
            }else if (i % 3 == 1){
                player2.add(poker);
            }else {
                player3.add(poker);
            }
        }

        // 排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);

        // 看牌
        lookPoker("地主", lord);
        lookPoker("钢脑壳", player1);
        lookPoker("大帅", player2);
        lookPoker("蛋筒", player3);
    }

    /**
     * 看牌
     * @param name 玩家的名字
     * @param list 玩家的牌
     */
    private void lookPoker(String name, ArrayList<String> list) {
        System.out.println(name + "的牌是：");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }

    /**
     * 利用牌的价值进行排序
     * @param list 集合
     */
    public void order(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            // Arrays.sort(插入排序 + 二分查找)
            @Override
            public int compare(String o1, String o2) {
                // o1: 表示当前要插入在有序序列中的牌
                // o2: 表示已经在有序序列中存在的牌

                // 负数：o1小，插入到前面
                // 整数：o1大，插入到后面
                // 0: o1和o2的数字是一样的，需要按照花色再次排序

                // 1.计算o1的花色和价值
                String color1 = o1.substring(0, 1);
                int value1 = getValue(o1);
                // 2.计算o2的花色和价值
                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);
                // 3.比较o1和o2的价值
                int i = value1 - value2;
                return i == 0? color1.compareTo(color2): i;
            }
        });
    }

    /**
     * 计算牌的价值
     * @param poker 牌
     * @return 价值
     */
    public int getValue(String poker){
        // 获取牌上的数字
        String number = poker.substring(1);
        // 拿着数字到map集合中判断是否存在
        // 存在，获取价值
        // 不存在，类型转换
        int value = hm.containsKey(number) ? hm.get(number): Integer.parseInt(number);
        return value;
    }
}
