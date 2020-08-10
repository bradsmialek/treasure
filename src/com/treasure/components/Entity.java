package com.treasure.components;

import com.treasure.util.Directions;

/**
 * Created by bradsmialek on Sun - 8/9/20 @ 3:07 PM
 */
public class Entity {

    protected static int x;
    protected static int y;

    protected static int pirx;
    protected static int piry;
    protected int pirhealth;
    protected int number;

    protected int health;
    protected int xp;
    protected int level = 1;
    protected int nextLevel = 50;
    protected int maxHealth;


    //Character and Pirate
    protected Entity(int x, int y, int health) {

        this.setPos(x, y);
        this.health=health;
        this.maxHealth=health;
    }
    protected Entity(int x, int y, int health, int number) {

        this.setpirPos(x, y);
        this.pirhealth=health;
        this.number = number;
    }

    //SETTERS

    // CHARACTER
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setpirPos(int x, int y){
        this.pirx = x;
        this.piry = y;
    }

    // GETTERS
    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getpirx() {
        return pirx;
    }

    public int getpiry() {
        return piry;
    }


    public int getHealth() {
        return health;
    }

    public int getpirHealth() {
        return pirhealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getXP() {
        return xp;
    }

    public void damage(int dmg){
        this.health -= dmg;
        this.pirhealth -= dmg;
    }

    public void heal(int amount){
        this.health+=amount;
        if (health>maxHealth)health=maxHealth;
    }

    public int getsLevel() {
        return level;
    }

    public int getNextLevel(){
        return nextLevel;
    }


    public void setLevel(int xp){

        if(xp>=400) {
            this.level = 6;
        }
        else if(xp>=275) {
            this.level = 5;
        }
        else if(xp>=175) {
            this.level = 4;
        }
        else if(xp>=100) {
            this.level = 3;
        }
        else if(xp>=50) {
            this.level = 2;
        }
        else{
            System.out.println("Error with levels");
        }
        setNextLevel(this.level);
    }

    public void setNextLevel(int level) {
        System.out.println("here at set next level");
        if(level == 6) {
            this.nextLevel = 600;
        }
        else if(level == 5) {
            this.nextLevel = 400;
        }
        else if(level == 4) {
            this.nextLevel = 275;
        }
        else if(level == 3) {
            this.nextLevel = 175;
        }
        else if(level == 2) {
            this.nextLevel = 100;
        }
        else if(level == 1) {
            this.nextLevel = 50;
        }
    }

    protected void move(Directions dir) {
        switch (dir) {
            case UP:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case DOWN:
                this.y++;
                break;
            case RIGHT:
                this.x++;
                break;
        }
    }
}

