class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[j] = index in word1 where word2[j] can be matched
        // while matching word2[j...] from right to left.
        int[] suf = new int[m];

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                break;
            }

            suf[j] = i;
            i--;
        }

        int[] ans = new int[m];

        int j = 0;
        boolean usedMismatch = false;

        for (i = 0; i < n && j < m; i++) {

            // Case 1: exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }

            // Case 2: use the one allowed mismatch
            else if (!usedMismatch) {

                // After choosing i, can we match
                // word2[j+1...] exactly?
                if (j == m - 1 || i + 1 <= suf[j + 1]) {

                    ans[j] = i;
                    j++;
                    usedMismatch = true;
                }
            }
        }

        // Couldn't form a valid sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}