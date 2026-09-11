package prep.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayPermutationsTest {

    private final ArrayPermutations solver = new ArrayPermutations();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void redirectStdout() {
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void restoreStdout() {
        System.setOut(originalOut);
    }

    @Test
    void printsAllPermutationsOfThreeElements() {
        List<List<Integer>> perms = solver.printPermutations(new int[]{1, 2, 3});

        assertEquals(6, perms.size(), "3 elements should yield 3! = 6 permutations");
        Set<List<Integer>> unique = new HashSet<>(perms);
        assertEquals(6, unique.size(), "no permutation should repeat");
        for (List<Integer> perm : perms) {
            assertEquals(Set.of(1, 2, 3), new HashSet<>(perm));
        }
        assertTrue(out.toString().trim().lines().count() == 6, "must also print one line per permutation");
    }

    @Test
    void singleElement() {
        List<List<Integer>> perms = solver.printPermutations(new int[]{5});
        assertEquals(List.of(List.of(5)), perms);
    }

    @Test
    void twoElements() {
        List<List<Integer>> perms = solver.printPermutations(new int[]{1, 2});
        assertEquals(2, perms.size());
        assertTrue(perms.contains(List.of(1, 2)));
        assertTrue(perms.contains(List.of(2, 1)));
    }
}
