package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.StoryLine;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/9/20 @ 2:40 PM
 */
public class Clues{

    public static ArrayList<String> clueTree(Directions direction, String island) {

        int clueX=0, clueY=0;

        switch(direction) {
            case UP:
                clueX = Attributes.player.getx(); clueY = Attributes.player.gety()-1; break;
            case LEFT:
                clueX = Attributes.player.getx()-1; clueY = Attributes.player.gety(); break;
            case DOWN:
                clueX = Attributes.player.getx(); clueY = Attributes.player.gety()+1; break;
            case RIGHT:
                clueX = Attributes.player.getx()+1; clueY = Attributes.player.gety(); break;
        }
        int sum = clueX+clueY;
        System.out.println("CLUE is at "+clueX+ " "+ clueY);
        System.out.println(sum);

        ArrayList<String> messages = new ArrayList<>();

        switch (island) {
            case "Black Pearl":
                messages = StoryLine.getbPearlClues();
                break;
            case "Rum Runner Island":
                if (sum == 58) {
                    messages = StoryLine.getRum1Clues();
                }
                break;
            case "Port Royal":
                if (sum == 77) {
                    messages = StoryLine.getPortRoyal1Clues();
                }
                break;
            case "Isla De Cruces":
                if (sum == 52) {
                    messages = StoryLine.getCruces1Clues();
                }
                break;
            case "Isle De Muerta":
                if (sum == 66) {
                    messages = StoryLine.getMuerta1Clues();
                }
                break;
            case "Treasure Island":
                if (sum == 66) {
                    messages = StoryLine.getTreasure1Clues();
                }
                break;
        }

        return messages;
    }

}

