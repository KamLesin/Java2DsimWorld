package pg.eti.project;

import java.util.Random;

public abstract class Animal extends Organism {
    private boolean movePermission = true;
    public Animal(int strength, int initiative, int positionX, int positionY, World world) {
        super(strength, initiative, positionX, positionY, world);
    }

    @Override
    public void collision()
    {
        Random random = new Random();
        int newInt = random.nextInt(4);
        for (int i = 15; i >= 0; i--)
        {
            if (newInt == 0)
            {
                if (checkFreeSpace(this.getPositionX(), getPositionY() + 1) == true)
                {
                    getWorld().addOrganism(this.getPositionX(), this.getPositionY() + 1, this.draw());
                    break;
                }
            }
            else if (newInt == 1)
            {
                if (checkFreeSpace(this.getPositionX(), getPositionY() - 1) == true)
                {
                    getWorld().addOrganism(this.getPositionX(), this.getPositionY() - 1, this.draw());
                    break;
                }
            }
            else if (newInt == 2)
            {
                if (checkFreeSpace(this.getPositionX() + 1, getPositionY()) == true)
                {
                    getWorld().addOrganism(this.getPositionX() + 1, this.getPositionY(), this.draw());
                    break;
                }
            }
            else if (newInt == 3)
            {
                if (checkFreeSpace(this.getPositionX() - 1, getPositionY()) == true)
                {
                    getWorld().addOrganism(this.getPositionX() - 1, this.getPositionY(), this.draw());
                    break;
                }
            }
        }
        this.movePermission = false;
    }

    @Override
    public void collisionOther(Organism other)
    {
        super.collisionOther(other);
    }
    @Override
    public String draw() {
        return null;
    }

    @Override
    public void action() {
        Random random = new Random();
        int posX = this.getPositionX();
        int posY = this.getPositionY();
        if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.TOP_LEFT_CORNER)
        {
            int moveInt = random.nextInt(2);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.TOP_RIGHT_CORNER)
        {
            int moveInt = random.nextInt(2);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.BOTTOM_LEFT_CORNER)
        {
            int moveInt = random.nextInt(2);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.BOTTOM_RIGHT_CORNER)
        {
            int moveInt = random.nextInt(2);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.TOP)
        {
            int moveInt = random.nextInt(3);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 2)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.BOTTOM)
        {
            int moveInt = random.nextInt(3);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 2)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.LEFT)
        {
            int moveInt = random.nextInt(3);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
            else if (moveInt == 2)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
        else if (checkPlace(this.getPositionY(), this.getPositionX()) == Place.RIGHT)
        {
            int moveInt = random.nextInt(3);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
            else if (moveInt == 2)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
        else
        {
            int moveInt = random.nextInt(4);
            if (moveInt == 0)
            {
                this.collisionNeeded(posX - 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() - 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 1)
            {
                this.collisionNeeded(posX + 1, posY);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX() + 1, this.getPositionY());
                this.movePermission = true;
            }
            else if (moveInt == 2)
            {
                this.collisionNeeded(posX, posY - 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                this.movePermission = true;
            }
            else if (moveInt == 3)
            {
                this.collisionNeeded(posX, posY + 1);
                if (this.movePermission == true)
                    this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                this.movePermission = true;
            }
        }
    }
    public void collisionNeeded(int posX, int posY)
    {
        if (checkCollisionPlace(posY, posX) == Place.SAME_ORGANISM)
        {
            this.collision();
        }
        else if (checkCollisionPlace(posY, posX) == Place.DIFFERENT_ORGANISM)
        {
            for (Organism o : getWorld().getOrganisms())
            {
                if (o == this)
                {
                    continue;
                }
                if (posX == o.getPositionX() && posY == o.getPositionY())
                {
                    this.collisionOther(o);
                }
            }
        }
    }
    public Place checkCollisionPlace(int y, int x)
    {
        for (Organism o : getWorld().getOrganisms())
        {
            if (this == o)
            {
                continue;
            }
            else if (x == o.getPositionX() && y == getPositionY() && o.draw() == this.draw())
            {
                return Place.SAME_ORGANISM;
            }
            else if (x == o.getPositionX() && y == getPositionY())
            {
                return Place.DIFFERENT_ORGANISM;
            }
        }
        return null;
    }
    public Place checkPlace(int y, int x)
    {
        if (y == 0 && x == 0)
        {
            return Place.TOP_LEFT_CORNER;
        }
        else if (y == 0 && x == getWorld().getWorldX() - 1)
        {
            return Place.TOP_RIGHT_CORNER;
        }
        else if (y == getWorld().getWorldY() - 1 && x == 0)
        {
            return Place.BOTTOM_LEFT_CORNER;
        }
        else if (y == getWorld().getWorldY() - 1 && x == getWorld().getWorldX() - 1)
        {
            return Place.BOTTOM_RIGHT_CORNER;
        }
        else if (x == 0)
        {
            return Place.LEFT;
        }
        else if (x == getWorld().getWorldY() - 1)
        {
            return Place.RIGHT;
        }
        else if (y == 0)
        {
            return Place.TOP;
        }
        else if (y == getWorld().getWorldX() - 1)
        {
            return Place.BOTTOM;
        }
        return null;
    }
}
