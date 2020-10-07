package com.example.facemaker_LuteLillo;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, RadioGroup.OnClickListener {

    //Instances of other classes.
    private Face aidContrFace;
    private FaceView viewContr;

    //Variables for this class.
    private int actionButton = 0;

    private SeekBar redSeek;
    private SeekBar blueSeek;
    private SeekBar greenSeek;

    private Spinner randChange;

    private int redBar;
    private int blueBar;
    private int greenBar;

    //Constructor Controller Class
    public FaceController(FaceView view) {
        viewContr = view;
        aidContrFace = view.getFace();
    }

    //Initialize the values of the seekBar
    public void setSeek(SeekBar red, SeekBar green, SeekBar blue) {
        redSeek = red;
        blueSeek = blue;
        greenSeek = green;
    }

    //Updates the values of the seekBars depending on the button selected.
    public void updateSeek(){

        if(actionButton == 1){ //Skin button

            /*
        External Citation
        Date: 10/5/2020
        Problem: I didn't know how to access the red, blue, green values of the color.
        Resource: https://developer.android.com/reference/android/graphics/Color
        */

            redBar = Color.red(aidContrFace.skinColor);
            greenBar = Color.green(aidContrFace.skinColor);
            blueBar = Color.blue(aidContrFace.skinColor);

        }else if(actionButton == 2){ //Eye button

            redBar = Color.red(aidContrFace.eyeColor);
            greenBar = Color.green(aidContrFace.eyeColor);
            blueBar = Color.blue(aidContrFace.eyeColor);

        }else if(actionButton == 3){ //Hair button

            redBar = Color.red(aidContrFace.hairColor);
            greenBar = Color.green(aidContrFace.hairColor);
            blueBar= Color.blue(aidContrFace.hairColor);

        }

        redSeek.setProgress(redBar);
        greenSeek.setProgress(greenBar);
        blueSeek.setProgress(blueBar);

    }

    //Initializes the spinner
    public void setSpinner(Spinner rand){
        randChange = rand;
    }

    //Updates the spinner when random button is clicked.
    public void updateSpinner(){
        randChange.setSelection(aidContrFace.hairStyle);
    }

    //Actions depending on the button selected.
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

                updateSpinner();
                aidContrFace.isRandom = true;  //Sets the face to be a random creation.
                actionButton = 0;
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
        this.viewContr.invalidate();

    }

    //Changes Hair style depending on the selection of the user.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        aidContrFace.hairStyle = i;
        aidContrFace.isRandom = false;
        this.viewContr.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    //Changes the progress of the seekBars when the user executes an action over them.
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        /*
        External Citation
        Date: 10/5/2020
        Problem: I didn't know how to work with different seekBars at the same time. I was guided by the
        example on the page.
        Resource: https://stackoverflow.com/questions/8719632/multiple-seekbars-listener/13468578
        */

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

        //Changes the color of the part that was selected due the change in the seekbars.
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
