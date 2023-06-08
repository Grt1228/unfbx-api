package com.unfbx.jd.asynctool.my.test;

import com.unfbx.jd.asynctool.executor.timer.SystemClock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureTest main = new CompletableFutureTest();
        long start = SystemClock.now();
        CompletableFuture<String> eat = CompletableFuture.supplyAsync(() -> main.eat());
        CompletableFuture<String> watch = CompletableFuture.supplyAsync(() -> main.watch());
        CompletableFuture<Void> say = CompletableFuture.runAsync(() -> main.say());
        System.out.println(eat.get());
        System.out.println(watch.get());
        System.out.println(say.get());
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

    private void say() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
