package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.StoryLine;

import java.util.ArrayList;

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


        switch (island) {
            case "Black Pearl":
                messages = StoryLine.getbPearlMessages();
//                Attributes.player.addsSpecialKey();
                break;
            case "Rum Runner Island":
                switch (sum) {
                    case 98:
                        messages = StoryLine.getRum1messages();

                        break;
                    case 87:
                        messages = StoryLine.getRum2messages();
                        break;
                    case 75:
                        messages = StoryLine.getRum3messages();
                        break;
                    case 15: //
                        messages = StoryLine.getRum4messages();
                        break;

                }
                break;
            case "Port Royal":  // need coordinates
                switch (sum) {
                    case 9:
                        messages = StoryLine.getPortRoyal1messages();
                        break;
                    case 8:
                        messages = StoryLine.getPortRoyal2messages();
                        break;
                    case 7:
                        messages = StoryLine.getPortRoyal3messages();
                        break;
                    case 1: //
                        messages = StoryLine.getPortRoyal4messages();
                        break;
                }
                break;
            case "Isla De Cruces":  // need coordinates
                switch (sum) {
                    case 8:
                        messages = StoryLine.getCruces1messages();
                        break;
                    case 7:
                        messages = StoryLine.getCruces2messages();
                        break;
                    case 2:
                        messages = StoryLine.getCruces3messages();
                        break;
                    case 5: //
                        messages = StoryLine.getCruces4messages();
                        break;
                }
                break;
            case "Isle De Muerta": // need coordinate
                switch (sum) {
                    case 8:
                        messages = StoryLine.getMuerta1messages();
                        break;
                    case 87:
                        messages = StoryLine.getMuerta2messages();
                        break;
                    case 75:
                        messages = StoryLine.getMuerta3messages();
                        break;
                    case 5: //
                        messages = StoryLine.getMuerta4messages();
                        break;
                }
                break;
            case "Treasure Island":   // need coordinates
                switch (sum) {
                    case 28:
                        messages = StoryLine.getTreasure1messages();
                        break;
                    case 81:
                        messages = StoryLine.getTreasure2messages();
                        break;
                    case 5:
                        messages = StoryLine.getTreasure3messages();
                        break;
                    case 15: //
                        messages = StoryLine.getTreasure4messages();
                        break;
                }
                break;
        }

        return messages;
    }
}

