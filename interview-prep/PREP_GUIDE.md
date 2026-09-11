# Reap (HK) — Software Engineer Interview Prep Guide

Context: 90-minute live technical + live-coding round, ~leetcode-medium level (confirmed with recruiter), no AI allowed,
handwritten cheat sheet allowed. Role's production stack is TypeScript, but practice below is in Java (candidate's
stronger language) since the requirements are stated implementation-agnostically — if the actual round turns out to
require TypeScript, re-read each `REQUIREMENTS.md` and re-implement there; none of the specs assume Java-only behavior.

## What we know about Reap's process (from Glassdoor, scraped 2026-08-29)

**Software Engineer track:**

- 1 technical round with the CTO + 1 behavioral round.
- Described as "easy data structures questions," quick turnaround, generally positive experience.
- One leaked question: **longest consecutive sum in array** (already covered in this repo — see
  `../longest-consecutive-sequence` and `../maximum-subarray`).

**Engineering Manager track** (more senior, but same company/interview culture — useful signal even though it's a
different level):

- Candidates download and run the company's own code locally for the exercise (not a blank slate).
- Leaked questions: **sort a string's permutations**, **fix broken unit tests** (one test case was *intentionally*
  wrong — testing whether the candidate reasons about correctness rather than just chasing green), **apply recursion to
  print permutations**.
- Reviewer noted heavy time pressure near the end and a strong preference from interviewers for one particular
  implementation style over other valid approaches — so lead with a clean, conventional solution rather than a
  clever/unusual one, and be ready to defend trade-offs if pushed.

No public source describes Reap-specific system-design or OOP questions — the OOP/ETL/CRUD themes below are informed
guesses based on Reap's business (card issuance, treasury, cross-border payments, ledgers), not leaked questions. Treat
the recursion + broken-test items as the most concretely confirmed prep targets, and the rest as
reasonable-but-speculative coverage.

## 3-day plan

**Day 1 — Fundamentals refresh (arrays, strings, hashmaps, two pointers).** Timed at 25-30 min each, in IntelliJ, no
autocomplete crutches:

- Two Sum → Group Anagrams
- Longest Substring Without Repeating Characters
- 3Sum
- Product of Array Except Self
- Longest Consecutive Sequence
- Container With Most Water

**Day 2 — Trees, graphs, BFS/DFS, and this repo's `interview-prep/` exercises 1 & 2**
(recursion/backtracking, then OOP wallet-ledger):

- Binary Tree Level Order Traversal
- Validate BST
- Number of Islands
- Course Schedule (topological sort)
- Clone Graph
- LRU Cache
- `interview-prep/01-recursion-backtracking` (permutations — directly mirrors leaked EM questions)
- `interview-prep/02-oop-wallet-ledger` (OOP modeling, payments-themed)

**Day 3 — DP, intervals, remaining `interview-prep/` exercises, full mock:**

- Coin Change, Longest Increasing Subsequence, House Robber
- Merge Intervals, Meeting Rooms II
- `interview-prep/03-etl-transaction-pipeline` (ETL/data transform)
- `interview-prep/04-fix-the-broken-test` (mirrors the leaked "fix unit tests" exercise — do this one **last**, after
  you've warmed up, since it's about reasoning under a time-boxed, slightly adversarial setup)
- One full 90-minute mock: 2 unseen mediums, talk out loud, no syntax lookups.

## Interview-day checklist

- [ ] Clarify constraints/edge cases out loud before coding (empty input, duplicates, negatives, overflow)
- [ ] State approach + Big-O before writing code
- [ ] Use IntelliJ shortcuts comfortably (extract method, rename, quick fixes) — no copilot to lean on
- [ ] Write brute force first if stuck, then optimize
- [ ] Test with at least one edge case manually after writing code
- [ ] Narrate while debugging
- [ ] If a test/requirement seems inconsistent, say so explicitly and reason about which side is wrong before "fixing"
  anything — this was called out as a specific evaluation point at this company
- [ ] Lead with a clean, conventional solution before an unusual one; explain trade-offs if the interviewer pushes

## Handwritten cheat sheet contents

- Java collection method signatures you always forget: `Map.getOrDefault`, `PriorityQueue` comparator syntax,
  `Collections.sort` with lambda, `Arrays.sort(int[][], Comparator)`
- Time complexity table: HashMap O (1), TreeMap O (log n), ArrayDeque as stack/queue
- Templates: BFS/DFS skeleton, binary search skeleton, sliding window skeleton, backtracking skeleton, Union-Find
  skeleton
- Formulas: modulo arithmetic for hashing, prefix sums, round-half-up rounding pattern (BigDecimal)

## Practice repos in `interview-prep/`

Each is a small, independent Maven project (open the folder in IntelliJ — it'll detect the `pom.xml`
and import it; JUnit 5 tests run via the green gutter arrow, the same workflow as a real take-home). Each has a
`REQUIREMENTS.md` (read this like a real interviewer's spec) and skeleton code with
`throw new UnsupportedOperationException("TODO")` where you need to implement.

1. **`01-recursion-backtracking`** — string permutations (sorted, dedupe on repeated chars) + array permutations via
   recursion. Directly mirrors the two leaked EM-round recursion questions.
2. **`02-oop-wallet-ledger`** — design/implement an in-memory ledger: deposit, withdraw, atomic transfer with
   idempotency, balance, transaction history. Payments-domain OOP modeling practice.
3. **`03-etl-transaction-pipeline`** — dedupe transactions by idempotency key, currency conversion, aggregate spend by
   category/merchant/month. ETL/data-processing practice.
4. **`04-fix-the-broken-test`** — a fully-implemented `FeeCalculator` plus a test suite where exactly one test
   contradicts the written spec. Find it, decide whether the code or the test is wrong, fix it, and be ready to explain
   your reasoning. Do this one under a real time box (30-40 min) — don't ask for the answer until you've formed and
   tried a hypothesis.

Work through them in order in IntelliJ; ask for a review of your implementation once you're done with each, or ask for a
hint if you get stuck for more than ~15 minutes past the time box.
