package com.itheima.BIO.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {

    //创建一个线程池的成员变量用于存储一个线程池对象
    private ExecutorService executorService;

    //创建这类对象的时候就需要初始化线程池对象
    public HandlerSocketServerPool(int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(3, maxThreadNum, 120,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    //提供一个方法来提交任务给线程池的任务队列来暂存，等待线程池处理
    public void execute(Runnable target) {
        executorService.execute(target);
    }


}
