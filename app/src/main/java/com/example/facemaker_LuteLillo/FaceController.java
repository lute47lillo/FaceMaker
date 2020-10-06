package com.example.facemaker_LuteLillo;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements SeekBar.OnSeekBarChangeListener, RadioButton.OnClickListener, Spinner.OnItemSelectedListener {

    private Face aidContrFace;
    private FaceView viewContr;
    private int actionButton = 0;


    public FaceController(FaceView view) {
        viewContr = view;
        aidContrFace = view.getFace();
    }



    @Override
    public void onClick(View v) {
        /*
        External Citation
        Date: 10/5/2020
        Problem: I didn't know how to select different buttons with the same OnCLick method
        Resource: https://www.youtube.com/watch?v=GtxVILjLcw8&ab_channel=CodinginFlow
        */

        switch(v.getId()){
            case R.id.randomBtt:
                aidContrFace.isRandom = true;
                actionButton = 0;
                break;
            case R.id.skinBtt:
                aidContrFace.isRandom = false;
                actionButton = 1;

                break;
            case R.id.eyeBtt:
                aidContrFace.isRandom = false;
                actionButton = 2;

                break;
            case R.id.hairBtt:
                aidContrFace.isRandom = false;
                actionButton = 3;

                break;
        }
        Log.i(null, "onClick: " + actionButton);
        this.viewContr.invalidate();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int blue = aidContrFace.
        int red;
        int green;

        //Anadir numero en face que sirva de referencia para los colores y cambiarlo.
        switch (viewContr.getId()){
            case R.id.blue:
                 blue = i;
                int newColor = Color.argb(255, red, green, blue);
                break;
            case R.id.red:
                red = i;
                newColor = Color.argb(255, red, green, blue);
                break;
            case R.id.green:
                green = i;
               newColor = Color.argb(255, red, green, blue);
                break;
        }

        //SeekBar red = findViewById(R.id.red);
       // SeekBar blue = viewContr.findViewById(R.id.blue);
       // SeekBar green = viewContr.findViewById(R.id.green);




        //int redV = red.getProgress();
       // int blueV = blue.getProgress();
       // int greenV = green.getProgress();

       int newColor = Color.argb(255, red, green, blue);

        switch (actionButton) {
            case 0:
                return;
            case 1:
                aidContrFace.skinColor = newColor;
                break;
            case 2:
                aidContrFace.eyeColor = newColor;
                break;
            case 3:
                aidContrFace.hairColor = newColor;
                break;


        }
        viewContr.getColors();
        this.viewContr.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
