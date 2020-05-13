package com.test.demo.tcp.socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端
 */
public class Client {
    Socket socket;
    OutputStream os;
    PrintWriter pw;
    InputStream is;
    BufferedReader br;

    public void init() throws IOException {
        //1.创建客户端Socket，指定服务器地址和端口
        socket = new Socket( "localhost", 8888 );
        //2.获取输出流，向服务器端发送信息
        os = socket.getOutputStream();//字节输出流
        pw = new PrintWriter( os );//将输出流包装为打印流

        is = socket.getInputStream();//3.获取输入流，并读取服务器端的响应信息
        br = new BufferedReader( new InputStreamReader( is ) );
    }

    public void sendCommand(String command) {
        try {


            pw.write( command );
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println( "我是客户端，服务器说：" + info );
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
        //4.关闭资源
        try {
            if (br != null) {
                br.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pw != null) {
            pw.close();
        }
        try {
            if (os != null) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        /*try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket( "localhost", 8888 );
            //2.获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter( os );//将输出流包装为打印流

            pw.write( "用户名：whf;密码：789" );
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader( new InputStreamReader( is ) );
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println( "我是客户端，服务器说：" + info );
            }
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Client client = null;
        try {
            client = new Client();
            client.init();
            Scanner scan = new Scanner( System.in ); //创建Scanner扫描器来封装System类的in输入流
            System.out.println( "欢迎！请输入：" );
            System.out.print( ">" );
            while (true) {
                String command = scan.nextLine();//获取一行文本
                client.sendCommand( command );
                System.out.print( ">" );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          if(client != null){
              client.destroy();
          }
        }

    }
}