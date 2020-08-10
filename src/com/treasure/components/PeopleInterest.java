package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.StoryLine;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class PeopleInterest  {


    public static ArrayList<String> poiTree(Directions direction, String island) {

        int poiX=0, poiY=0;

        switch(direction) {
            case UP:
                poiX = Attributes.player.getx();
                poiY = Attributes.player.gety()-1;
                break;
            case LEFT:
                poiX = Attributes.player.getx()-1;
                poiY = Attributes.player.gety();
                break;
            case DOWN:
                poiX = Attributes.player.getx();
                poiY = Attributes.player.gety()+1;
                break;
            case RIGHT:
                poiX = Attributes.player.getx()+1;
                poiY = Attributes.player.gety();
                break;
        }
        int sum = poiX+poiY;
        System.out.println("POI is at "+poiX+ " "+ poiY);
        System.out.println(sum);

        ArrayList<String> messages = new ArrayList<>();


        if(island.equals("Black Pearl")){
            messages = StoryLine.getbPearlMessages();
        }
        else if(island.equals("Rum Runner Island")){
            switch (sum) {
                case 42:
                    messages = StoryLine.getRum1messages();
                    break;
                case 75:
                    messages = StoryLine.getRum2messages();
                    Attributes.player.addsSpecialMaps();
                    break;
                case 87:
                    messages = StoryLine.getRum3messages();
                    break;
                case 98: //
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }
        else if(island.equals("Port Royal")){
            switch(sum) {
                case 58:
                    messages = StoryLine.getPortRoyal1messages();
                    break;
                case 67:
                    messages = StoryLine.getPortRoyal2messages();
                    break;
                case 60:
                    messages = StoryLine.getPortRoyal3messages();
                    break;
                case 77: //
                    messages = StoryLine.getPortRoyal4messages();
                    Attributes.player.addsSpecialMaps();
                    break;

            }
        }
        else if(island.equals("Isla De Cruces")){
            switch(sum) {
                case 20:
                    messages = StoryLine.getCruces1messages();
                    Attributes.player.addsEmerald();
                    Attributes.player.addsSpecialMaps();
                    break;
                case 67:
                    messages = StoryLine.getCruces2messages();
                    break;
                case 78:
                    messages = StoryLine.getCruces3messages();
                    break;
                case 85: //
                    messages = StoryLine.getCruces4messages();
                    Attributes.player.addsSpecialKey();
                    break;

            }
        }
        else if(island.equals("Isle De Muerta")){
            switch(sum) {
                case 99:
                    messages = StoryLine.getMuerta1messages();
                    Attributes.player.getSpecialMaps();
                    break;
                case 61:
                    messages = StoryLine.getMuerta2messages();
                    break;
                case 58:
                    messages = StoryLine.getMuerta3messages();
                    Attributes.player.addsSpecialKey();
                    break;
                case 48: //
                    messages = StoryLine.getMuerta4messages();
                    break;
            }
        }
        else if(island.equals("Treasure Island")){
            switch(sum) {
                case 66:
                    messages = StoryLine.getTreasure1messages();
                    Attributes.player.addsSpecialKey();
                    break;
                case 63:
                    messages = StoryLine.getTreasure2messages();
                    Attributes.player.addsSpecialKey();
                    break;
                case 53:
                    messages = StoryLine.getTreasure3messages();
                    Attributes.player.addsSpecialKey();
                    break;
                case 92: //
                    messages = StoryLine.getTreasure4messages();
                    Attributes.player.addsSpecialKey();
                    Attributes.player.addsEmerald();
                    Attributes.player.addsSpecialMaps();
                    Attributes.player.addsGold(1000);
                    Attributes.player.addsXP(1000);
                    break;

            }

        }
        return messages;
    }
}

