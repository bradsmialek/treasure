package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.StoryLine;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/9/20 @ 2:40 PM
 */
public class Clues{

//    public Clues(int posX, int posY) {
//        super(posX, posY, 'c');
//        System.out.println("CLUES CLASS: CREATING CLUE AT "+posX+ " "+posY);
//
//    }

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


        if(island.equals("Black Pearl")){
            messages = StoryLine.getbPearlClues();
        }
        else if(island.equals("Rum Runner Island")){   //TODO   get positions where clues are created and put them in here as the case.  Look in console for sum
            switch(sum) {
                case 66:
                    messages = StoryLine.getRum1Clues();
                    break;
                case 34:
                    messages = StoryLine.getRum2messages();
                    break;
                case 25:
                    messages = StoryLine.getRum3messages();
                    break;
                case 29:
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }
        else if(island.equals("Rum Runner Island")){   //TODO   get positions where clues are created and put them in here as the case.  Look in console for sum
            switch(sum) {
                case 66:
                    messages = StoryLine.getRum1Clues();
                    break;
                case 34:
                    messages = StoryLine.getRum2messages();
                    break;
                case 25:
                    messages = StoryLine.getRum3messages();
                    break;
                case 29:
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }
        else if(island.equals("Rum Runner Island")){   //TODO   get positions where clues are created and put them in here as the case.  Look in console for sum
            switch(sum) {
                case 66:
                    messages = StoryLine.getRum1Clues();
                    break;
                case 34:
                    messages = StoryLine.getRum2messages();
                    break;
                case 25:
                    messages = StoryLine.getRum3messages();
                    break;
                case 29:
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }
        else if(island.equals("Rum Runner Island")){   //TODO   get positions where clues are created and put them in here as the case.  Look in console for sum
            switch(sum) {
                case 66:
                    messages = StoryLine.getRum1Clues();
                    break;
                case 34:
                    messages = StoryLine.getRum2messages();
                    break;
                case 25:
                    messages = StoryLine.getRum3messages();
                    break;
                case 29:
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }

        return messages;
    }

}

