package com.treasure;

import com.treasure.components.*;
import com.treasure.gui.Board;
import com.treasure.gui.Music;
import com.treasure.util.Methods;
import com.treasure.util.StoryLine;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame window;
    private static Board board;

    public static void main(String[] args) {
        System.out.println("MAIN CLASS: Initializing....");
        createMainWindow();
        createBoard();
        StartGame();
    }

    private static void createMainWindow(){
        System.out.println("MAIN CLASS: CREATING WINDOW...");
        window = new JFrame("Treasure Island");
        window.setVisible(true);
        window.setResizable(false);
        window.setBounds(100, 10, Attributes.windowWidth, Attributes.windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void createBoard(){
        System.out.println("MAIN CLASS: CREATING BOARD....");
        board = new Board();

//        JTextField tf = new JTextField();
//        tf.setBackground(Color.cyan);
//        JScrollPane pane = new JScrollPane(tf);
//        pane.setSize(Attributes.windowWidth - 20, Attributes.windowHeight - 700);
//
//        board.add(pane);
        window.add(board);
        board.requestFocusInWindow();
    }

    //Start Game
    public static void StartGame() {
        System.out.println("MAIN CLASS: STARTING GAME....");
        Attributes.currentIsland = new Island(Island.getIslandNumber()); //starts at island 0 .txt
        Attributes.currentMap = new Maps(Maps.getMapNumber());
        System.out.println("\nMAIN CLASS: CREATING STORYLINE");
        StoryLine.createStoryline();
//        Music.playMusic("/Users/bradsmialek/tlg/java/projects/treasure/src/com/treasure/music/song1.wav");

        Attributes.player = new Player(19, 18);
        Attributes.pirates = new ArrayList<Pirate>();
        Attributes.peopleInterests = new ArrayList<PeopleInterest>();
        Attributes.clues = new ArrayList<Clues>();
//        Attributes.friendlies = new ArrayList<Friend>();  maybe make friendlies move??
        Methods.initializeTiles();
    }
}
