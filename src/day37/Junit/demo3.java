package day37.Junit;

import org.junit.*;

import java.io.*;

public class demo3 {
    // 实际开发中，真正完整的单元测试该怎么写？
    // 前提：测试代码不能污染原数据（修改、篡改），测试代码不能影响原数据的状态。

    // 1.利用@Before去对数据做一个初始化的动作
    // 2.利用@Test去编写测试方法
    // 3.利用@After去还原数据，对数据做一个清理的动作

    // 需求：测试File类中的delete方法是否书写正确

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("beforeMethod");
        // 先备份
        copyFile("src/day37/Junit/a.txt", "src/day37/Junit/bak.txt");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @Test
    public void method(){
        System.out.println("Test");
        File file = new File("src/day37/Junit/a.txt");
        boolean deleted = file.delete();
        // 只有同时满足类下面的断言，才表示delete方法正确
        Assert.assertEquals("delete方法出错了", true, deleted);
        // 检查a.txt是否存在
        Assert.assertEquals("文件不存在", false, file.exists());
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
        // 对a.txt做一个还原
        copyFile("src/day37/Junit/bak.txt", "src/day37/Junit/a.txt");
        // 备份数据要删除
        new File("src/day37/Junit/bak.txt").delete();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    public void copyFile(String srcPath, String descPath){
        File src = new File(srcPath);
        File desc = new File(descPath);

        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(desc);
            int b;
            while ((b = fis.read()) != -1){
                fos.write(b);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
