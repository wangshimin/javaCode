package day37.XML.demo2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

public class demo2 {
    static ArrayList<User> list = new ArrayList<>();

    /*
        Document 表示整个文档对象
        Element 表示一个标签
        Attribute 表示一个属性
        Text 表示标签中的文本

        Element、Attribute、Text共同的父类：Node(节点)
        每一个标签、属性、文本都可以看作是节点
     */
    public static void main(String[] args) throws DocumentException {
        // 1.创建一个解析器对象
        SAXReader saxReader = new SAXReader();
        // 2.利用解析器去读取xml文件，并返回文档对象
        Document document = saxReader.read(new File("src/day37/XML/demo2/users.xml"));
        // 3.获取根标签的所有子标签
        // 进入根标签，获取里面的user标签
        List<Element> elements = document.getRootElement().elements("user");
        // 遍历集合，获取里面的内容
        elements.forEach(user->{
            String id = user.attributeValue("id");
            String username = user.elementText("username");
            String password = user.elementText("password");
            String personid = user.elementText("personid");
            String mobile = user.elementText("mobile");
            String admin = user.elementText("admin");
            User u = new User(id,username,password,personid,mobile,Boolean.parseBoolean(admin));
            list.add(u);
        });
        // 打印集合
        System.out.println(list);

        // 登录操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userNameInput = sc.nextLine();
        System.out.println("请输入密码：");
        String passWordInput = sc.nextLine();

        // 1.判断用户名是否存在，如果不存在提示用户未注册
        int index = getIndex(list, userNameInput);
        if (index < 0) {
            System.out.println("用户名未注册");
        } else {
            // 2.判断密码是否正确，不正确则提示密码错误
            User user = list.get(index);
            if (!user.getPassword().equals(passWordInput)){
                System.out.println("密码错误");
            } else {
                // 3.判断是否是管理员，不是管理员则提示权限不足
                if (!user.isAdmin()){
                    System.out.println("权限不足");
                } else {
                    // 4.登录成功，提示登录成功
                    System.out.println("登录成功");
                }
            }
        }
    }

    /**
     * 查询userName在集合中的索引
     * @param list 集合
     * @param userName 用户名
     * @return 不存在则返回-1
     */
    public static int getIndex(ArrayList<User> list, String userName){
        int index = -1;
        for (User user : list) {
            if (user.getUsername().equals(userName)) {
                index = list.indexOf(user);
                break;
            }
        }
        return index;
    }
}
