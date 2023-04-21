package pg.eti.project;

import com.sun.org.apache.xpath.internal.operations.Or;

public abstract class Organism implements Comparable<Organism> {
    private int strength;
    private int initiative;
    private int positionX;
    private int positionY;
    private int age;
    private boolean toRemove = false;

    public void setToRemove(boolean toRemove) {
        this.toRemove = toRemove;
    }

    public boolean isToRemove() {
        return toRemove;
    }

    private World world;
    public abstract void collision();
    public void collisionOther(Organism other)
    {
        if (this.getStrength() >= other.getStrength())
        {
            getWorld().removeAfterTurn(other);
        }
        else
        {
            getWorld().removeAfterTurn(this);
        }
    }
    public abstract String draw();
    public abstract void action();
    public Organism(int strength, int initiative, int positionX, int positionY, World world) {
        this.strength = strength;
        this.initiative = initiative;
        this.positionX = positionX;
        this.positionY = positionY;
        this.world = world;
    }
    public World getWorld() {
        return world;
    }

    @Override
    public int compareTo(Organism o) {
        if (this.getInitiative() == o.getInitiative() && this.getStrength() == o.getStrength() && this.getPositionY() == o.getPositionY() && this.getPositionX() == o.getPositionX()) {
            return 0;
        } else if ((this.getInitiative() < o.getInitiative()) || (this.getInitiative() == o.getInitiative() && this.getAge() < this.getAge())) {
            return -1;
        } else {
            return 1;
        }
    }
    public boolean otherOrganismAtPosition (int x, int y)
    {
        for (Organism o : world.getOrganisms())
        {
            if (o.getPositionX() == x && o.getPositionY() == y)
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkFreeSpace(int posX, int posY)
    {
        if (posX == 0 || posY == 0 || posX == world.getWorldX() - 1 || posY == world.getWorldY() - 1 || otherOrganismAtPosition(posX, posY) == true)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}