package com.stonks.code;

import java.util.ArrayList;
import java.util.HashMap;

public class LEDPanelScrollingText implements Runnable {
    private int line;
    private Thread t;
    private boolean run = false;
    private LEDMatrix matrix;
    private HashMap<String, String> values;
    private HashMap<String, String> pendingUpdatesToValues;

    public LEDPanelScrollingText(int line, LEDMatrix matrix) {
        this.line = line;
        this.matrix = matrix;
        this.pendingUpdatesToValues = new HashMap<>();
        this.values = new HashMap<>();
    }

    public void setValues(HashMap<String, String> values) {
        if (!run) {
            this.values = values;
        }
    }

    public void updateValues(String key, String value) {
        if (values.containsKey(key)) {
            if (values.size() > 1) {
                pendingUpdatesToValues.put(key, value);
            } else {
                values.put(key, value);
            }
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
        String[] keys = values.keySet().toArray(new String[0]);

        while (run) {
            line = "";
            line += keys[currValue];
            line += " - ";
            line += values.get(keys[currValue]);
            line += " | ";

            if (line.length() - currChar - 1 <= 10) {
                int nextVal = currValue + 1 < keys.length ? currValue + 1 : currValue + 1 - keys.length;
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
                    row += " ";
                }

                int start = currChar * 6 + charRowOffset;
                String subRow = row.substring(start, start + 60);
                for (int j = 0; j < subRow.length(); j++) {
                    if (subRow.charAt(j) == '0') {
                        matrix.setPixel(j + 2, this.line * 8 + i + 1, 255, 255, 255);
                    } else {
                        matrix.setPixel(j + 2, this.line * 8 + i + 1, 0, 0, 0);
                    }
                }
            }

            for (String key : pendingUpdatesToValues.keySet()) {
                if (!keys[currValue].equals(key)) {
                    values.put(key, pendingUpdatesToValues.remove(key));
                }
            }

            charRowOffset++;
            if (charRowOffset > 5) {
                charRowOffset = 0;
                currChar++;
            }
            if (currChar > (keys[currValue].length() + values.get(keys[currValue]).length() + 5)) {
                currChar = 0;
                currValue++;
            }
            if (currValue > keys.length - 1) {
                currValue = 0;
            }

            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {

            }
        }
    }

}
