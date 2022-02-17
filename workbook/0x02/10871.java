import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        int temp;
        while (st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());
            if (temp < x) sb.append(temp).append(' ');
        }

        System.out.println(sb);

    }
}