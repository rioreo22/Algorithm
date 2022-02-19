import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int['z' - 'a' + 1];

        for (char c : sc.next().toCharArray()) {
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : alphabet) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);

    }
}