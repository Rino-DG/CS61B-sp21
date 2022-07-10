package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ntested = new AList<>();
        AList<Double> testtime = new AList<>();
        AList<Integer> opslist = new AList<>();

        for (int n = 1000; n <= 64000; n = n*2) {
            /* Add n to the AList that will hold the number of items tested */
            Ntested.addLast(n);
            SLList<Integer> test = new SLList<>();

            for(int start = 0; start <= n; start++) {
                test.addLast(start);
            }
            Integer OpsPerN = 10000;
            Stopwatch sw = new Stopwatch();

            for(int start = 0; start <= n; start++) {
                test.getLast();
            }

            double TimeInSeconds = sw.elapsedTime();
            testtime.addLast(TimeInSeconds);
            opslist.addLast(OpsPerN);

        }

        printTimingTable(Ntested, testtime, opslist);
    }
}
