import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.print('A');
            return;
        }

        if (score >= 80) {
            System.out.print('B');
            return;
        }

        if (score >= 70) {
            System.out.print('C');
            return;
        }

        if (score >= 60) {
            System.out.print('D');
            return;
        }

        System.out.print('F');

    }
}