package day21_Algorithm.CommonAlgorithms;

public class A02_BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {7, 23, 79, 81, 103, 127, 131, 147};
        System.out.println(binarySearch(arr, 103));
        System.out.println(InterpolationSearch(arr, 103));
    }

    /**
     * 差值查找法
     * 说明：适用于数据项均匀分布的有序数组。
     * 它利用待查找值与数组首尾元素的关系来预测目标值的位置，从而可能比二分查找更高效。
     * @param arr
     * @param i
     * @return
     */
    private static int InterpolationSearch(int[] arr, int number) {
        int min = 0;
        int max = arr.length - 1;
        while( min <= max && number >= arr[min] && number <= arr[max] ){
            if (min == max) {
                if (arr[min] == number) return min;
                return -1; // 元素不在数组中
            }
            // 预估位置 pos
            int pos = min + ( number - arr[min] ) / ( arr[max] - arr[min] ) * (max - min);
            // 根据比较结果调整搜索范围
            if (arr[pos] == number){
                return pos;
            } else if (arr[pos] < number) {
                min = pos + 1;
            } else {
                max = pos - 1;
            }

        }
        // 如果没有找到目标值，则返回-1
        return -1;
    }

    /**
     * 查询某个元素在数组中的索引
     * @param arr 数组
     * @param number 查询的元素
     * @return 查询到的索引，如果没有找到，返回-1
     *
     * 二分查找法
     * 说明：必须是元素有序的数组
     *
     */
    private static int binarySearch(int[] arr, int number) {
        // 1.定义两个变量记录要查找的范围
        int min = 0;
        int max = arr.length - 1;

        // 2.利用循环不断的去找要查找的数据
        while(true){
            if (min > max){
                return -1;
            }
            // 3.找到min和max的中间位置
            int mid = (min + max) / 2;
            // 4.拿着mid指向的元素跟要查找的元素进行比较
            if (arr[mid] > number){
                // 4.1 number在mid的左边
                // min不变，max = mid - 1
                max = mid - 1;
            } else if (arr[mid] < number) {
                // 4.2 number在mid的右边
                // max不变，min = mid + 1
                min = mid + 1;
            } else {
                // 4.3 number跟mid指向的元素一样
                // 找到了
                return mid;
            }
        }
    }
}
