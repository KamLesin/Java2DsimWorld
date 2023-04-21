package pg.eti.project;

import pg.eti.project.animals.Human;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    private PlayBoard playBoard;
    private World world;
    public MyFrame(World world, int winWidth, int winHeight)
    {
        this.world = world;
        this.playBoard = new PlayBoard(world.getWorldX(), world.getWorldY(), world);
        this.setTitle("Virtual World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(winWidth, winHeight);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
        this.setContentPane(playBoard.getWindow());
        this.setVisible(true);
        this.requestFocus();
    }

    public PlayBoard getPlayBoard() {
        return playBoard;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Human human = null;
        for (Organism o : world.getOrganisms())
        {
            if (o instanceof Human)
            {
                human = (Human) o;
                break;
            }
        }
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_M:
            {
                if (humanExists()) {
                    human.setSpeedY(0);
                    human.setSpeedX(0);
                    if (human.getDelay() == 0) {
                        human.startMagicalPotion();
                    }
                }
                world.play();
                break;
            }
            case KeyEvent.VK_UP:
            {
                if (humanExists())
                {
                    human.setSpeedY(-1);
                    human.setSpeedX(0);
                }
                world.play();
                break;
            }
            case KeyEvent.VK_DOWN:
            {
                if (humanExists())
                {
                    human.setSpeedY(1);
                    human.setSpeedX(0);
                }
                world.play();
                break;
            }
            case KeyEvent.VK_LEFT:
            {
                if (humanExists())
                {
                    human.setSpeedX(-1);
                    human.setSpeedY(0);
                }
                world.play();
                break;
            }
            case KeyEvent.VK_RIGHT:
            {
                if (humanExists())
                {
                    human.setSpeedX(1);
                    human.setSpeedY(0);
                }
                world.play();
                break;
            }
        }
    }
    public boolean humanExists()
    {
        for (Organism o : this.world.getOrganisms())
        {
            if (o instanceof Human)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
