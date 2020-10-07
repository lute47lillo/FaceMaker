package com.example.facemaker_LuteLillo;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, RadioGroup.OnClickListener {

    private Face aidContrFace;
    private FaceView viewContr;
    private int actionButton = 0;

    private SeekBar redSeek;
    private SeekBar blueSeek;
    private SeekBar greenSeek;

    private int redBar;
    private int blueBar;
    private int greenBar;

    public FaceController(FaceView view) {
        viewContr = view;
        aidContrFace = view.getFace();
    }

    public void setSeek(SeekBar red, SeekBar green, SeekBar blue) {
        redSeek = red;
        blueSeek = blue;
        greenSeek = green;
    }

    public void updateSeek(){

        if(actionButton == 1){

            redBar = Color.red(aidContrFace.skinColor);
            greenBar = Color.green(aidContrFace.skinColor);
            blueBar = Color.blue(aidContrFace.skinColor);

        }else if(actionButton == 2){

            redBar = Color.red(aidContrFace.eyeColor);
            greenBar = Color.green(aidContrFace.eyeColor);
            blueBar = Color.blue(aidContrFace.eyeColor);

        }else if(actionButton == 3){

            redBar = Color.red(aidContrFace.hairColor);
            greenBar = Color.green(aidContrFace.hairColor);
            blueBar= Color.blue(aidContrFace.hairColor);

        }
        redSeek.setProgress(redBar);
        greenSeek.setProgress(greenBar);
        blueSeek.setProgress(blueBar);

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
                updateSeek();
                break;
            case R.id.skinBtt:
                aidContrFace.isRandom = false;
                actionButton = 1;
                updateSeek();
                break;
            case R.id.eyeBtt:
                aidContrFace.isRandom = false;
                actionButton = 2;
                updateSeek();
                break;
            case R.id.hairBtt:
                aidContrFace.isRandom = false;
                actionButton = 3;
                updateSeek();
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

       // *External Citation*

        if(seekBar.getId() == R.id.blue){
            viewContr.blueColorSeek = i;
        }
        else if(seekBar.getId() == R.id.green){
            viewContr.greenColorSeek = i;
        }
        else if (seekBar.getId() == R.id.red){
            viewContr.redColorSeek = i;
        }


        int colorSeek = Color.argb(255, viewContr.redColorSeek,viewContr.greenColorSeek,viewContr.blueColorSeek);

        switch (actionButton){
            case 0:
                break;
            case 1:

                aidContrFace.skinColor = colorSeek;
                break;
            case 2:

                aidContrFace.eyeColor = colorSeek;
                break;
            case 3:

                aidContrFace.hairColor = colorSeek;
                break;
        }

        aidContrFace.isRandom = false;
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
