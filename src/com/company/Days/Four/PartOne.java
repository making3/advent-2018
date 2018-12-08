package com.company.Days.Four;

import com.company.AdventRun;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class PartOne implements AdventRun<ArrayList<GuardEvent>> {
    private final String fallsAlseep = "falls asleep";
    private final String beginsShift = "begins shift";

    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public ArrayList<GuardEvent> getInput() {
        return DayFourInput.get().getInput();
    }

    @Override
    public String run(ArrayList<GuardEvent> guardEvents) {
        GuardSleepSchedule mostSleptGuard = null;
        GuardSleepSchedule mostMinuteSleptGuard = null;
        HashMap<Integer, GuardSleepSchedule> guards = new HashMap<>();

        GuardSleepSchedule currentGuard = null;
        LocalDateTime fellAsleepTime = null;

        for (int i = 0; i < guardEvents.size(); i++) {
            GuardEvent event = guardEvents.get(i);
            if (event == null) {
                // End of list
                break;
            }

            if (event.Event.contains(beginsShift)) {
                if (currentGuard != null && (mostSleptGuard == null || currentGuard.getTotalMinutes() > mostSleptGuard.getTotalMinutes())) {
                    mostSleptGuard = currentGuard;
                }
                if (currentGuard != null && (mostMinuteSleptGuard == null || currentGuard.getBestMinuteCount() > mostMinuteSleptGuard.getBestMinuteCount())) {
                    mostMinuteSleptGuard = currentGuard;
                }
                fellAsleepTime = null;
                int currentGuardId = getIdFromShift(event.Event);
                currentGuard = guards.get(currentGuardId);

                if (currentGuard == null) {
                    currentGuard = new GuardSleepSchedule(currentGuardId);
                    guards.put(currentGuardId, currentGuard);
                }
            } else if (currentGuard != null) {
                if (event.Event.contains(fallsAlseep)) {
                    fellAsleepTime  = event.EventTime;
                } else if (fellAsleepTime!= null){
                    addMinutesSlept(fellAsleepTime, event.EventTime, currentGuard);
                }
            }
        }
        if (currentGuard != null && (mostSleptGuard == null || currentGuard.getTotalMinutes() > mostSleptGuard.getTotalMinutes())) {
            mostSleptGuard = currentGuard;
        }
        if (currentGuard != null && (mostMinuteSleptGuard == null || currentGuard.getBestMinuteCount() > mostMinuteSleptGuard.getBestMinuteCount())) {
            mostMinuteSleptGuard = currentGuard;
        }

        System.out.println("Part 2: " + mostMinuteSleptGuard.getBestMinute() * mostMinuteSleptGuard.getId());
        return Integer.toString(mostSleptGuard.getBestMinute() * mostSleptGuard.getId());
    }

    private int getIdFromShift(String guardShift) {
        return Integer.parseInt(guardShift.split("#")[1].split(" ")[0]);
    }

    private void addMinutesSlept(LocalDateTime fellAsleepTime, LocalDateTime wakeUpTime, GuardSleepSchedule guard) {
        for (int k = fellAsleepTime.getMinute(); k < wakeUpTime.getMinute(); k++) {
            guard.Set(k);
        }
    }
}
