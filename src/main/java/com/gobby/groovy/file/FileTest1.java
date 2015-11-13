package com.gobby.groovy.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john on 2015/11/13.
 */
public class FileTest1 {

    /**
     * 打开一个文本文件，每次读取一行内容。将每行作为一个String读入，并将那个String对象植入一个LinkedList中。
     * 按相反的顺序打印出LinkedList中的所有行
     */
    public static void file1Test(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));  // 缓冲输入

        String s;
        List list = new LinkedList();
        while((s = br.readLine()) != null) {
            list.add(s);
        }
        br.close();

        for(int i = list.size(); i > 0; i--) {
            System.out.println(list.get(i-1).toString().toUpperCase());
        }
    }

    public static void main(String [] args) {
        try {
            file1Test("E:/aa.txt");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // 读入一个文件的内容
    public static String read(String fileName) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bf.readLine()) != null) {
            sb.append(s + "/n");
        }
        bf.close();
        return sb.toString();
    }
}
