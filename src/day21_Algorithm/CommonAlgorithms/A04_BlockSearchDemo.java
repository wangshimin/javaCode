package day21_Algorithm.CommonAlgorithms;

/**
 * 分块查找
 * 核心思想：块内无序，块间有序
 * 适用范围：数据较多，但是数据不会发生变化的情况
 *
 * 分块查找的过程：
 *1.需要把数据分成N多小块，块与块之间不能有数据重复的交集。
 *2.给每一块创建对象单独存储到数组当中
 *3.查找数据的时候，先在数组查，当前数据属于哪一块
 *4.再到这一块中顺序查找
 *
 */
public class A04_BlockSearchDemo {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12,21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};
        // 创建三个块的对象
        Block b1 = new Block(21,0,5);
        Block b2 = new Block(37,6,11);
        Block b3 = new Block(73,12,17);

        // 定义数组用来管理三个块的对象（索引表）
        Block[] blockArr = {b1, b2, b3};

        // 定义一个变量用来记录要查找的元素
        int number = 37;

        // 调用方法，传递索引表、数组、要查找的元素
        int index = getIndex(blockArr, arr, number);

        // 打印一下
        System.out.println(index);
    }

    /**
     * 利用分块查找的原理，查询number的索引
     * @param blockArr  索引表
     * @param arr       数组
     * @param number    要查找的元素
     * @return          索引下标值
     */
    private static int getIndex(Block[] blockArr, int[] arr, int number) {
        // 1.确定number是在哪一块中
        int indexBlock = findIndexBlock(blockArr, number);
        if (indexBlock != -1) {
            // 2.获取这一块的起始索引和结束索引
            int startIndex = blockArr[indexBlock].getStartIndex();
            int endIndex = blockArr[indexBlock].getEndIndex();
            // 3.遍历查找
            for (int i = startIndex; i <= endIndex; i++) {
                if (arr[i] == number){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 查找number在哪一块中
     * @param blockArr
     * @param number
     * @return
     */
    private static int findIndexBlock(Block[] blockArr, int number) {
        for (int i = 0; i < blockArr.length; i++) {
            if (number <= blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }

    private static class Block {
        private int max;// 最大值
        private int startIndex; // 起始索引
        private int endIndex;   // 结束索引

        public Block() {
        }

        public Block(int max, int startIndex, int endIndex) {
            this.max = max;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "max=" + max +
                    ", startIndex=" + startIndex +
                    ", endIndex=" + endIndex +
                    '}';
        }
    }
}


