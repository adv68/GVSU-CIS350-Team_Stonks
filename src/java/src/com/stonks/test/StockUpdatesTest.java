package com.stonks.test;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;

public class StockUpdatesTest {
    public static void main(String[] args) {
        try {
            Stock stock = YahooFinance.get("GME");
            StockQuote quote = stock.getQuote();
            System.out.println(quote.getPrice());

            Thread.sleep(10000);

            quote = stock.getQuote();
            System.out.println(quote.getPrice());

            Thread.sleep(10000);

            quote = stock.getQuote(true);
            System.out.println(quote.getPrice());
            Thread.sleep(10000);

            quote = stock.getQuote();
            System.out.println(quote.getPrice());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
