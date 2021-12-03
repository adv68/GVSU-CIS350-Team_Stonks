package com.stonks.code;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

public class LEDPanelUpdater implements Runnable {
    private StockTickerManager stockTickerManager;
    private LEDMatrix ledMatrix;
    private final String connectionUrl = "jdbc:mysql://localhost:3306/stonks";
    private final String username = "root";
    private final String password = "";

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


        for (;;) {

            StockTickers stockTickers = DatabaseQuery.getStockTickers(connectionUrl, username, password);
/*
            if (stockTickers.getLayoutStyle().equals("single")) {
                StockQuote stockQuote = stockTickerManager.getStockQuote(stockTickers.getSingleTicker());

            } else if (stockTickers.getLayoutStyle().equals("double")) {

            } else {

            }

             */
            System.out.println(stockTickers.getSingleTicker());
            System.out.println(stockTickerManager.getStockQuote(stockTickers.getSingleTicker()));
            System.out.println(stockTickers.getDoubleTicker2());
            System.out.println(stockTickerManager.getStockQuote(stockTickers.getDoubleTicker2()));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }
}
