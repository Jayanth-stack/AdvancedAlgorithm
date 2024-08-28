
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] p = {5, 10, 4, 12, 5, 40, 6};
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        matrixChainOrder(p, m, s);

        System.out.print("Optimal parenthesization is: ");
        printOptimalParens(s, 0, n - 1);
        System.out.println("\nMinimum number of multiplications is: " + m[0][n - 1]);
    }

    public static void matrixChainOrder(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
