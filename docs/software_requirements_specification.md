# Software Requirements

# Overview

This document outlines the software requirements for the project. Listed below are both functional and non-functional requirements for each part of our project.

## Functional Requirements

1. WebUI Feature - Web interface for configuring settings
    1. The pi shall have a web console.
    2. The web console shall allow the user to choose stock tickers.
    3.	The web console shall save stock settings so that the watcher app can read them.
2. Stock Ticker Display Feature - The display output of the stock data
    1. The stock ticker shall display the current price of a stock.
    2. The stock ticker shall be able to display the price of multiple stocks simaultaneously.
    3. The stock ticker shall be able to display other data such as the days volume, change since previous close, etc.
    4. The stock ticker shall offer a scroll bar that displays data on many stocks in the background.
3. Other Functional Requirments
    1. The stock ticker shall run on a raspberry pi
    2. The stock ticker shall be portable


## Non-Functional Requirements

1. WebUI Feature - Web interface for configuring settings
    1.	The web console shall load in a reasonable amount of time (1-2 seconds max).
    2.	The web console shall have an intuitive UI.
    3.	The web console shall be visually appealing.
    4. The web console shall be behind a login page.
2. Stock Ticker Display Feature - The disply output of the stock data
    1. The stock ticker shall update within 5 seconds.
    2. The stock ticker shall be color-coded based on whether the stock price is up or down.
