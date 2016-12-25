package com.geekhub.lesson10;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        run(new Helper(Config.getInstance()), new Crawler(), Executors.newFixedThreadPool(20));
    }

    public static void run(Helper helper, Crawler crawler, ExecutorService executor) throws IOException {
        helper.cleanResources();

        helper.getLinks().forEach((link) -> {
            executor.execute(() -> {
                try {
                    System.out.println("==> Process link " + link);
                    String content = crawler.getContentByLink(link);
                    String hash = helper.md5(content);
                    helper.writeHash(hash);
                    System.out.println("<== Write hash " + hash);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        executor.shutdown();
    }
}
