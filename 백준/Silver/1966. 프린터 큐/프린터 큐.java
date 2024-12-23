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
                PrintJob currentJob = queue.poll();
                boolean hasHigherPriority = true;

                for (PrintJob job : queue) {
                    if (job.priority > currentJob.priority) {
                        hasHigherPriority = false;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    printOrder++;
                    if (currentJob.idx == M) {
                        break;
                    }
                } else {
                    queue.add(currentJob);
                }
            }
            System.out.println(printOrder);
        }
    }
}