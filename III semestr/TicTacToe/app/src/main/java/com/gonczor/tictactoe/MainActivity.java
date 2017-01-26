package com.gonczor.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.gonczor.tictactoe.play_activities.PlayActivityFactory;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPlay(View view){
        Integer boardSize = getBoardSize();
        Integer gameDuration = getGameDuration();
        Boolean isMultiplayer = getIsMultiplayer();

        Class ActivityClass = PlayActivityFactory.getActivity(boardSize);

        Intent playIntent = new Intent(this, ActivityClass);
        playIntent.putExtra(getResources().getString(R.string.multiplayer_option_key),
                            isMultiplayer);
        playIntent.putExtra(getResources().getString(R.string.board_size_key), boardSize);
        playIntent.putExtra(getResources().getString(R.string.game_duration_key), gameDuration);
        startActivity(playIntent);
    }

    public void onClickShowSettings(View view){
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    private Integer getBoardSize(){
        String boardSizeKey;
        boardSizeKey = getResources().getString(R.string.board_size_key);
        SharedPreferences settings = getSharedPreferences(Common.PREFERENCES_NAME, MODE_PRIVATE);
        return settings.getInt(boardSizeKey, 0);
    }

    private Boolean getIsMultiplayer(){
        String multiplayerKey = getResources().getString(R.string.multiplayer_option_key);
        SharedPreferences settings = getSharedPreferences(Common.PREFERENCES_NAME, MODE_PRIVATE);
        return settings.getBoolean(multiplayerKey, false);
    }

    private Integer getGameDuration(){
        String gameDurationKey = getResources().getString(R.string.game_duration_key);
        SharedPreferences settings = getSharedPreferences(Common.PREFERENCES_NAME, MODE_PRIVATE);
        return settings.getInt(gameDurationKey, 0);
    }
}
