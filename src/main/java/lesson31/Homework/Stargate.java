package lesson31.Homework;

import javax.swing.*;
import java.awt.*;

//TODO: используя значения shipX, gateXб gateY и константы GATE_OPEN_Y, GATE_CLOSED_Y, написать код, который будет
// открывать звездные врата, когда корабль подлетает к ним на расстояние <=10
public class Stargate extends JPanel {
    private final int GATE_OPEN_Y = 200;
    private final int GATE_CLOSED_Y = 90;

    private int shipX = 50;
    private int shipY = 130;

    private int gateX = 300;
    private int gateY = 90;

    private void run() {
        new Thread(() -> {
            while (shipX < 400) {
                shipX += 1;
                sleep(30);
            }
        }).start();

        new Thread(() -> {
            while (true) {
                repaint();
                sleep(1000/30);
            }
        }).start();
    }

    public static void main(String[] args) {
        Stargate stargate = new Stargate();

        JFrame frame = new JFrame("Stargate 1 ship");
        frame.setSize(new Dimension(400, 400));
        frame.setLocation(150, 150);
        frame.add(stargate);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        stargate.run();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Starship
        g.setColor(Color.BLUE);
        g.fillRect(shipX, shipY, 20, 20);

        //Stargate immovable part
        g.setColor(Color.BLACK);
        g.fillRect(300, 0, 15, 90);
        g.fillRect(300, 200, 15, 200);

        //Stargate movable part
        g.setColor(Color.RED);
        g.fillRect(gateX, gateY, 15, 110);
    }
}
