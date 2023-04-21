package pg.eti.project.plants;

import pg.eti.project.Plant;
import pg.eti.project.World;

public class Guarana extends Plant {
    public Guarana(int positionX, int positionY, World world) {
        super(0, 0, positionX, positionY, world);
    }

    @Override
    public void collision() {
        super.collision();
    }

    @Override
    public String draw() {
        return "gu";
    }

    @Override
    public void action() {
        super.action();
    }
}
