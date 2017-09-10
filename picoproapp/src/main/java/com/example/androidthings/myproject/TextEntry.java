package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class TextEntry extends SimplePicoPro {

    //The idea of this file is to moniter which button is pressed, saved pressed dot-dash set into
    //a variable, once ENTER button pressed, display the character on screen. Type space does not
    //need ENTER

    //Define public variable to save morse code
    public String dashDot="";



    @Override
    public void setup() {
        //Define GPIO pins
        //Dot
        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        //Dash
        pinMode(GPIO_37,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);

        //Space
        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);

        //Enter
        pinMode(GPIO_32,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_32,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
        //nothing in here

    }
    // println in this loop has no functional meaning, just used to track event

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent" + pin + ", " + value);
        //If dot is pressed
        if (pin == GPIO_39 && value == HIGH) {
            Dot();
        }

        //If dash is pressed
        else if (pin == GPIO_37 && value == HIGH) {
            Dash();
        }

        //Display space on screen
        else if (pin == GPIO_35 && value == HIGH) {
            printCharacterToScreen(' ');
            println("Space");
        }

        //Once a set of dash dot are pressed, press enter, text displays on screen
        else if (pin == GPIO_32 && value == HIGH) {
            Enter();
            println("Enter");
        }
    }

    // when dot() is called, add a dot into string
    private void Dot() {
        dashDot = dashDot + ".";
        println("Dot");
    }

    // when dash() is called, add a dash into string
    private void Dash() {
        dashDot = dashDot + "-";
        println("Dash");
    }

    // when enter() is called, call type function, input the dash dot string, print the output
    // letter on screen, reset dashDot string to empty
    private void Enter(){
        char letter;

        if(dashDot!="") {
            letter = type(dashDot);
            printCharacterToScreen(letter);
            dashDot = "";
        }
    }

    //Relate dash-dot string to a letter
    public char type(String dashDot)  {
        char letter='/';
        if (dashDot.equals(".-")){
            letter = 'A';
        }
        else if (dashDot.equals("-...")){
            letter = 'B';
        }
        else if (dashDot.equals("-.-.")){
            letter = 'C';
        }
        else if (dashDot.equals("-..")){
            letter = 'D';
        }
        else if (dashDot.equals(".")){
            letter = 'E';
        }
        else if (dashDot.equals("..-.")){
            letter = 'F';
        }
        else if (dashDot.equals("--.")){
            letter = 'G';
        }
        else if (dashDot.equals("....")){
            letter = 'H';
        }
        else if (dashDot.equals("..")){
            letter = 'I';
        }
        else if (dashDot.equals(".---")){
            letter = 'J';
        }
        else if (dashDot.equals("-.-")){
            letter = 'K';
        }
        else if (dashDot.equals(".-..")){
            letter = 'L';
        }
        else if (dashDot.equals("--")){
            letter = 'M';
        }
        else if (dashDot.equals("-.")){
            letter = 'N';
        }
        else if (dashDot.equals("---")){
            letter = 'O';
        }
        else if (dashDot.equals(".--.")){
            letter = 'P';
        }
        else if (dashDot.equals("--.-")){
            letter = 'Q';
        }
        else if (dashDot.equals(".-.")){
            letter = 'R';
        }
        else if (dashDot.equals("...")){
            letter = 'S';
        }
        else if (dashDot.equals("-")){
            letter = 'T';
        }
        else if (dashDot.equals("..-")){
            letter = 'U';
        }
        else if (dashDot.equals("...-")){
            letter = 'V';
        }
        else if (dashDot.equals(".--")){
            letter = 'W';
        }
        else if (dashDot.equals("-..-")){
            letter = 'X';
        }
        else if (dashDot.equals("-.--")){
            letter = 'Y';
        }
        else if (dashDot.equals("--..")){
            letter = 'Z';
        }
        else if (dashDot.equals(".----")){
            letter = '1';
        }
        else if (dashDot.equals("..---")){
            letter = '2';
        }
        else if (dashDot.equals("...--")){
            letter = '3';
        }
        else if (dashDot.equals("....-")){
            letter = '4';
        }
        else if (dashDot.equals(".....")){
            letter = '5';
        }
        else if (dashDot.equals("-....")){
            letter = '6';
        }
        else if (dashDot.equals("--...")){
            letter = '7';
        }
        else if (dashDot.equals("---..")){
            letter = '8';
        }
        else if (dashDot.equals("----.")){
            letter = '9';
        }
        else if (dashDot.equals("-----")){
            letter = '0';
        }
        // Return char letter as output
        return letter;
    }
}