package pg.eti.project.animals;

import pg.eti.project.Animal;
import pg.eti.project.Organism;
import pg.eti.project.World;

public class Human extends Animal {
    private int speedX = 0;
    private int speedY = 0;
    private boolean hasAbility = false;
    private int delay = 0;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public void setHasAbility(boolean hasAbility) {
        this.hasAbility = hasAbility;
    }

    public boolean isHasAbility() {
        return hasAbility;
    }

    public Human(int positionX, int positionY, World world) {
        super(5, 4, positionX, positionY, world);
    }
    @Override
    public void collision() {
        return;
    }

    public void startMagicalPotion()
    {
        this.setStrength(10);
        this.setHasAbility(true);
    }
    public void endMagicalPotion()
    {
        if (getStrength() > 5)
        {
            this.setStrength(this.getStrength() - 1);
        }
        else
        {
            this.setHasAbility(false);
            this.setDelay(5);
        }
    }
    @Override
    public void collisionOther(Organism other)
    {
        super.collisionOther(other);
    }

    @Override
    public String draw() {
        return "H";
    }

    @Override
    public void action() {
        this.setPosition(speedX + getPositionX(), speedY + getPositionY());
        this.collisionNeeded(this.getPositionX(), this.getPositionY());
        if (this.getDelay() > 0)
        {
            this.setDelay(this.getDelay() - 1);
        }
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
