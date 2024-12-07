package xjz.thread.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletureFutureDemo {
    public static void main(String[] args) throws Exception {
//        testCreate();
testThen();

    }

    public static void testThen(){
        CompletableFuture.supplyAsync(() -> "做第一件事情")
                .thenAccept(result -> {
                    System.out.println(result);
                    System.out.println("做第二件事情");
                });

        CompletableFuture.supplyAsync(() -> "aa")
                .thenAccept(result -> {
                    String s = result + "aa";
                    System.out.println(s);
                });

        CompletableFuture.runAsync(() -> System.out.println("bb"))
                .thenRun(() -> {
                    System.out.println("cc");
                });

        CompletableFuture.completedFuture("hello")
                .thenAccept(result -> System.out.println(result));

        CompletableFuture<String> world = CompletableFuture.completedFuture("world");
    }

    /**
     * 创建线程方式
     */
    @lombok.SneakyThrows
    public static void testCreate(){
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("无参数创建");
        });

        CompletableFuture<Void> runAsync1 = CompletableFuture.runAsync(() -> {
            System.out.println("使用自定义线程池");
        }, Executors.newFixedThreadPool(1));

        CompletableFuture<List<String>> supplyAsync = CompletableFuture.supplyAsync(() -> {
            return Arrays.asList("qq", "aa", "zz");
        });
        //阻塞获取结果
        System.out.println(supplyAsync.get());
        CompletableFuture<String[]> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            return new String[]{"ww", "ss", "cc"};
        }, Executors.newFixedThreadPool(2));
        //实时获取，如果没有使用自己创建的
        System.out.println(Arrays.toString(supplyAsync2.getNow(new String[]{"default","hello"})));
        CompletableFuture<String[]> supplyAsync3 = CompletableFuture.supplyAsync(() -> {
            return new String[]{"ww2", "ss3", "cc3"};
        }, Executors.newFixedThreadPool(2));
        System.out.println(Arrays.toString(supplyAsync3.join()));
    }
}
