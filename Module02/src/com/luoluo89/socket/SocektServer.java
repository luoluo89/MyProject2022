package com.luoluo89.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程的socket服务端
 */
public class SocektServer {
    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(8888);

            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while (true) {
                String msg = dis.readUTF();
                System.out.println("收到客户端信息"+msg);
                dos.writeUTF("我听不懂");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
