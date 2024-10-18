package day27_Exception.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class demo7 {
    public static void main(String[] args) {
        /*
        public static File[] listRoots()                列出可用的文件系统根
        public String[] list()                          获取当前该路径下所有内容
        public String[] list(FilenameFilter filter)     利用文件名过滤器获取当前该路径下所有内容
        （掌握）public File[] listFiles()                获取当前该路径下所有内容
        public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
        public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
      */

        //  1.listRoots  获取系统中所有的盘符
        File[] arr = File.listRoots();
//        System.out.println(Arrays.toString(arr));


        //  2.list()    获取当前该路径下所有内容(仅仅能获取名字)
        File f1 = new File("/Users/test/AA");
        String[] arr1 = f1.list();
        for (String s : arr1) {
            System.out.println(s);
        }

        // 3.list(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
        File f2 = new File("/Users/test/AA");
        String[] arr2 = f2.list(new FilenameFilter() {
            /**
             *  accept方法的形参，依次表示文件夹里每一个文件或文件夹的路径
             * @param dir    父级路径
             * @param name   子级路径
             * @return       true - 当前路径保留 ， false - 当前路径舍弃不要
             */
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                // 需求：只保留txt文件
                return src.isFile() && name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(arr2));


    }
}
