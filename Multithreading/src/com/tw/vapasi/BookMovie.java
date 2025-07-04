package com.tw.vapasi;

public class BookMovie implements Runnable {
    String name;

    public BookMovie(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Booking received from " + Thread.currentThread().getName());
        System.out.println("Payment processed for " + Thread.currentThread().getName());
        System.out.println("Ticket confirmed " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
