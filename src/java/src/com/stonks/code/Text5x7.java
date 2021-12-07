package com.stonks.code;

import java.util.ArrayList;

import static com.stonks.code.Font5x7.*;

public class Text5x7 {
    public static ArrayList<String[]> getLetters(String str) {
        ArrayList<String[]> list = new ArrayList<>();
        char [] array = str.toUpperCase().toCharArray();
        for(char ch : array) {
            if (ch == 'A') {
                list.add(a);
            } else if (ch == 'B') {
                list.add(b);
            } else if (ch == 'C') {
                list.add(c);
            } else if (ch == 'D') {
                list.add(d);
            } else if (ch == 'E') {
                list.add(e);
            } else if (ch == 'F') {
                list.add(f);
            } else if (ch == 'G') {
                list.add(g);
            } else if (ch == 'H') {
                list.add(h);
            } else if (ch == 'I') {
                list.add(i);
            } else if (ch == 'J') {
                list.add(j);
            } else if (ch == 'K') {
                list.add(k);
            } else if (ch == 'L') {
                list.add(l);
            } else if (ch == 'M') {
                list.add(m);
            } else if (ch == 'N') {
                list.add(n);
            } else if (ch == 'O') {
                list.add(o);
            } else if (ch == 'P') {
                list.add(p);
            } else if (ch == 'Q') {
                list.add(q);
            } else if (ch == 'R') {
                list.add(r);
            } else if (ch == 'S') {
                list.add(s);
            } else if (ch == 'T') {
                list.add(t);
            } else if (ch == 'U') {
                list.add(u);
            } else if (ch == 'V') {
                list.add(v);
            } else if (ch == 'W') {
                list.add(w);
            } else if (ch == 'X') {
                list.add(x);
            } else if (ch == 'Y') {
                list.add(y);
            } else if (ch == 'Z') {
                list.add(z);
            } else if (ch == '0') {
                list.add(zero);
            } else if (ch == '1') {
                list.add(one);
            } else if (ch == '2') {
                list.add(two);
            } else if (ch == '3') {
                list.add(three);
            } else if (ch == '4') {
                list.add(four);
            } else if (ch == '5') {
                list.add(five);
            } else if (ch == '6') {
                list.add(six);
            } else if (ch == '7') {
                list.add(seven);
            } else if (ch == '8') {
                list.add(eight);
            } else if (ch == '9') {
                list.add(nine);
            } else if (ch == '.') {
                list.add(decimal);
            } else if (ch == ':') {
                list.add(colon);
            } else if (ch == '$') {
                list.add(dollar);
            } else if (ch == '%') {
                list.add(percent);
            } else if (ch == '-') {
                list.add(minus);
            } else if (ch == '+') {
                list.add(plus);
            } else if (ch == ' ') {
                list.add(space);
            } else if (ch == '|') {
                list.add(bar);
            }
        }
        return list;
    }

    static int getWidth(String text) {
        return (text.length() + 2) * 5;
    }

    static int getHeight(String text) {
        return 7;
    }

    static void printText(ArrayList<String[]> strings) {
        for (int i = 0; i < 7; i++) {
            for(String[] s : strings) {
                System.out.print(s[i]);
                System.out.print("   ");
            }
            System.out.println("");
        }
    }


}
