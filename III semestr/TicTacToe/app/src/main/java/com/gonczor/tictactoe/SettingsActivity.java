package com.gonczor.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class SettingsActivity extends PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener{
    private SharedPreferences.Editor editor;
    private ListPreference boardSizePreference;
    private CheckBoxPreference multiplayerChoice;
    private ListPreference gameDurationPreference;
    private String boardSizeKey;
    private String multiplayerKey;
    private String gameDurationKey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        multiplayerKey = getResources().getString(R.string.multiplayer_option_key);
        boardSizeKey = getResources().getString(R.string.board_size_key);
        gameDurationKey = getResources().getString(R.string.game_duration_key);

        SharedPreferences pref = getApplicationContext()
                .getSharedPreferences(Common.PREFERENCES_NAME, MODE_PRIVATE);
        addPreferencesFromResource(R.xml.preferences);
        boardSizePreference = (ListPreference)getPreferenceScreen()
                .findPreference(boardSizeKey);
        multiplayerChoice = (CheckBoxPreference)getPreferenceScreen()
                .findPreference(multiplayerKey);
        gameDurationPreference = (ListPreference) getPreferenceScreen()
                .findPreference(gameDurationKey);
        editor = pref.edit();
    }

    @Override
    public void onPause(){
        super.onPause();
        save();
        showToast();
    }

    private void showToast(){
        CharSequence toastText = getResources().getString(R.string.settings_saved_toast);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

    private void save(){
        Integer boardSize = Integer.parseInt(boardSizePreference.getValue());
        editor.putInt(boardSizeKey, boardSize);

        Boolean multiplayerChosen = multiplayerChoice.isChecked();
        editor.putBoolean(multiplayerKey, multiplayerChosen);

        Integer gameDuration = Integer.parseInt(gameDurationPreference.getValue());
        editor.putInt(gameDurationKey, gameDuration);

        editor.commit();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
