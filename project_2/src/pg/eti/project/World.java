package pg.eti.project;

import pg.eti.project.animals.*;
import pg.eti.project.plants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class World {
    private int worldX;
    private int worldY;
    private TreeSet<Organism> organisms = new TreeSet<Organism>();
    private ArrayList<Organism> tempOrganisms = new ArrayList<Organism>();

    private MyFrame frame;
    public World(int x, int y)
    {
        this.worldX = x;
        this.worldY = y;
        this.frame = new MyFrame(this, 520, 1040);
        play();
    }
    public void removeAfterTurn(Organism o)
    {
        o.setToRemove(true);
        tempOrganisms.add(o);
    }
    public void addOrganism(int posX, int posY, String s)
    {
        switch (s)
        {
            case "H":
                tempOrganisms.add(new Human(posX, posY, this));
                break;

            case "W":
                tempOrganisms.add(new Wolf(posX, posY, this));
                break;

            case "S":
                tempOrganisms.add(new Sheep(posX, posY, this));
                break;

            case "F":
                tempOrganisms.add(new Fox(posX, posY, this));
                break;

            case "C":
                tempOrganisms.add(new Antelope(posX, posY, this));
                break;

            case "T":
                tempOrganisms.add(new Turtle(posX, posY, this));
                break;

            case "gr":
                tempOrganisms.add(new Grass(posX, posY, this));
                break;

            case "gu":
                tempOrganisms.add(new Guarana(posX, posY, this));
                break;

            case "sh":
                tempOrganisms.add(new SosnowskyHogweed(posX, posY, this));
                break;

            case "bd":
                tempOrganisms.add(new Belladonna(posX, posY, this));
                break;

            case "st":
                tempOrganisms.add(new SowThistle(posX, posY, this));
                break;

            default:
                break;
        }
    }
    public void saveToFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (Organism o : organisms)
        {
            String s = o.draw();
            int _x = o.getPositionX();
            int _y = o.getPositionY();
            switch (s)
            {
                case "H":
                    writer.write("Human " + _x + " " + _y + "\n");
                    break;

                case "W":
                    writer.write("Wolf " + _x + " " + _y + "\n");
                    break;

                case "S":
                    writer.write("Sheep " + _x + " " + _y + "\n");
                    break;

                case "F":
                    writer.write("Fox " + _x + " " + _y + "\n");
                    break;

                case "A":
                    writer.write("Antelope " + _x + " " + _y + "\n");
                    break;

                case "T":
                    writer.write("Turtle " + _x + " " + _y + "\n");
                    break;

                case "gr":
                    writer.write("Grass " + _x + " " + _y + "\n");
                    break;

                case "gu":
                    writer.write("Guarana " + _x + " " + _y + "\n");
                    break;

                case "sh":
                    writer.write("SosnowskyHogweed " + _x + " " + _y + "\n");
                    break;

                case "bd":
                    writer.write("Belladonna " + _x + " " + _y + "\n");
                    break;

                case "st":
                    writer.write("SowThistle " + _x + " " + _y + "\n");
                    break;

                default:
                    break;
            }
        }
        writer.close();
    }
    public void readFromFile(File file) throws FileNotFoundException {
        organisms.clear();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            String name = scanner.next();
            switch (name)
            {
                case "Turtle":
                    organisms.add(new Turtle(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Fox":
                    organisms.add(new Fox(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Sheep":
                    organisms.add(new Sheep(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Antelope":
                    organisms.add(new Antelope(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Wolf":
                    organisms.add(new Wolf(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Human":
                    organisms.add(new Human(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Grass":
                    organisms.add(new Grass(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "SowThistle":
                    organisms.add(new SowThistle(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Guarana":
                    organisms.add(new Guarana(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "Belladonna":
                    organisms.add(new Belladonna(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                case "SosnowskyHogweed":
                    organisms.add(new SosnowskyHogweed(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()),this));
                    break;

                default:
                    break;
            }
        }
        this.getFrame().getPlayBoard().drawBoard();
    }

    public void play()
    {
        makeTurn();
        frame.getPlayBoard().drawBoard();
    }
    public void makeTurn()
    {
        ArrayList<Organism> tempRemoveOrganisms = new ArrayList<Organism>();
        for (Organism o : organisms)
        {
            if (o.isToRemove() == true)
            {
                tempRemoveOrganisms.add(o);
            }
        }
        organisms.removeAll(tempRemoveOrganisms);
        tempRemoveOrganisms.clear();
        for (Organism o : organisms)
        {
            o.action();
            if (o instanceof Human)
            {
                ((Human) o).endMagicalPotion();
            }
        }
        for (Organism o : organisms)
        {
            o.setAge(o.getAge() + 1);
        }
        for (Organism o : tempOrganisms)
        {
            organisms.add(o);
        }
        tempOrganisms.clear();
    }
    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public TreeSet<Organism> getOrganisms() {
        return organisms;
    }

    public MyFrame getFrame() {
        return frame;
    }
}
