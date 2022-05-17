import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        final Comparator<Integer> comp = (a, b) -> Long.compare(Long.parseLong(Integer.toString(a) + Integer.toString(b)), Long.parseLong(Integer.toString(b) + Integer.toString(a)));
        final StringBuilder sb = new StringBuilder();

        Arrays.stream(numbers).boxed().sorted(comp.reversed()).forEach(i -> {
            if (sb.length() == 0 && i == 0) return;
            sb.append(i);
        });

        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}