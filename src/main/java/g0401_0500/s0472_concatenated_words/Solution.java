package g0401_0500.s0472_concatenated_words;

// #Hard #Array #String #Dynamic_Programming #Depth_First_Search #Trie

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private final List<String> ans = new ArrayList<>();
    private Trie root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;
        for (String word : words) {
            Trie ptr = root;
            if (search(word, 0, 0)) {
                ans.add(word);
            } else {
                for (int j = 0; j < word.length(); j++) {
                    if (ptr.nxt[word.charAt(j) - 'a'] == null) {
                        ptr.nxt[word.charAt(j) - 'a'] = new Trie();
                    }
                    ptr = ptr.nxt[word.charAt(j) - 'a'];
                }
                ptr.endHere = true;
            }
        }
        return ans;
    }

    private boolean search(String cur, int idx, int word_cnt) {
        if (idx == cur.length()) {
            return word_cnt >= 2;
        }
        Trie ptr = root;
        for (int i = idx; i < cur.length(); i++) {
            if (ptr.nxt[cur.charAt(i) - 'a'] == null) {
                return false;
            }
            if (ptr.nxt[cur.charAt(i) - 'a'].endHere) {
                boolean ret = search(cur, i + 1, word_cnt + 1);
                if (ret) {
                    return true;
                }
            }
            ptr = ptr.nxt[cur.charAt(i) - 'a'];
        }
        return ptr.endHere && word_cnt >= 2;
    }

    private static class Trie {
        Trie[] nxt;
        boolean endHere;

        Trie() {
            nxt = new Trie[26];
            endHere = false;
        }
    }
}