package day28_IO.Test;

import java.io.*;

public class test1 {
    //拷贝一个文件夹，考虑子文件夹
    public static void main(String[] args) throws IOException {

        // 1.创建对象表示数据源
        File src = new File("/Users/test/AA");
        // 2.创建对象表示目的地
        File dest = new File("myfile/copyDest");

        // 3.调用方法开始拷贝
        copyDir(src, dest);

    }

    /**
     * 拷贝文件夹
     * @param src 数据源
     * @param dest 目的地
     */
    private static void copyDir(File src, File dest) throws IOException {
        if (!dest.exists() && !dest.mkdir()){
            throw new RuntimeException("创建目录失败");
        }
        // 递归
        // 1.进入数据源
        File[] files = src.listFiles();
        // 2.遍历数据源，得到数据源里面的每一个文件或者文件夹
        for (File file : files) {
            // 3.判断如果数据源是文件，就拷贝
            if (file.isFile()) {
                // 要拷贝的文件
                FileInputStream fis = new FileInputStream(file);
                // 文件目的地
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }
                fis.close();
                fos.close();
            } else {
                // 4.判断如果数据源是文件夹，就创建文件夹，然后递归调用自己，继续拷贝
                copyDir(file, new File(dest, file.getName()));
            }
        }
    }
}
