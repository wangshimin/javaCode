package day27_Exception.File;

import java.io.File;
import java.io.IOException;

public class demo6 {
    public static void main(String[] args) {
        //public File[] listFiles()       获取当前该路径下所有内容

        // 1.创建File对象
        File f = new File("/Users/test/AA");
        // 2.调用listFiles方法
        //  作用：获取AA文件夹里面的所有内容，把所有的内容放到数组中返回
        File[] files = f.listFiles();
        for (File file : files) {
            //  file依次表示aaa文件夹里面的每一个文件或者文件夹
            System.out.println(file);
        }
        System.out.println();
        System.out.println(" ============== 案例2 ================");
        System.out.println();
        /**
         * 细节：
         * 1. 当调用者File的路径不存在时，返回null
         * 2. 当调用者File的路径是文件时，返回null
         * 3. 当调用者File表示的路径是一个空文件夹时，返回一个长度为0的数组
         * 4. 当调用者File表示的路径是一个有内容的文件夹时，将里面所有文件和文件夹的路径放在File数组中返回
         * 5. 当调用者File表示的路径是一个有隐藏文件的的文件夹时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
         * 6. 当调用者File表示的路径是需要权限才能访问的文件夹时，返回null
         */

        String[] directoryPaths = {
            "/Users/test/AA",
            "/Users/test/BB/.dirhidden",
            "/Users/test/AA/bb2",
            "/Users/test/AA/a1/f1.txt",
            "/Users/test/BB/b-01/b-01-011",
            "/Users/test/BB/b-01/b-01-012"
        };
        for (String directoryPath : directoryPaths) {
            File dir = new File(directoryPath);
            try {
                File[] fs = dir.listFiles();

                if ( fs == null ){

                    if ( !dir.exists() ){
                        // 1.当调用者File的路径不存在时，返回null
                        throw new IOException("路径不存在：" + directoryPath);
                    } else if ( !dir.isDirectory()) {
                        // 2. 当调用者File的路径是文件时，返回null
                        throw new IOException("路径是文件: " + directoryPath);
                    } else if ( !dir.canRead() ) {
                        // 6. 当调用者File表示的路径是需要权限才能访问的文件夹时，返回null
                        throw new IOException("需要权限才能访问的文件夹: " + directoryPath);
                    }
                    System.out.println(fs);
                    System.out.println("========");
                } else if ( fs.length == 0){
                    // 3. 当调用者File表示的路径是一个空文件夹时，返回一个长度为0的数组
                    System.out.println("目录 " + directoryPath + " 是空文件夹");
                } else {
                    System.out.println("目录 " + directoryPath + " 的内容:");
                    for (File file : fs) {
                        System.out.println(" " + file.getAbsolutePath());
                    }
                    System.out.println();
                }
            } catch (IOException e){
                // 获取原始异常信息
                String originalMessage = e.getMessage();
                // 获取堆栈跟踪信息
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                // 获取第一个堆栈元素（通常是抛出异常的地方）
                StackTraceElement stackTraceElement = stackTraceElements[0];
                // 获取行号
                int lineNumber = stackTraceElement.getLineNumber();
                // 自定义报错信息
                String customErrorMessage = "目录操作失败：" + originalMessage + "，在行号：" + lineNumber + "，目录名：" + directoryPath;
                // 输出自定义报错信息
                System.out.println( customErrorMessage);
            }
        }
    }
}
