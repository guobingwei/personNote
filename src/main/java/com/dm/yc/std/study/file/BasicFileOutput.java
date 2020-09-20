package com.dm.yc.std.study.file;

import java.io.*;

/**
 * Created by john on 2015/11/14.
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void test() throws IOException{

        // 输入流
        BufferedReader bf = new BufferedReader(
                new StringReader(FileTest1.read("E:/aa.txt")));

        // 输出流
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = bf.readLine()) != null) {
            out.println(lineCount++ + ":" + s + "/n");
        }
        out.close();
        System.out.print(FileTest1.read(file));
    }

    public static void main(String [] args) throws IOException{
        test();
    }
}
