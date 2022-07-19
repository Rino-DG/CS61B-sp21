package deque;
import edu.princeton.cs.algs4.Stopwatch;

public class TimeArrayDequeTest {
    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        ArrayDeque<Integer> testresultN = new ArrayDeque<>();
        ArrayDeque<Double> testresulttime = new ArrayDeque<>();

        for (int n = 1000; n <= 128000; n = n * 2) {
            /* Add n to the AList that will hold the number of items tested */
            testresultN.addLast(n);

            ArrayDeque<Integer> test = new ArrayDeque<>();


            for (int start = 0; start <= n; start++) {
                test.addLast(start);
            }

            Stopwatch sw = new Stopwatch();
            for (int start = 0; start <= n; start++) {
                test.size();
            }
            double TimeInSeconds = sw.elapsedTime();
            testresulttime.addLast(TimeInSeconds);

        }

        printTimingTable(testresultN, testresulttime, testresultN);
    }


}
