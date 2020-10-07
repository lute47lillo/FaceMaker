/*
Author: Lute Lillo Portero
CS3301 OO Design
Project FaceMaker
*/

package com.example.facemaker_LuteLillo;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;



public class Face {

    public int skinColor;              //Creating the fields for the class Face.
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public boolean isRandom = false;

    public Face(){
        randomize(skinColor, eyeColor, hairColor, hairStyle);//Randomize method to create a random face.
    }
    public void randomize(int skinColor, int eyeColor, int hairColor, int hairStyle){
        Random random = new Random();                               //Instantiation of the class Random.

        skinColor = getRandomColor();
        eyeColor = getRandomColor();
        hairColor = getRandomColor();

        hairStyle = (int)(Math.random() * 3);


        this.skinColor = skinColor;                                  //Assigning the values to the fields of the class.
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;

        //System.out.println("The random numbers are:" + skinColor + "," + eyeColor + "," + hairColor + "," + hairStyle);  //Error-check.
    }

    /*
        External Citation
        Date: 10/5/2020
        Problem: I had to change how to get the random colors as my old way wasn't working.
        Resource: https://stackoverflow.com/questions/5280367/android-generate-random-color-on-click
        */

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    /*
    public static void main(String[] args){
       Face face1 = new Face();              //Error-check of the values assigned.
    }*/
}
