package com.stonks.code;

import javax.swing.*;
import java.awt.*;

public class VirtualLEDMatrix extends JFrame implements LEDMatrix {

    private JFrame frame;

    private LEDMatrixPanel panel;



    public VirtualLEDMatrix(int width, int height) {

        this.frame = new JFrame("Virtual LED Matrix");

        this.panel = new LEDMatrixPanel();
        this.panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createRaisedSoftBevelBorder()));
        this.panel.setBackground(Color.BLACK);
        this.panel.setSize(width * 5, height * 5);



    }


    private class LEDMatrixPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            for (int i = 0; i < this.getSize().getHeight(); i++) {

                for (int j = 0; j < this.getSize().getWidth(); j++) {

                    g.drawOval(i, j, 2, 2);
                    g.fillOval(i, j, 2, 2);

                }

            }

        }

    }


    public void setPixel(int x, int y, int r, int g, int b) {

        // what rgb are we given if there's supposed to be no color?

    }


    public static void main(String[] args) {

        VirtualLEDMatrix test = new VirtualLEDMatrix(64, 32);

    }

}
