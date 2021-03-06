package com.test.demo.tcp.socket1;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/6/28 14:20
 */
public class ServerSSLTcp {
    public static void test() {
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            SSLServerSocket serverSocket;

            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
                    .getDefault();
            serverSocket = (SSLServerSocket) factory
                    .createServerSocket(8888);
            Socket socket=null;
            //记录客户端的数量
            int count=0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的连接
            while(true){
                //调用accept()方法开始监听，等待客户端的连接
                socket=serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread=new ServerThread(socket);
                //启动线程
                serverThread.start();

                count++;//统计客户端的数量
                System.out.println("客户端的数量："+count);
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
