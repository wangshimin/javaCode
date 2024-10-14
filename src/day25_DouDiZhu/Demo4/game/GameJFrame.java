package day25_DouDiZhu.Demo4.game;

import day25_DouDiZhu.Demo4.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/game.png"));
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
    }

    /**
     * 初始化牌（准备牌，洗牌，发牌）
     */
    private void initCard() {
        // 准备牌
        // 把所有的牌，包括大小王都添加到牌盒cardList当中
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 13; j++) {
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
