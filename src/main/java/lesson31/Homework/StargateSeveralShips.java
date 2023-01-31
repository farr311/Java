package lesson31.Homework;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StargateSeveralShips extends JPanel {
    private final int GATE_OPEN_Y = 200;
    private final int GATE_CLOSED_Y = 90;

    private List<Ship> ships;

    private int gateX = 300;
    private int gateY = 90;

    private void run() {
        for (Ship ship : ships) {
            ship.move();
        }

        new Thread(() -> {
            while (true) {
                repaint();
                sleep(1000/30);
            }
        }).start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stargate Several Ships Answer");
        frame.setSize(new Dimension(400, 400));
        frame.setLocation(150, 150);

        StargateSeveralShips stargate = new StargateSeveralShips();

        frame.add(stargate);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        stargate.run();
    }

    public StargateSeveralShips() {
        this.ships = new ArrayList<>(2);

        ships.add(new Ship(50, 130, 3, Color.BLUE));
        ships.add(new Ship(50, 180, 2, Color.GREEN));
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void paint(Graphics g) {
        for (Ship ship : ships) {
            g.setColor(ship.color);
            g.fillRect(ship.x, ship.y, 20, 20);
        }

        g.setColor(Color.BLACK);
        g.fillRect(300, 0, 15, 90);
        g.fillRect(300, 200, 15, 200);


        g.setColor(Color.RED);
        g.fillRect(gateX, gateY, 15, 110);
    }

    class Ship {
        int x;
        int y;
        int speed;
        Color color;

        public Ship(int x, int y, int speed, Color color) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.color = color;
        }

        public void move() {
            new Thread(() -> {
                while (this.x < 400) {
                    this.x += speed;
                    sleep( 20);

                    if (this.x >= 400) {
                        this.x = 50;
                    }
                }
            }).start();
        }
    }
}
