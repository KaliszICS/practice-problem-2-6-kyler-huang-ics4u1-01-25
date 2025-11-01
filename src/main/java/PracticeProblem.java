class PracticeProblem {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3};

        int[] bubbleResult = bubbleSort(arr.clone());
        int[] selectionResult = selectionSort(arr.clone());
        int[] insertionResult = insertionSort(arr.clone());

        System.out.println("Bubble: swaps=" + bubbleResult[0] + " steps=" + bubbleResult[1]);
        System.out.println("Selection: swaps=" + selectionResult[0] + " steps=" + selectionResult[1]);
        System.out.println("Insertion: swaps=" + insertionResult[0] + " steps=" + insertionResult[1]);

        System.out.println("Least swaps: " + leastSwaps(arr));
        System.out.println("Least iterations: " + leastIterations(arr));
    }

    public static int[] bubbleSort(int[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
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

    public static int[] selectionSort(int[] nums) {
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
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                swaps += 3;
            }
        }

        return new int[]{swaps, steps};
    }

    public static int[] insertionSort(int[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];
            swaps++;
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
        }

        return new int[]{swaps, steps};
    }

    public static String leastSwaps(int[] nums) {
        int[] bubble = bubbleSort(nums.clone());
        int[] selection = selectionSort(nums.clone());
        int[] insertion = insertionSort(nums.clone());

        int minSwaps = Math.min(Math.min(bubble[0], selection[0]), insertion[0]);

        if (bubble[0] == minSwaps) return "Bubble";
        if (insertion[0] == minSwaps) return "Insertion";
        return "Selection";
    }

    public static String leastIterations(int[] nums) {
        int[] bubble = bubbleSort(nums.clone());
        int[] selection = selectionSort(nums.clone());
        int[] insertion = insertionSort(nums.clone());

        int minSteps = Math.min(Math.min(bubble[1], selection[1]), insertion[1]);

        if (bubble[1] == minSteps) return "Bubble";
        if (insertion[1] == minSteps) return "Insertion";
        return "Selection";
    }
}