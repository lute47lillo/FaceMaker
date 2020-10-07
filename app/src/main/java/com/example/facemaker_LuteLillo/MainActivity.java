/*
Author: Lute Lillo Portero
CS3301 OO Design
Project FaceMaker
*/

package com.example.facemaker_LuteLillo;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;


import static com.example.facemaker_LuteLillo.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceView view = findViewById(R.id.faceView);
        FaceController controller = new FaceController(view);

        Button randomize = findViewById(R.id.randomBtt);
        randomize.setOnClickListener(controller);

        Button skinB = findViewById(R.id.skinBtt);
        skinB.setOnClickListener(controller);
        Button hairB = findViewById(R.id.hairBtt);
        hairB.setOnClickListener(controller);
        Button eyeB = findViewById(R.id.eyeBtt);
        eyeB.setOnClickListener(controller);

        Spinner styleHair = findViewById(R.id.spinner);
        styleHair.setOnItemSelectedListener(controller);

        SeekBar red = findViewById(R.id.red);
        red.setOnSeekBarChangeListener(controller);
        SeekBar blue = findViewById(R.id.blue);
        blue.setOnSeekBarChangeListener(controller);
        SeekBar green = findViewById(R.id.green);
        green.setOnSeekBarChangeListener(controller);

        controller.setSeek(red, green, blue);


    }

}