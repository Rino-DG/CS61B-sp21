package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> testresultN = new AList<>();
        AList<Double> testresulttime = new AList<>();

        for (int n = 1000; n <= 128000; n = n*2) {
            /* Add n to the AList that will hold the number of items tested */
            testresultN.addLast(n);

            AList<Integer> test = new AList<>();
            Stopwatch sw = new Stopwatch();

            for(int start = 0; start <= n; start++) {
                test.addLast(start);
            }
            double TimeInSeconds = sw.elapsedTime();

            testresulttime.addLast(TimeInSeconds);

        }

        printTimingTable(testresultN, testresulttime, testresultN);
    }
}
