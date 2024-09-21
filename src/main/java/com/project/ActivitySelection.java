package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Activity implements Comparable<ActivitySelection> {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(ActivitySelection other) {
        return this.finish - other.finish;
    }
}

public class ActivitySelection {
    public static List<ActivitySelection> selectActivities(List<ActivitySelection> activities) {
        // Sort activities by finish time
        activities.sort(ActivitySelection::compareTo);

        List<ActivitySelection> selectedActivities = new ArrayList<>();
        selectedActivities.add(activities.get(0)); // Select the first activity

        int lastFinishTime = activities.get(0).finish;

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start >= lastFinishTime) {
                selectedActivities.add(activities.get(i));
                lastFinishTime = activities.get(i).finish;
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        List<ActivitySelection> activities = Arrays.asList(
                new ActivitySelection(1, 4),
                new ActivitySelection(3, 6),
                new ActivitySelection(0, 7),
                new ActivitySelection(3, 10),
                new ActivitySelection(5, 11),
                new ActivitySelection(6, 10),
                new ActivitySelection(8, 12),
                new ActivitySelection(2, 14),
                new ActivitySelection(11, 12)
        );

        List<ActivitySelection> result = selectActivities(activities);

        System.out.println("Selected activities:");
        for (ActivitySelection activity : result) {
            System.out.println("[" + activity.start + "," + activity.finish + ")");
        }
    }
}
