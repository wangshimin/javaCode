package day25_DouDiZhu.Demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    // 牌盒 Map
    // 此时我们只需要把牌跟序号产生对应关系就可以了，不需要按照序号进行排序，所以只要HashMap即可
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    /*
        {1=♦3, 2=♣3, 3=♥3, 4=♠3,
        5=♦4, 6=♣4, 7=♥4, 8=♠4,
        9=♦5, 10=♣5, 11=♥5, 12=♠5,
        13=♦6, 14=♣6, 15=♥6, 16=♠6,
        17=♦7, 18=♣7, 19=♥7, 20=♠7,
        21=♦8, 22=♣8, 23=♥8, 24=♠8,
        25=♦9, 26=♣9, 27=♥9, 28=♠9,
        29=♦10, 30=♣10, 31=♥10, 32=♠10,
        33=♦J, 34=♣J, 35=♥J, 36=♠J,
        37=♦Q, 38=♣Q, 39=♥Q, 40=♠Q,
        41=♦K, 42=♣K, 43=♥K, 44=♠K,
        45=♦A, 46=♣A, 47=♥A, 48=♠A,
        49=♦2, 50=♣2, 51=♥2, 52=♠2,
        53=小王, 54=大王}



     */
    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 序号
        int serialNumber = 1;
        // 细节
        for (String n : number) {
            // n依次表示每一个牌面数字
            for (String c : color) {
                // c依次表示每一个花色
                hm.put(serialNumber, c+n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        hm.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "大王");
        list.add(serialNumber);

//        System.out.println(list);
//        System.out.println(hm);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);

        // 发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            // i:依次表示集合中的每一个索引
            // list.get(i)元素：牌的序号
            int serialNumber = list.get(i);

            if (i <= 2){
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0){
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }
        // 看牌
        lookPoker("地主", lord);
        lookPoker("孙悟空",player1);
        lookPoker("猪八戒",player2);
        lookPoker("沙僧",player3);
    }

    /**
     * 看牌
     * @param name 玩家名字
     * @param ts 牌的序号集合
     */
    private void lookPoker(String name, TreeSet<Integer> ts) {
        System.out.print(name + ": ");
        // 遍历TreeSet集合得到每一个序号，再拿着序号到map集合中去找真正的牌
        for (int serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker+ " ");
        }
        System.out.println();
    }
}
