package com.stonks.code;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.TimeZone;

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
    private void writeToPanel (int line, String text, int r, int g, int b) {
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
                    ledMatrix.setPixel(j + 2, i + 1 + (line * 8), r, g, b);
                } else {
                    ledMatrix.setPixel(j + 2, i + 1 + (line * 8), 0, 0, 0);
                }
            }
        }
    }

    // line is 0 - 3
    private void writeToPanel (int line, int offset, String text, int r, int g, int b) {
        ArrayList<String[]> chars;
        if (text.length() > (10 - offset)) {
            chars = Text5x7.getLetters(text.substring(0, (10 - offset)));
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
                    ledMatrix.setPixel(j + 2 + (offset * 6), i + 1 + (line * 8), r, g, b);
                } else {
                    ledMatrix.setPixel(j + 2 + (offset * 6), i + 1 + (line * 8), 0, 0, 0);
                }
            }
        }
    }

    public void writeToPanel(int line, String text) {
        writeToPanel(line, text, 255, 255, 255);
    }

    public void writeToPanel(int line, int offset, String text) {
        writeToPanel(line, offset, text, 255, 255, 255);
    }

    public void writeMarketStatus() {
        ZonedDateTime dateTime = ZonedDateTime.now(TimeZone.getTimeZone("EST").toZoneId());
        if (dateTime.getHour() < 16 && dateTime.getHour() > 9 || (dateTime.getHour() == 9 && dateTime.getMinute() >= 30)) {
            for (int i = 2; i < 62; i++) {
                ledMatrix.setPixel(i, 0, 0, 255, 0);
            }
        } else {
            for (int i = 2; i < 62; i++) {
                ledMatrix.setPixel(i, 0, 150, 150, 150);
            }
        }
    }

    @Override
    public void run() {
        for (;;) {
            StockTickers stockTickers = DatabaseQuery.getStockTickers(connectionUrl, username, password);
            writeMarketStatus();


            if (stockTickers.getLayoutStyle().equals("single")) {
                Stock stock = stockTickerManager.getStock(stockTickers.getSingleTicker());

                if (stock.getName().length() <= 10) {
                    writeToPanel(0, stock.getName());
                } else {
                    writeToPanel(0, stock.getSymbol());
                }

                writeToPanel(1, stock.getQuote().getPrice().toString());

                BigDecimal change = stock.getQuote().getChange();
                if (change.compareTo(new BigDecimal(0)) < 0) {
                    writeToPanel(2, change.toString(), 255, 0, 0);
                } else if (change.compareTo(new BigDecimal(0)) > 0) {
                    writeToPanel(2, change.toString(), 0, 255, 0);
                } else {
                    writeToPanel(2, change.toString(), 200, 200, 200);
                }

                long volume = stock.getQuote().getVolume();
                if (volume < 1000) {
                    writeToPanel(3, "Vol " + volume);
                } else if (volume < 1000000) {
                    writeToPanel(3, "Vol " + volume / 1000 + "K");
                } else if (volume < 1000000000) {
                    writeToPanel(3, "Vol " + volume / 1000000 + "M");
                } else if (volume < 1000000000000L){
                    writeToPanel(3, "Vol " + volume / 1000000000 + "B");
                }

            } else if (stockTickers.getLayoutStyle().equals("double")) {

            } else {

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            /*
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

             */
        }
    }
}
