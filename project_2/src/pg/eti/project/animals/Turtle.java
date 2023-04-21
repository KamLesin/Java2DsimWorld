package pg.eti.project.animals;

import pg.eti.project.Animal;
import pg.eti.project.Organism;
import pg.eti.project.World;

public class Turtle extends Animal {
    public Turtle(int positionX, int positionY, World world) {
        super(4, 4, positionX, positionY, world);
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
        return "T";
    }

    @Override
    public void action() {
        super.action();
    }
}
