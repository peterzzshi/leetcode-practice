class Solution {
    public int[] twoSum(final int[] numbers, final int target) {
        int start = 0;
        int end = numbers.length - 1;

        final int[] answer = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                return answer;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return answer;
    }
}