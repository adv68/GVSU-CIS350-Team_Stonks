package com.stonks.code;

public class LEDPanelUpdater implements Runnable {
    private StockTickerManager stockTickerManager;
    private LEDMatrix ledMatrix;

    public LEDPanelUpdater(StockTickerManager stockTickerManager, LEDMatrix ledMatrix) {
        this.stockTickerManager = stockTickerManager;
        this.ledMatrix = ledMatrix;
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
