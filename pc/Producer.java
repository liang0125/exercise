package com.bittech.thread.pc;

import com.bittech.thread.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static com.bittech.thread.pc.TestPC.MAX_POOL;

/**
 * Author:lorrie
 * Create:2019/2/21
 */
public class Producer implements Runnable {
    private Goods goods;

    @Override
    public void run() {
            while (true) {
                try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        synchronized (TestPC.queue) {

                goods=new Goods(1,"商品");
                if (TestPC.queue.size()<MAX_POOL) {
                    TestPC.queue.add(goods);
                    System.out.println(Thread.currentThread().getName()+"生产商品");

                } else {
                    try {
                        TestPC.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
