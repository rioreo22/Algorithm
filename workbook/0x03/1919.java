import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int['z' - 'a' + 1];
        for (char c : sc.next().toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : sc.next().toCharArray()) {
            alphabet[c - 'a']--;
        }

        int answer = 0;
        for (int i : alphabet) {
            answer += Math.abs(i);
        }

        System.out.println(answer);

    }
}