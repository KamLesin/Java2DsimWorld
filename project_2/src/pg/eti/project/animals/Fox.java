package pg.eti.project.animals;

import pg.eti.project.Animal;
import pg.eti.project.Organism;
import pg.eti.project.Place;
import pg.eti.project.World;

import java.util.Random;

public class Fox extends Animal {
    private boolean movePermission = true;
    public Fox(int positionX, int positionY, World world) {
        super(3, 7, positionX, positionY, world);
    }

    @Override
    public void collision() {
        super.collision();
    }
    @Override
    public void collisionOther(Organism other)
    {
        super.collisionOther(other);
    }

    @Override
    public String draw() {
        return "F";
    }

    public int findOrganism(int x, int y)
    {
        for (Organism o : this.getWorld().getOrganisms())
        {
            if (o.getPositionX() == x && o.getPositionY() == y)
            {
                return o.getStrength();
            }
        }
        return -1;
    }
    @Override
    public void action()
    {
        super.action();
    }

}
