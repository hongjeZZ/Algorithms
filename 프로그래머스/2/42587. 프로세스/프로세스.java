import java.util.*;

class Solution {
    
    static class Job {
        int idx;
        int priority;
        
        public Job(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Job> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            
            queue.add(new Job(i, priority));
        }
        
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            Job poll = queue.poll();
            
            if (getMax(queue) > poll.priority) {
                queue.add(poll);
                continue;
            }
            
            if (poll.idx == location) {
                return cnt;
            }
            
            cnt++;
        }
        return 0;
    }
    
    public int getMax(Queue<Job> queue) {
        int max = 0;
        
        for (Job job : queue) {
            max = Math.max(job.priority, max);
        }
        
        return max;
    }
}