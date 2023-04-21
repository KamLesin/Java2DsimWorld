package pg.eti.project;

import pg.eti.project.animals.*;
import pg.eti.project.plants.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

public class PlayBoard extends JPanel {
    private JPanel window;
    private JPanel board;
    private JPanel actionBoard;
    private int sizeX;
    private int sizeY;
    private JButton[][] buttons;
    private World world;
    private ButtonGroup spawner;

    public PlayBoard(int x, int y, World world) {
        this.sizeX = x;
        this.sizeY = y;
        this.world = world;
        this.window = new JPanel(new GridLayout(2, 1));
        this.board = new JPanel();
        this.actionBoard = new JPanel();
        board.setLayout(new GridLayout(sizeX, sizeY));
        actionBoard.setLayout(new FlowLayout(3, 70, 20));
        initBoard();
        initActionBoard();
        window.add(board);
        window.add(actionBoard);
    }

    public void initActionBoard() {
        JButton nextTurn = new JButton("Next Turn");
        JButton save = new JButton("save");
        JButton load = new JButton("load");
        spawner = new ButtonGroup();
        JRadioButton sheep = new MyRadioButton("Sheep");
        JRadioButton wolf = new MyRadioButton("Wolf");
        JRadioButton fox = new MyRadioButton("Fox");
        JRadioButton turtle = new MyRadioButton("Turtle");
        JRadioButton antelope = new MyRadioButton("Antelope");
        JRadioButton human = new MyRadioButton("Human");
        JRadioButton grass = new MyRadioButton("Grass");
        JRadioButton guarana = new MyRadioButton("Guarana");
        JRadioButton belladonna = new MyRadioButton("Belladonna");
        JRadioButton sowThistle = new MyRadioButton("SowThistle");
        JRadioButton sosnowskyHogweed = new MyRadioButton("SosnowskyHogweed");
        spawner.add(sheep);
        spawner.add(wolf);
        spawner.add(fox);
        spawner.add(turtle);
        spawner.add(antelope);
        spawner.add(human);
        spawner.add(grass);
        spawner.add(guarana);
        spawner.add(belladonna);
        spawner.add(sowThistle);
        spawner.add(sosnowskyHogweed);
        nextTurn.addActionListener(e -> {
            Human human1 = null;
            for (Organism o : world.getOrganisms())
            {
                if (o instanceof Human)
                {
                    human1 = (Human) o;
                    break;
                }
            }
            if (world.getFrame().humanExists())
            {
                human1.setSpeedY(0);
                human1.setSpeedX(0);
            }
            world.play();
        });
        nextTurn.setBounds(0, 0, 50, 20);
        save.setBounds(0, 0, 50, 20);
        load.setBounds(0, 0, 50, 20);
        save.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION)
            {
                try {
                    world.saveToFile(chooser.getSelectedFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        load.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION)
            {
                try {
                    world.readFromFile(chooser.getSelectedFile());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        nextTurn.setFocusable(false);
        save.setFocusable(false);
        load.setFocusable(false);
        actionBoard.add(nextTurn);
        actionBoard.add(save);
        actionBoard.add(load);
        actionBoard.add(sheep);
        actionBoard.add(wolf);
        actionBoard.add(fox);
        actionBoard.add(turtle);
        actionBoard.add(antelope);
        actionBoard.add(human);
        actionBoard.add(grass);
        actionBoard.add(guarana);
        actionBoard.add(belladonna);
        actionBoard.add(sowThistle);
        actionBoard.add(sosnowskyHogweed);
    }

    public void initBoard() {
        buttons = new JButton[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                buttons[y][x] = new JButton();
                board.add(buttons[y][x]);
                int finalX = x;
                int finalY = y;
                buttons[y][x].addActionListener(e -> {
                    String s = getSelectedButtonText(spawner);
                    switch (s)
                    {
                        case "Turtle":
                            world.getOrganisms().add(new Turtle(finalX, finalY,this.world));
                            break;

                        case "Fox":
                            world.getOrganisms().add(new Fox(finalX, finalY,this.world));
                            break;

                        case "Sheep":
                            world.getOrganisms().add(new Sheep(finalX, finalY,this.world));
                            break;

                        case "Antelope":
                            world.getOrganisms().add(new Antelope(finalX, finalY,this.world));
                            break;

                        case "Wolf":
                            world.getOrganisms().add(new Wolf(finalX, finalY,this.world));
                            break;

                        case "Human":
                            world.getOrganisms().add(new Human(finalX, finalY,this.world));
                            break;

                        case "Grass":
                            world.getOrganisms().add(new Grass(finalX, finalY,this.world));
                            break;

                        case "Guarana":
                            world.getOrganisms().add(new Guarana(finalX, finalY,this.world));
                            break;

                        case "Belladonna":
                            world.getOrganisms().add(new Belladonna(finalX, finalY,this.world));
                            break;

                        case "SowThistle":
                            world.getOrganisms().add(new SowThistle(finalX, finalY,this.world));
                            break;

                        case "SosnowskyHogweed":
                            world.getOrganisms().add(new SosnowskyHogweed(finalX, finalY,this.world));
                            break;

                        default:
                            break;
                    }
                    drawBoard();
                });
                buttons[y][x].setFocusable(false);
            }
        }
    }
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void drawBoard() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                buttons[y][x].setText("");
            }
        }
        for (Organism o : world.getOrganisms()) {
            for (int y = 0; y < sizeY; y++) {
                for (int x = 0; x < sizeX; x++) {
                    if (y == o.getPositionY() && x == o.getPositionX()) {
                        buttons[y][x].setText(o.draw());
                        break;
                    }
                }
            }
        }
    }

    public JPanel getWindow() {
        return window;
    }
}
