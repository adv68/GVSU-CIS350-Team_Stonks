package com.stonks.code;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class StockTickerMngr {
    private StockTickers tickers;
    private ConcurrentHashMap<String, Stock> stockData;

    public StockTickerMngr() {
        tickers = new StockTickers(
                "single",
                "GME",
                "GME",
                "AMC",
                "GME",
                "AMC",
                "F",
                "TSLA",
                "MSFT"
        );

        try {
            stockData = new ConcurrentHashMap<>(YahooFinance.get(tickers.getList().toArray(new String[0])));
        } catch (IOException e) {
            System.out.println("ERROR: Cannot connect to yahoo finance");
            stockData = new ConcurrentHashMap<>();
            for (String tick : tickers.getList()) {
                stockData.put(tick,  new Stock(tick));
            }
        }
    }

    public void updateTickers(StockTickers newTickers) {
        this.tickers = newTickers;
        for (String tick : newTickers.getList()) {
            if (!stockData.containsKey(tick)) {
                try {
                    stockData.put(tick, YahooFinance.get(tick));
                } catch (IOException e) {
                    stockData.put(tick, new Stock("GME"));
                    System.out.println("ERROR: Cannot connect to yahoo finance");
                }
            }
        }
    }

    public void updateQuotes() {
        for (String key : stockData.keySet()) {
            try {
                stockData.get(key).getQuote(true);
            } catch (IOException e) {
                System.out.println("ERROR: Cannot connect to yahoo finance to update quote");
                stockData.get(key).setQuote(new StockQuote(key));
            }
        }
    }

    public StockQuote getStockQuote(String ticker) {
        return stockData.get(ticker).getQuote();
    }

    public Stock getStock(String ticker) {
        return stockData.get(ticker);
    }

    public StockTickers getStockTickersSelected() {
        return tickers;
    }
}
