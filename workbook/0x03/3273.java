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
        int answer = 0;

        Arrays.sort(arr);

        int l = 0, r = n - 1;

        while (l < r) {
            if (arr[l] + arr[r] == x) {
                answer++;
                l++;
                r--;
                continue;
            }

            if (arr[l] + arr[r] < x) {
                l++;
                continue;
            }

            if (arr[l] + arr[r] > x) {
                r--;
                continue;
            }
        }

        System.out.println(answer);
    }
}
