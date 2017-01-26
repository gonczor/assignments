package com.gonczor.tictactoe.play_activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gonczor.tictactoe.R;
import com.gonczor.tictactoe.utils.GameManager;
import com.gonczor.tictactoe.utils.Timer;

public abstract class PlayActivity extends Activity {
    protected Timer timer;
    protected Button[][] buttonGrid;
    protected Boolean isMultiplayer;
    protected GameManager manager;
    protected boolean gameOver = false;
    protected int boardSize;
    protected int gameDuration;
    protected TextView timerWindow;

    protected abstract void createButtonGrid();

    protected void prepareGame(Intent intent){
        createButtonGrid();
        isMultiplayer =  intent.getBooleanExtra(getResources()
                .getString(R.string.multiplayer_option_key), false);
        boardSize = intent.getIntExtra(getResources().getString(R.string.board_size_key), 0);
        gameDuration = intent.getIntExtra(getResources().getString(R.string.game_duration_key), 0);

        timer = new Timer(gameDuration, timerWindow, this);
        timer.runTimer();

        manager = new GameManager(boardSize, isMultiplayer, buttonGrid);
    }

    public void onClickSetMarker(View view) {
        if(manager.makeMove((Button) view)) {
            gameOver = true;
            timer.stopTimer();
            Button[] winningStreak = manager.getWinningButtonStreak();
            if(winningStreak != null)
                for(Button button : winningStreak) {
                    button.setBackgroundColor(Color.GREEN);
                }
            disableButtons();
        }
    }

    public void onTimeElapsed(){
        disableButtons();
    }

    protected void disableButtons(){
        for(Button[] row: buttonGrid)
            for(Button button: row)
                button.setEnabled(false);
    }
}
