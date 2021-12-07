package com.stonks.test;

import com.stonks.code.LEDMatrix;
import com.stonks.code.LEDPanelScrollingText;
import com.stonks.code.VirtualLEDMatrix;

import java.util.HashMap;

public class ScrollingTextTest {
    public static void main(String[] args) {
        LEDMatrix matrix = new VirtualLEDMatrix();
        LEDPanelScrollingText scrollingText = new LEDPanelScrollingText(0, matrix);
        LEDPanelScrollingText scrollingText2 = new LEDPanelScrollingText(1, matrix);
        LEDPanelScrollingText scrollingText3 = new LEDPanelScrollingText(2, matrix);
        LEDPanelScrollingText scrollingText4 = new LEDPanelScrollingText(3, matrix);


        HashMap<String, String> map = new HashMap<>();
        map.put("GME", "231.23");
        map.put("AMC", "34.26");
        map.put("TSLA", "1023.78");

        scrollingText.setValues(map);
        scrollingText.start();

        scrollingText2.setValues(map);
        scrollingText2.start();

        scrollingText3.setValues(map);
        scrollingText3.start();

        scrollingText4.setValues(map);
        scrollingText4.start();

    }
}
