import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] d = new int[n];
        int cnt = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) cnt++;
            d[i] = cnt;
        }

        int lt = 0, rt = 0;
        int answer = 0;
        while (lt <= rt && rt < n) {
            // lt~rt 구간의 짝수 개수는 d[rt]-d[lt-1], 길이 - 짝수 개수 <= k 일 때, 길이
            int lk = 0;
            if (lt - 1 >= 0) lk = d[lt - 1];
            if (rt - lt + 1 - (d[rt] - lk) <= k) {
                answer = Math.max(answer, d[rt] - lk);
                rt++;
                continue;
            }
            lt++;
        }

        System.out.println(answer);
        br.close();
    }
}