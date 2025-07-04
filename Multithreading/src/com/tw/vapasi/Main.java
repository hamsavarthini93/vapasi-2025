package com.tw.vapasi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        try (ExecutorService booktickets = Executors.newFixedThreadPool(5)) {
            for (int i = 1; i <= 5; i++) {
                booktickets.execute(new BookMovie("task " + i));
            }
            booktickets.shutdown();
        }
    }
}