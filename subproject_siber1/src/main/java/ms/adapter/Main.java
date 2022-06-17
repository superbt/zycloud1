package ms.adapter;

import org.apache.commons.exec.InputStreamPumper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\86182\\Desktop\\组合.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfreader = new BufferedReader(isr);
        String line = bfreader.readLine() ;
        while ((line = bfreader.readLine())!=null&&!line.equals("")){
            System.out.println(line);
        }
        bfreader.close();
    }
}
