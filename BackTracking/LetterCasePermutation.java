//784. Letter Case Permutation


class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> results = new ArrayList<>();
        helper("", results,S.toCharArray(), 0);
        return results;
    }
    private void helper(String sub, List<String> results, char[] chars, int index){
        if (index == chars.length){
            results.add(sub);
            return;
        } else {
            if (Character.isLetter(chars[index])){
                chars[index] = Character.toLowerCase(chars[index]);
                helper(sub + chars[index], results, chars, index + 1);
                chars[index] = Character.toUpperCase(chars[index]);
            }
            helper(sub + chars[index], results, chars, index + 1);
        }
    }
}
