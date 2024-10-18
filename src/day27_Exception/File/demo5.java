package day27_Exception.File;

import java.io.File;

public class demo5 {
    public static void main(String[] args) {
        /*
        public boolean delete()             删除文件、空文件夹
        细节：
            如果删除的是文件，则直接删除，不走回收站。
            如果删除的是空文件夹，则直接删除，不走回收站
            如果删除的是有内容的文件夹，则删除失败
      */


        //1.创建File对象
        String[] fileNames = {"/Users/test/AA/test.txt", "/Users/test/fileTest/a.txt","/Users/test/AA/test2.txt"};
        for (String fileName : fileNames) {
            File f = new File(fileName);
            //2.调用delete方法
            boolean result = f.delete();
            System.out.println(result);
        }
    }
}
