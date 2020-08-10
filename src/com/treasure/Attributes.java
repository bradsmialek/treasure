package com.treasure;

import com.treasure.components.*;

import java.util.ArrayList;

public class Attributes {
    public static final int windowWidth = 1500;
    public static final int windowHeight = 1000;

    public static final int islandCount = 3;
    public static final int mapCount = 3;

    public static Island currentIsland;
    public static Maps currentMap;
    public static Player player;
    public static Vendor vendorItems = Vendor.getInstance();
    public static ArrayList<Pirate> pirates;
    public static ArrayList<PeopleInterest> peopleInterests;
    public static ArrayList<Clues> clues;


    public static Island getCurrentIsland() {
        return currentIsland;
    }

    public static Maps getCurrentMap() {
        return currentMap;
    }

}
