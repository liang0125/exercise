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
    public void menu(){
        System.out.println("*************欢迎进入聊天室*****************");
        System.out.println("*************1.注册    2.登录**************");
        System.out.println("*************3.私聊    4.群聊**************");
        System.out.println("*******************************************");
        System.out.println("格式如下：(1和2：userName：liang    3. private:targetUserName:message   4.group:message)");
        System.out.println("请输入：");


    }
}
