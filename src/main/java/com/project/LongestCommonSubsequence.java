package com.project;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "010010101";
        String Y = "0101101100";
        int m = X.length();
        int n = Y.length();
        int[][] L = new int[m + 1][n + 1];

        // Build the LCS table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS
        int index = L[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[--index] = X.charAt(i - 1);
                i--;
                j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS of " + X + " and " + Y + " is " + new String(lcs));
    }
}
