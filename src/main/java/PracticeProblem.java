public class PracticeProblem {

    public static void main(String[] args) {
        double[] values = {155.2, 155.1, 1, 5, 3, 2, 7};
        System.out.println(insertionSort(values)[0]);
    }

    // -------------------------------
    // Insertion Sort
    // -------------------------------
    public static int[] insertionSort(double[] data) {
        int[] counters = new int[]{0, 0}; // [0] = swaps, [1] = steps

        for (int index = 1; index < data.length; index++) {
            double key = data[index];
            int scan = index - 1;
            counters[0]++; // assignment to key

            while (scan >= 0 && data[scan] > key) {
                counters[1]++; // comparison
                data[scan + 1] = data[scan];
                scan--;
                counters[0]++; // shift
            }
            data[scan + 1] = key;
            counters[0]++; // placement
        }
        return counters;
    }

    // -------------------------------
    // Bubble Sort (optimized)
    // -------------------------------
    public static int[] bubbleSort(double[] data) {
        int[] counters = new int[]{0, 0}; // [0] = swaps, [1] = steps
        boolean swapped;

        for (int pass = 0; pass < data.length; pass++) {
            swapped = false;
            for (int pos = 1; pos < data.length - pass; pos++) {
                counters[1]++; // comparison
                if (data[pos] < data[pos - 1]) {
                    double hold = data[pos];
                    data[pos] = data[pos - 1];
                    data[pos - 1] = hold;
                    counters[0] += 3;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return counters;
    }

    // -------------------------------
    // Selection Sort
    // -------------------------------
    public static int[] selectionSort(double[] data) {
        int[] counters = new int[]{0, 0}; // [0] = swaps, [1] = steps

        for (int start = 0; start < data.length - 1; start++) {
            int smallest = start;
            for (int check = start + 1; check < data.length; check++) {
                counters[1]++;
                if (data[smallest] > data[check]) {
                    smallest = check;
                    counters[0]++;
                }
            }
            double temp = data[smallest];
            data[smallest] = data[start];
            data[start] = temp;
            counters[0] += 3;
        }
        return counters;
    }

    // -------------------------------
    // Least Swaps
    // -------------------------------
    public static String leastSwaps(double[] array) {
        int bubble = bubbleSort(array.clone())[0];
        int select = selectionSort(array.clone())[0];
        int insert = insertionSort(array.clone())[0];

        if (bubble < select && bubble < insert) {
            return "Bubble";
        } else if (select < bubble && select < insert) {
            return "Selection";
        } else if (insert < bubble && insert < select) {
            return "Insertion";
        } else if (insert == bubble || bubble == select) {
            return "Bubble";
        } else if (insert == select) {
            return "Insertion";
        } else {
            return "Selection";
        }
    }

    // -------------------------------
    // Least Iterations (Steps)
    // -------------------------------
    public static String leastIterations(double[] array) {
        int bubble = bubbleSort(array.clone())[1];
        int select = selectionSort(array.clone())[1];
        int insert = insertionSort(array.clone())[1];

        if (bubble < select && bubble < insert) {
            return "Bubble";
        } else if (select < bubble && select < insert) {
            return "Selection";
        } else if (insert < bubble && insert < select) {
            return "Insertion";
        } else if (insert == bubble || bubble == select) {
            return "Bubble";
        } else if (insert == select) {
            return "Insertion";
        } else {
            return "Selection";
        }
    }
}
