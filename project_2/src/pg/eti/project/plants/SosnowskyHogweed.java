package pg.eti.project.plants;

import pg.eti.project.Plant;
import pg.eti.project.World;

public class SosnowskyHogweed extends Plant {
    public SosnowskyHogweed(int positionX, int positionY, World world) {
        super(10, 0, positionX, positionY, world);
    }

    @Override
    public void collision() {
        super.collision();
    }

    @Override
    public String draw() {
        return "sh";
    }

    @Override
    public void action() {
        super.action();
    }
}
