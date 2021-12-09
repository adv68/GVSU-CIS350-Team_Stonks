package com.stonks.code;

public class Main {
    public static void main(String[] args) {
        StockTickerManager stockTickerManager = new StockTickerManager();
        LEDMatrix ledMatrix = new VirtualLEDMatrix();

        DatabaseMonitor databaseMonitor = new DatabaseMonitor(stockTickerManager);
        databaseMonitor.start();

        // wait for databaseMonitor to initialize
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        YahooFinanceMonitor yahooFinanceMonitor = new YahooFinanceMonitor(stockTickerManager);
        yahooFinanceMonitor.start();

        LEDPanelUpdater ledPanelUpdater = new LEDPanelUpdater(stockTickerManager, ledMatrix);
        ledPanelUpdater.start();
    }
}
