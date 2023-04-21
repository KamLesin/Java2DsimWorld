package pg.eti.project.plants;

import pg.eti.project.Plant;
import pg.eti.project.World;

public class Grass extends Plant {
    public Grass(int positionX, int positionY, World world) {
        super(0, 0, positionX, positionY, world);
    }

    @Override
    public void collision() {
        super.collision();
    }

    @Override
    public String draw() {
        return "gr";
    }

    @Override
    public void action() {
        super.action();
    }
}
