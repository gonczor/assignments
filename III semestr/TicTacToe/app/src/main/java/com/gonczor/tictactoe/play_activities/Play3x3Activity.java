package com.gonczor.tictactoe.play_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gonczor.tictactoe.R;

public class Play3x3Activity extends PlayActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play3x3);

        timerWindow = (TextView)findViewById(R.id.timer_window_3x3);
        Intent intent = getIntent();
        prepareGame(intent);
    }

    @Override
    protected void createButtonGrid(){
        buttonGrid = new Button[3][3];
        buttonGrid[0][0] = (Button)findViewById(R.id.button_3_00);
        buttonGrid[0][1] = (Button)findViewById(R.id.button_3_01);
        buttonGrid[0][2] = (Button)findViewById(R.id.button_3_02);

        buttonGrid[1][0] = (Button)findViewById(R.id.button_3_10);
        buttonGrid[1][1] = (Button)findViewById(R.id.button_3_11);
        buttonGrid[1][2] = (Button)findViewById(R.id.button_3_12);

        buttonGrid[2][0] = (Button)findViewById(R.id.button_3_20);
        buttonGrid[2][1] = (Button)findViewById(R.id.button_3_21);
        buttonGrid[2][2] = (Button)findViewById(R.id.button_3_22);
    }
}
