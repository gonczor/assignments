package com.gonczor.tictactoe.utils;


import android.os.Handler;
import android.widget.TextView;

import com.gonczor.tictactoe.play_activities.PlayActivity;

public class Timer {
    private long timeLeft;
    private TextView timerWindow;
    private boolean isActive;
    // TODO get rid of this spaghetti code
    PlayActivity activity;

    public Timer(long durationTime, TextView timerWindow, PlayActivity activity){
        this.timeLeft = durationTime;
        this.timerWindow = timerWindow;
        this.isActive = true;
        this.activity = activity;
    }

    public void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(isActive){
                    long minutes = timeLeft / 60;
                    long seconds = timeLeft % 60;
                    String timeLeft = String.format("%d:%02d", minutes, seconds);
                    timerWindow.setText(timeLeft);
                    if (timeElapsed())
                        onTimeElapsed();
                    else
                        Timer.this.timeLeft -= 1;
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    private boolean timeElapsed(){
        return this.timeLeft <= 0;
    }

    private void onTimeElapsed(){
        this.stopTimer();
        activity.onTimeElapsed();
    }

    public void stopTimer(){
        this.isActive = false;
        this.timeLeft = 0;
    }
}
