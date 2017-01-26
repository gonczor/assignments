package utils;

import settings.Settings;

public class Timer {
    private long startTimestamp;

    public Timer(){
        startTimestamp = System.currentTimeMillis();
    }
    public boolean hasTimeLeft(){
        return (startTimestamp + 1000 * Settings.timerRunningTime) > System.currentTimeMillis();
    }
}
