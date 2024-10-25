package ui;

import cn.hutool.core.io.IoUtil;
import domain.GameInfo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 创建一个二维数组
    // 目的：用来管理数据
    // 加载图片的时候，会根据二维数组中的数据进行加载
    int[][] data = new int[4][4];

    // 记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    // 定义一个变量，记录当前展示图片的路径
    String imagePath = "puzzlegame/image/";
    String imageTheme = "animal/animal3/";
    // 定义一个二维数组，存储正确的数据
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 定义变量用来统计步数
    int step = 0;

    // 创建选项下面的条目对象
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenu saveJMenu = new JMenu("存档");
    JMenu loadJMenu = new JMenu("读档");

    JMenuItem saveItem0 = new JMenuItem("存档0(空)");
    JMenuItem saveItem1 = new JMenuItem("存档1(空)");
    JMenuItem saveItem2 = new JMenuItem("存档2(空)");
    JMenuItem saveItem3 = new JMenuItem("存档3(空)");
    JMenuItem saveItem4 = new JMenuItem("存档4(空)");

    JMenuItem loadItem0 = new JMenuItem("读档0(空)");
    JMenuItem loadItem1 = new JMenuItem("读档1(空)");
    JMenuItem loadItem2 = new JMenuItem("读档2(空)");
    JMenuItem loadItem3 = new JMenuItem("读档3(空)");
    JMenuItem loadItem4 = new JMenuItem("读档4(空)");

    JMenuItem accountItem = new JMenuItem("公众号");

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
//        for (int i = 0; i < data.length; i++) {
//             for (int j = 0; j < data[i].length; j++) {
//                data[i][j] = tempArr[index];
//                index++;
//            }
//        }
        // 3.给而为数组添加数据
        // 遍历一维数组tempArr得到每一个元素，把每一个元素依次添加到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    /**
     * 初始化图片
     * 添加图片的时候，就需要按照二维数组中管理的数据添加图片
     */
    private void initImage() {

        // 清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()){
            // 显示胜利的图标
            JLabel winJLabel = new JLabel(new ImageIcon("puzzlegame/image/win.png"));
            winJLabel.setBounds(203,283,297,73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

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
                ImageIcon icon = new ImageIcon(imagePath + imageTheme + num + ".jpg");
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

        // 刷新一下界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        // 创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单上面的两个选项的对象(功能、关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        // 创建更换图片
        JMenu changeImage = new JMenu("更换图片");

        //把5个存档，添加到saveJMenu中
        saveJMenu.add(saveItem0);
        saveJMenu.add(saveItem1);
        saveJMenu.add(saveItem2);
        saveJMenu.add(saveItem3);
        saveJMenu.add(saveItem4);

        //把5个读档，添加到loadJMenu中
        loadJMenu.add(loadItem0);
        loadJMenu.add(loadItem1);
        loadJMenu.add(loadItem2);
        loadJMenu.add(loadItem3);
        loadJMenu.add(loadItem4);

        // 把美女、动物、运动添加到更换图片当中
        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);

        //将更换图片，重新游戏，重新登录，关闭游戏，存档，读档添加到“功能”选项当中
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(saveJMenu);
        functionJMenu.add(loadJMenu);

        //将公众号添加到关于我们当中
        aboutJMenu.add(accountItem);

        // 给条目绑定事件
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        saveItem0.addActionListener(this);
        saveItem1.addActionListener(this);
        saveItem2.addActionListener(this);
        saveItem3.addActionListener(this);
        saveItem4.addActionListener(this);
        loadItem0.addActionListener(this);
        loadItem1.addActionListener(this);
        loadItem2.addActionListener(this);
        loadItem3.addActionListener(this);
        loadItem4.addActionListener(this);

        // 将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void  initJFrame() {
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
        // 给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下不松时会调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){
            // 把界面中所有的图片全部删除
            this.getContentPane().removeAll();
            // 加载第一张完整的图片
            JLabel jLabel = new JLabel(new ImageIcon(imagePath + imageTheme +"all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);

            // 加载背景图片
            JLabel background = new JLabel(new ImageIcon(imagePath+"background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            // 刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 判断游戏是否已胜利，如果已胜利，此方法需直接结束，不能再继续执行
        if (victory()){
            // 1.返回结果 2.结束方法
            return;
        }

        // 对上下左右进行判断
        // 左：37，上：38，右：39，下：40
        int code = e.getKeyCode();
        switch (code){
            case 37 ->{
                System.out.println("向左移动");
                if (y == 3){
                    return;
                }
                data[x][y] = data[x][ y+1 ];
                data[x][y+1] = 0;
                y++;
                // 每移动一次，记步器就自增一次
                step++;
                // 调用方法按照最新的数字加载图片
                initImage();
            }
            case 38 ->{
                System.out.println("向上移动");
                if (x == 3){
                    // 表示空白方块已经在最下方执行了，它的下面没有图片再能移动了
                    return;
                }
                // 逻辑：
                // 把空白方块下面的数字向上移动
                // x,y 表示空白方块
                // x+1,y 表示空白方块下面的数字

                // 把空白方块下方的数字赋值给空白方块
                data[x][y] = data[ x+1 ][y];
                data[ x+1 ][y] = 0;
                x++;
                // 每移动一次，记步器就自增一次
                step++;
                // 调用方法按照最新的数字加载图片
                initImage();
            }
            case 39 ->{
                System.out.println("向右移动");
                if (y == 0){
                    return;
                }
                data[x][y] = data[x][ y-1 ];
                data[x][ y-1 ] = 0;
                y--;
                // 每移动一次，记步器就自增一次
                step++;
                // 调用方法按照最新的数字加载图片
                initImage();
            }
            case 40 ->{
                System.out.println("向下移动");
                if (x == 0){
                    // 表示空白方块已经在最上方执行了，它的上面没有图片再能移动了
                    return;
                }
                data[x][y] = data[ x-1 ][y];
                data[ x-1 ][y] = 0;
                x--;
                // 每移动一次，记步器就自增一次
                step++;
                // 调用方法按照最新的数字加载图片
                initImage();
            }
            case 65 ->{
                // 按a，回到拼图界面
                initImage();
            }
            case 87 ->{
                // 按w，直接胜利
                data = new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,0}
                };
                initImage();
            }
        }
    }

    /**
     * 判断拼图是否胜利
     * @return
     */
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            // i : 依次表示二维数组 data 里面的索引
            // data[i]:依次表示每一个一维数组
            for (int j = 0; j < data[i].length; j++) {
                if ( data[i][j] != win[i][j] ) {
                    // 只要有一个数据不一样，则返回false
                    return false;
                }
            }
        }
        // 循环结束表示数据遍历完毕，没有发现不一样的数据，返回true
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取当前被点就的条目对象
        Object obj = e.getSource();
        // 判断
        if (obj == replayItem){
            System.out.println("重新游戏");
            // 计步器清零
            step = 0;
            // 再次打乱二维数组中的数据
            initData();
            // 重新加载图片
            initImage();
        } else if (obj == reloginItem) {
            System.out.println("重新登录");
            // 关闭当前的游戏界面
            this.setVisible(false);
            // 打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            // 直接关闭虚拟机即可
            System.exit(0);
        } else if( obj == accountItem ) {
            System.out.println("公众号");

            // 创建一个弹框对象
            JDialog jDialog = new JDialog();
            // 创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame/image/about.png"));
            // 设置位置和宽高
            jLabel.setBounds(0,0,358,258);
            // 把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            // 设置弹框大小
            jDialog.setSize(344,344);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 设置弹框居中
            jDialog.setLocationRelativeTo(null);
            // 让弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            // 让弹框显示出来
            jDialog.setVisible(true);
        } else if (obj == girl) {
            changeTheme("girl", 13);
        } else if(obj == animal) {
            changeTheme("animal",8);
        } else if (obj == sport) {
            changeTheme("sport", 10);
        }else if(obj == saveItem0 || obj == saveItem1 || obj == saveItem2 || obj == saveItem3 ||obj == saveItem4){
            System.out.println("存档");
            // 直接把游戏的数据写到本地文件中
            // 使用IO的序列化流，把对象的整体写到本地文件中

            //获取当前是哪个存档被点击了，获取其中的序号
            JMenuItem item = (JMenuItem) obj;
            String str = item.getText();
            int index = str.charAt(2) - '0';

            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save/save"+ index +".data"));
                GameInfo gi = new GameInfo(data, x, y, imagePath + imageTheme, step);
                 // 写法1:写入并手动关流
//                oos.writeObject(gi);
//                oos.close();
                // 写法2，使用hutool工具类写入并关流
                IoUtil.writeObj(oos, true, gi);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //  修改一下存档item上的展示信息
            //  存档0(XX步)
            item.setText("存档" + index + "(" + step + "步)");
            //  修改一下读档item上的展示信息
            loadJMenu.getItem(index).setText("读档" + index + "(" + step + "步)");
        }else if(obj == loadItem0 || obj == loadItem1 || obj == loadItem2 || obj == loadItem3 ||obj == loadItem4){
            System.out.println("读档");
            JMenuItem item = (JMenuItem) obj;
            System.out.println(item.getText());

        }

    }

    /**
     * 更换图片
     * @param themeName
     * @param style
     */
    public void changeTheme(String themeName, int style){
        Random r = new Random();
        imageTheme = themeName +"/"+ themeName + r.nextInt(style) + "/";
//        System.out.println(imageTheme);
        // 计步器清零
        step = 0;
        // 再次打乱二维数组中的数据
        initData();
        // 重新加载图片
        initImage();
    }
}
