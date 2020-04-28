public class Trie{
    // Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;
    // class for Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents end of a word i.e. leaf node
        boolean isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    static TrieNode root;
    // If not key present, inserts into trie
// If the key is prefix of Trie node,
// marks leaf node
    static void insert(String key){
        int level;
        int keyLength = key.length();
        int i;
        TrieNode curr = root;
        for (level = 0; level < keyLength; level++) {
            i = key.charAt(level) - 'a';
            if (curr.children[i] == null){
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }
    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int keyLength = key.length();
        int i;
        TrieNode curr = root;
        for (level = 0; level < keyLength; level++) {
            i = key.charAt(level) - 'a';
            if (curr.children[i] == null){
                return false;
            }
            curr = curr.children[i];
        }
        return (curr != null && curr.isEndOfWord);
    }

    public static void main(String args[]) {
// Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        if(args.length>0)
        {
            keys = args;
        }
        root = new TrieNode();
        int i;
        for (i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }
        long startTime = System.nanoTime();
        System.out.print("Searching for one in the trie returns: "+search("one"));
        long endTime = System.nanoTime();
        long TimeTaken = endTime - startTime;
        System.out.println(". Time: "+TimeTaken);
        startTime = System.nanoTime();
        System.out.print("Searching for seventy in the trie returns: "+search("seventy"));
        endTime = System.nanoTime();
        TimeTaken = endTime - startTime;
        System.out.println(". Time: "+TimeTaken);
        startTime = System.nanoTime();
        System.out.print("Searching for banana in the trie returns: "+search("banana"));
        endTime = System.nanoTime();
        TimeTaken = endTime - startTime;
        System.out.println(". Time: "+TimeTaken);
    }
//end of class
}
