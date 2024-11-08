package day37.Logback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class demo1 {
    // 获取日志对象
    public static final Logger LOGGER = LoggerFactory.getLogger("demo1.class");
    public static void main(String[] args) {
        // 登录操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();

        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if ("zhangsan".equals(userName) && "123".equals(passWord)) {
            System.out.println("用户登录成功");
            LOGGER.info("用户于 "+ formattedDateTime +" 登录成功，用户名为 " + userName + "，密码为："+ passWord);
        } else {
            System.out.println("登录失败");
            LOGGER.error("用户于 "+ formattedDateTime +" 登录失败，用户名为 " + userName + "，密码为："+ passWord);
        }
    }
}
