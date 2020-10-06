package com.example.facemaker_LuteLillo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class FaceView extends SurfaceView{

    private Face aidFace = new Face();

    Paint paintFace = new Paint();
    Paint paintEye = new Paint();
    Paint paintHair = new Paint();

    private float centerX = 550.0f;
    private float centerY = 500.0f;
    private float height=800.0f;
    private float width=600.0f;


    public FaceView(Context context, AttributeSet attr){
        super(context, attr);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);

        paintFace.setColor(aidFace.skinColor);
        paintEye.setColor(aidFace.eyeColor);
        paintHair.setColor(aidFace.hairColor);

        /*
        External Citation
        Date: 10/5/2020
        Problem: I didn't know how to fill the paints, I had to search the specific parameter
        Resource: https://developer.android.com/reference/android/graphics/Paint.Style
        */

        paintFace.setStyle(Paint.Style.FILL);
        paintEye.setStyle(Paint.Style.FILL);
        paintEye.setStyle(Paint.Style.FILL);
    }

    public Face getFace(){
        return aidFace;
    }

    public void getColors(){
        paintFace.setColor(aidFace.skinColor);
        paintEye.setColor(aidFace.eyeColor);
        paintHair.setColor(aidFace.hairColor);
        return;
    }

    public void drawFace(Canvas canvas){

        if(aidFace.isRandom) {
            aidFace.randomize(aidFace.skinColor,aidFace.eyeColor,aidFace.hairColor, aidFace.hairStyle);

            paintFace.setColor(aidFace.skinColor);
            paintHair.setColor(aidFace.hairColor);
            paintEye.setColor(aidFace.eyeColor);

            canvas.drawOval(centerX - width / 3, centerY - height / 3, centerX + width / 2, centerY + height / 2, paintFace);

        }else{
            paintFace.setColor(0xFFE5BFAB);
            canvas.drawOval(centerX - width / 3, centerY - height / 3, centerX + width / 2, centerY + height / 2, paintFace);
        }
    }

    public void drawEyes(Canvas canvas){
        Paint pupilEye = new Paint();
        pupilEye.setColor(Color.BLACK);
        paintEye.setColor(aidFace.eyeColor);

        float eye_width = 100.0f;
        float eye_height = 50.0f;

        //LEFT - EYE

        float left = centerX - width * 0.20f - eye_width / 2;
        float top = centerX - height * 0.20f - eye_height / 2;
        float right = centerX - width * 0.20f + eye_width / 2;
        float bottom = centerY - height * 0.20f + eye_height / 2;

        float centerEyeX = centerX - width * 1/8;
        float centerEyeY = centerY - height * 1/8;

        canvas.drawCircle(centerEyeX,centerEyeY,35.0f, paintEye);
        canvas.drawCircle(centerEyeX,centerEyeY,8, pupilEye);

        //RIGHT - EYE

        centerEyeX = centerX + width * 0.28f;

        canvas.drawCircle(centerEyeX,centerEyeY,35.0f, paintEye);
        canvas.drawCircle(centerEyeX,centerEyeY,8, pupilEye);
    }

    public void drawMouth(Canvas canvas){
        Paint mouthColor = new Paint();
        mouthColor.setColor(Color.RED);

        if(aidFace.isRandom){
            Random rand = new Random();
            mouthColor.setColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }

        float leftMouthX = centerX - width /6;
        float topMouthY = centerY + height/ 8 ;
        float rightMouth = centerX + width / 3;
        float bottomMouth = centerY + height/3 + height /10;
        canvas.drawArc(leftMouthX, topMouthY, rightMouth,bottomMouth, 0 ,180, false, mouthColor);

    }

    private void drawHair(Canvas canvas) {

      if(aidFace.hairStyle == 0) {

           //PUNKY - HAIR

           float leftHair = centerX - width / 16;
           float topHair = centerY - height / 2;
           float widthHair = centerX + width / 5;
           float heightHair = centerY - 150.0f;

           paintHair.setColor(Color.MAGENTA);
           canvas.drawOval(leftHair, topHair, widthHair, heightHair, paintHair);

       }else if (aidFace.hairStyle == 1){

          //BALD
          /*No hair in this case*/

       }else{

           //BUNNY - TAIL

           float leftHair = centerX - width / 5;
           float topHair = centerY - height / 3;
           float widthHair = centerX + width /3 ;
           float heightHair = centerY - 150.0f;

           paintHair.setColor(Color.GRAY);
           canvas.drawOval(leftHair, topHair, widthHair, heightHair, paintHair);

           leftHair = centerX * 2.3f - width +200.0f  ;
           topHair = centerY - height / 2 ;
           widthHair = centerX + width / 8 ;
           heightHair = centerY - 150.0f;

           canvas.drawOval(leftHair, topHair, widthHair, heightHair, paintHair);
       }

    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawFace(canvas);
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);



    }



}
