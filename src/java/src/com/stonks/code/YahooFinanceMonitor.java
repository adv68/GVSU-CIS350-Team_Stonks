package com.stonks.code;

public class YahooFinanceMonitor implements Runnable {
    private StockTickerManager stockTickerManager;

    public YahooFinanceMonitor(StockTickerManager stockTickerManager) {
        this.stockTickerManager = stockTickerManager;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (;;) {
            stockTickerManager.refreshQuotes();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}