package com.treasure.util;

import com.treasure.Attributes;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;


public class RandomMessage {
    @Override
    public String toString() {
        return "RandomMessage{}";
    }
    public static String rMessage= null;

    public static String [] messageArr =
            {
            "'Take a swig of this here rum, ye scumbag!'",
            "'I found this Gold just laying around...'",
            "'I'll be taking that Gold ye got there!'",
            "'*Hiccup* I think me be a bit drunk...'",
            "'Ahoy ye matey!'",
            "'Bloody pirates...'",
            "'Off with ye!'",
            "'Yo-ho and a bottle of rum!'",
            "'I heard one of ye shipmates has scurvy...'",
            "'Have ye seen me eye?'",
            "'Ever wonder why we have no free will... Uhhh, Oops! I mean Arghh!'"
            };

    public static String randomMessageGenerator() throws IOException {

        //call to api.  Limited to 60 calls a day.  also only 5 calls per hour

//        String host = "http://api.fungenerators.com/pirate/generate/insult";
//        System.out.println("RANDOM MESSAGE: [GET] "+host);
//
//        URL urlForGetRequest = new URL(host);
//        String readLine = null;
//        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        conection.setRequestMethod("GET");
//
//        int responseCode = conection.getResponseCode();
//        System.out.println(responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            } in .close();
//            // print result
//            System.out.println("JSON String Result " + response.toString());
//            rMessage = response.toString();
//
//        } else {
//            System.out.println("Response code: [" + responseCode + "]: Too many requests");
        Random randomMessage = new Random();

        int selectedMessage = randomMessage.nextInt(messageArr.length);
        rMessage = messageArr[selectedMessage];

        System.out.println("Random Message selected: " + rMessage);

//        }


        return rMessage;
    }

    public static void getRandomMessage() throws IOException {
        randomMessageGenerator();

        Methods.setMessage(rMessage);

        if (rMessage.equals(messageArr[0])) {
            Attributes.player.heal(Methods.getRandomNumber(5)+3);
            Attributes.player.addsXP(2);
            Methods.setMessage2("You drank some rum...");
            Methods.setMessage3("+ HP");
            Methods.setMessage4("+2 XP");


        }
        else if (rMessage.equals(messageArr[1])) {
            Attributes.player.addsXP(2);
            Attributes.player.addsGold(2);
            Methods.setMessage2("You got some Gold!");
            Methods.setMessage3("+2 Gold");
            Methods.setMessage4("+2 XP");
        }
        else if (rMessage.equals(messageArr[2])) {
            if (Attributes.player.getsGold() >= 5) {
                Attributes.player.takesGold(5);
                Methods.setMessage2("You lost some Gold!");
                Methods.setMessage3("-5 Gold");
                Methods.setMessage4("I guess he wasn't so friendly after all...");
            }
            else if (Attributes.player.getsGold() >= 1 && Attributes.player.getsGold() < 5) {
                Methods.setMessage2("You lost some Gold!");
                Methods.setMessage3("-"+Attributes.player.getsGold() + " Gold");
                Methods.setMessage4("I guess he wasn't so friendly after all...");
                Attributes.player.takesGold(Attributes.player.getsGold());

            }
            else {
                Methods.setMessage2("'What... are ye really that broke?!'");
                Methods.setMessage3("...");
                Methods.setMessage4("I guess he wasn't so friendly after all...");
            }
        }

        else {
            Methods.setMessage2(" ");
            Methods.setMessage3(" ");
            Methods.setMessage4(" ");
        }
    }


}
