package g0701_0800.s0748_shortest_completing_word;

// #Easy #Array #String #Hash_Table

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] a = new int[26];

        for (int i = 0; i < licensePlate.length(); i++) {
            if (Character.isLetter(licensePlate.charAt(i))) {
                a[licensePlate.charAt(i) - 'a']++;
            }
        }
        String ans = "";
        for (String str : words) {
            int[] a1 = new int[26];
            for (int j = 0; j < str.length(); j++) {
                a1[str.charAt(j) - 'a']++;
            }
            int j = 0;
            while (j < 26) {
                if (a[j] <= a1[j]) {
                    j++;
                } else {
                    break;
                }
            }

            if (j == 26) {
                if (ans.isEmpty()) {
                    ans = str;
                } else if (ans.length() > str.length()) {
                    ans = str;
                }
            }
        }
        return ans;
    }
}
