package day21_Algorithm.CommonAlgorithms;

/**
 * 快速排序：
 * 第一轮：以0索引的数字为基准数，确定基准数在数组中正确的位置。
 * 比基准数小的全部在左边，比基准数打的全部在右边。
 * 后面以此类推。
 */
public class A10_QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 7, 9, 3, 4, 2, 10, 8};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }

    /**
     * 快速排序
     * @param arr
     * @param i
     * @param j
     */
    private static void quickSort(int[] arr, int i, int j) {
//        System.out.println("快速排序开始！i = " +i+ " ，j = "+ j );
        // 定义两个变量记录要查找的范围
        int start = i;
        int end = j;

        if (start > end){
            // 递归的出口
            return;
        }
        // 记录基准数
        int baseNumber = arr[i];
       // 利用循环找到要交换的数字
        while( start < end ){

            // 利用end 从后往前找到比基准数小的数字
            while (end > start && arr[end] >= baseNumber) {
                end--;
            }

            // 利用start 从前往后找到比基准数大的数字
            while (start < end && arr[start] <= baseNumber) {
                start++;
            }
            if (start < end) {
//                System.out.println("此时的基准数是"+ baseNumber + "，交换前的数组：");
//                printArr(arr);
//                System.out.println();
//                System.out.println("end 为 arr[" + end + "]值为:" + arr[end] );
//                System.out.println("start 为 arr[" + start + "]值为："+ arr[start]);
//                System.out.println("交换后，");
                // 把end 和 start 指向的元素进行交换
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
//                printArr(arr);
//                System.out.println();
//                System.out.println("******************** ");
            }

        }
        // 当start和end指向了同一个元素的时候，那么上面的循环就会结束
        // 表示已经找到了基准数在数组中应存入的位置
        // 基准数归位
        // 就是拿着这个范围中的第一个数字，跟start指向的元素进行交换
        int temp = arr[i];
        arr[i] = arr[start];
//        System.out.println("基准数归位："+ arr[start] + " index: "+ start);
        arr[start] = temp;
        // 确定6左边的元素，重复刚刚所做的事情
        quickSort(arr, i, start-1);
        // 确定6右边的元素，重复刚刚所做的事情
        quickSort(arr, start+1, j);
    }

    private static void printArr(int[] arr) {
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
    }

}
