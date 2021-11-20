package com.stonks.code;

public class LEDPanelUpdater implements Runnable {
    private StockTickerManager stockTickerManager;

    public LEDPanelUpdater(StockTickerManager stockTickerManager) {
        this.stockTickerManager = stockTickerManager;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        // print stock prices here
    }
}
