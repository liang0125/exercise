package multiClient;

import java.io.IOException;
import java.net.Socket;

/**
 * Author:lorrie
 * Create:2019/2/24
 */
public class MultiThreadClient {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 6666);
            System.out.println("连接服务器成功");
            new Thread(new ReadFromServer(client)).start();
            new Thread(new WriterToServer(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
