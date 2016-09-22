package com.interview;

/**
 * Created by arjun on 2/26/16.
 */
class PrintIndex {
    public static void PrintIndicesForValue(int[] numbers, int target) {
        if (numbers == null)
            return;

        int low = 0, high = numbers.length - 1;
        // get the start index of target number
        int startIndex = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] == target) {
                startIndex = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        // get the end index of target number
        int endIndex = -1;
        low = 0;
        high = numbers.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] == target) {
                endIndex = mid;
                low = mid + 1;
            } else
                low = mid + 1;
        }

        if (startIndex != -1 && endIndex != -1) {
            for (int i = 0; i + startIndex <= endIndex; i++) {
                if (i > 0)
                    System.out.print(',');
                System.out.print(i + startIndex);
            }
        }
    }

    public static void main(String[] args) {
        PrintIndex Pi = new PrintIndex();
        int[] arr = {1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4};
        Pi.PrintIndicesForValue(arr, 4);
        System.out.println();
    }
}