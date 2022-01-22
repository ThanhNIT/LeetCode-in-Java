package g0601_0700.s0677_map_sum_pairs;

// #Medium #String #Hash_Table #Design #Trie

public class MapSum {
    static class Node {
        int val;
        Node[] child;

        Node() {
            child = new Node[26];
            val = 0;
        }
    }

    private final Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node curr = root;
        for (char c : key.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new Node();
            }
            curr = curr.child[c - 'a'];
        }
        curr.val = val;
    }

    private int sumHelper(Node root) {
        int o = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                o += root.child[i].val + sumHelper(root.child[i]);
            }
        }
        return o;
    }

    public int sum(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                return 0;
            }
            curr = curr.child[c - 'a'];
        }
        int sum = curr.val;
        return sum + sumHelper(curr);
    }
}
