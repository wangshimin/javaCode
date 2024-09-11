package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Random;

public class GameJFrame extends JFrame {
    // 创建一个二维数组
    // 目的：用来管理数据
    // 加载图片的时候，会根据二维数组中的数据进行加载
    int[][] data = new int[4][4];

    public GameJFrame() {
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据（打乱）
        initData();

        // 初始化图片（根据打乱之后的结果去加载图片）
        initImage();

        // 界面显示，建议放在最后
        this.setVisible(true);
    }

    private void initData() {
        // 1.定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 2.打乱数组中的数据的顺序
        // 遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        int len = tempArr.length;
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            // 获取随机索引
            int index = r.nextInt(len);
            // 拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        // 3.给二维数组添加数据
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[index];
                index++;
            }
        }
    }

    /**
     * 初始化图片
     * 添加图片的时候，就需要按照二维数组中管理的数据添加图片
     */
    private void initImage() {
        // 路径分为两种：
        // 绝对路径 - 一定是哦那个盘符开始的。 C:\ D:\
        // 相对路径 - 不是从盘符开始，而是从当前项目下开始。 aaa\bbb
        // 在当前项目下，去找aaa文件夹，里面再找bbb文件夹。


        /* 细节：先加载的图片在上方，后加载的图片塞在下面 */

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取当前要加载图片的序号
                int num = data[i][j];
                // 创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon("puzzlegame/image/animal/animal3/" + num + ".jpg");
                // 创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                // 指定图片位置
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                // 给图片添加边框
                // 0:表示让图片凸起来
                // 1：表示让图片凹下去
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // 将管理容器添加到界面当中
                this.getContentPane().add(jLabel);
                num++;
            }
        }

        // 添加背景图片
        ImageIcon bg = new ImageIcon("puzzlegame/image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        // 把背景图片添加到界面当中
        this.getContentPane().add(background);

    }

    private void initJMenuBar() {
        // 创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单上面的两个选项的对象(功能、关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // 创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新开始");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        // 将每一个选项下面的条目添加到选项当中
        functionJMenu.add(reloginItem);
        functionJMenu.add(replayItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        // 将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        // 界面宽高
        this.setSize(603, 680);
        // 界面标题
        this.setTitle("游戏开始界面");
        // 界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
    }

}
