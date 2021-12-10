# Overview
<This document outlines the software requirements for the project. Listed below are both functional and non-functional requirements for each part of our project. Our project is a stock ticker implemented on a 32x64 LED board and virtually.>
# Software Requirements
<Contents below in this markdown file include three categories of functional and non-functional requirements; further, each category holds a minimum of 5 requirements>
## Functional Requirements
### <WebUI Feature>
| 01 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | <The web console shall allow the user to choose stock tickers.> | TC1 | 
| FR2 | <The web console shall save stock settings so that the watcher app can read them.> 
| FR3 | <The web console shall require the user to login.> 
| FR4 | <The web console shall give feedback to the user when settings are saved.> 
| FR5 | <The web console shall display a preview of each possible layout.> 
| … | … | … |
### <Stock Ticker Display Feature>
| 02 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR6 | <The stock ticker shall display the current price of a stock.> | TC5 | 
| FR7 | <The stock ticker shall be able to display the price of multiple stocks simultaneously.> 
| FR8 | <The stock ticker shall be able to display other data such as the days, volume, change since previous close, etc.> | TC8 | 
| FR9 | <The stock ticker shall display data on a Virtual LED panel.> | TC9 | 
| FR10 | <The stock ticker shall allow for different display layouts.> 
| … | … | … |
### < Other Functional Requirements>
| 03 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR11 | <The stock ticker shall signal whether or not the market is open.> 
| FR12 | <The stock ticker shall have an internet connection> 
| FR13 | <The stock ticker shall run on IntelliJ> 
| FR14 | <The SQL and Apache modules shall run on XAMPP Control Panel> 
| FR15 | <The stock ticker shall offer a scroll bar that displays data on many stocks in the background.> 
| … | … | … |
## Non-Functional Requirements
### < WebUI Feature>
| 04 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR16 | <The pi shall have a web console.> | TC18 |
| FR17 | <The web console shall load in a reasonable amount of time (1-2 seconds max).> | TB19 |
| FR18 | <The web console shall have an intuitive UI.> | TC20|
| FR19 | <The web console shall be visually appealing.> | TC21 |
| FR20 | <The web console password shall not be stored in plaintext.> | TC22 |
| … | … | … |
### < Stock Ticker Display Feature>
| 05 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR21 | <The stock ticker shall update within 5 seconds.> | TC21 | 
| FR22 | <The stock ticker shall be color-coded based on the change in price of the stock.>
| FR23 | <The LED panel shall be large enough to display multiple stocks at the same time.> 
| FR24 | <The stock ticker servers’ version for controlling and displaying the SQL database shall run in desktop application XAMPP version 3.3.0> 
| FR25 | <The stock tickers’ desktop application for running the code IntelliJ should run the code with “Oracle OpenJDK ver. 16.0.2”.> 
| … | … | … |
### < Other Non-Functional Requirements>
| 06 | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR26 | <The software shall run on Raspberry Pi OS.> 
| FR27 | <The stock ticker shall run on a raspberry pi.> 
| FR28 | <The hardware shall have soldered wires.> 
| FR29 | <The stock ticker shall be portable.> 
| FR30 | <The stock ticker shall be plugged into a regular wall outlet.>
| … | … | … |
