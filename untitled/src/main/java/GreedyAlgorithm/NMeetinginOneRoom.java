package GreedyAlgorithm;
import java.util.Arrays;

public class NMeetinginOneRoom {

    //Need to create data class to hold meeting details
    public class data {
        int start;
        int end;
        int pos; // position of the meeting in the original input
    }

    public int maxMeetings(int start[], int end[], int n) {
        data[] data = new data[n];
        for (int i = 0; i < n; i++) {
            data[i].start = start[i];
            data[i].end = end[i];
            data[i].pos = i + 1;
        }

        Arrays.sort(data, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEndTime = data[0].end;

        for (int i = 1; i < n; i++) {
            if (data[i].start > lastEndTime) {
                count++;
                lastEndTime = data[i].end;
            }
        }

        return count;
    }
}
