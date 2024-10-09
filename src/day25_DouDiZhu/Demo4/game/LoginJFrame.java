package day25_DouDiZhu.Demo4.game;

import day25_DouDiZhu.Demo4.domain.User;
import day25_DouDiZhu.Demo4.util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("zhangsan", "123"));
        allUsers.add(new User("lisi", "456"));
    }

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    // 正确的验证码
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        // 初始化界面
        initJFrame();
        // 初始化组件：在这个界面中添加内容
        initView();
        // 让当前界面显示出来
        this.setVisible(true);
    }

    /**
     * 初始化界面
     */
    private void initJFrame() {
        this.setSize(633, 423); // 设置宽高
        this.setTitle("斗地主游戏 v1.0登录");  // 设置标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭模式
        this.setLocationRelativeTo(null);   // 居中
        this.setAlwaysOnTop(true);          // 窗口置顶
        this.setLayout(null);               // 取消内容默认布局
    }

    /**
     * 初始化组件：在这个界面中添加内容
     */
    private void initView() {
        // 1.添加用户名文字
        Font usernameFont = new Font(null, 1, 16);
        JLabel usernameText = new JLabel("用户名");
        usernameText.setForeground(Color.white);
        usernameText.setFont(usernameFont);
        usernameText.setBounds(140, 55, 55, 22);
        this.getContentPane().add(usernameText);

        // 2.添加用户名输入框
        username.setBounds(223, 46, 200, 30);
        this.getContentPane().add(username);

        // 3.添加密码文字
        JLabel passwordText = new JLabel("密码");
        passwordText.setForeground(Color.white);
        passwordText.setFont(usernameFont);
        passwordText.setBounds(197, 95, 40, 22);
        this.getContentPane().add(passwordText);

        // 4.添加密码输入框
        password.setBounds(263, 87, 160, 30);
        this.getContentPane().add(password);

        // 5.添加验证码文字
        JLabel codeText = new JLabel("验证码");
        codeText.setForeground(Color.white);
        codeText.setFont(usernameFont);
        codeText.setBounds(215, 142, 55, 22);
        this.getContentPane().add(codeText);

        // 6.添加验证码输入框
        code.setBounds(291, 133, 100, 30);
        this.getContentPane().add(code);

        // 7.获取正确的验证码
        String codeStr = CodeUtil.getCode();
        Font rightCodeFont = new Font(null, 1, 15);
        rightCode.setForeground(Color.RED);   // 设置颜色
        rightCode.setFont(rightCodeFont);       // 设置字体
        rightCode.setText(codeStr);             // 设置内容
        rightCode.addMouseListener(this);    // 绑定鼠标事件
        rightCode.setBounds(400, 133, 100, 30);// 位置和宽高
        this.getContentPane().add(rightCode);   // 添加到界面

        // 8.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/登录按钮.png"));
        login.setBorderPainted(false);    // 去除按钮的边框
        login.setContentAreaFilled(false);// 去除按钮的背景
        login.addMouseListener(this);   // 给登录按钮绑定鼠标事件
        this.getContentPane().add(login);

        // 9.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/注册按钮.png"));
        register.setBorderPainted(false);       // 去除按钮的边框
        register.setContentAreaFilled(false);   // 去除按钮的背景
        register.addMouseListener(this);    // 给注册按钮绑定鼠标事件
        this.getContentPane().add(register);

        // 10.添加背景图片
        JLabel background = new JLabel(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/background.png"));
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);
    }

    //展示弹框
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        //让弹框展示出来
        jDialog.setVisible(true);
    }

    // 点击
    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
//            System.out.println("登录按钮被点击了");
            // 获取两个输入框中的内容
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            // 获取用户输入的验证码
            String codeInput = code.getText();

            // 判断验证码是否为空
            if (codeInput.length() == 0){
                showJDialog("验证码不能为空");
                return;
            }
            // 判断用户名和密码是否为空
            if (usernameInput.isEmpty() || passwordInput.isEmpty()){
                showJDialog("用户名或密码为空");
                return;
            }
            // 判断验证码是否正确
            if (!codeInput.equalsIgnoreCase(rightCode.getText())){
                showJDialog("验证码输入错误");
                return;
            }
            // 判断集合中是否包含当前用户对象
            //其实就是验证用户名和密码是否相同
            //contains底层是依赖equals方法判断的，所以需要重写equals方法
            User userInfo = new User(usernameInput, passwordInput);
            if (allUsers.contains(userInfo)){
                // 关闭当前登录界面
                this.setVisible(false);
                // 打开游戏的主界面
                new GameJFrame();
            } else {
                showJDialog("用户名或密码错误");
            }
        } else if (obj == register) {
            System.out.println("注册按钮被点击了");
        } else if (obj == rightCode) {
            // 获取一个新的验证码
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    // 按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/注册按下.png"));
        }
    }

    // 松开按钮
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/day25_DouDiZhu/Demo4/farmerandlord/image/login/注册按钮.png"));
        }
    }

    // 鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    // 鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
