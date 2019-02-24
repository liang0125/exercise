package multiThreadServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:lorrie
 * Create:2019/2/24
 */
public class ExecutorClient implements Runnable {
    //当前客户端
    private Socket currentClient;

    //所有注册用户的集合
    private final static ConcurrentHashMap<String, Socket> ONLINE_USER = new ConcurrentHashMap<>();

    public ExecutorClient(Socket currentClient) {
        this.currentClient = currentClient;
    }

    @Override
    public void run() {
        try {
            //接收数据
            Scanner input = new Scanner(currentClient.getInputStream());

            while (true) {
                String message = input.next();

                //注册用户
                if (message.startsWith("userName")) {
                    String userName = message.split("\\:")[1];
                    this.register(userName);
                    continue;
                }

                //私聊功能
                if (message.startsWith("private")) {
                    String targetUser = message.split("\\:")[1];
                    String targetMessage = message.split("\\:")[2];
                    this.privateChat(targetUser, targetMessage);
                    continue;
                }

                //群聊功能
                if (message.startsWith("group")){
                    String groupMessage=message.split("\\:")[1];
                    this.groupChat(groupMessage);
                    continue;
                }

                //退出功能
                if("bye".equals(message)){
                    this.quit();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出功能具体实现
    private void quit() {
        String userName=this.getCurrentClientName();
        sendMessage(this.getCurrentClientName(),"bye!!!");
        try {
            this.currentClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ONLINE_USER.remove(userName);
        this.printCurrentClient();
    }

    //打印当前在线人数
    private void printCurrentClient() {
        System.out.println("当前在线用户数："+ONLINE_USER.size()+" 列表如下：");
        for (String userName:ONLINE_USER.keySet()){
            System.out.println(userName);
        }
    }

    //群聊功能具体实现
    private void groupChat(String groupMessage) {
        String currentUserName=this.getCurrentClientName();
        for(Map.Entry<String,Socket> entry:ONLINE_USER.entrySet()){
            if(!entry.getKey().equals(currentUserName)) {
                sendMessage(entry.getKey(), "来自" + currentUserName + "的消息:" + groupMessage);
            }
        }
    }

    //私聊功能具体实现
    private void privateChat(String targetUserName, String targetMessage) {
        String currentUserName=this.getCurrentClientName();
        if(targetUserName!=null){
        sendMessage(targetUserName,"来自"+currentUserName+"的消息："+targetMessage);
        }
    }

    //注册功能具体实现
    private void register(String userName) {
        ONLINE_USER.put(userName,this.currentClient);
        sendMessage(userName,"注册成功!!!");
        System.out.println("用户"+userName+"加入聊天"+this.currentClient.getRemoteSocketAddress());
        this.printCurrentClient();
    }

    //向目标客户发送消息
    private void sendMessage(String targetUser,String message){
        try {
            Socket target=currentClient;
                for (Map.Entry<String,Socket> entry:ONLINE_USER.entrySet()){
                    if(targetUser.equals(entry.getKey())){
                         target=entry.getValue();
                    }
                }
            OutputStream outputStream=target.getOutputStream();
            OutputStreamWriter writer=new OutputStreamWriter(outputStream);
            writer.write(message+"\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取当前客户的用户名
    private String getCurrentClientName(){
        String currentUserName=" ";
        for(Map.Entry<String,Socket> entry:ONLINE_USER.entrySet()) {
            if(this.currentClient.equals(entry.getValue())){
                currentUserName=entry.getKey();
                break;
            }
        }
            return currentUserName;
    }
}
