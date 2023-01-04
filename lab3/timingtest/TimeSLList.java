package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.List;

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
        System.out.printf("Timing table for getLast\n");
        AList<Integer> Ns = new AList();
        AList<Double> times = new AList();
        for (int x = 1000; x <= 128000; x *= 2) {
            Ns.addLast(x);
            SLList<Integer> items = new SLList();
            for (int i=0;i < x;i++) {
                items.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for (int i=0;i < 10000;i++) {
                items.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        AList<Integer> opCounts = new AList();
        for(int i =0;i < 8; i++ ){
            opCounts.addLast(10000);
        }
        printTimingTable(Ns,times,opCounts);

    }

}
