import java.time.Duration;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Duration videoD = parseDuration(video_len);
        Duration posD = parseDuration(pos);
        Duration startD = parseDuration(op_start);
        Duration endD = parseDuration(op_end);

        // 오프닝 시간이라면 스킵
        if (posD.compareTo(startD) >= 0 && posD.compareTo(endD) < 0) {
            posD = endD;
        }

        for (String command : commands) {
            switch (command) {
                case "next" -> {
                    posD = posD.plusSeconds(10);
                    // 비디오 시간을 넘기면, 비디오 종료 시간으로 변경
                    if (posD.compareTo(videoD) > 0) {
                        posD = videoD;
                    }
                    // 오프닝 시간이라면 스킵
                    if (posD.compareTo(startD) >= 0 && posD.compareTo(endD) < 0) {
                        posD = endD;
                    }
                }
                case "prev" -> {
                    posD = posD.minusSeconds(10);
                    // 비디오 시간을 넘기면, 0분 0초로 변경
                    if (posD.compareTo(Duration.ZERO) < 0) {
                        posD = Duration.ZERO;
                    }
                    // 오프닝 시간이라면 스킵
                    if (posD.compareTo(startD) >= 0 && posD.compareTo(endD) < 0) {
                        posD = endD;
                    }
                }
            }
        }
        long seconds = posD.getSeconds();
        long min = seconds / 60;
        long sec = seconds % 60;

        return String.format("%02d:%02d", min, sec);
    }

    private Duration parseDuration(String len) {
        String[] split = len.split(":");
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return Duration.ofMinutes(min).plusSeconds(sec);
    }
}