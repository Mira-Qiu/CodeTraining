class Solution {
    public boolean isValid(String s) {
       
        if (s == null || s.length() == 0) return true;
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() )
                    return false;
                else if (stack.pop() != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

Time complixcity: O(n), because we simply traverse the given string one character at a time. push and pop in a stack take O(1) time
Space complexity: O(n), as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack.
