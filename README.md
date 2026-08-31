# leetcode-practice

A single Maven module containing LeetCode practice solutions, organized as flat Java packages under `com.leetcode`.

## Structure

```
leetcode-practice/
├── pom.xml                          # single Maven build for all solutions
├── src/main/java/com/leetcode/
│   ├── common/                      # shared helper types (ListNode, TreeNode, ...)
│   ├── twosum/Solution.java
│   ├── binarysearch/Solution.java
│   ├── validparentheses/Solution.java
│   └── ...
├── src/test/java/com/leetcode/...   # optional unit tests, mirrors main package layout
└── interview-prep/                  # separate, standalone Maven modules (unrelated exercises)
```

Each LeetCode problem lives in its own leaf package named after the problem (e.g. `com.leetcode.twosum`),
with no intermediate category grouping (`arrays`, `trees`, ...). Categorization was dropped because many
problems legitimately span more than one category (e.g. a stack-based string problem, or an array problem
solved with two pointers), which made forcing a single category arbitrary and prone to disagreement/churn
as solutions are revisited. This also replaces the earlier layout of one top-level folder + one IntelliJ
module per problem, which required 60+ hand-maintained `.iml` files and was easy to break (as happened
with the earlier indexing issues).

Shared data structures used across multiple problems (`ListNode`, `TreeNode`, etc.) live once in
`com.leetcode.common` instead of being duplicated per problem.

## Adding a new problem

1. Create a new package named after the problem (lowercase, no separators), e.g. `numislands`, directly
   under `src/main/java/com/leetcode/`.
2. Add your solution class there with the matching `package` declaration:

   ```java
   package com.leetcode.numislands;

   public class Solution {
       public int numIslands(char[][] grid) {
           // ...
       }
   }
   ```

3. If the problem needs a shared type (e.g. `ListNode`, `TreeNode`), import it from `com.leetcode.common`
   instead of redefining it.
4. If you introduce a genuinely new shared type, add it to `com.leetcode.common` so other problems can reuse it.
5. (Optional) Add a test under `src/test/java/com/leetcode/<same-package>/SolutionTest.java`.
6. No new `.iml` file, no `.idea/modules.xml` edit, and no new Maven module are needed — the IDE and Maven
   pick up the new package automatically as part of the single `leetcode-practice` module.

## Adding an alternative solution to an existing problem

If you want to keep multiple approaches to the same problem (e.g. brute force vs. optimized), avoid a naming
clash by using distinct class names in the same package, for example:

```java
package com.leetcode.twosum;

public class BruteForceSolution { ... }
public class HashMapSolution { ... }
```

or nest them under a sub-package such as `com.leetcode.twosum.v2`.

## Building and running

```
mvn -q compile        # compile all solutions
mvn -q test           # run tests, if any are added
```

## `interview-prep/`

The `interview-prep/` exercises are intentionally kept as their own standalone Maven modules (already
registered in `.idea/misc.xml` as separate `pom.xml` projects), since they represent independent
mini-projects rather than single-class LeetCode solutions.
