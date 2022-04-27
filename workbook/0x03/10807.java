import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if (arr[n - 1] < x) {
            System.out.println(0);
            return;
        }

        int i = 0;
        int answer = 0;
        while (i <= n - 1) {
            if (arr[i] > x) break;
            if (arr[i] == x)
                answer++;
            i++;
        }

        System.out.println(answer);
    }
}
