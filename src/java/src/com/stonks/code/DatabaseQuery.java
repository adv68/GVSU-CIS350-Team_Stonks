package com.stonks.code;

import java.sql.*;

public class DatabaseQuery {
    private static StockTickers defaultData = new StockTickers(
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

    public static StockTickers getStockTickers(String url, String user, String pwd) {
        try (Connection connection = DriverManager.getConnection(url, user, pwd)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM settings WHERE id = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new StockTickers(
                    resultSet.getString("layoutStyle"),
                    resultSet.getString("singleTicker"),
                    resultSet.getString("doubleTicker1"),
                    resultSet.getString("doubleTicker2"),
                    resultSet.getString("manyTicker1"),
                    resultSet.getString("manyTicker2"),
                    resultSet.getString("manyTicker3"),
                    resultSet.getString("manyTicker4"),
                    resultSet.getString("manyTicker5")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return defaultData;
    }
}