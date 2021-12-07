package com.stonks.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LEDPanelScrollingText implements Runnable {
    private int line;
    private Thread t;
    private boolean run = false;
    private LEDMatrix matrix;
    private HashMap<String, String> values;

    public LEDPanelScrollingText(int line, LEDMatrix matrix) {
        this.line = line;
        this.matrix = matrix;
    }

    public void setValues(HashMap<String, String> values) {
        if (!run) {
            this.values = values;
        }
    }

    public void updateValues(String key, String value) {
        if (values.containsKey(key)) {
            values.put(key, value);
        }
    }

    public void start() {
        if (t == null) {
            run = true;
            t = new Thread(this);
            t.start();
        }
    }

    public void stop() {
        if (t != null) {
            run = false;
            while (t.isAlive()) {}
            t = null;
        }
    }

    @Override
    public void run() {
        int numValues = values.size();

        int currValue = 0;
        int currChar = 0;
        int charRowOffset = 0;

        String line;
        String[] keys = (String[])values.keySet().toArray();

        while (run) {
            line = "";
            line += keys[currValue];
            line += " - ";
            line += values.get(keys[currValue]);
            line += " | ";

            if (line.length() - currChar < 10) {
                int nextVal = currValue + 1 < keys.length ? currValue : currValue + 1 - keys.length;
                line += keys[nextVal];
                line += " - ";
                line += values.get(keys[nextVal]);
                line += " | ";
            }

            ArrayList<String[]> panelText = Text5x7.getLetters(line);
            for (int i = 0; i < 7; i++) {
                String row = "";
                for (String[] s : panelText) {
                    row += s[i];
                }
            }


        }
    }

}
