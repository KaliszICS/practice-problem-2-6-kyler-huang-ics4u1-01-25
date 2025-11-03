public class PracticeProblem {

    public static int[] bubbleSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (nums[j] > nums[j + 1]) {
                    double temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps += 3;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return new int[]{swaps, steps};
    }

    public static int[] selectionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                steps++;
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

    public static int[] insertionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            double key = nums[i];
            int j = i - 1;

            while (j >= 0) {
                steps++;
                if (nums[j] > key) {
                    nums[j + 1] = nums[j];
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }

            nums[j + 1] = key;
            swaps++;
        }

        return new int[]{swaps, steps};
    }

    public static String leastSwaps(double[] nums) {
        double[] arr1 = nums.clone();
        double[] arr2 = nums.clone();
        double[] arr3 = nums.clone();

        int[] bubble = bubbleSort(arr1);
        int[] selection = selectionSort(arr2);
        int[] insertion = insertionSort(arr3);

        int min = Math.min(bubble[0], Math.min(selection[0], insertion[0]));

        String result = "Bubble";
        if (insertion[0] == min && result.compareTo("Insertion") > 0) result = "Insertion";
        if (selection[0] == min && result.compareTo("Selection") > 0) result = "Selection";
        if (bubble[0] == min && result.compareTo("Bubble") > 0) result = "Bubble";

        return result;
    }

    public static String leastIterations(double[] nums) {
        double[] arr1 = nums.clone();
        double[] arr2 = nums.clone();
        double[] arr3 = nums.clone();

        int[] bubble = bubbleSort(arr1);
        int[] selection = selectionSort(arr2);
        int[] insertion = insertionSort(arr3);

        int min = Math.min(bubble[1], Math.min(selection[1], insertion[1]));

        String result = "Bubble";
        if (insertion[1] == min && result.compareTo("Insertion") > 0) result = "Insertion";
        if (selection[1] == min && result.compareTo("Selection") > 0) result = "Selection";
        if (bubble[1] == min && result.compareTo("Bubble") > 0) result = "Bubble";

        return result;
    }
}
