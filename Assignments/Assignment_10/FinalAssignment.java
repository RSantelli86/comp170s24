public class FinalAssignment {

    /**
     * Merges two sorted arrays into a single sorted array.
     * 
     * @param left the first sorted array
     * @param right the second sorted array
     * @return a new array containing all elements from both input arrays in sorted order
     */
    public int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] mergedArray = new int[leftLength + rightLength];
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // Merge the two arrays while both have unmerged elements
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                mergedArray[mergedIndex++] = left[leftIndex++];
            } else {
                mergedArray[mergedIndex++] = right[rightIndex++];
            }
        }

        // Copy remaining elements from the left array, if any
        while (leftIndex < leftLength) {
            mergedArray[mergedIndex++] = left[leftIndex++];
        }

        // Copy remaining elements from the right array, if any
        while (rightIndex < rightLength) {
            mergedArray[mergedIndex++] = right[rightIndex++];
        }

        return mergedArray;
    }

    /**
     * Reverses a given string.
     * 
     * @param string the string to be reversed
     * @return the reversed string
     */
    public String reverse(String string) {
        int length = string.length();
        char[] reversedArray = new char[length];

        // Iterate over the string from end to start
        for (int i = 0; i < length; i++) {
            reversedArray[i] = string.charAt(length - 1 - i);
        }

        return new String(reversedArray);
    }

    /**
     * Sorts an array in ascending order using a simple selection sort technique.
     * 
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] simpleSort(int[] array) {
        int arrayLength = array.length;

        // Iterate over each element in the array
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the unsorted part of the array
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest element with the first element of the unsorted part
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        FinalAssignment assignment = new FinalAssignment();

        // Testing merge method
        int[] a = {1, 2, 8, 9};
        int[] b = {0, 5, 6, 7};
        int[] merged = assignment.merge(a, b);
        System.out.println("Merged array: " + java.util.Arrays.toString(merged));

        // Testing reverse method
        String original = "Hello";
        String reversed = assignment.reverse(original);
        System.out.println("Reversed string: " + reversed);

        // Testing simpleSort method
        int[] unsorted = {10, 8, 5, 6, 2};
        int[] sorted = assignment.simpleSort(unsorted);
        System.out.println("Sorted array: " + java.util.Arrays.toString(sorted));
    }
}