import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class PrintJob {
        int idx;
        int priority;

        PrintJob(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);

            Queue<PrintJob> queue = new LinkedList<>();

            String[] values = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(new PrintJob(j, Integer.parseInt(values[j])));
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                // 최대값 저장
                int max = Integer.MIN_VALUE;
                for (PrintJob job : queue) {
                    if (job.priority > max) {
                        max = job.priority;
                    }
                }
                PrintJob printJob = queue.poll();
                if (printJob.priority == max) {
                    printOrder++;
                    if (printJob.idx == M) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(printJob);
                }
            }
        }
    }
}