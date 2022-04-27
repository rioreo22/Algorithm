import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());

        while (times-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char[] chars = st.nextToken().toCharArray();
            char[] chars1 = st.nextToken().toCharArray();

            if (chars.length != chars1.length) {
                System.out.println("Impossible");
                continue;
            }

            Arrays.sort(chars);
            Arrays.sort(chars1);
            int length = chars.length;
            boolean flag = true;
            for (int i = 0; i < length; i++) {
                if (chars[i] != chars1[i]) {
                    System.out.println("Impossible");
                    flag = false;
                    break;
                }
            }

            if (flag) System.out.println("Possible");

        }
    }
}
