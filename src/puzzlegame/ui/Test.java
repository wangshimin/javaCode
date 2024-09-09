package puzzlegame.ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        // 1.创建游戏主界面
        JFrame gameJframe = new JFrame();
        gameJframe.setSize(603,680);
        gameJframe.setTitle("拼图游戏界面");
        gameJframe.setAlwaysOnTop(true);
        gameJframe.setLocationRelativeTo(null);
        gameJframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameJframe.setVisible(true);
    }
}
