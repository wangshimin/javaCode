package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 需求：
        // 把一个一维数组的数据，0～15打乱顺序
        // 然后再按照4个一组的方式添加到二维数组中

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
        // 3.遍历数组
        for (int i = 0; i < len; i++) {
            System.out.print(tempArr[i] + " " );
        }

        // 4.创建一个二维数组
        int[][] data = new int[4][4];

        // 5.给二维数组添加数据
        // 解法一：
            // 遍历一维数组tempArr得到每一个元素。把每一元素依次添加到二维数组中
//            for (int i = 0; i < len; i++) {
//                System.out.println("父子"+ i/4+"-hh-"+i%4+"--zzz---"+ tempArr[i]);
//                data[ i / 4][ i % 4] = tempArr[i];
//
//            }

            // 解法二：
            int index = 0;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = tempArr[index];
                    index++;
                }
            }
        // 遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
