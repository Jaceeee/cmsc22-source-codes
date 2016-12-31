package machineproblems.mp5;

import java.util.Scanner;

/**
 * Created by Juan Carlos on 11/19/2016.
 */

/*
notes on concurrency
with an x = 10000

Rationale for using x = 10000:
A small enough input size will not significantly affect running time of the multithreaded program.

Also, one could note that a sufficiently large enough THREADCOUNT would significantly stall the program!

Methodology:
    -Alternated using 1 thread and 3 threads in presenting the Rule30 generations, while varying the input size to find the
expected scenario which would prove the hypothesis that (more threads == faster program execution)

    -Found out that 3 threads could be helpful enough in lessening program duration.

THREADCOUNT = 3 thread
Trial1 = 152789 ms (milliseconds)
Trial2 = 125759 ms
Trial3 = 120253 ms
=================
Average = 132934 ms

THREADCOUNT = 1 thread
Trial1 = 318421 ms
Trial2 = 335653 ms
Trial3 = 335825 ms
=================
Average = 329966 ms

additionally, the experimenter tried to increase the THREADCOUNT while retaining input size x = 10000
THREADCOUNT = 10 threads
Trial1 = 180209 ms
Trial2 = 180868 ms
Trial3 = 177932 ms
=================
Average = 179670 ms

which is not as fast as we expected it to be. It must be over some sort of threshold or limit for the number of threads
needed for an efficient multithreaded program

a concurrent threaded Rule30 program
took approx. 130 s for 1 thread (2 and a half mins)
and approx 330 s for 3 3 threads (5 mins)

3 seems to be the optimal number of threads for the optimal time complexity
using more than 3 threads slows the program down depending on the amount of input

NOTE: input for a minimum of 3 trials each, using x = 10000.
NOTE: The time complexity for the algorithm presented above is dependent on a loosely bounded input of x >= 10000. Meaning
        at an input size of 10000, a program running 3 threads is faster than a program running 1 thread.
NOTE: All data used are dependent on the algorithm below. Representing the time complexity of other multi-threaded algorithms
        using the aforementioned data is ill-advised. Also, this would depend on hardware components similar to those used by the
        experimenter.
*/


public class Rule30Tester {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        int x;
//        Scanner input = new Scanner(System.in);
//        x = input.nextInt();
        x = 100;
        Rule30Threads[] cellRange = new Rule30Threads[THREAD_COUNT];

        int cellsPerThread = x / THREAD_COUNT;

        boolean[] arr = new boolean[x];

        for (int i = 0; i < x; i++) {
            arr[i] = false;
            if (i == x / 2) {
                arr[i] = true;
            }
            System.out.print((arr[i]) ? "1" : "0");
        }
        System.out.println("");

        for (int i = 0; i < x; i++) {
            int start = 0;
            int end = start + cellsPerThread - 1;
            for (int j = 0; j < THREAD_COUNT; j++) {
                cellRange[j] = new Rule30Threads(arr, start, end);
                start = end + 1;
                end = (j + 1 < THREAD_COUNT - 1) ? start + cellsPerThread - 1 : x - 1;
            }

            for (int j = 0; j < THREAD_COUNT; j++) {
                cellRange[j].start();
            }

            for (int j = 0; j < THREAD_COUNT; j++) {
                while (cellRange[j].isAlive()) {
                    try {
                        cellRange[j].join();
                    } catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
                if (i < x - 1) {
                    System.out.print(cellRange[j]);
                    cellRange[j].changeOrigArray(arr);
                }
            }

            System.out.println();
        }

        System.out.println("Time it took in ms: " + (System.currentTimeMillis() - startTime));
//        for output execution time checking.
    }

    private static class Rule30Threads extends Thread {
        boolean[] temp;
        boolean[] arr;
        int start;
        int end;
        String threadDisp;

        public Rule30Threads(boolean[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
            temp = new boolean[end - start + 1];
            threadDisp = "";
        }

        public void run() {
            boolean[] pat = new boolean[3];
            for (int i = start; i <= end; i++) {
                pat[0] = (i != 0) ? arr[i - 1] : false;
                pat[1] = arr[i];
                pat[2] = (i + 1 != arr.length) ? arr[i + 1] : false;

                temp[i - start] = pat[0] ^ (pat[1] | pat[2]);
                threadDisp += (temp[i - start]) ? "1" : "0";
            }
        }

        @Override
        public String toString() {
            return threadDisp;
        }

        void changeOrigArray(boolean[] arr) {
            for (int i = start; i <= end; i++) {
                arr[i] = temp[i - start];
            }
        }
    }
}

/*
for input size x = 100, one thread
Trial1: 120 ms
Trial2: 185 ms
Trial3: 74 ms
Average: 126 ms

for input size x = 100, three threads
Trial1: 98 ms
Trial2:  95 ms
Trial3: 115 ms
Average = 103 ms

for input size, x = 100, two threads
Trial1: 140 ms
Trial2:
Trial3:


*/
