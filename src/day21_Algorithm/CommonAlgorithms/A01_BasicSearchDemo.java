package day21_Algorithm.CommonAlgorithms;

/**
 * 顺序查找
 * 适用于：存储结构为数组或者链表
 *
 * 基础思想：
 * 顺序查找也称为线性查找，属于无序查找算法。
 * 从数据结构线的一端开始，顺序扫描，依次将遍历到的结点与要查找的值相比较，若相等则表示查找成功；若遍历结束仍没找到相同的，表示查找失败。
 *
 */
public class A01_BasicSearchDemo {
    public static void main(String[] args) {
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79};
        int number = 81;
        System.out.println(basicSearch(arr, number));
    }

    /**
     * 查询指定元素是否存在
     * @param arr 数组
     * @param number 查找的元素
     * @return
     *
     */
    private static boolean basicSearch(int[] arr, int number) {
        for (int i : arr) {
            if (i == number){
                return true;
            }
        }
        return false;
    }
}
