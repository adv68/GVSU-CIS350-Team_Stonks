package com.stonks.test;

import com.stonks.code.DatabaseQuery;
import com.stonks.code.StockTickers;
import com.stonks.code.StockTickerManager;

import java.io.IOException;

public class DBYahooFinanceIntegrationTest {
    public static void main(String[] args) {
        String connection = "jdbc:mysql://localhost:3306/stonks";
        String user = "root";
        String password = "";

        StockTickers tickers = DatabaseQuery.getStockTickers(connection, user, password);
        StockTickerManager stockTickerManager = new StockTickerManager();
        stockTickerManager.initializeTickerList(tickers.getList());
        try {
            System.out.println(StockTickerManager.getStockPrice(stockTickerManager.getStock(tickers.getSingleTicker())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
