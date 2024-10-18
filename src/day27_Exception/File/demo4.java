package day27_Exception.File;

import java.io.File;
import java.io.IOException;

public class demo4 {
    public static void main(String[] args) {
/*
        public boolean createNewFile()      创建一个新的空的文件
        public boolean mkdir()              创建单级文件夹
        public boolean mkdirs()             创建多级文件夹
        public boolean delete()             删除文件、空文件夹
      */

        System.out.println("========== createNewFile 创建一个新的空的文件 =================");
        //  1.createNewFile 创建一个新的空的文件
        //  细节1：如果当前路径表示的文件是不存在的，则创建成功，方法返回true
        //      如果当前路径表示的文件是存在的，则创建失败，方法返回false
        //  细节2：如果父级路径是不存在的，那么方法会有异常IOException
        //  细节3：createNewFile方法创建的一定是文件，如果路径中不包含后缀名，则创建一个没有后缀的文件

        String[] fileNames = {"/Users/test/AA/test.txt", "/Users/test/fileTest/a.txt","/Users/test/AA/test2.txt"};
        for (String fileName : fileNames) {
            File f = new File(fileName);
            try{
                boolean created = f.createNewFile();
                if (created) {
                    System.out.println("文件创建成功:" + fileName);
                } else {
                    System.out.println("文件已存在：" + fileName );
                }
            } catch (IOException e) {
                customEception("文件创建失败",e);
            }

        }

        System.out.println("========== mkdir 创建单级文件夹 =================");
        //  2.mkdir   make Directory，文件夹（目录）
        //  细节1：windows当中路径是唯一的，如果当前路径已经存在，则创建失败，返回false
        //  细节2：mkdir方法只能创建单级文件夹，无法创建多级文件夹。
        String[] dirNames = {"/Users/test/AA/bb1", "/Users/test/fileTest/a1", "/Users/test/AA/a3/44"};
        for (String dirName : dirNames) {
            File directory = new File(dirName);
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("目录创建成功：" + dirName);
            } else if (!directory.exists()) {
                System.out.println("创建失败，父级目录不存在：" + dirName);
            } else {
                System.out.println("目录已存在：" + dirName);
            }
        }

        // 3.mkdirs   创建多级文件夹
        //  细节：既可以创建单级的，又可以创建多级的文件夹
        System.out.println("========== mkdirs 创建多级文件夹 =================");
        File f3 = new File("/Users/test/AA/bb2/cc/dd");
        boolean b = f3.mkdirs();
        System.out.println(b);
    }

    /**
     * 自定义异常信息
     * @param e
     */
    private static void customEception( String str,Exception e) {
        // 获取原始异常信息
        String originalMessage = e.getMessage();
        // 获取堆栈跟踪信息
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        // 获取第一个堆栈元素（通常是抛出异常的地方）
        StackTraceElement stackTraceElement = stackTraceElements[0];
        // 获取行号
        int lineNumber = stackTraceElement.getLineNumber();
        // 自定义报错信息
        String customErrorMessage = str + "！原因：" + originalMessage + "，行号：" + lineNumber;
        System.out.println( customErrorMessage);
    }
}
