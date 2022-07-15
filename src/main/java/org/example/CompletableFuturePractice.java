package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuturePractice {

    public void go() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            return "world";
        });

        /*CompletableFuture<String> future = hello.thenCompose(CompletableFuturePractice::getCompletable);

        System.out.println(future.get());*/

        /*CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + "///" + w);
        System.out.println(future.get());*/

        /*List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v ->
                    futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList()));

        results.get().forEach(System.out::println);*/

        /*CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future.get();*/

        /*CompletableFuture<String> error = CompletableFuture.supplyAsync(() -> {
            if(true) {
                throw new IllegalArgumentException();
            }

            return "abc";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "error";
        });
*/

        CompletableFuture<String> error = CompletableFuture.supplyAsync(() -> {
            if(true) {
                throw new IllegalArgumentException();
            }

            return "abc";
        }).handle((result,ex) -> {
            if(ex != null){
                System.out.println(ex);
            }

            return result;
        });
        System.out.println(error.get());
    }

    static CompletableFuture<String> getCompletable(String message){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message + Thread.currentThread().getName());
            return message;
        });
    }
}
