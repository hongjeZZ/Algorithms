import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    
    private static Map<String, Double> map = new HashMap<>();

    private static class Course {
        String subject;
        double score;
        String grade;

        Course(String subject, double score, String grade) {
            this.subject = subject;
            this.score = score;
            this.grade = grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        map.put("P", 0.0);
        
        double totalSum = 0.0;
        double scoreSum = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            
            Course course = new Course(subject, score, grade);

            if (!course.grade.equals("P")) {
                totalSum += course.score * map.get(course.grade);
                scoreSum += course.score;
            }
        }

        double average = totalSum / scoreSum;
        System.out.printf("%.6f\n", average);
    }
}