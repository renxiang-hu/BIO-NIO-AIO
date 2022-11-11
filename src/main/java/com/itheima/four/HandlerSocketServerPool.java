package com.itheima.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {

    //1.创建一个线程池的成员变量用于存储线程池对象
    private ExecutorService executorService;

    /**
     * 创建这个类对象的时候需要初始化线程池对象
     *            ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue)
     */
    public HandlerSocketServerPool(int maxThreadNum , int queueSize){
       executorService = new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS,
               new ArrayBlockingQueue<Runnable>(queueSize));
    }

    /**
     * 提供一个方法来提交任务给线程池的任务队列来暂存，等线程池来处理
     */
    public void execute11(Runnable target){
        executorService.execute(target);
    }
}
