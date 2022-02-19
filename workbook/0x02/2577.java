import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        num *= sc.nextInt();
        num *= sc.nextInt();

        int[] count = new int[10];

        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }

        for (int i : count) {
            System.out.println(i);
        }

    }
}