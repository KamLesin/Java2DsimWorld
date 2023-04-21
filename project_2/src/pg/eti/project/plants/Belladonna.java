package pg.eti.project.plants;

import pg.eti.project.Plant;
import pg.eti.project.World;

public class Belladonna extends Plant {
    public Belladonna(int positionX, int positionY, World world) {
        super(99, 0, positionX, positionY, world);
    }

    @Override
    public void collision() {
        super.collision();
    }

    @Override
    public String draw() {
        return "bd";
    }

    @Override
    public void action() {
        super.action();
    }
}
