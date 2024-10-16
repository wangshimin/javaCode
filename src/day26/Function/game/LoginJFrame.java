package day26.Function.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginJFrame extends MyJFrame{
    JButton go = new JButton("Go");

    public LoginJFrame() {
        // 设置图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/day26/Function/image/logo.jpg"));

        // 设置界面
        initJframe();

        // 添加组件
        initVime();

        // 显示界面
        this.setVisible(true);
    }

    /**
     * 初始化组件
     */
    private void initVime() {
        JLabel image = new JLabel(new ImageIcon("src/day26/Function/image/kit.jpg"));
        image.setBounds(100, 50, 174, 174);
        this.getContentPane().add(image);


        go.setFont(new Font(null, 1, 20));
        go.setBounds(120, 274, 150, 50);
        go.setBackground(Color.WHITE);

//        go.addActionListener(this::method1); // 引用本类中的成员方法
        go.addActionListener(super::method2);  // 引用父类中的成员方法
        this.getContentPane().add(go);
    }

    /**
     * 初始化界面
     */
    private void initJframe() {
        // 设置标题
        this.setTitle("随机点名器");
        // 设置大小
        this.setSize(400, 500);
        // 设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口无法进行调节
        this.setResizable(false);
        // 界面居中
        this.setLocationRelativeTo(null);
        // 取消内部默认居中放置
        this.setLayout(null);
        // 设置背景颜色
        this.getContentPane().setBackground(Color.white);
        // 置顶
        this.setAlwaysOnTop(true);
    }

    public void method1(ActionEvent e) {
        System.out.println("Go按钮被点击了");
    }
}
