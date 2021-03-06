package amazon.sorting;


import java.util.Arrays;

//O(nlogn)
public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {10,6,20,5,30,15,11,50,40,100,60};// = n/2

        mergeSort(arr, 0 , arr.length -1);
        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    public static void mergeSort(int arr[], int low, int high) {

        if (high > low) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, mid+1, high);

        }
    }
        private static void merge(int []arr, int low1, int high1, int low2, int high2) {

            int brr[] = new int[high2-low1+1];

            int i = low1;
            int j = low2;
            int k = 0;
            while (i <= high1 && j <= high2) {
                if (arr[i] < arr[j]) {
                    brr[k++] = arr[i++];
                } else {
                    brr[k++] = arr[j++];
                }
            }
            if (i == high1+1) {
                while (j <= high2) {
                    brr[k++] = arr[j++];
                }
            } else {
                while (i <= high1) {
                    brr[k++] = arr[i++];
                }
            }

            //Copying back to the original array
            int l= 0;
            while (l < k){
                arr[low1++] = brr[l++];
            }

        }

    }

