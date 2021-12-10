package com.stonks.test;

import com.stonks.code.DatabaseQuery;
import com.stonks.code.StockTickerMngr;
import com.stonks.code.StockTickers;

public class DBYahooFinanceIntegrationTest {
    public static void main(String[] args) {
        String connection = "jdbc:mysql://localhost:3306/stonks";
        String user = "root";
        String password = "";

        StockTickers tickers = DatabaseQuery.getStockTickers(connection, user, password);
        StockTickerMngr stockTickerManager = new StockTickerMngr();
        stockTickerManager.updateTickers(tickers);
        System.out.println(stockTickerManager.getStockQuote(tickers.getSingleTicker()).getPrice());
    }
}
