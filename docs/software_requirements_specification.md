# Software Requirements

# Overview

This document outlines the software requirements for the project. Listed below are both functional and non-functional requirements for each part of our project.

## Functional Requirements

1. WebUI Feature - Web interface for configuring settings
    1. The web console shall allow the user to choose stock tickers.
    2. The web console shall save stock settings so that the watcher app can read them.
    3. The web console shall require the user to login.
    4. The web console shall give feedback to the user when settings are saved.
    5. The web console shall display a preview of each possible layout.
2. Stock Ticker Display Feature - The display output of the stock data
    1. The stock ticker shall display the current price of a stock.
    2. The stock ticker shall be able to display the price of multiple stocks simultaneously.
    3. The stock ticker shall be able to display other data such as the days volume, change since previous close, etc.
    4. The stock ticker shall offer a scroll bar that displays data on many stocks in the background.
    5. The stock ticker shall display data on a LED panel.
    6. The stock ticker shall allow for different display layouts.
    7. The stock ticker shall signal whether or not the market is open.
3. Other Functional Requirements
    1. The stock ticker shall have an internet connection.


## Non-Functional Requirements

1. WebUI Feature - Web interface for configuring settings
    1. The pi shall have a web console.
    2. The web console shall load in a reasonable amount of time (1-2 seconds max).
    3. The web console shall have an intuitive UI.
    4. The web console shall be visually appealing.
    5. The web console password shall not be stored in plaintext.
2. Stock Ticker Display Feature - The display output of the stock data
    1. The stock ticker shall update within 5 seconds.
    2. The stock ticker shall be color-coded based on the change in price of the stock.
    3. The LED panel shall be large enough to display multiple stocks at the same time.
3. Other Non-Functional Requirements
    1. The software shall run on Raspberry Pi OS.
    2. The stock ticker shall run on a raspberry pi.
    3. The hardware bundle shall have a protective case surrounding it.
    4. The stock ticker shall be portable.
