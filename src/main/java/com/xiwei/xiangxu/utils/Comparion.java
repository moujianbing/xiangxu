package com.xiwei.xiangxu.utils;

import java.io.*;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/2/4 18:55
 */
public class Comparion {
    public static void main(String[] args)throws  Exception {
        File file=new File("C:\\Users\\86188\\Desktop\\aaa.txt");
        if(file.exists()){
            FileReader reader=new FileReader("C:\\Users\\86188\\Desktop\\aaa.txt");
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line=bufferedReader.readLine();
            if(line!=null){
                System.out.println(line);
                line=bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();
            reader.close();
        }
    }
}
