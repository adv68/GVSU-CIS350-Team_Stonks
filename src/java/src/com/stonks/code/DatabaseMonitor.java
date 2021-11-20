package com.stonks.code;

public class DatabaseMonitor implements Runnable {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/stonks";
    private final String username = "root";
    private final String password = "";

    private final int GARBAGE_COLLECT_CYCLE_RATE = 25;

    private StockTickerManager stockTickerManager;

    public DatabaseMonitor(StockTickerManager stockTickerManager) {
        this.stockTickerManager = stockTickerManager;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        int increment = 0;

        for (;;) {
            StockTickers tickersFromDB = DatabaseQuery.getStockTickers(connectionUrl, username, password);
            if (increment == 0) {
                stockTickerManager.setTickerList(tickersFromDB.getList(), true);
            } else {
                stockTickerManager.setTickerList(tickersFromDB.getList(), false);
            }

            increment++;

            if (increment > GARBAGE_COLLECT_CYCLE_RATE) {
                increment = 0;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
