import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] str = new char[n];
        Arrays.fill(str, ' ');

        for (int i = 0; i < n; i++) {
            str[n - i - 1] = '*';
            System.out.println(str);
        }

    }
}