/*
Author: Lute Lillo Portero
CS3301 OO Design
Project FaceMaker
*/

package com.example.facemaker_LuteLillo;
import java.util.Random;



public class Face {

    private int skinColor;              //Creating the fields for the class Face.
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face(){                                                  //Initializing them from the constructor.

        randomize(skinColor, eyeColor, hairColor, hairStyle);       //Calling the randomize method to create a random face by assigning random values to its fields.

    }

    public void randomize(int skinColor, int eyeColor, int hairColor, int hairStyle){
        Random random = new Random();                               //Instantiation of the class Random.


        skinColor = random.nextInt(255);                           //Assigns a random int from 0 to 255.
        eyeColor = random.nextInt(255);
        hairColor = random.nextInt(255);
        hairStyle = random.nextInt(255);

        this.skinColor = skinColor;                                  //Assigning the values to the fields of the class.
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;

        //System.out.println("The random numbers are:" + skinColor + "," + eyeColor + "," + hairColor + "," + hairStyle);  //Error-check.
    }

    /*
    public static void main(String[] args){
       Face face1 = new Face();              //Error-check of the values assigned.
    }*/
}
