import java.io.*;

public class Main{
    static int[] alphabet = new int[26];	//알파벳 개수 저장 배열
    static StringBuilder sb = new StringBuilder();	//결과 저장할 StringBuilder
    static StringBuilder front = new StringBuilder();
    static StringBuilder end = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        boolean check = false;	//팰린드롬 만들 수 있는지 확인 변수
        int oddCheck = 0;		//알파벳 홀수인 개수
        char mid = '0';
        //알파벳 개수를 구하기
        for(int i=0;i<name.length();i++)
            alphabet[name.charAt(i) - 65]++;

        //팰린드롬 만들기
        for(int i=0;i< alphabet.length;i++){
            if(alphabet[i] != 0 && alphabet[i]%2 == 1){
                if(oddCheck==0){	//홀수가 1개가 될 때
                    oddCheck++;
                    mid = (char)('A' + i);	//mid구하기
                }else{	//홀수가 2개가 될 때
                    //팰린드롬 만들지 못하기 때문에 "I'm Sorry Hansoo"를 저장
                    sb = new StringBuilder("I'm Sorry Hansoo");
                    check = true;
                    break;
                }
            }
            //"개수 ÷ 2"만큼 front, end 구성 
            for(int j=0;j<alphabet[i]/2;j++){
                front.append((char)('A' + i));
                end.insert(0, (char)('A' + i));
            }
        }
        if(!check){		//팰린드롬 만들었을 때
            if(mid == '0')	//홀수 개수가 0개일 때
                sb.append(front).append(end);	//front + end
            else		//홀수 개수가 1개일 때
                sb.append(front).append(mid).append(end);	//front + mid + end
        }

        bw.write(sb.toString());		//팰린드롬 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}