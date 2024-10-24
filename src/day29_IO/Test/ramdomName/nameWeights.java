package day29_IO.Test.ramdomName;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class nameWeights {
    /**
     *  TXT文件中事先准备好一些学生信息，每个学生的信息独占一行。
     *  需求:每次被点到的学生，再次被点到的概率在原先的基础上降低一半。
     *  举例：80个学生，点名5次，每次都点到小A，概率变化情况如下：
     *  第一轮：每人概率为 1.25%
     *  第二轮：小A概率为 0.625%，   其他学生概率 1.2579%
     *  第三轮：小A概率为 0.3125%    其他学生概率 1.261867%
     *  第四轮：小A概率为 0.15625%   其他学生概率 1.2638449%
     *  第五轮：小A概率为 0.078125%   其他学生概率 1.264843386%
     *
     *  提示：本题的核心就是带权重的随机
     */
    public static void main(String[] args) throws IOException {
        //1.把文件中所有的学生信息读取到内存中
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/day29_IO/Test/ramdomName/nameWeights.txt"));
        String line;
        while((line = br.readLine()) != null){
            String[] arr = line.split("-");
            Student stu = new Student(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3]));
            list.add(stu);
        }
        br.close();

        //2.计算权重的总和
        double weight = 0;
        for (Student stu : list) {
            weight = weight + stu.getWeight();
        }

        //3.计算每一个人的实际占比
        //[0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1]
        double[] arr = new double[list.size()];
        int index = 0;
        for (Student stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }

        //4.计算每一个人的权重占比范围
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        //5.随机抽取
        //获取一个0.0~1.0之间的随机数
        double number = Math.random();
        //判断number在arr中的位置
        //二分查找法
        //方法回返回： - 插入点 - 1
        //获取number这个数据在数组当中的插入点位置
        int result = -Arrays.binarySearch(arr, number) - 1;
        Student stu = list.get(result);
        System.out.println(stu);

        //6.修改当前学生的权重
        double w = stu.getWeight() / 2;
        stu.setWeight(w);

        //7.把集合中的数据再次写到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/day29_IO/Test/ramdomName/nameWeights.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();


    }
}

