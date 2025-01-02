import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student s) {
            if (korean != s.korean) {
                return Integer.compare(s.korean, korean);
            }
            else if (english != s.english) {
                return Integer.compare(english, s.english);
            }
            else if (math != s.math) {
                return Integer.compare(s.math, math);
            }
            return name.compareTo(s.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            String name = strings[0];
            int korean = Integer.parseInt(strings[1]);
            int english = Integer.parseInt(strings[2]);
            int math = Integer.parseInt(strings[3]);

            students[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(students);

        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }

        System.out.println(sb);
    }
}