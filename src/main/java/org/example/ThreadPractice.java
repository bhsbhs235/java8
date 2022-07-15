package org.example;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.function.Function;

public class ThreadPractice {

    public void go() throws InterruptedException, ExecutionException {
        /*Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    Thread.sleep(1000L); // 재우면 다른 쓰레드 작업을 먼저 진행함
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        });

        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread.interrupt();*/

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //executorService.execute(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        // executorService.shutdown();

        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("aaa"));
        executorService.submit(getRunnable("bbb"));
        executorService.submit(getRunnable("ccc"));
        executorService.submit(getRunnable("ddd"));

        executorService.shutdown();*/

        /*ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(getRunnable("aaa"), 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(getRunnable("bbb"), 1,2, TimeUnit.SECONDS);*/

       /* ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(5000L);
            return "hyoseong";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone());
        System.out.println("start");

        submit.get(); // blocking 됨

        System.out.println(submit.isDone());
        System.out.println("end");
        executorService.shutdown();*/

        /*ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> aaa = () -> {
            Thread.sleep(2000L);
            return "aaa";
        };

        Callable<String> bbb = () -> {
            Thread.sleep(3000L);
            return "bbb";
        };

        Callable<String> ccc = () -> {
            Thread.sleep(1000L);
            return "ccc";
        };*/

        /*List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(aaa,bbb,ccc)); // 여러 작업을 동시에 시키는데 가장 오래 걸리는 작업 까지 기다림
        futureList.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });*/

        /*String s = executorService.invokeAny(Arrays.asList(aaa,bbb,ccc));
        System.out.println(s);

        executorService.shutdown();*/

        /*CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("hyoseong");

        future.get();*/

        /*CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });

        future.get();*/

       /* CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }).thenApply((s) -> {
            return s.toUpperCase();
        });
        System.out.println(future.get());*/

        /*CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }).thenAccept((s) -> {
            System.out.println(s.toUpperCase());
        });*/

        /*CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });*/

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);

        future.get();

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message){
        return ()->{
            System.out.println(message+ Thread.currentThread().getName());
        };
    }
}
