package day25_DouDiZhu.Demo4.game;

import day25_DouDiZhu.Demo4.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class  GameJFrame extends JFrame implements ActionListener {

    // 获取界面中的隐藏容器，现在统一获取了，后面直接用就可以了
    public static Container container = null;

    // 管理抢地主和不抢地主两个按钮
    JButton landlord[] = new JButton[2];

    // 管理出牌和不要两个按钮
    JButton publishCard[] = new JButton[2];

    // 游戏界面中地主的图标
    JLabel dizhu;

    // 集合嵌套集合
    // 大集合中有三个小集合
    // 小集合中装着每一个玩家当前要出的牌
    // 0索引：左边的电脑玩家
    // 1索引：中间的自己
    // 2索引：右边的电脑玩家
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    // 集合嵌套集合
    // 大集合中有三个小集合
    // 小集合中装着每一个玩家手上的牌
    // 0索引：左边的电脑玩家
    // 1索引：中间的自己
    // 2索引：右边的电脑玩家
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    // 底牌
    ArrayList<Poker> lordList = new ArrayList<>();

    // 牌盒：装所有的牌
    ArrayList<Poker> pokerList = new ArrayList<>();

    // 三个玩家前方的文本提示
    // 0索引：左边的电脑玩家
    // 1索引：中间的自己
    // 2索引：右边的电脑玩家
    JTextField time[] = new JTextField[3];


    public GameJFrame() {
        // 设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/day25_DouDiZhu/Demo4/farmerandlord/image/poker/dizhu.png"));
        // 设置界面
        initJframe();
        // 添加组件
        initView();
        // 界面显示出来
        // 先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);
        // 初始化牌
        // 准备牌，洗牌，发牌
        initCard();
        // 打牌之前的准备工作
        // 展示抢地主和不抢地主两个按钮，并且再创建三个集合用来装三个玩家准备要出的牌
        initGame();
    }

    /**
     * 打牌之前的准备工作
     * 展示抢地主和不抢地主两个按钮，并且再创建三个集合用来装三个玩家准备要出的牌
     */
    private void initGame() {
        //创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            // 添加到大集合中方便管理
            currentList.add(list);
        }

        // 展示抢地主和不抢地主两个按钮
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        // 展示自己面前的倒计时文本
        for (JTextField field : time) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }
    }

    /**
     * 初始化牌（准备牌，洗牌，发牌）
     */
    private void initCard() {
        // 准备牌
        // 把所有的牌，包括大小王都添加到牌盒cardList当中
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if ((i == 5) && (j > 2)) {
                    break;
                } else {
                    Poker poker = new Poker(i + "-" + j, false);
                    poker.setLocation(350, 150);
                    pokerList.add(poker);
                    container.add(poker);
                }
            }
        }

        // 洗牌
        Collections.shuffle(pokerList);

        // 创建三个集合用来装三个玩家的牌，并把三个小集合放到大集合中方便管理
        ArrayList<Poker> player0 = new ArrayList<>();
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();

        // 发牌
        for (int i = 0; i < pokerList.size(); i++) {
            // 获取当前遍历的牌
            Poker poker = pokerList.get(i);

            // 发三张底牌
            if (i <=  2) {
                // 把底牌添加到集合中
                lordList.add(poker);
                move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                continue;
            }

            // 给三个玩家发牌
            if (i % 3 == 0) {
                // 给左边的玩家发牌
                move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
                player0.add(poker);
            } else if (i % 3 == 1) {
                // 给中间的自己发牌
                move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
                player1.add(poker);
                // 把自己的牌展示正面
                poker.turnFront();
            } else if (i % 3 == 2) {
                // 给右边的玩家发牌
                move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
                player2.add(poker);
            }

            // 把当前的牌置于最顶端，这样就会有牌依次错开且叠起来的效果
            container.setComponentZOrder(poker, 0);
        }

        // 把三个装着牌的小集合放到大集合中方便管理
        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);

        // 排序
        for (int i = 0; i < 3; i++) {
            order(playerList.get(i));
            rePosition(this,playerList.get(i), i);
        }
    }

    /**
     * 添加组件
     */
    private void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        // 设置位置
        robBut.setBounds(320, 400, 75, 20);
        // 添加点击事件
        robBut.addActionListener(this);
        // 设置隐藏
        robBut.setVisible(false);
        // 添加到数组中统一管理
        landlord[0] = robBut;
        // 添加到界面中
        container.add(robBut);

        // 创建不抢的按钮
        JButton noBut = new JButton("不抢");
        // 设置位置
        noBut.setBounds(420, 400, 75, 20);
        // 添加点击事件
        noBut.addActionListener(this);
        // 设置隐藏
        noBut.setVisible(false);
        // 添加到数组中统一管理
        landlord[1] = noBut;
        // 添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);

        // 创建三个玩家前方的提示文字：倒计时
        // 每个玩家一个
        // 左边的电脑玩家是0
        // 中间的自己是1
        // 右边的电脑玩家是2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("倒计时");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);


        //创建地主图标
        dizhu = new JLabel(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/poker/dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);
    }

    /**
     * 设置界面
     */
    private void initJframe() {
        // 设置标题
        this.setTitle("斗地主");
        // 设置大小
        this.setSize(830, 620);
        // 设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口无法进行调节
        this.setResizable(false);
        // 界面居中
        this.setLocationRelativeTo(null);
        // 获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        // 取消内部默认的居中位置
        container.setLayout(null);
        // 设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * 移动牌(有移动的效果)
     * @param poker 要移动的牌
     * @param from 移动的起始位置
     * @param to 移动的结束位置
     */
    public static void move(Poker poker, Point from, Point to){
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int flag = 0;
            if (from.x < to.x)
                flag = 20;
            else {
                flag = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
                double y = k * i + b;

                poker.setLocation(i, (int) y);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        poker.setLocation(to);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == landlord[0]) {
            // 点击“抢地主”
            time[1].setText("抢地主");
            ArrayList<Poker> player1 = playerList.get(1);
            player1.addAll(lordList);
            lordList.clear();
            order(playerList.get(1));
            for (Poker poker : player1) {
                poker.turnFront();
            }
            rePosition(this, playerList.get(1), 1);
        } else if (e.getSource() == landlord[1]) {
            // 点击“不抢”
            time[1].setText("不抢");
        } else if (e.getSource() == publishCard[1]) {
            // 点击“不要”
            time[1].setText("不要");
        } else if (e.getSource() == publishCard[0]) {
            time[1].setText("出牌");
        }

    }

    /**
     * 重新摆放牌
     * @param m
     * @param list
     * @param flag
     */
    public static void rePosition(GameJFrame m,ArrayList<Poker> list, int flag) {
        Point p = new Point();
        if (flag == 0) {
            p.x = 50;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        if (flag == 1) {
            p.x = (800 / 2) - (list.size() + 1) * 21 / 2;
            p.y = 450;
        }
        if (flag == 2) {
            p.x = 700;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Poker poker = list.get(i);
            move(poker, poker.getLocation(), p);
            m.container.setComponentZOrder(poker, 0);
            if (flag == 1)
                p.x += 21;
            else
                p.y += 15;
        }
    }

    /**
     * 按牌价值排序
     * @param list
     */
    public void order(ArrayList<Poker> list) {
        Collections.sort(list, (o1, o2) -> {
            // 获取o1的花色和价值
            int color1 = Integer.parseInt(o1.getName().substring(0, 1));
            int value1 = getValue(o1);

            // 获取o2的花色和价值
            int color2 = Integer.parseInt(o2.getName().substring(0, 1));
            int value2 = getValue(o2);

            // 倒序排列
            int flag = value2 - value1;
            // 如果牌的价值一样，则按照花色排序
            if (flag == 0) {
//                System.out.println(  o1.getName() + "/ " + o2.getName()  +"牌价值一样，按照花色排序");
                return color2 - color1;
            } else {
//                System.out.println(  o1.getName() + "/ " + o2.getName()  +",值为"+ flag);
                return flag;
            }
        });
    }


    /**
     * 获取牌的价值
     * @param poker 牌
     * @return  价值
     */
    public int getValue(Poker poker) {
        // 获取牌的名字 1-1
        String name = poker.getName();
        // 获取牌的花色
        int color = Integer.parseInt(poker.getName().substring(0, 1));
        // 获取牌对应的数字，同时也是牌的价值
        int value = Integer.parseInt(name.substring(2));

        //在本地文件中，每张牌的文件名为：数字1-数字2
        //数字1表示花色，数字2表示牌的数字
        //其中3~K对应的数字2，可以视为牌的价值
        //所以，我们单独判断大小王，A，2即可

        //计算大小王牌的价值
        if (color == 5) {
            //小王的初始价值为1，在1的基础上加100，小王价值为：101
            //大王的初始价值为2，在2的基础上加100，大王价值为：102
            return value += 100;
        }

        // 计算A的价值
        if (value == 1) {
            // A的初始化价值为1，在1的基础上加20，大王价值为：21
            return value += 20;
        }

        // 计算2的价值
        if (value == 2) {
            // 2的初始化价值为2，在2的基础上加30，大王价值为：32
            return value += 30;
        }

        // 如果不是大小王，不是A，不是2，牌的价值就是牌对应的数字
        return value;
    }
}
