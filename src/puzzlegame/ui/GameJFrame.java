package puzzlegame.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化图片
        initImage();

        // 界面显示，建议放在最后
        this.setVisible(true);
    }

    private void initImage() {
        int num = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon("/Users/wangshimin/study/java/basicCode/image/animal/animal3/"+num+".jpg");
                // 创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                // 指定图片位置
                jLabel.setBounds(j*105,i*105,105,105);
                // 将管理容器添加到界面当中
                this.getContentPane().add(jLabel);
                num++;
            }
        }

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
        this.setSize(603,680);
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
