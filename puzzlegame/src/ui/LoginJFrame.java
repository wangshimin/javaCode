package ui;

import cn.hutool.core.io.FileUtil;
import domain.User;
import util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

// 登录界面
public class LoginJFrame extends JFrame implements MouseListener {

    ArrayList<User> allUsers = new ArrayList<>();

//    static {
//        allUsers.add(new User("zhangsan","123"));
//        allUsers.add(new User("lisi","1234"));
//    }
    JButton login = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();
    JTextField password = new JTextField();
//    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    // 正确的验证码
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        // 读取本地文件中的用户信息
        readUserInfo();
        
        // 初始化界面
        initJFrame();
        
        // 在这个界面中添加内容
        initView();

        // 让当前界面显示出来
        this.setVisible(true);
    }

    /**
     * 读取本地文件中的用户信息
     */
    private void readUserInfo() {
        // 1.读取数据
        List<String> userInfoStrList = FileUtil.readUtf8Lines("/Users/wangshimin/study/java/basicCode/puzzlegame/userinfo.txt");
        // 2.遍历集合获取用户信息并创建User对象
        for (String str : userInfoStrList) {
            // 3.按照=进行分割
            // username=zhangsan&password=123
            String[] userInfoArr = str.split("&");
            // username=zhangsan
            String[] arr1 = userInfoArr[0].split("=");
            // password=123
            String[] arr2 = userInfoArr[1].split("=");
            // 4.创建User对象
            User u = new User(arr1[1],arr2[1]);
            // 5.把User对象添加到集合中
            allUsers.add(u);
        }
    }

    private void initView() {
        // 1.添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("puzzlegame/image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        // 2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        // 3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("puzzlegame/image/login/密码.png"));
        passwordText.setBounds(130,195,32,16);
        this.getContentPane().add(passwordText);

        // 4.添加密码输入框
        password.setBounds(195,195,200,30);
        this.getContentPane().add(password);

        // 验证码提示
        JLabel codeText = new JLabel(new ImageIcon("puzzlegame/image/login/验证码.png"));
        codeText.setBounds(133,256,50,30);
        this.getContentPane().add(codeText);

        // 验证码的输入框
        code.setBounds(195,256,100,30);
        this.getContentPane().add(code);

        String codeStr = CodeUtil.getCode();
        // 设置内容
        rightCode.setText(codeStr);
        // 绑定鼠标事件
        rightCode.addMouseListener(this);
        // 位置和宽高
        rightCode.setBounds(300,256,50,30);
        // 添加到界面
        this.getContentPane().add(rightCode);

        // 5.添加登录按钮
        login.setBounds(123,310,128,47);
        login.setIcon(new ImageIcon("puzzlegame/image/login/登录按钮.png"));
        // 去除按钮的边框
        login.setBorderPainted(false);
        // 去除按钮的背景
        login.setContentAreaFilled(false);
        // 给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        // 6. 添加注册按钮
        register.setBounds(256,310,128,47);
        register.setIcon(new ImageIcon("puzzlegame/image/login/注册按钮.png"));
        // 去除按钮的边框
        register.setBorderPainted(false);
        // 去除按钮的背景
        register.setContentAreaFilled(false);
        // 给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        // 7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("puzzlegame/image/login/background.png"));
        background.setBounds(0,0,470,390);
        this.getContentPane().add(background);

    }


    private void initJFrame() {
        // 设置宽高
        this.setSize(488,430);
        // 设置标题
        this.setTitle("拼图游戏 v1.0登录");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面默认关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消内部默认布局
        this.setLayout(null);
    }

    // 鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login){
            System.out.println("点击了登录按钮");

            // 获取两个文本输入框中的内容
            String usernameInput = username.getText();
//            char[] passwordInput = password.getPassword();
            String passwordInput = password.getText();


            // 获取用户输入的验证码
            String codeInput = code.getText();
            System.out.println("用户输入的用户名为" + usernameInput);
            System.out.println("用户输入的密码为" + passwordInput);
            
            // 创建一个User对象
            User userInfo = new User(usernameInput,passwordInput);

            if (codeInput.length() == 0){
                showJDialog("验证码不能为空");
            }else if (usernameInput.length() == 0 || passwordInput.length() == 0){
                // 校验用户名和密码是否为空
                System.out.println("用户名或者密码为空");
                // 调用showJDialog方法并展示弹框
                showJDialog("用户名或者密码为空");
            } else if ( !codeInput.equalsIgnoreCase(rightCode.getText()) ) {
                showJDialog("验证码输入错误");
            } else if (contains(userInfo)){
                System.out.println("用户名和密码正确可以开始玩游戏了");
                // 关闭当前登录界面
                this.setVisible(false);
                // 打开游戏的主界面
                // 需要把当前登录的用户名传递给游戏界面
                new GameJFrame();
            } else {
                System.out.println("用户名或密码错误");
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource() == register) {
            System.out.println("点击了注册按钮");
            // 关闭当前的登录界面
            this.setVisible(false);
            // 打开注册界面
            new RegisterJFrame(allUsers);
        } else if (e.getSource() == rightCode) {
            System.out.println("更换验证码");
            // 获取一个新的验证码
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    /**
     * 判断用户在集合中是否存在
     * @param userInput
     * @return
     */
    private boolean contains(User userInput) {
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if ( userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword()) ){
                // 有相同的代表存在，返回true，后面的就不需要再比了
                return true;
            }
        }
        // 循环结束之后还没有找到就代表不存在
        return false;
    }

    private void showJDialog(String content) {
        // 创建一个弹框对象
        JDialog jDialog = new JDialog();
        // 给弹框设置大小
        jDialog.setSize(200,150);
        // 让弹框置顶
        jDialog.setAlwaysOnTop(true);
        // 让弹框居中
        jDialog.setLocationRelativeTo(null);
        // 让弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);

        // 创建JLabel对象管理文字并添加到弹框当中
        JLabel waring = new JLabel(content);
        waring.setBounds(0,0,200,150);
        jDialog.getContentPane().add(waring);

        // 让弹框展示出来
        jDialog.setVisible(true);
    }

    // 鼠标按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login){
            login.setIcon(new ImageIcon("puzzlegame/image/login/登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("puzzlegame/image/login/注册按下.png"));
        }
    }

    // 鼠标松开
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login){
            login.setIcon(new ImageIcon("puzzlegame/image/login/登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("puzzlegame/image/login/注册按钮.png"));
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