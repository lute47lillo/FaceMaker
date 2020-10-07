/*
Author: Lute Lillo Portero
CS3301 OO Design
Project FaceMaker
*/

package com.example.facemaker_LuteLillo;

import android.graphics.Color;

import java.util.Random;

public class Face {

    //Class fields.

    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public boolean isRandom = false;

    public Face(){

        //Create a random face
        randomize(skinColor, eyeColor, hairColor, hairStyle);

    }

    public void randomize(int skinColor, int eyeColor, int hairColor, int hairStyle){

        //Create random value
        Random random = new Random();
        hairStyle = (int)(Math.random() * 3);

        skinColor = getRandomColor();
        eyeColor = getRandomColor();
        hairColor = getRandomColor();

        //Initialize values.
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;

    }

    /*
        External Citation
        Date: 10/5/2020
        Problem: I had to change how to get the random colors as my old way wasn't working.
        Resource: https://stackoverflow.com/questions/5280367/android-generate-random-color-on-click
        */

    //Creates a randome number between 0 - 255.
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

}
