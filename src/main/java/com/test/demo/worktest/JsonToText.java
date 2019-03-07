package com.test.demo.worktest;




import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @Author:cai.chaoxiong
 * @Date: 2018/11/17 12:28
 */
public class JsonToText {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = null;
        BufferedReader reader = null;

        try {
            String fileName = "C:\\Users\\13450\\Desktop\\logs\\2b65bbda3db11114dfab66fbd536556e0ba71f3449aa5f1f7c348379744fc042-json.log";
            File file = new File(fileName);

            out = new FileOutputStream(new File("C:\\Users\\13450\\Desktop\\logs\\1.log"));


            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                out.write(JSON.parseObject(tempString,ZCMLog.class).getLog().getBytes());
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    out.close();
                } catch (IOException e1) {
                }
            }
        }
    }


}
