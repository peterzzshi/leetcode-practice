package prep.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private List<List<Integer>> capturedPermutations() {
        String printed = out.toString().trim();
        if (printed.isEmpty()) return List.of();
        return Arrays.stream(printed.split("\n"))
                .map(line -> Arrays.stream(line.trim().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Test
    void printsAllPermutationsOfThreeElements() {
        solver.printPermutations(new int[]{1, 2, 3});
        List<List<Integer>> perms = capturedPermutations();

        assertEquals(6, perms.size(), "3 elements should yield 3! = 6 permutations");
        Set<List<Integer>> unique = new HashSet<>(perms);
        assertEquals(6, unique.size(), "no permutation should repeat");
        for (List<Integer> perm : perms) {
            assertEquals(List.of(1, 2, 3), perm.stream().sorted().collect(Collectors.toList()));
        }
    }

    @Test
    void singleElement() {
        solver.printPermutations(new int[]{5});
        assertEquals(List.of(List.of(5)), capturedPermutations());
    }

    @Test
    void twoElements() {
        solver.printPermutations(new int[]{1, 2});
        List<List<Integer>> perms = capturedPermutations();
        assertEquals(2, perms.size());
        assertTrue(perms.contains(List.of(1, 2)));
        assertTrue(perms.contains(List.of(2, 1)));
    }
}
