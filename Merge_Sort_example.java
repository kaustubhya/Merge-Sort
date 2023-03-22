import java.util.Arrays;

public class Merge_Sort_example {
    public static void main(String[] args) {
        int[] array = {8,3,4,12,6,5,15};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    // Here we'll create new objects for each function call
    // Original array is not modified

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        // Base Condition

        int mid = arr.length/2;

        int [] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        // This method creates the copy of an array where we can modify the range

        int [] rightArray = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(leftArray, rightArray);
        // Return the 2 sorted arrays
    }

    private static int[] merge(int[] first, int[] second) {
        // Here left = first
        // Here right = second
        // Here we'll now try to sort internally the 2 arrays and combine them into one combined merger array

        int[] mix = new int[first.length + second.length];
        // new combined array defined

        int i = 0; // index of leftArray
        int j = 0; // index of rightArray
        int k = 0; // index of the combinedArray or mixedArray

        while (i < first.length && j < second.length) {
            if (first[i] < second [j]) {
                mix[k] = first[i];
                i++;
            }

            // If the first element of leftArray is smaller than the first element of rightArray. Put 
            // the smaller LHS array element into the mix array and update the 'i' index
            else {
                mix[k] = second[j];
                j++;
            }
            // Else do the same and update the 'j' index

            k++;
        // When both arrays are done, update the 'k' index and place the elements in the mix array

        }

        // Sometimes it might be possible that the first and second arrays are of unequal lengths
        // and one of the arrays is not completed

        // Hence copy the remaining elements

        while(i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // Left array is already sorted internally here, therefore, copy it to mix and update 'i' and 'k'

        while(j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        // Repeat the same for Right Array

        return mix;
        // Return this array of mix
    }
    
}