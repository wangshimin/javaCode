package day29_IO.ConverStream;

import java.io.*;

public class demo4 {
    public static void main(String[] args) throws IOException {
        /*
            利用字节流读取文件中的数据，每次读一整行，而且不能出现乱码

            1.字节流在读取中文的时候，是会出现乱码的
            解决方法：利用转换流，将字节流转换为字符流

            2.字节流里面没有读一整行的方法，只有字符缓冲流才有
         */
/*
        FileInputStream fis = new FileInputStream("myfile/a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        System.out.println(str);
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("myfile/a.txt")));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
