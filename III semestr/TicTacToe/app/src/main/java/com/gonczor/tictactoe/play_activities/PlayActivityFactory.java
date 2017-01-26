package com.gonczor.tictactoe.play_activities;


public class PlayActivityFactory {
    public static Class getActivity(Integer boardSize){
        if (boardSize == 3)
            return Play3x3Activity.class;
        else if (boardSize == 4)
            return Play4x4Activity.class;
        else
            return Play5x5Activity.class;
    }
}
