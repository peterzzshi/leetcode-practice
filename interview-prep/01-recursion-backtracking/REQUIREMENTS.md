# Practice: Recursion & Backtracking

Simulates Reap's leaked questions: "sort string (permutations)" and "apply recursion to print
permutations." Time-box: 45 minutes total for both tasks. Don't look at existing solutions elsewhere
in this repo (e.g. `subsets`, `letter-combinations-of-a-phone-number`) until you've attempted these.

## Task A — StringPermutations

Implement `List<String> permutations(String s)`:
- Returns all distinct permutations of the characters in `s`.
- The returned list must be sorted in lexicographic order.
- If `s` has duplicate characters (e.g. `"aab"`), the result must not contain duplicate permutations.
- `s` may be empty (return a list containing just the empty string) but will not be `null`.

Talk through: time complexity, and how you avoid generating duplicate permutations when there are
repeated characters — an interviewer will push back if you just dedupe with a `Set` after generating
everything; they want to see pruning during the recursion.

## Task B — ArrayPermutations

Implement `List<List<Integer>> printPermutations(int[] nums)`:
- Prints every permutation of `nums` (distinct integers) to stdout, one per line, space-separated.
- Also returns the permutations as a `List<List<Integer>>` (this is what the tests assert against —
  printing alone isn't practically testable/verifiable in isolation).
- Must be done via recursion/backtracking (no library shortcuts).
- Order of permutations doesn't matter, but each must appear exactly once.

## What's provided

`StringPermutations.java` and `ArrayPermutations.java` have method stubs that throw
`UnsupportedOperationException("TODO")`. Replace with your implementation, then run the JUnit tests
in `src/test/java/prep/recursion/`.
