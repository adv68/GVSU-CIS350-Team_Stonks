package com.stonks.code;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

import java.util.ArrayList;

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

    // line is 0 - 3
    private void writeToPanel (int line, String text) {
        ArrayList<String[]> chars;
        if (text.length() > 10) {
            chars = Text5x7.getLetters(text.substring(0, 10));
        } else {
            chars = Text5x7.getLetters(text);
        }
        for (int i = 0; i < 7; i++) {
            String row = "";
            for (String[] s : chars) {
                row += s[i];
                row += " ";
            }

            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '0') {
                    ledMatrix.setPixel(j + 1, i + (line * 8), 255, 255, 255);
                } else {
                    ledMatrix.setPixel(j + 1, i + (line * 8), 0, 0, 0);
                }
            }
        }
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
            writeToPanel(0, stockTickers.getDoubleTicker1());
            writeToPanel(1, stockTickerManager.getStockQuote(stockTickers.getDoubleTicker1()).getPrice().toString());
            writeToPanel(2, stockTickers.getDoubleTicker2());
            writeToPanel(3, stockTickerManager.getStockQuote(stockTickers.getDoubleTicker2()).getPrice().toString());

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
