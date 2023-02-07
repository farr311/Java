package lesson31.Homework;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//TODO: написать код, который будет открывать звездные врата, если хотя бы один корабль находится на подлете
//  и закрывать врата, если:
//      - Оба корабля правее врат
//      - Оба корабля слева, но еще далеко (dX > 40) от звездных врат
//      - Один корабль слева и далеко, а второй пролетел
public class Stargate extends JPanel {
    private final int GATE_OPEN_Y = 200;
    private final int GATE_CLOSED_Y = 90;

    private List<Ship> ships;

    private int shipX = 50;
    private int shipY = 130;

    private int gateX = 300;
    private int gateY = 90;

    private void run() {

        for (Ship ship : ships) {
            new Thread(() -> {
                while (ship.x < 400) {
                    ship.x += ship.speed;
                    sleep(30);

                    if (ship.x >= 400) {
                        ship.x = 50;
                    }
                }
            }).start();
        }

        /*new Thread(() -> {
            while (true) {
                if (gateX - shipX <= 40 && shipX <= gateX && gateY < GATE_OPEN_Y) {
                    gateY += (GATE_OPEN_Y - GATE_CLOSED_Y) / 10;
                }

                if (shipX >= gateX + 15 && gateY > GATE_CLOSED_Y) {
                    gateY -= (GATE_OPEN_Y - GATE_CLOSED_Y) /
                    ;
                }
                sleep(30);
            }
        }).start();*/

        new Thread(() -> {
            while (true) {
                repaint();
                sleep(1000/30);
            }
        }).start();
    }

    public Stargate() {
        this.ships = new ArrayList<Ship>(2);

        ships.add(new Ship(50, 130, 3, Color.BLUE));
        ships.add(new Ship(50, 180, 2, Color.GREEN));
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
        /*g.setColor(Color.BLUE);
        g.fillRect(shipX, shipY, 20, 20);*/

        for (Ship ship : ships) {
            g.setColor(ship.color);
            g.fillRect(ship.x, ship.y, 20, 20);
        }

        //Stargate immovable part
        g.setColor(Color.BLACK);
        g.fillRect(300, 0, 15, 90);
        g.fillRect(300, 200, 15, 200);

        //Stargate movable part
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
