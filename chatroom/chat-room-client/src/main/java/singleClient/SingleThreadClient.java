package singleClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/2/23
 */

public class SingleThreadClient {
    public static void main(String[] args) {
        int port=6666;
        String host="127.0.0.1";
        try {
            if(args.length>1){
                port= Integer.parseInt(args[0]);
                host=args[1];
            }
            Socket socket=new Socket(host,port);
            System.out.println("服务端连接成功！！！");
            System.out.println(socket.getInetAddress()+" "+socket.getPort());

                Scanner inputClient = new Scanner(socket.getInputStream());
                String in = inputClient.next();
                System.out.println(in);
                OutputStreamWriter outputClient = new OutputStreamWriter(socket.getOutputStream());

                outputClient.write("你好服务器\n");
                outputClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
