package com.slackroute;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        tempConvertor();
    }
    public static void tempConvertor(){
        Scanner scan = new Scanner(System.in);

        //accept input from user
        System.out.println("Type temperature in Celsius");
        int tempC = scan.nextInt(); //try with int instead of float
        System.out.println(tempC + " IS THE INPUT");

        //convert C to F (0°C × 9/5) + 32 = 32°F
        float tempF = (tempC * 9/5) + 32;

        //print result and ask to continue
        System.out.printf("Temperature in Fahrenheit = %.2f\n" , tempF);

        //if user's response is no, then stop program
        System.out.println("Do you wish to continue(y/n)?");
        String res = scan.next();
        if (res.equals("y")){
            tempConvertor();
        } else if (res.equals("n")) {
            System.exit(0);
        }
    }
}
