class Trie{
    class TrieNode{
        public char val;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public TrieNode(){};
        public TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private TrieNode root;
    public Trie(){
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word){
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                ws.children[c - 'a'] = new TrieNode(c);
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word){
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) 
                return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startWith(String prefix){
        TrieNode ws = root;
        for (int i = 0; i < prefix.length();i++){
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }

    //test main
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        obj.insert("app");
        boolean ans = obj.search("app");
        boolean ans1 = obj.startWith("app");
        System.out.println(ans);
    }
}

/**
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
*/
