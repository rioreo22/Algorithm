import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] d = new int[n]; //d[i] 홀수의 개수 누적 합
        int[] d2 = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 1) {
                cnt++;
            } else d2[i] = 1;
            d[i] = cnt;
        }

        for (int i = 0; i < n; i++) {
            if (d[i] <= k) d2[i] = Math.max(d2[i], i + 1 - d[i]);
            for (int l = 1; l < i; l++) {
                // l부터 i까지의 홀수의 개수의 합은 d[i]-d[l-1]
                if (d[i] - d[l - 1] <= k) d2[i] = Math.max(d2[i], i - l + 1 - (d[i] - d[l - 1]));
            }
        }

        System.out.println(Arrays.stream(d2).max().getAsInt());

        br.close();
    }
}