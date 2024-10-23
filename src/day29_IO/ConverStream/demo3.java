package day29_IO.ConverStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class demo3 {
    public static void main(String[] args) throws IOException {
        /*
            将本地文件中的GBK文件，转成UTF-8
        */


        //1.JDK11以前的方案
       /* InputStreamReader isr = new InputStreamReader(new FileInputStream("myfile/tc.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile/e.txt"),"UTF-8");

        int b;
        while((b = isr.read()) != -1){
            osw.write(b);
        }

        osw.close();
        isr.close();*/

        //2.替代方案
        FileReader fr = new FileReader("myfile/tc.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("myfile/e.txt",Charset.forName("UTF-8"));
        int b;
        while ((b = fr.read()) != -1){
            fw.write(b);
        }
        fw.close();
        fr.close();

    }
}
