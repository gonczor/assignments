package com.gonczor.tictactoe.play_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gonczor.tictactoe.R;

public class Play4x4Activity extends PlayActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play4x4);

        timerWindow = (TextView)findViewById(R.id.timer_window_4x4);
        Intent intent = getIntent();
        prepareGame(intent);
    }

    @Override
    protected void createButtonGrid() {
        buttonGrid = new Button[4][4];
        buttonGrid[0][0] = (Button) findViewById(R.id.button_4_00);
        buttonGrid[0][1] = (Button) findViewById(R.id.button_4_01);
        buttonGrid[0][2] = (Button) findViewById(R.id.button_4_02);
        buttonGrid[0][3] = (Button) findViewById(R.id.button_4_03);

        buttonGrid[1][0] = (Button) findViewById(R.id.button_4_10);
        buttonGrid[1][1] = (Button) findViewById(R.id.button_4_11);
        buttonGrid[1][2] = (Button) findViewById(R.id.button_4_12);
        buttonGrid[1][3] = (Button) findViewById(R.id.button_4_13);

        buttonGrid[2][0] = (Button) findViewById(R.id.button_4_20);
        buttonGrid[2][1] = (Button) findViewById(R.id.button_4_21);
        buttonGrid[2][2] = (Button) findViewById(R.id.button_4_22);
        buttonGrid[2][3] = (Button) findViewById(R.id.button_4_23);

        buttonGrid[3][0] = (Button) findViewById(R.id.button_4_30);
        buttonGrid[3][1] = (Button) findViewById(R.id.button_4_31);
        buttonGrid[3][2] = (Button) findViewById(R.id.button_4_32);
        buttonGrid[3][3] = (Button) findViewById(R.id.button_4_33);
    }
}

