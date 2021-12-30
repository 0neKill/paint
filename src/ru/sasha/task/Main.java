package ru.sasha.task;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Main extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    private final DrawPanel drawPanel = new DrawPanel();

    Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(this.setPanelWithSlider(), BorderLayout.NORTH);
        this.add(this.setPanelDraw());
    }

    private JPanel setPanelDraw() {
        JPanel panel = new JPanel();
        drawPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                drawPanel.setCurrentLine(new PolyLine(drawPanel.getColor(), drawPanel.getFontSize()));
                drawPanel.getLines().add(drawPanel.getCurrentLine());
                drawPanel.getCurrentLine().addPoint(evt.getX(), evt.getY());
            }
        });
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                drawPanel.getCurrentLine().addPoint(evt.getX(), evt.getY());
                drawPanel.draw();
            }
        });
        drawPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(drawPanel);
        return panel;
    }

    private JPanel setPanelWithSlider() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(WIDTH, 80));
        Box box = new Box(BoxLayout.Y_AXIS);
        JSlider slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setValue(drawPanel.getFontSize());
        slider.addChangeListener(e -> {
            drawPanel.setFontSize(((JSlider) e.getSource()).getValue());
        });
        JLabel labelFontSize = new JLabel("Выберите размер шрифта");
        box.add(labelFontSize);
        box.add(slider);
        box.setAlignmentX(CENTER_ALIGNMENT);
        JButton colorButton = new JButton("Выберите цвет пера");
        colorButton.addActionListener(e -> {
            drawPanel.setColor(JColorChooser.showDialog(null, "Выберите цвет", Color.GREEN));
        });
        panel.add(colorButton, BorderLayout.NORTH);
        panel.add(box, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new Main("Холст");
        frame.setVisible(true);
    }

}
