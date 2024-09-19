package day21_Algorithm.CommonAlgorithms;

public class A04_BlockSearchDemo2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        int x = 55;
        int result = blockSearch(arr, x);
        System.out.println((result == -1) ? "Element not found" : "Element is present at index " + result);
    }

    private static int blockSearch(int[] arr, int x) {

        int n = arr.length;

        // 1.确定块大小：首先选择一个合适的块大小 blockSize，通常可以取为 sqrt(n)，其中 n 是数组长度。
        int blockSize = (int) Math.sqrt(n);
        // 2.跳跃查找:从数组的第一个元素开始，每次跳跃 blockSize 个位置，直到找到第一个大于或等于目标值的块为止。
        int prev = 0;
        while (arr[Math.min(prev + blockSize, n) -1] < x){ // 检查当前块的最后一个元素是否小于x
            prev += blockSize;
            if (prev >= n){
                return -1;// 目标值不在数组中
            }
        }
        // 3.线性查找：在找到的块内进行线性查找，寻找目标值。
        for (int i = prev; i < Math.min(prev + blockSize, n); i++) {
            if (arr[i] == x){
                return i;
            }
        }
        return -1; // 目标值不在数组中
    }
}
