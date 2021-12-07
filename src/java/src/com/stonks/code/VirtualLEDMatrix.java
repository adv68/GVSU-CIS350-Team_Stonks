package com.stonks.code;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;

public class VirtualLEDMatrix extends JFrame implements LEDMatrix {

    private JFrame frame;

    private JPanel panel;

    private LEDMatrixPanel matrixPanel;

    public VirtualLEDMatrix() {

        this.frame = new JFrame("Virtual LED Matrix");

        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createLineBorder(Color.DARK_GRAY, 10)));
//        this.panel.setBackground(Color.BLACK);

        this.matrixPanel = new LEDMatrixPanel(16);
        this.panel.add(this.matrixPanel);

        this.frame.getContentPane().add(this.panel);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.validate();
        this.frame.setVisible(true);
        this.frame.pack();

    }


    private class LEDMatrixPanel extends JPanel {

        //private ArrayList<Diode> diodes;
        HashMap<String, Diode> diodes;

        public LEDMatrixPanel(int mult) {

            int width = 64 * mult;
            int height = 32 * mult;

            this.setPreferredSize(new Dimension(width, height));

            //this.diodes = new ArrayList<>();
            this.diodes = new HashMap<>();
        }

        public void add(Diode d) {

            //this.diodes.add(d);
            this.diodes.put("" + d.x + "-" + d.y, d);
            this.repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D panelBackground = (Graphics2D) g.create();
            panelBackground.setColor(Color.BLACK);
            panelBackground.fill(new Rectangle(this.getWidth(), this.getHeight()));


            //for (Diode diode : diodes) {
            for (String s : diodes.keySet()) {
                Diode diode = diodes.get(s);
                panelBackground.setColor(new Color(diode.r, diode.g, diode.b));
                panelBackground.fill(new Ellipse2D.Double(diode.x * 16, diode.y * 16, 14, 14));

            }

        }

    }

    private static class Diode extends Point {

        private int r;

        private int g;

        private int b;

        public Diode(int x, int y, int r, int g, int b) {

            super(x, y);
            this.r = r;
            this.g = g;
            this.b = b;

        }

    }


    public void setPixel(int x, int y, int r, int g, int b) {

        this.matrixPanel.add(new Diode(x, y, r, g, b));

    }


//    public static void main(String[] args) {
//
//        VirtualLEDMatrix test = new VirtualLEDMatrix();
//
//        test.setPixel(11, 11, 255, 0, 0);
//        test.setPixel(11, 12, 255, 0, 0);
//        test.setPixel(11, 13, 255, 0, 0);
//        test.setPixel(11, 14, 255, 0, 0);
//        test.setPixel(11, 15, 255, 0, 0);
//
//        test.setPixel(12, 13, 255, 0, 0);
//        test.setPixel(13, 13, 255, 0, 0);
//
//        test.setPixel(14, 11, 255, 0, 0);
//        test.setPixel(14, 12, 255, 0, 0);
//        test.setPixel(14, 13, 255, 0, 0);
//        test.setPixel(14, 14, 255, 0, 0);
//        test.setPixel(14, 15, 255, 0, 0);
//
//
//        test.setPixel(16, 12, 0, 255, 0);
//        test.setPixel(16, 14, 0, 255, 0);
//        test.setPixel(16, 15, 0, 255, 0);
//
//        test.setPixel(18, 11, 0, 0, 255);
//        test.setPixel(18, 12, 0, 0, 255);
//        test.setPixel(18, 13, 0, 0, 255);
//        test.setPixel(18, 15, 0, 0, 255);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {}
//
//        test.setPixel(18, 15, 255, 255, 255);
//
//        test.setPixel(0, 0, 255, 0, 0);
//        test.setPixel(63, 31, 255, 0, 0);
//
//    }

}
