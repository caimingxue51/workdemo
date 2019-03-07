package com.test.demo.imsi;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/1/30 15:03
 */
public class CutImsi {
    public static void main(String[] args) throws Exception {
        String inputName = "/oss/cmdlist.log";
        String ouputName = "/oss/imislist.txt";
        if(args != null && args.length == 2){
            inputName = args[0];
            ouputName = args[1];
        }
        FileReader fr = new FileReader(inputName);
        BufferedReader bf = new BufferedReader(fr);
        String str;
        String reg = "^([0-9]){12}\\s+([0-9]){15}\\s+CONNECTED\\s+AVAILABLE$";

        FileWriter fileWriter = new FileWriter( ouputName);
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            Matcher m = Pattern.compile( reg ).matcher( str );
            if(m.find()){
                String number = m.group();
                //System.out.println(number);
                fileWriter.append( number + "\r\n" );
            }
        }
        bf.close();
        fr.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
