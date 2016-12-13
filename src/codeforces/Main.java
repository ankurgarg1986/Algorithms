import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();  // The number of gas stations.
            int s = in.nextInt();  // The length of the road.
            long t = in.nextLong();  // The time limit.

            int[] prices = new int[n];
            int[] capacities = new int[n];
            int maxCapacity = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                prices[i] = in.nextInt();
                capacities[i] = in.nextInt();
                maxCapacity = Math.max(maxCapacity, capacities[i]);
            }

            int[] stations = new int[k];
            for (int i = 0; i < k; ++i)
                stations[i] = in.nextInt();
            Arrays.sort(stations);

            int low = 0, high = maxCapacity;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (check(mid, stations, s, t)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            if (!check(low, stations, s, t)) {
                out.println(-1);
            } else {
                int result = Integer.MAX_VALUE;
                for (int i = 0; i < n; ++i) {
                    if (capacities[i] >= low)
                        result = Math.min(result, prices[i]);
                }
                out.println(result);
            }
        }

        private static boolean check(int capacity, int[] stations, int dist, long limit) {
            int current = 0;
            long total = 0;
            for (int i = 0; i < stations.length; ++i) {
                int length = stations[i] - current;
                int normalDist = Math.max(0, 2 * length - capacity);
                int accDist = length - normalDist;
                if (accDist < 0) return false;
                total += accDist + 2*normalDist;
                current = stations[i];
            }

            // Cover the last stretch.
            int length = dist - current;
            int normalDist = Math.max(0, 2 * length - capacity);
            int accDist = length - normalDist;
            if (accDist < 0) return false;
            total += accDist + 2*normalDist;
            return total <= limit;
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private static final int BUFFER_SIZE = 32768;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}