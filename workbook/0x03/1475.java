import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = new int[10];
        int input = Integer.parseInt(br.readLine());
        while (input > 0) {
            int i = input % 10;
            input /= 10;

            if (i == 6 && temp[6] > temp[9]) {
                temp[9]++;
                continue;
            }
            if (i == 9 && temp[9] > temp[6]) {
                temp[6]++;
                continue;
            }

            temp[i]++;
        }

        System.out.println(Arrays.stream(temp).max().getAsInt());

    }
}
