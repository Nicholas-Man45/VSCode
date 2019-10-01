package LaiCode.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Dfs {

    /*
     * All subsets 1 Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”,
     * “b”, “bc”, “c”] Set = "", all the subsets are [""] Set = null, all the
     * subsets are []
     */

    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null || set.length() <= 1) {
            return result;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        subsets_helper(array, result, sb, 0);
        return result;
    }

    private void subsets_helper(char[] array, List<String> result, StringBuilder sb, int level) {
        if (array.length == level) {
            result.add(sb.toString());
            return;
        }
        // add
        subsets_helper(array, result, sb.append(array[level]), level + 1);
        sb.deleteCharAt(sb.length() - 1);
        // not add
        subsets_helper(array, result, sb, level + 1);
    }

    /**
     * All Valid Permutations Of Parentheses I N = 1, all valid permutations are
     * ["()"] N = 3, all valid permutations are ["((()))", "(()())", "(())()",
     * "()(())", "()()()"]
     */
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        validParentheses_helper(2 * n, n, n, result, sb, 0);
        return result;
    }

    private void validParentheses_helper(int total, int left, int right, List<String> result, StringBuilder sb,
            int level) {
        if (/* left == 0 && right == 0 */ total == level) {
            result.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            validParentheses_helper(total, left - 1, right, result, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right) {
            sb.append(')');
            validParentheses_helper(total, left, right - 1, result, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // permutation
  

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        String set = "abc";
        // List<String> sub = dfs.subSets(set);
        // System.out.println(sub.toString());

        List<String> pan = dfs.validParentheses(3);
        System.out.println(pan.toString());
    }

}