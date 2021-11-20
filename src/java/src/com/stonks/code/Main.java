package com.stonks.code;

public class Main {
    public static void main(String[] args) {
        StockTickerManager stockTickerManager = new StockTickerManager();
        DatabaseMonitor databaseMonitor = new DatabaseMonitor(stockTickerManager);
        databaseMonitor.start();

        YahooFinanceMonitor yahooFinanceMonitor = new YahooFinanceMonitor(stockTickerManager);
        yahooFinanceMonitor.start();


    }
}
