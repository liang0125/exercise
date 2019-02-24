package multiThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:lorrie
 * Create:2019/2/24
 */
public class MultiThreadServer {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(5);
        try {
            ServerSocket serverSocket=new ServerSocket(6666);
            System.out.println("等待客户端的连接...");
            while (true){
                Socket client=serverSocket.accept();
                executor.submit(new ExecutorClient(client));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
