package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jbt1 = new JButton("按钮");

    public MyJFrame2(){
        // 设置界面的宽高
        this.setSize(630,680);
        // 设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 取消默认的居中模式，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        // 给按钮设置位置和宽高
        jbt1.setBounds(0,0,100,50);
        // 给按钮绑定鼠标事件
        jbt1.addMouseListener(this);


        // 把按钮添加到整个界面当中
        this.getContentPane().add(jbt1);

        // 让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");
    }
}