package com.gonczor.tictactoe.play_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gonczor.tictactoe.R;

public class Play5x5Activity extends PlayActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play5x5);

        timerWindow = (TextView)findViewById(R.id.timer_window_5x5);
        Intent intent = getIntent();
        prepareGame(intent);
    }

    @Override
    protected void createButtonGrid(){
        buttonGrid = new Button[5][5];
        buttonGrid[0][0] = (Button)findViewById(R.id.button_5_00);
        buttonGrid[0][1] = (Button)findViewById(R.id.button_5_01);
        buttonGrid[0][2] = (Button)findViewById(R.id.button_5_02);
        buttonGrid[0][3] = (Button)findViewById(R.id.button_5_03);
        buttonGrid[0][4] = (Button)findViewById(R.id.button_5_04);

        buttonGrid[1][0] = (Button)findViewById(R.id.button_5_10);
        buttonGrid[1][1] = (Button)findViewById(R.id.button_5_11);
        buttonGrid[1][2] = (Button)findViewById(R.id.button_5_12);
        buttonGrid[1][3] = (Button)findViewById(R.id.button_5_13);
        buttonGrid[1][4] = (Button)findViewById(R.id.button_5_14);

        buttonGrid[2][0] = (Button)findViewById(R.id.button_5_20);
        buttonGrid[2][1] = (Button)findViewById(R.id.button_5_21);
        buttonGrid[2][2] = (Button)findViewById(R.id.button_5_22);
        buttonGrid[2][3] = (Button)findViewById(R.id.button_5_23);
        buttonGrid[2][4] = (Button)findViewById(R.id.button_5_24);

        buttonGrid[3][0] = (Button)findViewById(R.id.button_5_30);
        buttonGrid[3][1] = (Button)findViewById(R.id.button_5_31);
        buttonGrid[3][2] = (Button)findViewById(R.id.button_5_32);
        buttonGrid[3][3] = (Button)findViewById(R.id.button_5_33);
        buttonGrid[3][4] = (Button)findViewById(R.id.button_5_34);

        buttonGrid[4][0] = (Button)findViewById(R.id.button_5_40);
        buttonGrid[4][1] = (Button)findViewById(R.id.button_5_41);
        buttonGrid[4][2] = (Button)findViewById(R.id.button_5_42);
        buttonGrid[4][3] = (Button)findViewById(R.id.button_5_43);
        buttonGrid[4][4] = (Button)findViewById(R.id.button_5_44);
    }
}

