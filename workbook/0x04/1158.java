import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue q = new LinkedList();

        List result = new ArrayList();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        IntStream.range(1, n + 1).forEach(i -> q.offer(i));
        int count = 1;
        while (!q.isEmpty()) {
            if (count % k == 0) {
                result.add(q.poll());
            } else {
                q.offer(q.poll());
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();

        sb.append('<');
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != result.size() - 1) sb.append(", ");
        }
        sb.append('>');

        System.out.println(sb);
    }
}
