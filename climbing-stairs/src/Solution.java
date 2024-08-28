import java.util.HashMap;
import java.util.Map;

public class Solution {
    final Map<Integer, Integer> calculated = new HashMap<>();

    public int climbStairs(final int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (this.calculated.containsKey(n)) {
            return this.calculated.get(n);
        }

        final int result = this.climbStairs(n - 1) + this.climbStairs(n - 2);
        this.calculated.put(n, result);

        return result;
    }
}