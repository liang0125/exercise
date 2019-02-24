package multiClient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/2/24
 */
public class WriterToServer implements Runnable{

    private Socket client;
    public WriterToServer(Socket client) {
        this.client=client;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream=client.getOutputStream();
            OutputStreamWriter outputClient=new OutputStreamWriter(outputStream);
            Scanner in=new Scanner(System.in);
            while (true){
                System.out.println("请输入：");
                String message=in.next();
                outputClient.write(message+"\n");
                outputClient.flush();
                if("bye".equals(message)){
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
