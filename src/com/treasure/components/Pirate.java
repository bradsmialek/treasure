package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.Methods;
import com.treasure.util.Tile;

public class Pirate extends Entity{

    private String name;


    public Pirate(String name, int x, int y, int health) {
        super(x, y, health);
        this.name=name;
        System.out.println("PIRATE CLASS: CREATING PIRATE AT "+x+ " "+y);
    }

    // Randomly moves pirate
    public void randomMove() {
        switch(Methods.getRandomNumber(4)) {
            case 1:
                System.out.println("case 1");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getx(), this.gety()-1));
                if(Attributes.currentIsland.getTile(this.getx(), this.gety()-1) == Tile.NOTHING)
                    super.move(Directions.UP);
                else if(Attributes.currentIsland.getTile(this.getx(), this.gety()-1) == Tile.PLAYER)
                    Methods.fightPirate(Directions.UP);
                break;
            case 2:
                System.out.println("case 2");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getx(), this.gety()-1));
                if(Attributes.currentIsland.getTile(this.getx()-1, this.gety()) == Tile.NOTHING)
                    super.move(Directions.LEFT);
                else if(Attributes.currentIsland.getTile(this.getx()-1, this.gety()) == Tile.PLAYER)
                    Methods.fightPirate(Directions.LEFT);
                break;
            case 3:
                System.out.println("case 3");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getx(), this.gety()-1));
                if(Attributes.currentIsland.getTile(this.getx(), this.gety()+1) == Tile.NOTHING)
                    super.move(Directions.DOWN);
                else if(Attributes.currentIsland.getTile(this.getx(), this.gety()+1) == Tile.PLAYER)
                    Methods.fightPirate(Directions.DOWN);
                break;
            case 4:
                System.out.println("case 4");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getx(), this.gety()-1));
                if(Attributes.currentIsland.getTile(this.getx()+1, this.gety()) == Tile.NOTHING)
                    super.move(Directions.RIGHT);
                else if(Attributes.currentIsland.getTile(this.getx()+1, this.gety()) == Tile.PLAYER)
                    Methods.fightPirate(Directions.RIGHT);
                break;

        }
    }
    public String getName() {return name;}


}

