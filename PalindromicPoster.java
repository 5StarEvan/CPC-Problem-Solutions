import java.io.*;
import java.util.*;

public class PalindromicPoster{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    public static void main(String[] args) throws IOException {

        int n = readInt();
        int m = readInt();
        int r = readInt();
        int c = readInt();

        char[][] arrs = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(arrs[i], 'a');
        }

        int rows_left = n - r;
        int columns_left = m - c;

        if (r == 0 && c == 0) {
            for (int i = 0; i < n; i++) {
                arrs[i][0] = 'b';
            }
            for (int i = 0; i < m; i++) {
                arrs[0][i] = 'b';
            }
            arrs[0][0] = 'c';
        } else if (r == 0) {
            for (int i = 0; i < n; i++) {
                arrs[i][0] = 'b';
            }
            for (int i = 0; i < m && columns_left > 0; i++) {
                arrs[0][i] = 'c';
                columns_left--;
            }
        } else if (c == 0) {
            for (int i = 0; i < m; i++) {
                arrs[0][i] = 'b';
            }
            for (int i = 0; i < n && rows_left > 0; i++) {
                arrs[i][0] = 'c';
                rows_left--;
            }
        } else if (r == n && m % 2 == 0 && columns_left % 2 == 1) {
            System.out.println("IMPOSSIBLE");
            return;
        } else if (c == m && n % 2 == 0 && rows_left % 2 == 1) {
            System.out.println("IMPOSSIBLE");
            return;
        } else if (r == n) {
            if (columns_left % 2 == 1) {
                arrs[0][m/2] = 'b';
                columns_left--;
            }
            for (int j = 0; j < m && columns_left > 0; j++) {
                if (j % 2 == 0) {
                    arrs[0][j/2] = 'b';
                } else {
                    arrs[0][m-j/2 - 1] = 'b';
                }
                columns_left--;
            }
        } else if (c == m) {
            if (rows_left % 2 == 1) {
                arrs[n / 2][0] = 'b';
                rows_left--;
            }
            for (int j = 0; j < n && rows_left > 0; j++) {
                if (j % 2 == 0) {
                    arrs[j/2][0] = 'b';
                } else {
                    arrs[n-j/2-1][0] = 'b';
                }
                rows_left--;
            }
        } else {
            for (int i = 0; i < n && rows_left > 0; i++) {
                arrs[i][0] = 'b';
                rows_left--;
            }
            for (int i = 0; i < m && columns_left > 0; i++) {
                arrs[0][i] = 'c';
                columns_left--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arrs[i][j]);
            }
            System.out.println();
        }
    }
}