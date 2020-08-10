package com.treasure.components;

import com.treasure.util.Directions;

public class Player extends Entity {

    private Directions facing;
    private int keys;
    private int gold;

    private int specialKeys = 0;
    private int specialMaps = 0;
    private int emerald = 0;
    private boolean alive;


    public Player(int x, int y) {
        super(x, y, 20);
        this.gold=0;
//        this.equippedWeapon = Weapon.hand;
//        this.equippedArmor = Armor.normal;
        this.alive=true;
        System.out.println("PLAYER CLASS: CREATING PLAYER AT "+x+ " "+y);
    }

    @Override
    public void move(Directions dir){
        super.move(dir);
        System.out.println("\nPLAYER CLASS: POSITION IS NOW "+x+" "+y);
    }

    public void move() {
        this.move(facing);
    }

    public void setFacing(Directions dir) {
        this.facing = dir;
    }

    public Directions getFacing() {
        return facing;
    }

    public int getsKeys() {
        return keys;
    }

    public void addsKey() {
        keys++;
    }

    public void takesKey() {
        if(keys>0)
            keys--;
    }

    public void addsSpecialKey(){
        specialKeys++;
    }

    public void addsSpecialMaps(){
        specialMaps++;
    }

    public void addsEmerald(){
        emerald++;
    }

    public int getSpecialKeys() {
        return specialKeys;
    }

    public int getSpecialMaps() {
        return specialMaps;
    }

    public int getEmerald() {
        return emerald;
    }

    public int getsGold() {
        return gold;
    }

    public void addsGold(int amount) {
        gold+=amount;
    }

    public void takesGold(int amount) {
        gold-=amount;
    }

    public void addsXP(int amount){
        xp+= amount;
        setLevel(this.xp);
    }


    public boolean isLiving() {
        return alive;
    }

    public void setDead() {
        this.alive = false;
    }

}

