package com.company.Days.Four;

public class GuardSleepSchedule {
    private int totalMinutes = 0;
    private int[] minutes = new int[60];
    private int maxIndex = -1;
    private int guardId;

    public GuardSleepSchedule(int id) {
        guardId = id;
    }

    public void Set(int i) {
        if (minutes[i] < 1) {
            minutes[i] = 1;
        } else {
            minutes[i]++;
        }

        if (maxIndex != i && (maxIndex < 1 || minutes[i] > minutes[maxIndex])) {
            maxIndex = i;
        }
        totalMinutes++;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getBestMinute() {
        return maxIndex;
    }

    public int getBestMinuteCount() {
        if (maxIndex < 1) {
            return 0;
        }
        return minutes[maxIndex];
    }

    public int getId() {
        return guardId;
    }
}
