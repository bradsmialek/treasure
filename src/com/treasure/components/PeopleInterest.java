package com.treasure.components;

import com.treasure.Attributes;
import com.treasure.util.Directions;
import com.treasure.util.StoryLine;

import java.util.ArrayList;

public class PeopleInterest  {


//    public PeopleInterest(int posX, int posY) {
//        super(posX, posY, 6);
//        System.out.println("PEOPLEINTEREST CLASS: CREATING POI AT "+posX+ " "+posY);
//
//    }

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
            switch(sum) {
                case 42:
                    messages = StoryLine.getRum1messages();
                    break;
                case 75:
                    messages = StoryLine.getRum2messages();
                    break;
                case 87:
                    messages = StoryLine.getRum3messages();
                    break;
                case 98: //
                    messages = StoryLine.getRum4messages();
                    break;

            }
        }

        return messages;
    }
}

