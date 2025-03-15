import java.util.Arrays;

public class AverageLess3Max {
    public static void averageLess3Max(int[] arr) {
        
        int max = arr[0];
        int sum = 0;
        int count = 0;
        //Sort array
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //Sort arraty using sort funtion
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arrCopy = Arrays.copyOf(arr, arr.length-3);
        System.out.println(Arrays.toString(arrCopy));

        for (int i = 0; i < arrCopy.length; i++) {
            sum += arr[i];
            count++;
        }
        int average = sum / count;
        System.out.println(average);
        
    }
    
    public static void main(String[] args) {
        
        int[] arr = { 9, 7, 3, 4, 5, 6, 2, 8, 1, 10 };
        averageLess3Max(arr);
    }

    
}