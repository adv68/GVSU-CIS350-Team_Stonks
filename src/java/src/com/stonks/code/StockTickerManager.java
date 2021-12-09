package com.stonks.code;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StockTickerManager {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private ConcurrentMap<String, Stock> stocks;

    private boolean initialized = false;

    private StockTickers stockTickers;

    public StockTickerManager() {
        stockTickers = new StockTickers(
                "single",
                "GME",
                "GME",
                "TSLA",
                "GME",
                "TSLA",
                "F",
                "AMC",
                "MSFT"
        );
    }

    public void setStockTickers(StockTickers tickers) {
        this.stockTickers = tickers;
    }

    public StockTickers getStockTickers() {
        return this.stockTickers;
    }

    public void initializeTickerList(ArrayList<String> tickerList) {
        writeLock.lock();
        try {
            if (!initialized) {
                try {
                    String[] tickers = new String[tickerList.size()];
                    for (int i = 0; i < tickerList.size(); i++) {
                        tickers[i] = tickerList.get(i);
                    }
                    stocks = new ConcurrentHashMap(YahooFinance.get(tickers));
                    initialized = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void setTickerList(ArrayList<String> tickerList, boolean garbageCollect) {
        writeLock.lock();
        try {
            if (initialized) {
                for (String s : tickerList) {
                    if (!stocks.containsKey(s)) {
                        try {
                            Stock stock = YahooFinance.get(s);
                            stocks.put(s, stock);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (garbageCollect) {
                    for (String s : stocks.keySet()) {
                        if (!tickerList.contains(s)) {
                            stocks.remove(s);
                        }
                    }
                }
            } else {
                initializeTickerList(tickerList);
            }
        } finally {
            writeLock.unlock();
        }
    }

    public Stock getStock(String ticker) {
        readLock.lock();
        try {
            return stocks.get(ticker);
        } finally {
            readLock.unlock();
        }
    }

    public StockQuote getStockQuote(String ticker) {
        readLock.lock();
        try {
            return stocks.get(ticker).getQuote();
        } finally {
            readLock.unlock();
        }
    }

    public void refreshQuotes() {
        if (initialized) {
            writeLock.lock();
            try {
                try {
                    for (String s : stocks.keySet()) {
                        stocks.get(s).getQuote(true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                writeLock.unlock();
            }
        }
    }


    public static StockQuote getStockPrice(Stock ticker) throws IOException {
        return ticker.getQuote(true);
    }


}
