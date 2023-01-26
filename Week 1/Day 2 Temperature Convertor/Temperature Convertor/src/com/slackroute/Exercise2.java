package com.slackroute;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("No             Temp Cels        Temp F");
        int tempC= 0;
        for(int i=1; i<=11; i++){
            int tempF = (tempC * 9/5) + 32;
            System.out.println(i +"                "+ tempC + "                "+ tempF );
            tempC+=10;
        }
    }
}
