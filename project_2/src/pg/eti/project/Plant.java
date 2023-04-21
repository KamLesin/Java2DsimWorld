package pg.eti.project;

import java.util.Random;

public class Plant extends Organism{
    public Plant(int strength, int initiative, int positionX, int positionY, World world) {
        super(strength, 0, positionX, positionY, world);
    }

    @Override
    public void collision() {

    }

    @Override
    public void collisionOther(Organism other) {

    }

    @Override
    public String draw() {
        return null;
    }

    @Override
    public void action()
    {
        Random random = new Random();
        int chance = random.nextInt(2);
        int nextInt = random.nextInt(4);
        switch (nextInt)
        {
            case 0:
                if (chance == 1)
                {
                    getWorld().addOrganism(this.getPositionX(), this.getPositionY() + 1, this.draw());
                }
                break;
            case 1:
                if (chance == 1)
                {
                    getWorld().addOrganism(this.getPositionX(), this.getPositionY() - 1, this.draw());
                }
                break;
            case 2:
                if (chance == 1)
                {
                    getWorld().addOrganism(this.getPositionX() + 1, this.getPositionY(), this.draw());
                }
                break;
            case 3:
                if (chance == 1)
                {
                    getWorld().addOrganism(this.getPositionX() - 1, this.getPositionY(), this.draw());
                }
                break;
        }
    }
}
