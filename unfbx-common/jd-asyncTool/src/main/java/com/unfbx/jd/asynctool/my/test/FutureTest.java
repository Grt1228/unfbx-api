package com.unfbx.jd.asynctool.my.test;

import com.unfbx.jd.asynctool.executor.timer.SystemClock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTest main = new FutureTest();
//        long start = SystemClock.now();
//        main.eat();
//        main.watch();
//        long end = SystemClock.now();
//        System.out.println(end - start);

        FutureTest main = new FutureTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = SystemClock.now();
        FutureTask<String> eat = new FutureTask<>(() -> main.eat());
        FutureTask<String> watch = new FutureTask<>(() -> main.watch());
        executorService.submit(eat);
        executorService.submit(watch);
        System.out.println(eat.get());
        System.out.println(watch.get());
        long end = SystemClock.now();
        System.out.println(end - start);

    }


    private String eat() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }

    private String watch() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }
}
