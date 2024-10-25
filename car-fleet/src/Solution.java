import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int carFleet(final int target, final int[] position, final int[] speed) {

        final int n = position.length;
        final int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (c1, c2) -> Integer.compare(c2[0], c1[0]));

        final Stack<Double> stack = new Stack<>();

        for (final int[] car : cars) {
            final double eta = (double) (target - car[0]) / car[1];
            if (stack.isEmpty() || eta > stack.peek()) {
                stack.push(eta);
            }
        }

        return stack.size();
    }
}