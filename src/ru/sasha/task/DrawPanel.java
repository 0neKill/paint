package ru.sasha.task;


import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private int fontSize = 10;
    private Color color = Color.BLACK;
    private PolyLine currentLine;
    private List<PolyLine> lines = new ArrayList<PolyLine>();


    public void draw() {
        repaint();
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        for (PolyLine line : lines) {
            line.draw((Graphics2D) gr);
        }
    }

    //Getters
    public int getFontSize() {
        return fontSize;
    }

    public Color getColor() {
        return this.color;
    }

    public List<PolyLine> getLines() {
        return lines;
    }

    public PolyLine getCurrentLine() {
        return currentLine;
    }

    //Setters
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCurrentLine(PolyLine currentLine) {
        this.currentLine = currentLine;
    }
}
