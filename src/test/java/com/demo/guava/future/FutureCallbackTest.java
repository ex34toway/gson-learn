package com.demo.guava.future;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * Created by liliang on 2016/12/20.
 */
public class FutureCallbackTest {

    @Test
    public void testBase()
    {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture<String> futureTask = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task completed";
            }
        });

        FutureCallbackImpl callback = new FutureCallbackImpl();
        Futures.addCallback(futureTask, callback);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(callback.getCallbackResult());
    }
}
