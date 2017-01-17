package facebook.hackercup;

import java.util.Scanner;


public class Q3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());

        int tcase = 1;

        while (T-- > 0) {

            String NMK = in.nextLine();
            String anmk[] = NMK.split(" ");
            int N = Integer.parseInt(anmk[0]);
            int M = Integer.parseInt(anmk[1]);
            int K = Integer.parseInt(anmk[2]);
            int towns[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    towns[i][j] = -1;
                }
            }

            int n = N;
            int m = M;
            int k = K;

            while (M-- > 0) {

                String ABG[] = in.nextLine().split(" ");
                int A = Integer.parseInt(ABG[0]);
                int B = Integer.parseInt(ABG[1]);
                int G = Integer.parseInt(ABG[2]);
                if (towns[A-1][B-1] == -1) {
                    towns[A - 1][B - 1] = towns[B - 1][A - 1] = G;
                } else {
                    towns[A - 1][B - 1] = towns[B - 1][A - 1] = Math.min(G,towns[A-1][B-1]);
                }
            }

            int index = 0;
            Move moves[] = new Move[K];
            while (K-- > 0) {
                String SD[] = in.nextLine().split(" ");
                int S = Integer.parseInt(SD[0]);
                int D = Integer.parseInt(SD[1]);
                Move mv = new Move();
                mv.s = S - 1;
                mv.d = D - 1;
                moves[index++] = mv;
            }

            int result = (int) solve(towns, moves, n, m, k);
            System.out.println("Case #" + tcase + ": " + result);
            tcase++;
        }
    }



    private static long solve(int[][] towns, Move[] moves, int n, int m, int k) {

        long dist[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (towns[i][j] > 0) dist[i][j] = towns[i][j];
                else dist[i][j] = 1000000000;
            }
            dist[i][i] = 0;
        }

        for (int k1 = 0; k1 < n; k1++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k1] + dist[k1][j] < dist[i][j])
                        dist[i][j] = dist[i][k1] + dist[k1][j];
                }
            }
        }

        long[][] dp = new long[moves.length][2];
        for(int i = 0; i<moves.length;i++) {
            dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
        }

        int l = 0;
        dp[l][0] = dist[0][moves[l].s] + dist[moves[l].s][moves[l].d];
        if (l+1 < moves.length) {
            dp[l][1] = dist[0][moves[l].s] + dist[moves[l].s][moves[l+1].s] + dist[moves[l+1].s][moves[l].d];
        }

        for (int i = 1; i < moves.length; i++) {
            long x = dp[i-1][0] + dist[moves[i-1].d][moves[i].s] + dist[moves[i].s][moves[i].d];
            long y = dp[i-1][1] + dist[moves[i-1].d][moves[i].d];
            dp[i][0] = Math.min(x, y);
            if (i+1 < moves.length) {
                x = dp[i-1][1] + dist[moves[i-1].d][moves[i+1].s] + dist[moves[i+1].s][moves[i].d];
                y = dp[i-1][0] + dist[moves[i-1].d][moves[i].s] + dist[moves[i].s][moves[i+1].s] + dist[moves[i+1].s][moves[i].d];
                dp[i][1] = Math.min(x, y);
            }
        }
        return Math.min(dp[moves.length-1][0], dp[moves.length-1][1]) >= 1000000000 ? -1 :
                Math.min(dp[moves.length-1][0], dp[moves.length-1][1]);
    }

    static class Move {
        int s;
        int d;

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
    }
}
