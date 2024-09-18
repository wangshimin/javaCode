package day21_Algorithm.CommonAlgorithms;

import java.util.Arrays;

public class A03_FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(search(arr, 1000));
    }

    private static int search(int[] arr, int key) {
        int low = 0;
        int height = arr.length - 1;
        // 表示斐波那契分割数的下标值
        int index = 0;
        int mid = 0;
        // 调用斐波那契数列
        int[] f = getFeiBo();
        //获取斐波那契分割数值的下标
        while (height > f[index] - 1) {
            index++;
        }
        //因为f[k]值可能大于a的长度，因此需要使用Arrays工具类，构造一个新数组，并指向temp[],不足的部分会使用0补齐
        int[] temp = Arrays.copyOf(arr, f[index]);
        //实际需要使用arr数组的最后一个数来填充不足的部分
        for (int i = height + 1; i < temp.length; i++) {
            temp[i] = arr[height];
        }

        // 使用while循环处理，找到key值
        while(low <= height){
            mid = low + f[index - 1] - 1;
            if (key < temp[mid]) {//向数组的前面部分进行查找
                height = mid -1;
                /*
                  对k--进行理解
                  1.全部元素=前面的元素+后面的元素
                  2.f[k]=k[k-1]+f[k-2]
                  因为前面有k-1个元素没所以可以继续分为f[k-1]=f[k-2]+f[k-3]
                  即在f[k-1]的前面继续查找k--
                  即下次循环,mid=f[k-1-1]-1
                 */
            } else if (key > temp[mid]) {//向数组的后面的部分进行查找
                low = mid + 1;
                index -= 2;
            } else { // 找到了
                //需要确定返回的是哪个下标
                if (mid <= height) {
                    return mid;
                } else {
                    return height;
                }
            }
        }
        return -1;
    }

    private static int[] getFeiBo() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i -1] + arr[i - 2];
        }
        return arr;
    }
}
