package com.leetcode.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(final String digits) {

        if (digits.isBlank()) {
            return new ArrayList<>();
        }

        final Map<Character, String> buttonMapping = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    }
}