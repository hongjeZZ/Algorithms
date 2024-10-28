import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meetingList.add(new Meeting(br.readLine()));
        }
        meetingList.sort(Comparator.comparingInt(Meeting::getEnd).thenComparingInt(Meeting::getStart));

        int cnt = 0;
        int end = 0;

        for (Meeting meeting : meetingList) {
            if (meeting.start >= end) {
                cnt++;
                end = meeting.end;
            }
        }

        System.out.println(cnt);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(String line) {
            String[] str = line.split(" ");
            start = Integer.parseInt(str[0]);
            end = Integer.parseInt(str[1]);
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}