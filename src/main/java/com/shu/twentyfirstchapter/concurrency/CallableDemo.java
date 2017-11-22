package com.shu.twentyfirstchapter.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-09-16 16:22
 * @Version: 1.0.0
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService cached = Executors.newCachedThreadPool();
        List<Future<String>> lists = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++)
            lists.add(cached.submit(new TaskWithResult(i)));
        System.out.println(lists.size());

        do {
            for (Iterator<Future<String>> it = lists.listIterator();it.hasNext();)
                try {
                    Future<String> future = it.next();
                    if (future.isDone()){
                        it.remove();
//                            System.out.println(future.get());//Blocks until complete....
                        //set the maximum time to wait when Blocks until complete....
                        System.out.println(future.get(10, TimeUnit.SECONDS));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
        } while (lists.size() > 0);

    }
}


class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);//模拟阻塞时间
        return "Result of TaskWithResult " + id;
    }
}