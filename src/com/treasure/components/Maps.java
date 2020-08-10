package com.treasure.components;

import com.treasure.util.FileManager;
import com.treasure.util.Tile;

import java.util.ArrayList;

public class Maps {
    private ArrayList<ArrayList<Tile>> tiles;

    private static int mapNumber = 0;

    public Maps(int mapNumber) {
        Maps.setMapNumber(mapNumber );
        System.out.println("MAP CLASS: CREATING MAP "+mapNumber);

        tiles = new ArrayList<ArrayList<Tile>>();

        ArrayList<String> strs = FileManager.readIslandFile("src/com/treasure/maps/map"
                +mapNumber+".txt");

        for(int i = 0; i < strs.size()-1 ; i++) {
            char[] charray = strs.get(i).toCharArray();
            tiles.add(new ArrayList<Tile>());
            for (char c : charray) {
                switch (c) {
                    case '.':
                        tiles.get(i).add(Tile.NOTHING);
                        break;
                    case '#':
                        tiles.get(i).add(Tile.WALL);
                        break;
                    case '@':
                        tiles.get(i).add(Tile.PLAYER);
                        break;
                    case '^':
                        tiles.get(i).add(Tile.DOCK);
                        break;
                    case 'r':
                        tiles.get(i).add(Tile.RUM);
                        break;
                    case 'g':
                        tiles.get(i).add(Tile.GOLD);
                        break;
                    case 'm':
                        tiles.get(i).add(Tile.TREASURE);
                        break;
                    case '!':
                        tiles.get(i).add(Tile.KEY);
                        break;
                    case '/':
                        tiles.get(i).add(Tile.DOOR);
                        break;
                    case 'p':
                        tiles.get(i).add(Tile.PIRATE);
                        break;
                    case 'f':
                        tiles.get(i).add(Tile.FRIENDLY);
                        break;
                    case '&':
                        tiles.get(i).add(Tile.BLACKJACK);
                        break;
                    case 'c':
                        tiles.get(i).add(Tile.COINTOSS);
                        break;
                    case '$':
                        tiles.get(i).add(Tile.LOTTERY);
                        break;
                    case 'V':
                        tiles.get(i).add(Tile.VENDOR);
                        break;
                    case '+':
                        tiles.get(i).add(Tile.PLUS);
                        break;
                    case '*':
                        tiles.get(i).add(Tile.MAP);
                        break;
                    case 'X':
                        tiles.get(i).add(Tile.X);
                        break;
                    case '~':
                        tiles.get(i).add(Tile.TILDE);
                        break;
                    case ' ':
                        tiles.get(i).add(Tile.SPACE);
                        break;
                    case '?':
                        tiles.get(i).add(Tile.POI);
                        break;
                    case '`':
                        tiles.get(i).add(Tile.CLUE);
                        break;

                    //Alphabet characters
                    case 'A':
                        tiles.get(i).add(Tile.A);
                        break;
                    case 'B':
                        tiles.get(i).add(Tile.B);
                        break;
                    case 'C':
                        tiles.get(i).add(Tile.C);
                        break;
                    case 'D':
                        tiles.get(i).add(Tile.D);
                        break;
                    case 'E':
                        tiles.get(i).add(Tile.E);
                        break;
                    case 'F':
                        tiles.get(i).add(Tile.F);
                        break;
                    case 'G':
                        tiles.get(i).add(Tile.G);
                        break;
                    case 'H':
                        tiles.get(i).add(Tile.H);
                        break;
                    case 'I':
                        tiles.get(i).add(Tile.I);
                        break;
                    case 'J':
                        tiles.get(i).add(Tile.J);
                        break;
                    case 'K':
                        tiles.get(i).add(Tile.K);
                        break;
                    case 'L':
                        tiles.get(i).add(Tile.L);
                        break;
                    case 'M':
                        tiles.get(i).add(Tile.M);
                        break;
                    case 'N':
                        tiles.get(i).add(Tile.N);
                        break;
                    case 'O':
                        tiles.get(i).add(Tile.O);
                        break;
                    case 'P':
                        tiles.get(i).add(Tile.P);
                        break;
                    case 'Q':
                        tiles.get(i).add(Tile.Q);
                        break;
                    case 'R':
                        tiles.get(i).add(Tile.R);
                        break;
                    case 'S':
                        tiles.get(i).add(Tile.S);
                        break;
                    case 'T':
                        tiles.get(i).add(Tile.T);
                        break;
                    case 'U':
                        tiles.get(i).add(Tile.U);
                        break;
                    //V for Vendor
                    case 'W':
                        tiles.get(i).add(Tile.W);
                        break;
                    case 'Y':
                        tiles.get(i).add(Tile.Y);
                        break;
                    case 'Z':
                        tiles.get(i).add(Tile.Z);
                        break;

                        // STORE ITEMS
                    case '=':
                        tiles.get(i).add(Tile.SOAP);
                        break;
                    case '|':
                        tiles.get(i).add(Tile.SWORD);
                        break;
                    case ',':
                        tiles.get(i).add(Tile.APPLE);
                        break;
                    case ';':
                        tiles.get(i).add(Tile.WHISKEY);
                        break;
                    case '}':
                        tiles.get(i).add(Tile.BOW);
                        break;
                    case '[':
                        tiles.get(i).add(Tile.CORN);
                        break;
                    case '"':
                        tiles.get(i).add(Tile.XP);
                        break;

                    // NUMBERS
                    case '1':
                        tiles.get(i).add(Tile.ONE);
                        break;
                    case '2':
                        tiles.get(i).add(Tile.TWO);
                        break;
                    case '3':
                        tiles.get(i).add(Tile.THREE);
                        break;
                    case '4':
                        tiles.get(i).add(Tile.FOUR);
                        break;
                    case '5':
                        tiles.get(i).add(Tile.FIVE);
                        break;
                    case '6':
                        tiles.get(i).add(Tile.SIX);
                        break;
                    case '7':
                        tiles.get(i).add(Tile.SEVEN);
                        break;
                    case '8':
                        tiles.get(i).add(Tile.EIGHT);
                        break;
                    case '9':
                        tiles.get(i).add(Tile.NINE);
                        break;
                    case '0':
                        tiles.get(i).add(Tile.ZERO);
                        break;

                }
            }
        }
    }


    //Gets the size of the floor on the y coordinate
    public int getHeight() {
        return tiles.size();
    }

    //Gets the size of the floor on the x coordinate
    public int getWidth() {
        return tiles.get(0).size();
    }

    public static void setMapNumber(int islandNumber) {
        Maps.mapNumber = islandNumber;
    }

    public static int getMapNumber() {
        return mapNumber;
    }
    //Returns one tile of the floor
    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    //Returns one tile of the floor
    public char getTileChar(int x, int y) {
        return tiles.get(y).get(x).symbol();
    }
}

