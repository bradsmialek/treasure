package com.treasure.util;

import com.sun.source.doctree.AttributeTree;
import com.treasure.Attributes;
import com.treasure.components.*;

import java.util.ArrayList;
import java.util.Random;


public class Methods {
    private static String message = " ";
    private static String message2 = " ";
    private static String message3 = " ";
    private static String message4 = " ";
    private static String message5 = " ";
    private static String message6 = " ";
    private static boolean yesNo = false;
    public static Directions direction;

    public static void initializeTiles(){

        Attributes.pirates.clear();

        for (int y = 0; y < Attributes.currentIsland.getHeight()-1; y++) {
            for (int x = 0; x < Attributes.currentIsland.getWidth()-1; x++) {
                switch (Attributes.currentIsland.getTile(x,y)) {
                    case PLAYER:
                        Attributes.player.setPos(x, y);
                        break;
                    case PIRATE:
                        Attributes.pirates.add(new Pirate("pirate", x, y, 5, x)); // TODO make strength and or defense
                        break;
//                    case FRIENDLY:
//                        Attributes.friendlys.add(new Friendly("Friendly", x, y));  //  maybe??
//                        break;
                    default:
                        break;
                }
            }
        }
    }

    //TODO test me
    public static int getRandomNumber(int n) {
        Random rand = new Random();
//        if ()
        return rand.nextInt(n) +1;
    }

    public static void playerHandler(Directions dir) throws Exception {

//        direction = dir;
        Tile tile = null;

        switch(dir) {
            case UP:
                tile = Attributes.currentIsland.getTile(Attributes.player.getx(), Attributes.player.gety()-1);
                break;
            case LEFT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getx()-1, Attributes.player.gety());
                break;
            case DOWN:
                tile = Attributes.currentIsland.getTile(Attributes.player.getx(), Attributes.player.gety()+1);
                break;
            case RIGHT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getx()+1, Attributes.player.gety());
                System.out.println(tile);
                break;
        }

        //Handles the player movement
        switch(tile){
            case NOTHING:
                Attributes.currentSubGame = SubGames.NONE;
                decided = Decision.NONE;
                Attributes.player.move(dir);
                // every time player moves previous displayed message will dissapear
                message = " ";
                message2 = " ";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
                message2 = " ";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
                break;
            case DOCK:
                message = "Do you want to return to your Ship?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.RETURN_TO_SHIP;
                break; //Randomly change floor
            case RUM:
                message = "You found Rum! Do you want to drink it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.RUM_UP;
                break;
            case GOLD:
                Attributes.player.move(dir);
                Attributes.player.addsGold(Methods.getRandomNumber(3)+2);
                message = "You picked up gold!";
                message2 = " ";
                message3 = " ";
                break;
            case TREASURE:
                message = "You found a chest.  Do you want to open it!";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.OPEN_TREASURE;
                break; //Ask to open chest
            case KEY:
                Attributes.player.move(dir);
                Attributes.player.addsKey();
                message = "You picked up a normal key! Must be something nearby to unlock?";
                message2 = " ";
                message3 = " ";
                break; //Adds a key
            case DOOR:
                message = "This door is locked. Do you want to use a key and open it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.OPEN_DOOR;
                break; //Ask to open door
            case PIRATE:
                Methods.fightPirate(dir);
//                message = "Fight the pirate!?";
//                message2 = "   [Y] Yes     [N] No";
//                message3 = " ";
//                message4 = " ";
//                message5 = " ";
//                message6 = " ";
//                decided = Decision.FIGHT_PIRATE;

                break; //Handles encounters with pirates
            case FRIENDLY:
                RandomMessage.getRandomMessage();
                // drops random items with random generator
                break;
            case MAP:
                message = "Where would you like to sail to?";
                message2 = " ";
                message3 = "Rum Runner Isle [2]    Port Royal [3]    Isla De Cruces [4]";
                message4 = "Isle De Muerta [5]    Treasure Island [6]";
                message5 = " ";
                message6 = " ";
                locationDecided = LocationDecision.LOCATION;
                break;
            case VENDOR:
                message = "Would you like to enter the Vendor's shop?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
                decided = Decision.VENDOR;
                break;
            case POI:
                message = "Would you like to talk?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
                decided = Decision.TALK;
                break;
            case COINTOSS:
                message = "Would you like to play CoinToss for 5 Gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.COIN_TOSS;
                break;
            case CLUE:
                message = "You found a clue. Would you like to read it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                message4 = " ";
                decided = Decision.CLUE;
                break;
            case BLACKJACK:
                message = "Would you like to play BlackJack for 1 Gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.PLAY_BLACKJACK;
                break;
            case LOTTERY:
                message = "Would you like to play the Lottery for 50 Gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.PLAY_LOTTERY;
                break;
            case SOAP:
                message = "You would you like to purchase soap you dirty pirate?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.SOAP;
                break;
            case SWORD:
                message = "You would you like to purchase a trusty sword?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.SWORD;
                break;
            case BOW:
                message = "You would you like to purchase this fine bow?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.BOW;
                break;
            case APPLE:
                message = "You would you like to purchase a delicious apple?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.APPLE;
                break;
            case CORN:
                message = "You would you like to purchase some rare corn?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.CORN;
                break;
            case WHISKEY:
                message = "You would you like to purchase whiskey to drink your worries away?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.WHISKEY;
                break;
            case XP:
                Attributes.player.addsXP(200);
                message = "You would you like to purchase XP points?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.XP;
                break;
            default:
                System.out.println("Where are you??? You must be lost!");
        }
    }


    private enum LocationDecision {
        LOCATION,
        NOWHERE;
    }

    private enum Decision {
        NONE,
        RUM_UP,
        COIN_TOSS,
        RETURN_TO_SHIP,
        OPEN_DOOR,
        OPEN_TREASURE, //TODO give random good thing
        CLUE,
        FIGHT_PIRATE, // drops stuff
        TALK,
        PLAY_BLACKJACK,
        PLAY_LOTTERY,
        VENDOR,
        CORN,
        WHISKEY,
        SWORD,
        APPLE,
        BOW,
        XP,
        SOAP;
    }

    private enum CoinTossDecision {
        NONE,
        SIDEOFCOIN;
    }
    private static LocationDecision locationDecided = LocationDecision.NOWHERE;
    private static CoinTossDecision tossDecision = CoinTossDecision.NONE;
    private static Decision decided = Decision.NONE;


    //DECISION TREE
    public static void decisionTree(boolean yn) {

        if (decided == Decision.NONE) {
            return;
        }
        else if(decided == Decision.RETURN_TO_SHIP && yn) {
            Attributes.currentIsland = new Island(1);
            Attributes.currentMap = new Maps(1);
            message = "You have returned to your Ship!"; // 89 char
            message2 = " ";
            message3 = " ";
            Methods.initializeTiles();
        }
        else if (decided == Decision.RETURN_TO_SHIP) {
            message = "Arhg... Fine, stay here.";
            message2 = " ";
            message3 = " ";
        }
        else if(decided == Decision.RUM_UP && yn) {
            Attributes.player.heal(Methods.getRandomNumber(5)+3);
            Attributes.player.addsXP(2);
            message = "Down the hatchet...";
            message2 = "+ HP";
            message3 = "+2 XP";
            Attributes.player.move();//replace tile to .
        }
        else if(decided == Decision.RUM_UP) {
            message = "I'm too drunk already!";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.COIN_TOSS && yn) {
            if (Attributes.player.getsGold() >= 5) {
                message = "Heads or Tails?";
                message2 = "    [H]        [T]";
                tossDecision = CoinTossDecision.SIDEOFCOIN;
            }
            else {
                message = "You don't have enough Gold...";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.COIN_TOSS) {
            message = "'I'd rather not lose me money...'";
            message2 = " ";
        }
        else if(decided == Decision.OPEN_DOOR && yn) {
            if (Attributes.player.getsKeys() >= 1) {
                Attributes.player.takesKey();
                Attributes.player.addsXP(2);
                message = "You opened the door!";
                message2 = " On with ye discovery...";
                message3 = "+2 XP"; //Open chest
                Attributes.player.move();
            }
            else{
                message = "You don't have any keys!";
                message2 = " ";
            }
        }
        else if(decided == Decision.OPEN_DOOR) {
            message = "You might be better off not knowing what's behind this door!";
            message2 = " ";
            message3 = " ";
        }
        else if(decided == Decision.CLUE && yn) {
            ArrayList<String> c = Clues.clueTree(Attributes.player.getFacing(), Island.getIslandName(Island.getIslandNumber()));////TODO
            message = c.get(0);
            message2 = c.get(1);
            message3 = c.get(2);
            message4 = c.get(3);
            message5 = c.get(4);
            message6 = c.get(5);
        }
        else if (decided == Decision.CLUE) {
            message = "Alright ... but it could be a good clue!";
            message2 = " ";
            message3 = " ";
        }
        else if(decided == Decision.TALK && yn) {
            ArrayList<String> m = PeopleInterest.poiTree(Attributes.player.getFacing(), Island.getIslandName(Island.getIslandNumber()));
            System.out.println(m);
            message = m.get(0);
            message2 = m.get(1);
            message3 = m.get(2);
            message4 = m.get(3);
            message5 = m.get(4);
            message6 = m.get(5);
        }
        else if(decided == Decision.TALK) {
            message = "They might have something important to tell you!";
            message2 = " ";
            message3 = " ";
            message4 = " ";
            message5 = " ";
            message6 = " ";
        }
        else if(decided == Decision.FIGHT_PIRATE && yn) {
            Methods.fightPirate(direction);

        }
        else if (decided == Decision.FIGHT_PIRATE) {
            message = "That pirate might have fucked you up...hahahaha. Good choice matey!!";
            message2 = " ";
            message3 = " ";
            message4 = " ";
            message5 = " ";
            message6 = " ";
        }
        else if(decided == Decision.OPEN_TREASURE && yn) {
            if (Attributes.player.getsKeys() >= 1) {
                Attributes.player.takesKey();
                Attributes.player.addsXP(2);
                Attributes.player.addsGold(20);
                message = "You opened the chest!";
                message2 = " On with ye discovery...";
                message3 = "+2 XP"; //Open chest
                message4 = "+20 Gold";
                Attributes.player.move();
            }
            else{
                message = "You don't have any keys!";
                message2 = " ";
            }

        }
        else if (decided == Decision.OPEN_TREASURE) {
            message = "Yeah, you're right... there could be snake or a critter of your dislike in there!";
            message2 = " ";
            message3 = " ";
            message4 = " ";
            message5 = " ";
            message6 = " ";
        }
        else if(decided == Decision.PLAY_BLACKJACK && yn) {
            BlackJackGame.playBlackJack();

        }
        else if (decided == Decision.PLAY_BLACKJACK) {
            message = "Alright then";
            message2 = "";
            message3 = " ";
        }
        else if (decided == Decision.PLAY_LOTTERY && yn) {
            if (Attributes.player.getsGold() >= 50) {
                LotteryGame.playLottery();
            }
            else {
                message = "You don't have enough Gold...";
                message2 = " ";
                message3 = " ";
            }
        }
        else if (decided == Decision.PLAY_LOTTERY) {
            message = "'I'd rather not lose me money...'";
            message2 = " ";
            message3 = " ";
        }

        else if(decided == Decision.VENDOR && yn) {
            if(Attributes.player.getsLevel()>=3){
                message = "Please explore my store. My stock is low.";
                message2 = " ";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
                Attributes.currentMap = new Maps(7);
                Attributes.currentIsland = new Island(7);
                Methods.initializeTiles();
            }else{
                message = "You must be a level 3 to use the Vendor shop.";
                message2 = " ";
                message3 = " ";
                message4 = " ";
                message5 = " ";
                message6 = " ";
            }
        }
        else if(decided == Decision.VENDOR) {
            message = "Another time then...";
            message2 = " ";
            message3 = " ";
        }

        else if(decided == Decision.XP && yn) {
            if(Attributes.player.getsGold()>=1000) {
                message = "Thanks for buying!";
                message2 = "+100 XP";
                message3 = " ";
                Attributes.player.takesGold(1000);
                Attributes.player.addsXP(100);
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.XP) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.APPLE && yn) {
            if(Attributes.player.getsGold()>=1 && Attributes.player.getHealth()<20)  {
                message = "Thanks for buying!";
                message2 = "+2 HP";
                message3 = " ";
                Attributes.player.takesGold(1);
                Attributes.player.heal(2);
            }
            else if(Attributes.player.getHealth() == 20){
                message = "You're HP is already full.";
                message2 = " ";
                message3 = " ";
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.APPLE) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.SWORD && yn) {
            if(Attributes.player.getsGold()>=250) {
                message = "Thanks for buying!";
                message2 = "+4 STR";
                message3 = " ";
                Attributes.player.takesGold(250);
//                Attributes.player.addsStrength(4);
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.SWORD) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.SOAP && yn) {
            if(Attributes.player.getsGold()>=20 && Attributes.player.getHealth()<20) {
                message = "Thanks for buying!";
                message2 = "+10 HP";
                message3 = " ";
                Attributes.player.takesGold(20);
                Attributes.player.heal(10);
            }
            else if(Attributes.player.getHealth() == 20){
                message = "You're HP is already full.";
                message2 = " ";
                message3 = " ";
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.SOAP) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.BOW && yn) {
            if(Attributes.player.getsGold()>=200) {
                message = "Thanks for buying!";
                message2 = "+3 STR";
                message3 = " ";
                Attributes.player.takesGold(200);
//                Attributes.player.addsStrength(3);
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.BOW) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.WHISKEY && yn) {
            if(Attributes.player.getsGold()>=4 && Attributes.player.getHealth()<20) {
                message = "Thanks for buying!";
                message2 = "+7 HP";
                message3 = " ";
                Attributes.player.takesGold(4);
                Attributes.player.heal(7);
            }
            else if(Attributes.player.getHealth() == 20){
                message = "You're HP is already full.";
                message2 = " ";
                message3 = " ";
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.WHISKEY) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.CORN && yn) {
            if(Attributes.player.getsGold()>=2 && Attributes.player.getHealth()<20) {
                message = "Thanks for buying!";
                message2 = "+5 HP";
                message3 = " ";
                Attributes.player.takesGold(2);
                Attributes.player.heal(5);
            }
            else if(Attributes.player.getHealth() == 20){
                message = "You're HP is already full.";
                message2 = " ";
                message3 = " ";
            }
            else{
                message = "You don't have enough gold.";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.CORN) {
            message = "Thanks";
            message2 = "";
            message3 = "";
        }

        decided = Decision.NONE;
    }

    //LOCATION TREE
    public static void locationTree(int islandNumber) {

        System.out.println(islandNumber);
        if (locationDecided == LocationDecision.NOWHERE) {
            return;
        }
        else if ( islandNumber == 2) {
            Attributes.currentIsland = new Island(2);
            Attributes.currentMap = new Maps(2);
            Methods.initializeTiles();
        }
        else if (islandNumber == 3) {
            if(Attributes.player.getSpecialMaps()>=1){
                Attributes.currentIsland = new Island(3);
                Attributes.currentMap = new Maps(3);
                Methods.initializeTiles();
            }else{
                message = "You need a piece of the map to get to Port Royal!";
                message2 = "";
                message3 = "";
                message4 = "";
                message5 = "";
            }

        }
        else if (islandNumber == 4) {
            if(Attributes.player.getSpecialMaps()>=2){
                Attributes.currentIsland = new Island(4);
                Attributes.currentMap = new Maps(4);
                Methods.initializeTiles();
            }else{
                message = "You need a piece of the map to get to Isla De Cruces!";
                message2 = "";
                message3 = "";
                message4 = "";
                message5 = "";
            }
        }
        else if (islandNumber == 5) {
            if(Attributes.player.getSpecialMaps()>=3){
                Attributes.currentIsland = new Island(5);
                Attributes.currentMap = new Maps(5);
                Methods.initializeTiles();
            }else{
                message = "You need a piece of the map to get to Isle De Muerta!";
                message2 = "";
                message3 = "";
                message4 = "";
                message5 = "";
            }
        }
        else if (islandNumber == 6) {
            if(Attributes.player.getSpecialMaps()>=4 && Attributes.player.getSpecialKeys()==3 && Attributes.player.getEmerald()==1){
                Attributes.currentIsland = new Island(6);
                Attributes.currentMap = new Maps(6);
                Methods.initializeTiles();
            }else{
                message = "You need the map, 3 special keys, and a green emerald to get to Treasure Island!";
                message2 = "";
                message3 = "";
                message4 = "";
                message5 = "";
            }
        }
        else {
            message = "Argh... fine, stay here.";
        }
        locationDecided = LocationDecision.NOWHERE;
    }

    public static void coinTossTree(String chooseCoinSide) {
        HeadsOrTails.coinToss();
        System.out.println(chooseCoinSide);
        if (tossDecision == CoinTossDecision.NONE) {
            return;
        }
        else if (chooseCoinSide.equals("Heads")) {
            System.out.println("You chose heads");
            message = "You chose Heads...";
            if (HeadsOrTails.coinSide.equals("Heads")) {
                Attributes.player.addsGold(5);
                Attributes.player.addsXP(2);
                message2 = "Coin landed on Heads...";
                message3 = "You Win!";
                message4 = "+5 Gold";
                message5 = "+2 XP";
            }
            else {
                message = "Coin landed on Tails...";
                message2 = "You Lose!";
                message4 = "-5 Gold";
                Attributes.player.takesGold(5);
            }
        }
        else if (chooseCoinSide.equals("Tails")) {
            System.out.println("You chose Tails");
            message = "You chose Tails";
            if (HeadsOrTails.coinSide.equals("Tails")) {
                Attributes.player.addsGold(5);
                Attributes.player.addsXP(2);
                message2 = "Coin landed on Tails...";
                message3 = "You Win!";
                message4 = "+5 Gold";
                message5 = "+2 XP";
            }
            else {
                message = "Coin landed on Heads...";
                message2 = "You Lose!";
                message4 = "-5 Gold";
                Attributes.player.takesGold(5);
            }
        }
        else {
            message = "Argh... I hate this game.";
        }
        tossDecision = CoinTossDecision.NONE;
    }

    public static void setMessage(String bjMessage) {message = bjMessage;}
    public static void setMessage2(String bjMessage2) {message2 = bjMessage2;}
    public static void setMessage3(String bjMessage3) {message3 = bjMessage3;}
    public static void setMessage4(String bjMessage4) {message4 = bjMessage4;}
    public static void setYn(boolean yn) {yesNo = yn;}

    public static boolean getYesNo() {return yesNo;}

    // Returns messages
    public static String getMessage() {return message;}

    public static String getMessage2() {return message2;}

    public static String getMessage3() {return message3;}

    public static String getMessage4() {return message4;}

    public static String getMessage5() {return message5;}

    public static String getMessage6() {return message6;}

    public static void movePirates() {
        for(int i=0;i<Attributes.pirates.size();i++) {
            System.out.println("pirate x:"+ Attributes.pirates.get(i).getx()+"y:"+ Attributes.pirates.get(i).gety());
            System.out.println("player x:"+ Attributes.player.getx()+"y:"+ Attributes.player.gety());
            Attributes.pirates.get(i).randomMove();
        }
    }

    public static void fightPirate(Directions direction) {
        int pirateX=0, pirateY=0;
        System.out.println(direction);

        switch(direction) {
            case UP:
                pirateX = Attributes.player.getx(); pirateY = Attributes.player.gety()-1; break;
            case LEFT:
                pirateX = Attributes.player.getx()-1; pirateY = Attributes.player.gety(); break;
            case DOWN:
                pirateX = Attributes.player.getx(); pirateY = Attributes.player.gety()+1; break;
            case RIGHT:
                pirateX = Attributes.player.getx()+1; pirateY = Attributes.player.gety(); break;
        }

        for(int i=0;i<Attributes.pirates.size();i++) {
//            System.out.println("pirate array size: "+Attributes.pirates.size());
//            System.out.println("pirate in array: "+Attributes.pirates.get(i).getpirx() + ", "+Attributes.pirates.get(i).getpiry() );
//            System.out.println("character: "+Attributes.player.getx() + ", "+Attributes.player.gety() );
//            System.out.println("new pirate x and y: "+pirateX+ ", " + pirateY );
            if(Attributes.pirates.get(i).getpirx() == pirateX && Attributes.pirates.get(i).getpiry() == pirateY) {
//                float playerAttack = Attributes.player.getStr()-(Attributes.pirates.get(i).getDef()/10)*Attributes.player.getStr();//--------------------TODO
//                float pirateAttck = Attributes.pirates.get(i).getStr()-(Attributes.player.getDef()/10)*Attributes.pirates.get(i).getStr();//--------------------TODO
                Attributes.pirates.get(i).damage(3);
                Attributes.player.damage(3);
                System.out.println(Attributes.pirates.get(i).getpirHealth());
                message2 = "You attacked the pirate and left him with "+Attributes.pirates.get(i).getpirHealth()+" HP!";
                message3 = "The pirate attacked you!";
            }
        }
    }

    public static void checkIsDead() {
        if(Attributes.player.getHealth()<=0) {
            message = "You died!";
            message2 = "Press any button to continue";
            message3 = " ";
            message4 = " ";
            Attributes.player.setDead();
            Attributes.currentIsland = new Island(0);
            Attributes.currentMap = new Maps(0);
            Methods.initializeTiles();
        }
    }
}
