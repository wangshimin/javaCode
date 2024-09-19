package day21_Algorithm.CommonAlgorithms;

import java.util.LinkedList;

public class A05_HashSearchDemo {
    public static void main(String[] args) {
        // 创建一个哈希表
        HashTable hashTable = new HashTable(10);

        // 插入一些键值
        hashTable.insert(10);
        hashTable.insert(28);
        hashTable.insert(32);
        hashTable.insert(45);
        hashTable.insert(54);
        hashTable.insert(60);
        hashTable.insert(79);
        hashTable.insert(86);
        hashTable.insert(99);

        // 打印哈希表
        hashTable.print();

        // 查找键值
        System.out.println("Searching for 54:" + hashTable.search(54));// true
        System.out.println("Searching for 80:" + hashTable.search(80));// false
        System.out.println("Searching for 99:" + hashTable.search(99));// true

        //删除键值
        hashTable.delete(99);
        hashTable.print();

        // 再次查找删除的键值
        System.out.println("Searching for 99:" + hashTable.search(99));// false

    }
}

class HashTable{
    private LinkedList<Integer>[] table; // 一个 LinkedList<Integer> 类型的数组，用于存储键值。
    private int size;// 哈希表的大小。

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];// 初始化哈希表的大小。
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();// 为每个槽位创建一个链表。
        }
    }

    /**
     * 哈希函数：计算键值 key 的哈希值。
     * 使用取模运算 (%) 将键值映射到哈希表的范围内。
     * @param key
     * @return
     */
    private int hashFunction(int key){
        return key % size;
    }

    // 插入操作：将 key 添加到对应槽位的 LinkedList 中
    public void insert(int key){
        int index = hashFunction(key);
//        System.out.println(key + "的槽位是"+ index);
        table[index].add(key);
    }

    // 查找操作：检查对应槽位的 LinkedList 是否包含 key。
    public boolean search(int key){
        int index = hashFunction(key);
        return table[index].contains(key);
    }

    // 删除操作：从对应槽位的 LinkedList 中删除 key。
    public void delete(int key){
        int index = hashFunction(key);
        table[index].remove(Integer.valueOf(key));
    }

    // 打印哈希表
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println("Bucket "+ i + ": ");
            for (int key: table[i]){
                System.out.println(key + " ");
            }
            System.out.println();
        }
    }
}
