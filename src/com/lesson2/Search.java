package com.lesson2;

public class Search {
    public static Integer runBinarySearchMissedNumber(
            Integer[] sortedArray) {
        int err = 0;
        int low = 1;
        int high = sortedArray.length - 1;
        if (sortedArray.length == 0 || sortedArray[0] != 1) return 1;
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray[mid] != mid + 1) {
                if (sortedArray[mid - 1] != mid) {
                    high = mid - 1;
                } else {
                    return mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return err;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(runBinarySearchMissedNumber(arr));
    }

}
