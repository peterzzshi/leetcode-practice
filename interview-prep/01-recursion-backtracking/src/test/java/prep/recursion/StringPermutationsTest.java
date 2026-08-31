package prep.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringPermutationsTest {

    private final StringPermutations solver = new StringPermutations();

    @Test
    void distinctCharacters() {
        List<String> result = solver.permutations("abc");
        assertEquals(List.of("abc", "acb", "bac", "bca", "cab", "cba"), result);
    }

    @Test
    void singleCharacter() {
        assertEquals(List.of("a"), solver.permutations("a"));
    }

    @Test
    void emptyString() {
        assertEquals(List.of(""), solver.permutations(""));
    }

    @Test
    void duplicateCharactersProduceNoDuplicatePermutations() {
        List<String> result = solver.permutations("aab");
        assertEquals(3, result.size());
        assertEquals(List.of("aab", "aba", "baa"), result);
    }

    @Test
    void allSameCharacter() {
        assertEquals(List.of("aaa"), solver.permutations("aaa"));
    }
}
