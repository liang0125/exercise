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

//向服务器发送消息
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
                menu();
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

    //菜单提示信息
    public void menu(){
        System.out.println("********      Welcome to chatroom         *******");
        System.out.println("*********  1.register        2.login      *******");
        System.out.println("*********  3.private chat    4.group chat *******");
        System.out.println("*******************************************");
        System.out.println("The format is following：(1和2：userName：liang    3. private:targetUserName:message   4.group:message)");
        System.out.println("input：");


    }
}
