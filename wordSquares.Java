// word Squares
public class Solution {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
     
    //TrieNode
    class TrieNode{
        List<String> startWith;
        TrieNode[] children;
        TrieNode(){
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(String[] words){
            root = new TrieNode();
            for (String w : words){
                TrieNode cur = root;
                for (char c : w.toCharArray()){
                    int idx = c -'a';
                    if(cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }
        List<String> findByPrefix(String prefix){
            List<String> ans = new ArrayList();
            TrieNode cur = root;
            for (char c : prefix.toCharArray()){
                int idx = c -'a';
                if (cur.children[idx] == null)
                    return ans;
                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> ans = new ArrayList();
        if (words == null || words.length == 0) return ans;
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList();
        for (String word : words){
            int len = word.length();
            ansBuilder.add(word);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() -1);
        }
        return ans;
    }
    
    private void search(int len, Trie trie, List<List<String>> ans, List<String> ansBuilder){
        if(ansBuilder.size() == len){
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }
        
        int i = ansBuilder.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : ansBuilder){
            prefix.append(s.charAt(i));
        }
        
        // look up all the prefix in the root trie
        List<String> startWith = trie.findByPrefix(prefix.toString());
        for (String s : startWith){
            ansBuilder.add(s);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() -1);
        }
    }
}
