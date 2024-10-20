package day28_IO.CharSet;

import java.io.FileInputStream;
import java.io.IOException;

public class demo1 {
    public static void main(String[] args) throws IOException {
        /*
           字节流读取中文会出现乱码
        */
        FileInputStream fis = new FileInputStream("myfile/a.txt");
        int b;

        while ( (b = fis.read()) != -1) {
            System.out.println((char)b);
        }

        fis.close();
    }
}
