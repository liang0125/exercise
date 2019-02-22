package ThreadLocal;

/**
 * Author:lorrie
 * Create:2019/2/22
 */
public class TestThreadLocal {
    private static String string;
    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();

    public static void main(String[] args) {
        string="main";
        threadLocal.set("main");
        Thread thread =new Thread(new Runnable() {
            public void run() {
                string="thread";
                threadLocal.set("thread");
                System.out.println("子线程的string变量值为:"+string);
                System.out.println("子线程的threadLocal变量值为:"+threadLocal.get());
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程的string变量值为:"+string);
        System.out.println("主线程的threadLocal变量值为:"+threadLocal.get());
    }
}
