public class PracticeProblem {

    // ----------------- Bubble Sort -----------------
    public static int[] bubbleSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++; // comparison
                if (nums[j] > nums[j + 1]) {
                    double temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps += 3;
                    swapped = true;
                }
            }
            if (!swapped) break; // optimization: stop early if sorted
        }

        return new int[]{swaps, steps};
    }

    // ----------------- Selection Sort -----------------
    public static int[] selectionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                steps++; // comparison
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                double temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                swaps += 3;
            }
        }

        return new int[]{swaps, steps};
    }

    // ----------------- Insertion Sort -----------------
    public static int[] insertionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            double key = nums[i];
            swaps++; // assignment of key
            int j = i - 1;
            while (j >= 0) {
                steps++; // comparison
                if (nums[j] > key) {
                    nums[j + 1] = nums[j];
                    swaps++; // each move counts as 1
                    j--;
                } else {
                    break;
                }
            }
            nums[j + 1] = key;
            swaps++; // placing key
        }

        return new int[]{swaps, steps};
    }

    // ----------------- Least Swaps -----------------
    public static String leastSwaps(double[] nums) {
        double[] arr1 = nums.clone();
        double[] arr2 = nums.clone();
        double[] arr3 = nums.clone();

        int[] bubble = bubbleSort(arr1);
        int[] selection = selectionSort(arr2);
        int[] insertion = insertionSort(arr3);

        int minSwaps = Math.min(bubble[0], Math.min(selection[0], insertion[0]));
        String result = "";

        if (bubble[0] == minSwaps) result += "Bubble";
        if (insertion[0] == minSwaps) result += "Insertion";
        if (selection[0] == minSwaps) result += "Selection";

        // Return first alphabetically
        if (result.contains("Bubble")) return "Bubble";
        else if (result.contains("Insertion")) return "Insertion";
        else return "Selection";
    }

    // ----------------- Least Iterations (Steps) -----------------
    public static String leastIterations(double[] nums) {
        double[] arr1 = nums.clone();
        double[] arr2 = nums.clone();
        double[] arr3 = nums.clone();

        int[] bubble = bubbleSort(arr1);
        int[] selection = selectionSort(arr2);
        int[] insertion = insertionSort(arr3);

        int minSteps = Math.min(bubble[1], Math.min(selection[1], insertion[1]));
        String result = "";

        if (bubble[1] == minSteps) result += "Bubble";
        if (insertion[1] == minSteps) result += "Insertion";
        if (selection[1] == minSteps) result += "Selection";

        // Return first alphabetically
        if (result.contains("Bubble")) return "Bubble";
        else if (result.contains("Insertion")) return "Insertion";
        else return "Selection";
    }
}
