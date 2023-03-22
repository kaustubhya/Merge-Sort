import java.util.Arrays;

public class Merge_Sort_In_Place {
    public static void main(String[] args) {
    int [] array = {5,4,3,2,1};
    mergeSortInPlace(array, 0, array.length);
    System.out.println(Arrays.toString(array));
        
    }

    static void mergeSortInPlace(int [] arr, int start, int end) {
        if ((end - start) == 1) {
            return;
        }
        // We are only left with a single element at last, and then we'll return it

        int mid = start + (end-start)/2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);


    //  not returning anything here, hence we used void here

         mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int [] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if(arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            }
            else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // Adding the left elements

        while(i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Updating the original array now

        for(int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];

        }

        // Not returning anything here too!

    } 

    
}
