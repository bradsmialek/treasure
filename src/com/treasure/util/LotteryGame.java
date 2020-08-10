package com.treasure.util;

import com.treasure.Attributes;

public class LotteryGame {
    public static int randomNum(int x, int y){
        int random = x-((int)Math.round((Math.random())*(x-y)));
        System.out.println(random);
        return random;
    }

    public static void playLottery(){
        int randomNum1 = randomNum(1, 10);
        int randomNum2 = randomNum(1,10);
        if (randomNum1 == randomNum2) {
            Methods.setMessage("Your number today is: " + randomNum1);
            Methods.setMessage2("The winning number is: " + randomNum2);
            Methods.setMessage3("You Win!!!");
            Attributes.player.addsGold(1000);
            return;
        }
        else{
            Methods.setMessage("Your number today is: " + randomNum1);
            Methods.setMessage2("The winning number is: " + randomNum2);
            Methods.setMessage3("You Lose!!!");
            Attributes.player.takesGold(50);
            return;
        }
    }



}
