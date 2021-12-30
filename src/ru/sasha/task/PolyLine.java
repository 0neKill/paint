package ru.sasha.task;

import java.awt.*;
import java.util.*;
import java.util.List;


public class PolyLine {
    private List<Integer> xList;
    private List<Integer> yList;
    private Color color;
    private int fontSize;


    public PolyLine(Color color, int fontSize) {
        this.color = color;
        this.fontSize = fontSize;
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
    }

    public void addPoint(int x, int y) {//Добавляем координаты
        xList.add(x);
        yList.add(y);
    }

    public void draw(Graphics2D g) { // метод отрисовки линии
        BasicStroke pen = new BasicStroke(fontSize);
        for (int i = 0; i < xList.size() - 1; ++i) {
            g.setColor(color);
            g.setStroke(pen);
            g.drawLine((int) xList.get(i), (int) yList.get(i), (int) xList.get(i + 1),
                    (int) yList.get(i + 1));
        }
    }


}