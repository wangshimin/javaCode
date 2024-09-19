package day21_Algorithm.CommonAlgorithms;

/**
 * 选择排序
 *
 * 算法步骤：
 * 从0索引开始，跟后面的元素一一比较
 * 小的放前面，大的放后面
 * 第一次循环结束后，最小的数据已经确定
 * 第二次循环从1索引开始以此类推
 * 第三轮循环从2索引开始以此类推
 * 第四轮循环从3索引开始以此类推。
 */
public class A07_SelectionDemo {
    public static void main(String[] args) {
        //1.定义数组
        int[] arr = {2, 4, 5, 3, 1};

        //2.利用选择排序让数组变成 1 2 3 4 5
        //外循环：几轮
        //i:表示这一轮中，我拿着哪个索引上的数据跟后面的数据进行比较并交换
        for (int i = 0; i < arr.length -1; i++) {
            //内循环：每一轮我要干什么事情？
            //拿着i跟i后面的数据进行比较交换
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        //3.遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
