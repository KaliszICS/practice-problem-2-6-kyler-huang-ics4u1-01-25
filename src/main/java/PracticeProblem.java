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
            swaps++; // assignment of key
            int j = i - 1;
            while (j >= 0) {
                steps++;
                if (nums[j] > key) {
                    nums[j + 1] = nums[j];
                    swaps++; // move counts as 1
                    j--;
                } else {
                    break;
                }
            }
            nums[j + 1] = key;
            swaps++; // final placement of key
        }

        return new int[]{swaps, steps};
    }

    public static String leastSwaps(double[] nums) {
        int[] bubble = bubbleSort(nums.clone());
        int[] insertion = insertionSort(nums.clone());
        int[] selection = selectionSort(nums.clone());

        int minSwaps = Math.min(Math.min(bubble[0], insertion[0]), selection[0]);

        if (bubble[0] == minSwaps) return "Bubble";
        if (insertion[0] == minSwaps) return "Insertion";
        return "Selection";
    }

    public static String leastIterations(double[] nums) {
        int[] bubble = bubbleSort(nums.clone());
        int[] insertion = insertionSort(nums.clone());
        int[] selection = selectionSort(nums.clone());

        int minSteps = Math.min(Math.min(bubble[1], insertion[1]), selection[1]);

        if (bubble[1] == minSteps) return "Bubble";
        if (insertion[1] == minSteps) return "Insertion";
        return "Selection";
    }
}
